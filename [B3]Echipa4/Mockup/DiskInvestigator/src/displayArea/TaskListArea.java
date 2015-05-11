package displayArea;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class TaskListArea extends JPanel {

	private static final long serialVersionUID = -2809884889360505234L;

	protected TaskListArea() {
		initUI();
	}
	
	private void initUI() {
		setBackground(Color.pink);
		setPreferredSize(new Dimension(620, 450));
	}
}
