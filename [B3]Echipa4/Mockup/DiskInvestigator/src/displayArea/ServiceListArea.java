package displayArea;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class ServiceListArea extends JPanel {

	private static final long serialVersionUID = -2809884889360505234L;

	protected ServiceListArea() {
		initUI();
	}
	
	private void initUI() {
		setBackground(Color.darkGray);
		setPreferredSize(new Dimension(620, 450));
	}
}
