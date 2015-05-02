package tabBar;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class MainTabBar extends JPanel {
	private FileTabBar fileTabBar = new FileTabBar();
	private ProcessTabBar processTabBar = new ProcessTabBar();
	
	public MainTabBar() {
		initUI();
	}
	
	private void initUI() {
		add(fileTabBar);
		fileTabBar.setVisible(false);
		
		add(processTabBar);
		processTabBar.setVisible(false);
		
		setLayout(new FlowLayout(FlowLayout.LEADING));
		//setBackground(Color.red);
	}
	
	public void setTabBar(String option) {
		switch(option) {
			case "start":
				fileTabBar.setVisible(false);
				processTabBar.setVisible(false);
				break;
			case "file":
				fileTabBar.setVisible(true);
				processTabBar.setVisible(false);
			    break;
			case "process":
				fileTabBar.setVisible(false);
				processTabBar.setVisible(true);
				break;	
		}
	}
}
