

import javax.swing.JToolBar;


public class ToolBar extends JToolBar {
	private ProcessScan processScan = new ProcessScan();
	
	
	
	protected ToolBar(){
		add(processScan.getEndButton());
		add(processScan.getNewTaskButton());
		
	}
	

}
