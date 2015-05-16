package displayArea;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ProcessListArea extends JScrollPane {

	private static final long serialVersionUID = -2809884889360505234L;

	protected ProcessListArea() {
		initUI();
	}
	
	private void initUI() {
		//setBackground(Color.cyan);
		setPreferredSize(new Dimension(620, 450));
		
		String[] columnNames = {" Name", " Session Name", " Pid", " Memory"};
		Object[][] data = { {" Name1", " Session Name1", " Pid4", " 4"},
							{" Name2", " Session Name4", " Pid2", " 1"},
							{" Name3", " Session Name3", " Pid3", " 3"},
							{" Name4", " Session Name2", " Pid1", " 2"}};

		@SuppressWarnings("serial")
		DefaultTableModel model = new DefaultTableModel(data, columnNames) {
			
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int column){
				Class returnValue;
					if((column>=0)&&(column<getColumnCount())){
						returnValue=getValueAt(0,column).getClass();
					}else{
						returnValue=Object.class;
					}
					return returnValue;
			};

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
	table.getColumnModel().getColumn(1).setMinWidth(100);
	table.getColumnModel().getColumn(2).setMinWidth(70);
	table.getColumnModel().getColumn(3).setMinWidth(100);
	
	
	table.setForeground(Color.black);
	table.setShowGrid(false);
	table.setShowVerticalLines(true);
	table.setGridColor(new Color(198, 168, 138));
	
	TableRowSorter<TableModel>sorter=new TableRowSorter<TableModel>(model);
	table.setRowSorter(sorter);
	
	
	
	getViewport().add(table);
	getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
		
	}
}
