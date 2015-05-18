package observers;

import items.FileHandler;

public class FileObserver {
	private FileHandler fileHandler;
	
	public FileObserver(FileHandler fileHandler) {
		setFileHandler(fileHandler);
	}
	
	public void startScan(String diskName) {
		fileHandler.scanFiles(diskName);
	}
	
	public void stopScan() {
		fileHandler.stopScan();
	}

	public FileHandler getFileHandler() {
		return fileHandler;
	}

	public void setFileHandler(FileHandler fileHandler) {
		this.fileHandler = fileHandler;
	}
}
