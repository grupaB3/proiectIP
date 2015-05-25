package items;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.swing.SwingWorker;

import controller.ProcessCheck;
import dialogs.ErrorDialog;
import dialogs.LoadingDialog;
import diskscan.*;
import displayArea.FilesDisplayer;

public class FileHandler {
	private boolean scanned = false;
	private LoadingDialog loading;
	private Scan fileScan;
	private FilesDisplayer fileDisplayer;
	private String diskName = null;

	private Map<Integer, MFTEntry> filesMap;

	public void scanFiles(String diskName) {
		setDiskName(diskName);
		loading = new LoadingDialog(this);
		loading.setVisibility(true);

		SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>(){
			@Override
			protected Void doInBackground() throws Exception {

				System.out.println("Started thread for scanning. ");
				fileScan = new Scan(getDiskName());
				fileDisplayer.getFileListArea().getViewport().removeAll();
				fileScan.startScan();
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
		boolean isFinished = fileScan.getFinished();
		while(!isFinished){
			isFinished = fileScan.getFinished();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		setFilesMap(fileScan.getMapMFT());

		setScanned(true);

		fileDisplayer.getFileListArea().setData(filesMap);

		System.out.println("Done.");
	}

	public void stopScan() {
		fileScan.setStopped();
		System.out.println("Scan stopped. ");
		loading.dispose();
	}

	public void recover() {
		int rowNo = fileDisplayer.getFileListArea().getSelectedStatus();
		if(rowNo != -1 && fileDisplayer.getFileListArea().getSelectedFileColumn(3).equals("Deleted")) {
			File file = new File("\\\\.\\"+diskName);
			Recover.revive(Integer.parseInt(fileDisplayer.getFileListArea().getSelectedFileColumn(4)), file);
			
			fileDisplayer.getFileListArea().changeFileStatus(rowNo);
		}
		else {
			ErrorDialog error = new ErrorDialog();
			error.displayMessage("You have to select a deleted file");
		}
	}
	
	public void shred() throws IOException {
		if(fileDisplayer.getFileListArea().getSelectedStatus() != -1) {
			String path = fileDisplayer.getFileListArea().getPath(fileDisplayer.getFileListArea().getSelectedStatus());
			
			System.out.println(path);
			
			ProcessCheck processCheck = new ProcessCheck();
			boolean result = false;
			result = processCheck.delete(path);
			
			if(!result) {
				ErrorDialog error = new ErrorDialog();
				error.displayMessage("You have to select a deleted file.");
			}
		}
		else {
			ErrorDialog error = new ErrorDialog();
			error.displayMessage("You have to select a file.");
		}
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

	public String getDiskName() {
		return diskName;
	}

	public void setDiskName(String diskName) {
		this.diskName = diskName;
	}

}
