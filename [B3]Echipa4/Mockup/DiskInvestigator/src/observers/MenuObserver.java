package observers;

import displayArea.AreaOfDisplay;
import tabBar.MainTabBar;
import mainToolBar.ToolBar;

public class MenuObserver {
	private ToolBar toolBar = null;
	private MainTabBar tabBar = null;
	private AreaOfDisplay displayArea = null;
	
	public MenuObserver(ToolBar toolBar, MainTabBar tabBar, AreaOfDisplay displayArea) {
		this.toolBar = toolBar;
		this.tabBar = tabBar;
		this.displayArea = displayArea;
	}
	
	public void activateBar(String barName) {
		toolBar.setToolBar(barName);
		tabBar.setTabBar(barName);
		displayArea.setArea(barName);
	}
}
