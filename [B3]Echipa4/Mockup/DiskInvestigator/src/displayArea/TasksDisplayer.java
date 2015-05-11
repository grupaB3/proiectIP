package displayArea;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class TasksDisplayer extends JPanel {

	private static final long serialVersionUID = -2809884889360505234L;

	private TaskListArea taskListArea = new TaskListArea();
	private ProcessInfoArea processInfoArea = new ProcessInfoArea();
	
	protected TasksDisplayer() {
		initUI();
	}
	
	private void initUI() {
		
		JPanel space = new JPanel();
		space.setPreferredSize(new Dimension(2, 450));
		
		add(space);
		add(taskListArea);
		add(processInfoArea);
		
		//setBackground(Color.cyan);
		setPreferredSize(new Dimension(898, 450));
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
	}
}
