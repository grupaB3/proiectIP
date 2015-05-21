package mainToolBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import processToolBar.MainProcessToolBar;
import fileToolBar.FileToolBar;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

import observers.BackObserver;
import observers.FileObserver;
import observers.ProcessesObserver;
import observers.ServiceObserver;

public class ToolBar extends JToolBar {

	private static final long serialVersionUID = 6343254365674473635L;
	
	private FileToolBar filesToolBar = new FileToolBar();
	private MainProcessToolBar processesToolBar = new MainProcessToolBar();
	private JLabel welcomeMessage = new JLabel("Welcome to Disk Investigator");
	private BackButton backP = new BackButton();
	private BackButton backF = new BackButton();
	private BackObserver observer = null;
	
	public ToolBar() {
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JLabel intermediar = new JLabel();
		intermediar.setPreferredSize(new Dimension(500,12));
		add(intermediar);
		
		welcomeMessage.setForeground(Color.white);
		welcomeMessage.setVisible(true);
		welcomeMessage.setPreferredSize(new Dimension(500,30));
		welcomeMessage.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeMessage.setVerticalAlignment(SwingConstants.CENTER);
		welcomeMessage.setFont(new Font("Arial", Font.ITALIC, 24));
		add(welcomeMessage);
		
		processesToolBar.add(new JLabel("        "));
		processesToolBar.add(backP);
		processesToolBar.initializeBars();
		processesToolBar.setRollover(true);
		add(processesToolBar);
		processesToolBar.setVisible(false);
		
		filesToolBar.add(new JLabel("        "));
		filesToolBar.add(backF);
		filesToolBar.initializeButtons();
		add(filesToolBar);
		filesToolBar.setVisible(false);
		
		setFloatable(false);
		
		backP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setToolBar("start");
				observer.setTabBar();
				observer.setOrderBar();
			}
			
		});
		
		backF.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setToolBar("start");
				observer.setTabBar();
				observer.setOrderBar();
			}
			
		});
	}
	
	public void setToolBar(String option) {
		switch(option) {
			case "start":
				setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
				welcomeMessage.setVisible(true);
				filesToolBar.setVisible(false);
				processesToolBar.setVisible(false);
				break;
			case "file":
				setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
				filesToolBar.setVisible(true);
				processesToolBar.setVisible(false);
				welcomeMessage.setVisible(false);
				checkScanStatus();
			    break;
			default:
				setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
				welcomeMessage.setVisible(false);
				filesToolBar.setVisible(false);
				processesToolBar.setVisible(true);
				processesToolBar.setToolBar(option);
				break;
		}
	}
	
	private void checkScanStatus() {
		SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>() {
			@Override
	         protected Void doInBackground() throws Exception {
				System.out.println("Waiting...");
				boolean status = filesToolBar.getDiskScan().getScanButton().getFileObserver().getFileHandler().isScanned();
	        	while(!status) {
	        		status = filesToolBar.getDiskScan().getScanButton().getFileObserver().getFileHandler().isScanned();
	        		Thread.sleep(10);
	        	}
	        	filesToolBar.getDiskScan().getRefreshButton().setEnabled(true);
	        	filesToolBar.getDiskScan().getRecoveryButton().setEnabled(true);
	        	filesToolBar.getFileWorker().getShredButton().setEnabled(true);
	        	System.out.println("Done.");
	            return null;
	         }
		};
		mySwingWorker.execute();
	}

	public void setObserver(FileObserver fileObserver) {
		filesToolBar.setFileObserver(fileObserver);
	}
	
	public void setObserver(ProcessesObserver processObserver){
		processesToolBar.setProcessesObserver(processObserver);
	}
	
	public BackObserver getObserver() {
		return observer;
	}

	public void setObserver(BackObserver observer) {
		this.observer = observer;
	}

	public void setObserver(ServiceObserver serviceObserver) {
		processesToolBar.getServicesBar().setServiceObserver(serviceObserver);
	}
}
