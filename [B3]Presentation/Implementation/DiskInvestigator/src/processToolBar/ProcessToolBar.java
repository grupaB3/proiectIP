package processToolBar;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JToolBar;

import observers.ProcessesObserver;

public class ProcessToolBar extends JToolBar {

	private static final long serialVersionUID = 965328829017261188L;
	
	private ProcessScanButton processScanButton = new ProcessScanButton();
	private StartProcessButton startProcessButton = new StartProcessButton();
	private EndProcessButton endProcessButton = new EndProcessButton();
	private ProcessCheckButton processCheckButton = new ProcessCheckButton();
	
	public ProcessToolBar() {	
		setFloatable(false);
		setPreferredSize(new Dimension(100, 70));
		
		initializeButtons();
	}
	
	private void initializeButtons() {
		add(new JLabel("                 "));
		add(processScanButton);
		add(new JLabel("                 "));
		add(startProcessButton);
		add(new JLabel("                 "));
		add(endProcessButton);
		add(new JLabel("                 "));
		add(processCheckButton);
	}

	public void setObserver(ProcessesObserver processesObserver) {
		processCheckButton.setProcessesObserver(processesObserver);
		processScanButton.setProcessesObserver(processesObserver);
		startProcessButton.setProcessesObserver(processesObserver);
		endProcessButton.setProcessesObserver(processesObserver);
	}
}
