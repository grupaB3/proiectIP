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
		processesToolBar.setVisible(false);
		
		filesToolBar.add(new JLabel("        "));
		filesToolBar.add(back);
		filesToolBar.initializeButtons();
		add(filesToolBar);
		filesToolBar.setVisible(false);
		
		setFloatable(false);
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
			case "process":
				filesToolBar.setVisible(false);
				processesToolBar.setVisible(true);
				break;	
		}
	}
}
