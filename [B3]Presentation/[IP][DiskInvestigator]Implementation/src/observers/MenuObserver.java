package observers;

import mainToolBar.ToolBar;

public class MenuObserver {
	private ToolBar toolBar;
	
	public MenuObserver(ToolBar toolBar) {
		this.toolBar = toolBar;
	}
	
	public void activateBar(String barName) {
		toolBar.setToolBar(barName);
	}
}
