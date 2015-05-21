package displayArea;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class ProcessesDisplayer extends JPanel {

	private static final long serialVersionUID = -2809884889360505234L;

	private ProcessListArea processListArea = new ProcessListArea();
	private ProcessInfoArea processInfoArea = new ProcessInfoArea();
	
	public ProcessesDisplayer() {
		initUI();
	}
	
	private void initUI() {
		
		JPanel space = new JPanel();
		space.setPreferredSize(new Dimension(2, 440));
		
		add(space);
		add(processListArea);
		add(processInfoArea);
		
		//setBackground(Color.cyan);
		setPreferredSize(new Dimension(898, 440));
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
	}
	
	public ProcessListArea getProcessListArea() {
		return processListArea;
	}

	public void setProcessListArea(ProcessListArea processListArea) {
		this.processListArea = processListArea;
	}
}
