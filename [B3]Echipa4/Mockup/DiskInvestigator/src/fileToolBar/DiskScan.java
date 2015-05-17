package fileToolBar;

public class DiskScan {
    private ScanButton scanButton;
    private RecoveryButton recoveryButton;
    private RefreshButton refreshButton;
    
    public DiskScan(){
    	scanButton = new ScanButton();
        recoveryButton = new RecoveryButton();
        refreshButton = new RefreshButton();
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
}
