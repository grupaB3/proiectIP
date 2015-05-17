package displayArea;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

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

public class ServiceListArea extends JScrollPane {

	private static final long serialVersionUID = -2809884889360505234L;
    int itsRow = 0;
    int itsColumn;
    boolean isMouseEnter = false;
    JTable table;
    
	protected ServiceListArea() {
		initUI();
	}
	
	private void initUI() {
		
		String[] columnNames = {" Name",
				                " Type",
				                " Status",
				                " Description"};
		Object[][] data = { {" Service1", " Type1", " Stopped", " This is service1"},
							{" Service2", " Type2", " Running", " This is service2"},
							{" Service3", " Type3", " Stopped", " This is service3"},
							{" Service4", " Type1", " Running", " This is service4"},
							{" Service5", " Type3", " Running", " This is service5"},
							{" Service6", " Type4", " Stopped", " This is service6"},
							{" Service7", " Type2", " Stopped", " This is service7"}};
		
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
		
		((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer())
	    										.setHorizontalAlignment(JLabel.LEFT);
		table.getColumnModel().getColumn(0).setMinWidth(70);
		table.getColumnModel().getColumn(1).setMinWidth(70);
		table.getColumnModel().getColumn(2).setMinWidth(70);
		table.getColumnModel().getColumn(3).setMinWidth(100);
		
		table.setShowGrid(false);
	    table.setShowVerticalLines(true);
	    table.setGridColor(new Color(198, 168, 138));
	    table.setDefaultRenderer(Object.class, new AttributiveCellRenderer());
		
		getViewport().add(table);
		getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);

		setPreferredSize(new Dimension(620, 450));
	
		TableRowSorter<TableModel>sorter=new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		
		ListSelectionModel rowSelectionModel = table.getSelectionModel();
	    rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
            itsColumn = column;

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
