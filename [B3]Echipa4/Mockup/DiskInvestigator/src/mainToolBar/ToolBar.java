package mainToolBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import processToolBar.ProcessToolBar;
import fileToolBar.FileToolBar;

import javax.swing.JLabel;
import javax.swing.JToolBar;

import observers.BackObserver;

public class ToolBar extends JToolBar {
	private FileToolBar filesToolBar = new FileToolBar();
	private ProcessToolBar processesToolBar = new ProcessToolBar();
	private BackButton backP = new BackButton();
	private BackButton backF = new BackButton();
	private BackObserver observer = null;
	
	public ToolBar(BackObserver observer) {
		this.observer = observer;
		
		processesToolBar.add(new JLabel("        "));
		processesToolBar.add(backP);
		processesToolBar.initializeButtons();
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
				filesToolBar.setVisible(false);
				processesToolBar.setVisible(false);
				break;
			case "file":
				filesToolBar.setVisible(true);
				processesToolBar.setVisible(false);
			    break;
			default:
				filesToolBar.setVisible(false);
				processesToolBar.setVisible(true);
				processesToolBar.setToolBar(option);
				break;
		}
	}
}
