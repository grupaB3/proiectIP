package observers;

import mainToolBar.ToolBar;
import displayArea.AreaOfDisplay;

public class TabObserver {
	private ToolBar toolBar = null;
	private AreaOfDisplay displayArea = null;
	
	public TabObserver(AreaOfDisplay displayArea) {
		this.displayArea = displayArea;
	}
	
	public void setDisplayArea(String areaName) {
		displayArea.setArea(areaName);
		toolBar.setToolBar(areaName);
	}

	public void setToolBar(ToolBar toolBar) {
		this.toolBar = toolBar;
	}
}
