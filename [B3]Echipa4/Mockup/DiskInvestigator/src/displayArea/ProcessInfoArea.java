package displayArea;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class ProcessInfoArea extends JPanel {

	private static final long serialVersionUID = -2809884889360505234L;

	protected ProcessInfoArea() {
		initUI();
	}
	
	private void initUI() {
		setBackground(Color.gray);
		setPreferredSize(new Dimension(276, 440));
	}
}