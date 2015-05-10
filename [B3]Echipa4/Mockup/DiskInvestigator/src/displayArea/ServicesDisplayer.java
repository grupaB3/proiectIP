package displayArea;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ServicesDisplayer extends JPanel {

	private static final long serialVersionUID = -2809884889360505234L;

	protected ServicesDisplayer() {
		initUI();
	}
	
	private void initUI() {
		//setBackground(Color.magenta);
		setPreferredSize(new Dimension(70, 40));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
}
