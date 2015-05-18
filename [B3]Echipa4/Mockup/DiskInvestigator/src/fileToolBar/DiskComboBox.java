package fileToolBar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import diskscan.DiskPartition;

@SuppressWarnings("serial")
public class DiskComboBox extends JComboBox<String> {
	private DiskScan diskScan;
	
	protected DiskComboBox() {
		DiskPartition diskPartition = new DiskPartition();
		System.out.println(diskPartition.getPhysDrives().size());
		String[] tempChoices = new String[diskPartition.getPhysDrives().size()];
		for(int index = 0; index < tempChoices.length; index ++) {
			tempChoices[index] = diskPartition.getPhysDrives().get(index).toString();
		}
		insertItemAt("", 0);
		initBox(tempChoices);
		setMinimumSize(new Dimension(100, 30));
		setMaximumSize(new Dimension(100, 30));
	}
	
	private void initBox(String[] choices) {
		for(int index = 0; index < choices.length; index ++) {
			addItem(choices[index]);
		}
		
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				diskScan.setDiskSelected(getSelectedItem().toString());
				if(getSelectedItem().equals("")) {
					setButtonStatus("pre-choice");
				}
				if(!getSelectedItem().equals("")) {
					setButtonStatus("pre-scan");
				}
				/*if(scanned == true && typeOfSelection == 0) {
					setButtonStatus("unselectedFile");
				}
				if(scanned == true && typeOfSelection == 1) {
					setButtonStatus("selectedNormalFile");
				}
				if(scanned == true && typeOfSelection == 2) {
					setButtonStatus("selectedDeletedFile");
				}*/
			}
		});
	}
	
	public void setButtonStatus (String state) {
		switch(state) {
			case "pre-choice":
				diskScan.setRecoveryButtonStatus(false);
				diskScan.setRefreshButtonStatus(false);
				diskScan.setScanButtonStatus(false);
				break;
			case "pre-scan":
				diskScan.setRecoveryButtonStatus(false);
				diskScan.setRefreshButtonStatus(false);
				diskScan.setScanButtonStatus(true);
				break;
			/*case "unselectedFile":
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
				break;*/
		}
	}

	public DiskScan getDiskScan() {
		return diskScan;
	}

	public void setDiskScan(DiskScan diskScan) {
		this.diskScan = diskScan;
	}
}
