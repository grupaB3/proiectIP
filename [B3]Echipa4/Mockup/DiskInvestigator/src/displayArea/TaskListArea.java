package displayArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class TaskListArea extends JScrollPane {

	private static final long serialVersionUID = -2809884889360505234L;


	private String[] columnNames = {"Name", "Session Name", "Status","Memory"};
	private JTable table;
	private Object[][] data = {
	        {"row1", "row1","row1", "row1"},
	        {"row2", "row2","row2", "row2"},
	        {"row3", "row3","row3", "row3"},
	        {"row3", "row3","row3", "row3"},
	        {"row1", "row1","row1", "row1"},
	        {"row2", "row2","row2", "row2"},
	        {"row3", "row3","row3", "row3"},
	        {"row3", "row3","row3", "row3"},
	        {"row1", "row1","row1", "row1"},
	        {"row2", "row2","row2", "row2"},
	        {"row3", "row3","row3", "row3"},
	        {"row3", "row3","row3", "row3"},
	        {"row1", "row1","row1", "row1"},
	        {"row2", "row2","row2", "row2"},
	        {"row3", "row3","row3", "row3"},
	        {"row3", "row3","row3", "row3"},
	        {"row1", "row1","row1", "row1"},
	        {"row2", "row2","row2", "row2"},
	        {"row3", "row3","row3", "row3"},
	        {"row3", "row3","row3", "row3"},
	        {"row1", "row1","row1", "row1"},
	        {"row2", "row2","row2", "row2"},
	        {"row3", "row3","row3", "row3"},
	        {"row3", "row3","row3", "row3"},
	        {"row1", "row1","row1", "row1"},
	        {"row2", "row2","row2", "row2"},
	        {"row3", "row3","row3", "row3"},
	        {"row3", "row3","row3", "row3"},
	        {"row1", "row1","row1", "row1"},
	        {"row2", "row2","row2", "row2"},
	        {"row3", "row3","row3", "row3"},
	        {"row3", "row3","row3", "row3"},
	        {"row1", "row1","row1", "row1"},
	        {"row2", "row2","row2", "row2"},
	        {"row3", "row3","row3", "row3"},
	        {"row3", "row3","row3", "row3"}
	        };
	
	protected TaskListArea() {
		initUI();
	}
	
	private void initUI() {
		//setBackground(Color.pink);
		setPreferredSize(new Dimension(620, 450));
		
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
		 table.setShowGrid(false);
		 getViewport().add(table);
		 getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
		  
	}
	
}
