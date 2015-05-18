package displayArea;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import diskscan.MFTEntry;
import observers.FileObserver;


public class FileListArea extends JScrollPane {

	private static final long serialVersionUID = -2809884889360505234L;
	private int itsRow = 0;
	private int itsColumn;
	private boolean isMouseEnter = false;
	private JTable table;
	private String[] columnNames = {" Name"," Extension"," Size"," Status"};
	private Object[][] data;

	protected FileListArea() {
		initUI();
	}

	public void setData(Map<Integer, MFTEntry> map){
		int size = 0;
		for(Map.Entry<Integer, MFTEntry> entryTest: map.entrySet()) {
			if(entryTest.getValue().getFileName() != null)
				size++;
		}
		data = new Object[size] [4];
//		data = new Object[map.size()][4];
		int i = 0;
		for(Map.Entry<Integer, MFTEntry> entry: map.entrySet()) {
			if(entry.getValue().getFileName() != null) {
				data[i][0] = String.valueOf(entry.getValue().getFileName().getName()).trim().replaceAll("\\s+", "");
				data[i][1] = String.valueOf(entry.getValue().getCompletePath()).trim().replaceAll("\\s+", "");
				if((entry.getValue().getMftHeader().getFlags() & (1<<0)) > 0){
					data[i][2] = "I n - u s e";
				}
				else{
					data[i][2] = "D e l e t e d";
				}
				data[i][3] = entry.getKey();
				i++;
			}
		} 
		getViewport().removeAll();
		initUI();
	}

	private void initUI() {
		setPreferredSize(new Dimension(620, 450));

		@SuppressWarnings("serial")
		DefaultTableModel model = new DefaultTableModel(data, columnNames) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
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

		table.setDefaultRenderer(Object.class, new AttributiveCellRenderer());

		TableRowSorter<TableModel>sorter=new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);

		ListSelectionModel rowSelectionModel = table.getSelectionModel();
		rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}


	public int getItsColumn() {
		return itsColumn;
	}

	public void setItsColumn(int itsColumn) {
		this.itsColumn = itsColumn;
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
}
