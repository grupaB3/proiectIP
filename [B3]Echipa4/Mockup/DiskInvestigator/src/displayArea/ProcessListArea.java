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
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.ProcessCheck;
import model.ProcessT;

public class ProcessListArea extends JScrollPane {

	private static final long serialVersionUID = -2809884889360505234L;
	int itsRow = 0;
    int itsColumn;
    boolean isMouseEnter = false;
    JTable table;
    private Object[][] data;
    private String[] columnNames = {" Name", " Session Name", " Pid", " Memory", " Digital Signature"};
    private List<ProcessT> pro;
    
	protected ProcessListArea() {
		initUI();
	}
	
	public void setData(List<ProcessT> processes){
		setPro(processes);
		ProcessCheck check = new ProcessCheck();
		//int verifica[]= new int[100];
		data = new Object[processes.size()+1][6];
		
		for(int i = 0; i<processes.size(); i++)
		{
			
			ProcessT p = processes.get(i);
		
			//verifica[i] = Integer.parseInt(p.getPID());
			
			data[i][0] = p.getName();
			data[i][1] = p.getSessionName();
			data[i][2] = p.getPID();
			data[i][3] = p.getMemoryUsage();
			data[i][4] = "yes/no";
			/*
			if(check.verify(verifica[i])==null)
				data[i][4] = "no";
			else
				data[i][4]="yes";
			*/
		}
		
		getViewport().removeAll();
		initUI();
	}

	public ProcessT getSelectedProcess(){
		ProcessT p;
		int rowNo = table.getSelectedRow();
		if(rowNo>=0)
		{
			p = pro.get(rowNo);				
			return p;
		}
		return null;
	}
	public void setPro(List<ProcessT> p){
		pro = p;
	}
	public List<ProcessT> getPro(){
		return pro;
	}
	
	private void initUI() {
		//setBackground(Color.cyan);
		setPreferredSize(new Dimension(620, 440));
		
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

    table.setDefaultRenderer(Object.class, new AttributiveCellRenderer());

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
//                	 System.out.println("Selected row "+String.valueOf(row) +
//	                		 " . The selected service is "+ data[row][2]);
                 }
            }               
        }           
    }, AWTEvent.MOUSE_EVENT_MASK);
    
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
