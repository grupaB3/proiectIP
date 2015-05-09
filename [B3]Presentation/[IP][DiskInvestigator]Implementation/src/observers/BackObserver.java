package observers;

import displayArea.AreaOfDisplay;
import tabBar.MainTabBar;

public class BackObserver {
	private MainTabBar tabBar = null;
	private AreaOfDisplay displayArea = null;
	
	public BackObserver(MainTabBar tabBar, AreaOfDisplay displayArea) {
		this.tabBar = tabBar;
		this.displayArea = displayArea;
	}
	
	public void setTabBar() {
		tabBar.setTabBar("start");
	}
	
	public void setOrderBar() {
		displayArea.setArea("start");
	}
}
