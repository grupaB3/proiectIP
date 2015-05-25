package fileToolBar;

import observers.FileObserver;

public class DiskScan {
    private ScanButton scanButton;
    private RecoveryButton recoveryButton;
    private RefreshButton refreshButton;
    
    public DiskScan(){
    	scanButton = new ScanButton();
        recoveryButton = new RecoveryButton();
        refreshButton = new RefreshButton();
    }
    
    public void setDiskSelected(String diskName) {
    	scanButton.setDiskSelected(diskName);
    }
    
    public void setScanButtonStatus(boolean state) {
    	scanButton.setEnabled(state);
    }
    
    public void setRecoveryButtonStatus(boolean state) {
    	recoveryButton.setEnabled(state);
    }
    
    public void setRefreshButtonStatus(boolean state) {
    	refreshButton.setEnabled(state);
    }
    
    public ScanButton getScanButton(){
    	return scanButton;
    }
    public RecoveryButton getRecoveryButton(){
    	return recoveryButton;
    }
    public RefreshButton getRefreshButton(){
    	return refreshButton;
    }

	public void setObserver(FileObserver fileObserver) {
		scanButton.setFileObserver(fileObserver);
		refreshButton.setFileObserver(fileObserver);
		recoveryButton.setFileObserver(fileObserver);
	} 
}
