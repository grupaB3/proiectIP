package observers;

import displayArea.AreaOfDisplay;

public class TabObserver {
	private AreaOfDisplay displayArea;
	
	public TabObserver(AreaOfDisplay displayArea) {
		this.displayArea = displayArea;
	}
	
	public void setDisplayArea(String areaName) {
		displayArea.setArea(areaName);
	}
}
