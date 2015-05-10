package processToolBar;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JToolBar;

public class ProcessToolBar extends JToolBar {

	private static final long serialVersionUID = 965328829017261188L;
	
	private ProcessScanButton processScanButton = new ProcessScanButton();
	private EndProcessButton endProcessButton = new EndProcessButton();
	
	public ProcessToolBar() {	
		setFloatable(false);
		setPreferredSize(new Dimension(100, 70));
		
		initializeButtons();
	}
	
	private void initializeButtons() {
		add(new JLabel("                 "));
		add(processScanButton);
		add(new JLabel("                 "));
		add(endProcessButton);
	}
}
