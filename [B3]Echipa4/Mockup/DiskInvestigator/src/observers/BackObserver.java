package observers;

import tabBar.MainTabBar;

public class BackObserver {
	MainTabBar tabBar = null;
	
	public BackObserver(MainTabBar tabBar) {
		this.tabBar = tabBar;
	}
	
	public void setTabBar() {
		tabBar.setTabBar("start");
	}
}
