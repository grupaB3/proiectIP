package mainToolBar;

import processToolBar.ProcessToolBar;
import fileToolBar.FileToolBar;

import javax.swing.JLabel;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar {
	private FileToolBar filesToolBar = new FileToolBar();
	private ProcessToolBar processesToolBar = new ProcessToolBar();
	private BackButton back = new BackButton();
	
	public ToolBar() {
		processesToolBar.add(new JLabel("        "));
		processesToolBar.add(back);
		processesToolBar.initializeButtons();
		add(processesToolBar);
		processesToolBar.setVisible(true);
		//add(filesToolBar);
		
		setFloatable(false);
	}
	
	public void setToolBar(String option) {
		switch(option) {
			case "start": ;
				
		}
	}
}
