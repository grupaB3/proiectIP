package tabBar;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProcessTabBar extends JPanel {
	protected ProcessTabBar() {
		initUI();
	}
	
	private void initUI() {
		add(new JLabel("Tasks"));
		add(new JLabel("    "));
		add(new JLabel("Processes"));
		add(new JLabel("    "));
		add(new JLabel("Services"));
		//setPreferredSize(new Dimension(70, 30));
		setLayout(new FlowLayout());
	}
}
