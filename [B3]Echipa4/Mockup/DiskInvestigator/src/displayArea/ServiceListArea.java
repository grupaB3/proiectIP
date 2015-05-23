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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.ServiceMonitor;

public class ServiceListArea extends JScrollPane {

	private static final long serialVersionUID = -2809884889360505234L;
    private int itsRow = 0;
    private int itsColumn;
    private boolean isMouseEnter = false;
    private JTable table;
    private String[] columnNames = {" Name"," Status","PID", " Description"};
    private Object[][] data;
    private ServiceMonitor sm = new ServiceMonitor();
    private String selectedService;
    private List<model.Service> services;
    
	protected ServiceListArea() {
		initUI();
	}
	
	public void setData(){		
		sm.initiliaze();
		sm.connect();		
		sm.parse();
		services = sm.getServicesList();		
		display();	
	}
	
	public void display(){
		
		data = new Object[services.size()+1][6];
		
		for(int i = 0; i<services.size(); i++)
		{
		
			model.Service s = services.get(i);	
			data[i][0] = s.getName();
			data[i][1] = s.getState();
			data[i][2] = s.getPID();
			data[i][3] = s.getDescription();
			
		}
		
		
		getViewport().removeAll();
		initUI();
	}
	
	public void StartServiceButton(){
		//TODO set selectedService!
		System.out.println("START Service!");
		
		 model.Service s = services.get(table.getSelectedRow());
		
		
		setService(s.getName());
		System.out.println(selectedService+" la randul "+table.getSelectedRow());
		
		
		System.out.println("Start service "+selectedService);
		
		if(!selectedService.equals(null))
		{
			sm.start(selectedService);
			getViewport().removeAll();
			initUI();
		}
		
		 
	}
	
	public void setService(String s){
		selectedService = s;
	}
	
	private void initUI() {
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
		table.getColumnModel().getColumn(1).setMinWidth(70);
		table.getColumnModel().getColumn(2).setMinWidth(70);
		table.getColumnModel().getColumn(3).setMinWidth(100);
		
		table.setShowGrid(false);
	    table.setShowVerticalLines(true);
	    table.setGridColor(new Color(198, 168, 138));
	    table.setDefaultRenderer(Object.class, new AttributiveCellRenderer());
		
		getViewport().add(table);
		getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);

		TableRowSorter<TableModel>sorter=new TableRowSorter<TableModel>(model);
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
//	                	 System.out.println("Selected row "+String.valueOf(row) +
//		                		 " . The selected service is "+ data[row][2]);
	                 }
	            }               
	        }           
	    }, AWTEvent.MOUSE_EVENT_MASK);
		
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
