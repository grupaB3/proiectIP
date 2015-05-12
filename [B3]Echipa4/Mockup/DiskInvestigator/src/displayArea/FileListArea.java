package displayArea;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class FileListArea extends JScrollPane {

	private static final long serialVersionUID = -2809884889360505234L;
	private String[] columnNames = {" Name"," Extension"," Size"," Status"};
	private Object[][] data = {
	        {" row1", " row1"," row1", " row1"},
	        {" row1", " row1"," row1", " row1"}};
	protected FileListArea() {
		initUI();
	}
	
	private void initUI() {
		//setBackground(Color.orange);
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
		 
		 ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer())
			.setHorizontalAlignment(JLabel.LEFT);
		 
		table.setShowVerticalLines(true);
		table.setGridColor(new Color(198, 168, 138));
		    
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(70);
		table.getColumnModel().getColumn(2).setMinWidth(70);
		table.getColumnModel().getColumn(3).setMinWidth(70);
	}
}
