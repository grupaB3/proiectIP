package tabBar;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileTabBar extends JPanel {
	protected FileTabBar() {
		initUI();
	}
	
	private void initUI() {
		add(new JLabel("Files"));
		setPreferredSize(new Dimension(70, 30));
	}
}
