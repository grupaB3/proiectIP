package displayArea;




import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;

import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;

public class ProcessListArea extends JScrollPane {

	private static final long serialVersionUID = -2809884889360505234L;

	protected ProcessListArea() {
		initUI();
	}
	
	private void initUI() {
		setBackground(Color.cyan);
		setPreferredSize(new Dimension(620, 450));
		
		String[] columnNames = {"Name", "Session Name", "Pid", "Memory"};
		Object[][] data = { {"Name1", "Session Name1", "Pid1", "Memory1"},
							{"Name2", "Session Name2", "Pid2", "Memory2"}};

		@SuppressWarnings("serial")
		DefaultTableModel model = new DefaultTableModel(data, columnNames) {

			@Override
		public boolean isCellEditable(int row, int column) {
				return false;
  }
}; 
	JTable table = new JTable(model); 
	table.setFillsViewportHeight(true);
	table.setAutoCreateRowSorter(true);
	table.setForeground(Color.black);
	table.setShowGrid(false);
	table.setShowVerticalLines(true);
	
	getViewport().add(table);
	getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
		
	}
}
