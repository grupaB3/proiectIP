package items;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

import javax.swing.SwingWorker;

import dialogs.LoadingDialog;
import diskscan.*;
import displayArea.FilesDisplayer;

public class FileHandler {
	private boolean scanned = false;
	private LoadingDialog loading;
	private Scan fileScan;
	private FilesDisplayer fileDisplayer;
	
	private Map<Integer, MFTEntry> filesMap;
	
	public void scanFiles(String diskName) {
		loading = new LoadingDialog(this);
		loading.setVisibility(true);
		
		SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>(){
			@Override
	         protected Void doInBackground() throws Exception {

	        	 System.out.println("Started thread for scanning. ");
					for(int index = 0; index < 5; index ++) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(index);
					}
					fileScan = new Scan(diskName);				
					setScanned(true);
	            return null;
	         }
		};
	      
		mySwingWorker.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
	        public void propertyChange(PropertyChangeEvent evt) {
	           if (evt.getPropertyName().equals("state")) {
	              if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
	                 loading.dispose();
	              }
	           }
	        }
		});
	    mySwingWorker.execute();
		
	    loading.displayMessage("Scanning...");
	    setFilesMap(fileScan.getMapMFT());
	    
	    fileDisplayer.getFileListArea().setData(filesMap);
	    
	    System.out.println("Done.");
	}
	
	public void stopScan() {
		fileScan.setStopped();
		System.out.println("Scan stopped. ");
		loading.dispose();
	}

	public boolean isScanned() {
		return scanned;
	}

	public void setScanned(boolean scanned) {
		this.scanned = scanned;
	}

	public Map<Integer, MFTEntry> getFilesMap() {
		return filesMap;
	}

	public void setFilesMap(Map<Integer, MFTEntry> filesMap) {
		this.filesMap = filesMap;
	}
	
	
	public FilesDisplayer getFileDisplayer() {
		return fileDisplayer;
	}

	public void setFileDisplayer(FilesDisplayer fileDisplayer) {
		this.fileDisplayer = fileDisplayer;
	}
	
}
