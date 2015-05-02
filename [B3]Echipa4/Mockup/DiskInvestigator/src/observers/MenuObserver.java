package observers;

import tabBar.MainTabBar;
import mainToolBar.ToolBar;

public class MenuObserver {
	private ToolBar toolBar;
	private MainTabBar tabBar;
	
	public MenuObserver(ToolBar toolBar, MainTabBar tabBar) {
		this.toolBar = toolBar;
		this.tabBar = tabBar;
	}
	
	public void activateBar(String barName) {
		toolBar.setToolBar(barName);
		tabBar.setTabBar(barName);
	}
}
