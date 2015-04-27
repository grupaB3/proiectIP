package mainToolBar;

import processToolBar.ProcessToolBar;
import fileToolBar.FileToolBar;

import javax.swing.JToolBar;

public class ToolBar extends JToolBar {
	private FileToolBar filesToolBar = new FileToolBar();
	private ProcessToolBar processesToolBar = new ProcessToolBar();
	
	public ToolBar() {
		add(processesToolBar);
		processesToolBar.setVisible(false);
		add(filesToolBar);
		
	}
	
	public void setToolBar(String option) {
		switch(option) {
			case "start": ;
				
		}
	}
}
