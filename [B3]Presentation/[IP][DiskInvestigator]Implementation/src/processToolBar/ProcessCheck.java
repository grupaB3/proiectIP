package processToolBar;

public class ProcessCheck {
	 private ProcessScanButton processScanButton;
	
	
	protected ProcessCheck(){
		processScanButton=new ProcessScanButton();
	}
	
	public ProcessScanButton getCheckButton(){
		return processScanButton;
	}
}
