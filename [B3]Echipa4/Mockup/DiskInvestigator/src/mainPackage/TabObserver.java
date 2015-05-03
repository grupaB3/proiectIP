package mainPackage;

import displayArea.AreaOfDisplay;

public class TabObserver {
	private AreaOfDisplay displayArea = null;
	
	public TabObserver(AreaOfDisplay displayArea) {
		this.displayArea = displayArea;
	}
	
	public void setDisplayArea(String areaName) {
		displayArea.setArea(areaName);
	}
}
