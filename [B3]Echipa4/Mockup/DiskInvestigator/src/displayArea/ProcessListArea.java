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
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import observers.ProcessesObserver;
import controller.ProcessCheck;
import controller.ProcessMonitor;
import model.DigitalSignature;
import model.MaliciousProcess;
import model.ProcessT;

public class ProcessListArea extends JScrollPane {

	private static final long serialVersionUID = -2809884889360505234L;
	int itsRow = 0;
	int itsColumn;
	boolean isMouseEnter = false;
	JTable table;
	private Object[][] data;
	private String[] columnNames = {" Name", " Session Name", " Pid", " Memory"," Process Number", "Malicious Ratio", "Malicious Value"};
	private List<ProcessT> pro;
	private ProcessInfoArea processInfoArea;
	private boolean focus = false;
	private boolean scanned = false;
	private ProcessCheck check = new ProcessCheck();
	private ProcessesObserver processesObserver;



	protected ProcessListArea() {
		initUI();
	}

	public void setData(List<ProcessT> processes){
		setPro(processes);

		data = new Object[processes.size()][6];	
		for(int i = 0; i<processes.size(); i++)
		{
			ProcessT p = processes.get(i);		
			String pid = p.getPID();

			data[i][0] = p.getName();
			data[i][1] = p.getSessionName();
			data[i][2] = pid;
			data[i][3] = p.getMemoryUsage();
			data[i][4] = i;
			data[i][5] = -1;

		}

		getViewport().removeAll();
		initUI();
	}

	public String getSelectedProcess(){
		int rowNo = table.getSelectedRow();
		if(rowNo>=0)
		{
			String pid=table.getValueAt(rowNo, 2).toString();			
			return pid;
		}
		return null;
	}
	public void setPro(List<ProcessT> p){
		pro = p;
	}
	public List<ProcessT> getPro(){
		return pro;
	}

	void initUI() {
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
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(70);
		table.getColumnModel().getColumn(3).setMinWidth(50);
		table.getColumnModel().getColumn(4).setMinWidth(0);
		table.getColumnModel().getColumn(4).setMaxWidth(0);
		table.getColumnModel().getColumn(5).setMinWidth(50);

		table.getColumnModel().getColumn(6).setMinWidth(0);
		table.getColumnModel().getColumn(6).setMaxWidth(0);

		table.setForeground(Color.black);
		table.setShowGrid(false);
		table.setShowVerticalLines(true);
		table.setGridColor(new Color(198, 168, 138));

		TableRowSorter<TableModel>sorter=new TableRowSorter<TableModel>(model);
		sorter.setSortable(2, false);
		sorter.setSortable(3, false); 
		table.setRowSorter(sorter);

		getViewport().add(table);
		getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);



		table.getColumnModel().getColumn(5).setCellRenderer(new CustomRenderer());
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

				}               
			}           
		}, AWTEvent.MOUSE_EVENT_MASK);


		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (table.getSelectedRow() > -1) {
					processInfoArea.setProcessInfoRow(pro.get((int)table.getValueAt(table.getSelectedRow(), 4)));

					int verifica[]=new int[1];

					try{

						verifica[0] = Integer.parseInt(getSelectedProcess());												
						List<DigitalSignature> ar = check.verify(verifica);

						DigitalSignature sign = ar.get(0);								 
						processInfoArea.setSignature(sign);

					}catch(NumberFormatException e){
						System.out.println("Error: parse");
					}catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		});
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

	public class CustomRenderer extends DefaultTableCellRenderer 
	{
		private static final long serialVersionUID = 6703872492730589499L;

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
		{
			Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			if(table.getValueAt(row, column).toString()!=null)
			{double val=Double.parseDouble(table.getValueAt(row, column).toString());
			if(val==0){

				cellComponent.setBackground(Color.GREEN);
			} else 
				if(val>0 && val<0.25){
					cellComponent.setBackground(Color.YELLOW);
				}
				else 
					if(val>=0.25 && val<0.5){
						cellComponent.setBackground(Color.ORANGE);
					}
					else if(val>=0.5){
						cellComponent.setBackground(Color.RED);
			} else {
				cellComponent.setBackground(Color.GRAY);
			}
			}
			return cellComponent;
		}
	}

	public void startRefresh() {
		SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				boolean intermediary = isFocus();
				while(intermediary) {
					Thread.sleep(3000);
					ProcessMonitor processMonitor = new ProcessMonitor();
					processMonitor.connect();
					processMonitor.parse();

					List<ProcessT> processList = processMonitor.getProcessList();
					for(int index = 0; index < processList.size(); index ++) {
						boolean found = checkAndModify(processList.get(index).getPID(), processList.get(index).getMemoryUsage());
						if(!found) {
							//System.out.println("New process: "+processList.get(index).getName());
						}
					}

					intermediary = isFocus();
				}
				return null;
			}
		};
		mySwingWorker.execute();
	}

	private boolean checkAndModify(String pid, String memory) {
		boolean found = false;
		for (int row = 0; row <= table.getRowCount() - 1; row++) {
			if (pid.equals(table.getValueAt(row, 2))) {
				table.setValueAt(memory, row, 3);
				found = true;
				break;
			}
		}
		return found;
	}


	public void checkAndModify2(int pid,double maliciousRatio){

		for (int row = 0; row <= table.getRowCount() - 1; row++) {
			int pidValue=Integer.parseInt(table.getValueAt(row,2).toString());

			if(pid==pidValue){

				table.setValueAt(maliciousRatio, row, 5);
				break;
			}

		}

	}


	public void setColorTable(){
		repaint();
	}


	public ProcessInfoArea getProcessInfoArea() {
		return processInfoArea;
	}

	public void setProcessInfoArea(ProcessInfoArea processInfoArea) {
		this.processInfoArea = processInfoArea;
	}

	public boolean isFocus() {
		return focus;
	}

	public void setFocus(boolean focus) {
		this.focus = focus;
	}

	public boolean isScanned() {
		return scanned;
	}

	public void setScanned(boolean scanned) {
		this.scanned = scanned;
	}

}
