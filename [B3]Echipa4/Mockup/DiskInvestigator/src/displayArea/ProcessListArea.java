package displayArea;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class ProcessListArea extends JPanel {

	private static final long serialVersionUID = -2809884889360505234L;

	protected ProcessListArea() {
		initUI();
	}
	
	private void initUI() {
		setBackground(Color.cyan);
		setPreferredSize(new Dimension(620, 450));
	}
}
