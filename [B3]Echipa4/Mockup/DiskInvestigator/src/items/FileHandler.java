package items;

import java.util.HashMap;

public class FileHandler {
	private boolean scanned = false;
	//private HashMap<K, V> filesMap;
	
	public void scanFiles(String diskName) {
		
		Thread scanThread = new Thread() {
			
			public void run() {
				System.out.println("Started thread for scanning. ");
				for(int index = 0; index < 10; index ++) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(index);
				}
				//filesMap =  getFiles - module 3
				setScanned(true);
				System.out.println("Finished scan. ");
			}
		};
		
		scanThread.start();
	}
	
	public void stopScan() {
		//stopScan - module 3
		System.out.println("Scan stopped. ");
	}

	public boolean isScanned() {
		return scanned;
	}

	public void setScanned(boolean scanned) {
		this.scanned = scanned;
	}
	
}
