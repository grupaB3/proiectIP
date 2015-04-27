package processToolBar;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JToolBar;

public class ProcessToolBar extends JToolBar {
	private ProcessScan processScan = new ProcessScan();
	private ProcessCheck processCheck = new ProcessCheck();
	
	public ProcessToolBar(){
		add(new JLabel("                 "));
		add(processScan.getNewTaskButton());
		add(new JLabel("                 "));
		add(processScan.getEndButton());
		add(new JLabel("                 "));
		
		add(processCheck.getCheckButton());
		setFloatable(false);
		setPreferredSize(new Dimension(100, 70));
	}
}
