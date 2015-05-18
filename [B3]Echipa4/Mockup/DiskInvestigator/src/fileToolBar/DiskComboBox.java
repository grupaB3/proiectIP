package fileToolBar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class DiskComboBox extends JComboBox<String> {
	private DiskScan diskScan;
	private FileWorker fileWorker;
	private boolean scanned = false;
	private int typeOfSelection = 0;
	
	protected DiskComboBox() {
		//get options - team 3
		String[] tempChoices = {"Disk0", "Disk1", "Disk2"};
		insertItemAt("", 0);
		initBox(tempChoices);
		setMinimumSize(new Dimension(100, 30));
		setMaximumSize(new Dimension(100, 30));
	}
	
	private void initBox(String[] choices) {
		for(int index = 0; index < choices.length; index ++) {
			addItem(choices[index]);
		}
		
		addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				diskScan.setDiskSelected(getSelectedItem().toString());
				if(getSelectedItem().equals("") && scanned == false) {
					setButtonStatus("pre-choice");
				}
				if(!getSelectedItem().equals("") && scanned == false) {
					setButtonStatus("pre-scan");
				}
				if(scanned == true && typeOfSelection == 0) {
					setButtonStatus("unselectedFile");
				}
				if(scanned == true && typeOfSelection == 1) {
					setButtonStatus("selectedNormalFile");
				}
				if(scanned == true && typeOfSelection == 2) {
					setButtonStatus("selectedDeletedFile");
				}
			}
		});
	}
	
	public void setButtonStatus (String state) {
		switch(state) {
			case "pre-choice":
				diskScan.setRecoveryButtonStatus(false);
				diskScan.setRefreshButtonStatus(false);
				diskScan.setScanButtonStatus(false);
				fileWorker.setSearchButtonStatus(false);
				fileWorker.setShredButtonStatus(false);
				break;
			case "pre-scan":
				diskScan.setRecoveryButtonStatus(false);
				diskScan.setRefreshButtonStatus(false);
				diskScan.setScanButtonStatus(true);
				fileWorker.setSearchButtonStatus(false);
				fileWorker.setShredButtonStatus(false);
				break;
			case "unselectedFile":
				diskScan.setRecoveryButtonStatus(false);
				diskScan.setRefreshButtonStatus(true);
				diskScan.setScanButtonStatus(true);
				fileWorker.setSearchButtonStatus(true);
				fileWorker.setShredButtonStatus(false);
				break;
			case "selectedNormalFile":
				diskScan.setRecoveryButtonStatus(false);
				diskScan.setRefreshButtonStatus(true);
				diskScan.setScanButtonStatus(true);
				fileWorker.setSearchButtonStatus(true);
				fileWorker.setShredButtonStatus(true);
				break;
			case "selectedDeletedFile":
				diskScan.setRecoveryButtonStatus(true);
				diskScan.setRefreshButtonStatus(true);
				diskScan.setScanButtonStatus(true);
				fileWorker.setSearchButtonStatus(true);
				fileWorker.setShredButtonStatus(true);
				break;
		}
	}

	public DiskScan getDiskScan() {
		return diskScan;
	}

	public void setDiskScan(DiskScan diskScan) {
		this.diskScan = diskScan;
	}

	public FileWorker getFileWorker() {
		return fileWorker;
	}

	public void setFileWorker(FileWorker fileWorker) {
		this.fileWorker = fileWorker;
	}
}
