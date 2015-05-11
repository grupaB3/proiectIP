package displayArea;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class ProcessesDisplayer extends JPanel {

	private static final long serialVersionUID = -2809884889360505234L;

	private ProcessListArea processListArea = new ProcessListArea();
	private ProcessInfoArea processInfoArea = new ProcessInfoArea();
	
	protected ProcessesDisplayer() {
		initUI();
	}
	
	private void initUI() {
		
		add(processListArea);
		add(processInfoArea);
		
		//setBackground(Color.cyan);
		setPreferredSize(new Dimension(900, 450));
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
	}
}
