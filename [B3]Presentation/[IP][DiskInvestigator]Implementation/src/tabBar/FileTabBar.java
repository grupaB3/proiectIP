package tabBar;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileTabBar extends JPanel {
	private JLabel fileLabel = new JLabel("     Files     ");
	protected FileTabBar() {
		initUI();
	}
	
	private void initUI() {
		fileLabel.setOpaque(true);
		fileLabel.setBackground(Color.yellow);
		add(fileLabel);
		setPreferredSize(new Dimension(70, 30));
	}
}
