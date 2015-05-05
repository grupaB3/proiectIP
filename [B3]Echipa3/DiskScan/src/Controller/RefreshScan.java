package Controller;

import Model.Diff;
import Model.Scan;

public class RefreshScan {
	
	private Scan lastScan;
	
	public void updateScan() {
		lastScan = Diff.computeDifferences(lastScan, lastScan.beginScan(lastScan.getPath()));
		updateInformation();
	}
	
	public void updateInformation() {
		
	}

}
