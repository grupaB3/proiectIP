package displayArea;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import diskscan.MFTEntry;
import diskscan.NTFSAttribute;

public class FileListArea extends JScrollPane {

	private static final long serialVersionUID = -2809884889360505234L;
	private int itsRow = 0;
	private int itsColumn;
	private boolean isMouseEnter = false;
	private JTable table;
	private String[] columnNames = {" Name"," Extension"," Size"," Status", "Record Number"};
	private Object[][] data;
	private FileInfoArea fileInfoArea;
	private Map<Integer,MFTEntry> mapMFT;
	private long maxSizePossible;
	protected FileListArea() {
		initUI();
	}

	public void setData(Map<Integer, MFTEntry> map){

		mapMFT=map;
		data = new Object[map.size()][5];
		int i = 0;
		for(Map.Entry<Integer, MFTEntry> entry: map.entrySet()) {
			if(entry.getKey() == 8)
				for(NTFSAttribute attr : entry.getValue().getAttributes()){
					if(attr.getType() == 0x80) {
						if(attr.getNonResFlag() == 0) {
							maxSizePossible=attr.getrAttr().getLength();
						}
						else{
							maxSizePossible=attr.getNrAttr().getRealSize();
						}
					}
				}
			if(entry.getValue().getFileName() != null) {
				data[i][0] = String.valueOf(entry.getValue().getFileName().getName()).trim().replaceAll("\\s+", "");
				//data[i][1] = String.valueOf(entry.getValue().getCompletePath()).trim().replaceAll("\\s+", "");
				String[] extension = String.valueOf(entry.getValue().getFileName().getName()).split("\\.");
				if(extension.length > 1 && extension[extension.length - 1].length()<5)
					data[i][1] = extension[extension.length - 1];
				else
					data[i][1] = "No extension";
				data[i][2] = "No physical size";
				for(NTFSAttribute attr : entry.getValue().getAttributes()){
					if(attr.getType() == 0x80) {
						if(attr.getNonResFlag() == 0) {
							data[i][2]=String.valueOf(attr.getrAttr().getLength() + " bytes");
						}
						else{
							data[i][2]=String.valueOf(attr.getNrAttr().getRealSize() + " bytes");
						}
					}
				}
				if((entry.getValue().getMftHeader().getFlags() & (1<<0)) > 0){
					data[i][3] = "In-use";
				}
				else{
					data[i][3] = "Deleted";
				}
				data[i][4] = entry.getKey();
				i++;
			}
		}
		getViewport().removeAll();
		initUI();
	}

	private void initUI() {
		setPreferredSize(new Dimension(620, 440));
		
		@SuppressWarnings("serial")
		DefaultTableModel model = new DefaultTableModel(data, columnNames) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public Class getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				default:
					return String.class;
				}
			}
		};

		table = new JTable(model);
		table.setFillsViewportHeight(true);
		table.setForeground(Color.black);
		table.setShowGrid(false);
		getViewport().add(table);
		getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);

		((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer())
		.setHorizontalAlignment(JLabel.LEFT);

		table.setShowVerticalLines(true);
		table.setGridColor(new Color(198, 168, 138));

		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(70);
		table.getColumnModel().getColumn(2).setMinWidth(70);
		table.getColumnModel().getColumn(3).setMinWidth(70);
		table.getColumnModel().getColumn(4).setMinWidth(0);
		table.getColumnModel().getColumn(4).setMaxWidth(0);

		table.setDefaultRenderer(Object.class, new AttributiveCellRenderer());

		TableRowSorter<TableModel>sorter=new TableRowSorter<TableModel>(model);
		sorter.setSortable(2, false); 
		table.setRowSorter(sorter);

		ListSelectionModel rowSelectionModel = table.getSelectionModel();
		rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener(){
			public void eventDispatched(AWTEvent event) {
				if(event.getID() == MouseEvent.MOUSE_CLICKED) {
					MouseEvent mevent = (MouseEvent) event;
					int row = table.rowAtPoint(mevent.getPoint());
					if(row == -1) {
						table.clearSelection();
					}
					else {
					}
				}               
			}           
		}, AWTEvent.MOUSE_EVENT_MASK);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (table.getSelectedRow() > -1) {
					fileInfoArea.setMaxSize(maxSizePossible);
					fileInfoArea.setInfoRow(mapMFT.get(table.getValueAt(table.getSelectedRow(), 4)));
				}
			}
		});
	}

	public String getPath(int selectedRow) {
		MFTEntry mftEntry = mapMFT.get(table.getValueAt(table.getSelectedRow(), 4));
		return String.valueOf(mftEntry.getCompletePath()).trim().replaceAll("\\s+", "");
	}

	public int getItsColumn() {
		return itsColumn;
	}

	public void setItsColumn(int itsColumn) {
		this.itsColumn = itsColumn;
	}

	public int getSelectedStatus() {
		return table.getSelectedRow();
	}

	public String getSelectedFileColumn(int columnNo) {
		return table.getValueAt(table.getSelectedRow(), columnNo).toString();
	}

	public FileInfoArea getFileInfoArea() {
		return fileInfoArea;
	}

	public void setFileInfoArea(FileInfoArea fileInfoArea) {
		this.fileInfoArea = fileInfoArea;
	}


	public class MyMouseAdapter extends MouseMotionAdapter {

		public void mouseMoved(MouseEvent e) {
			JTable aTable = (JTable) e.getSource();
			itsRow = aTable.rowAtPoint(e.getPoint());
			aTable.repaint();
		}
	}

	public class MyMouseListener extends MouseAdapter {

		public void mouseEntered(MouseEvent e) {
			isMouseEnter = true;
		}

		public void mouseExited(MouseEvent e) {
			isMouseEnter = false;
			table.repaint();
		}

	}

	@SuppressWarnings("serial")
	public class AttributiveCellRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

		public AttributiveCellRenderer() {
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) {

			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);     
			setItsColumn(column);

			if (isSelected) {
			} else if (row == itsRow && isMouseEnter == true) {
				;
			} else if (row == itsRow && isMouseEnter == false) {
				isSelected = true;
			} else {
				;
			}
			if (value == null) {
			} else {
				this.setText(value.toString());
			}
			return this;
		}
	}
	
	public void changeFileStatus(int rowNo) {
		table.setValueAt("In-Use", rowNo, 3);
	}
}
