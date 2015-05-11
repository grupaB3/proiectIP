package tabBar;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import observers.TabObserver;

public class MainTabBar extends JPanel {

	private static final long serialVersionUID = -7912284906261105627L;
	
	private FileTabBar fileTabBar = new FileTabBar();
	private ProcessTabBar processTabBar;
	private TabObserver observer;
	
	public MainTabBar(TabObserver observer) {
		this.observer = observer;
		processTabBar = new ProcessTabBar(observer);
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
				observer.setDisplayArea("start");
				break;
			case "file":
				fileTabBar.setVisible(true);
				processTabBar.setVisible(false);
				observer.setDisplayArea("file");
			    break;
			case "process":
				fileTabBar.setVisible(false);
				processTabBar.setVisible(true);
				processTabBar.selectProcessTab();
				observer.setDisplayArea("process");
				break;	
		}
	}
}
