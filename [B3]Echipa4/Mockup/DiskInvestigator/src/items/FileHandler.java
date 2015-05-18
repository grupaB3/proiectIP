package items;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

import javax.swing.SwingWorker;

import dialogs.LoadingDialog;

public class FileHandler {
	private boolean scanned = false;
	LoadingDialog loading;
	
	//private HashMap<Integer, MFTEntry> filesMap;
	
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
					//start scan function
					
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
		
	    //filesMap =  getFiles - module 3
	    System.out.println("Done.");
	}
	
	public void stopScan() {
		//stopScan - module 3
		System.out.println("Scan stopped. ");
		loading.dispose();
	}

	public boolean isScanned() {
		return scanned;
	}

	public void setScanned(boolean scanned) {
		this.scanned = scanned;
	}
	
}
