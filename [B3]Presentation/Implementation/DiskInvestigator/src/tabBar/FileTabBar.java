package tabBar;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileTabBar extends JPanel {

	private static final long serialVersionUID = 5081671752495077597L;
	
	protected FileTabBar() {
		initUI();
	}
	
	private void initUI() {
		
		JLabel fileLabel = new JLabel("Files");
		fileLabel.setOpaque(true);
		fileLabel.setBackground(new Color(255, 178, 102));
		
		JPanel filePanel = new JPanel();
		filePanel.add(fileLabel);
		filePanel.setBackground(new Color(255, 178, 102));
		filePanel.setPreferredSize(new Dimension(70, 30));
		
		add(filePanel);
	}
}
