package displayArea;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ServiceListArea extends JScrollPane {

	private static final long serialVersionUID = -2809884889360505234L;

	protected ServiceListArea() {
		initUI();
	}
	
	private void initUI() {
		
		String[] columnNames = {"Name",
				                "Type",
				                "Status",
				                "Description"};
		Object[][] data = { {"Service1", "Type1", "Stopped", "This is service1"},
							{"Service2", "Type2", "Running", "This is service2"},
							{"Service3", "Type3", "Stopped", "This is service3"},
							{"Service4", "Type1", "Running", "This is service4"},
							{"Service5", "Type3", "Running", "This is service5"},
							{"Service6", "Type4", "Stopped", "This is service6"},
							{"Service7", "Type2", "Stopped", "This is service7"}};
		
		@SuppressWarnings("serial")
		DefaultTableModel model = new DefaultTableModel(data, columnNames) {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		}; 
		JTable table = new JTable(model); 
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
	    
	    /*table.setCellSelectionEnabled(true);
	    table.setColumnSelectionAllowed(false);
	    table.setRowSelectionAllowed(false);
	    ListSelectionModel rowSelectionModel = table.getSelectionModel();
	    rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    table.setSelectionBackground(Color.red);*/
		
		getViewport().add(table);
		getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
		
		//setBackground(Color.gray);
		setPreferredSize(new Dimension(620, 450));
	}
}
