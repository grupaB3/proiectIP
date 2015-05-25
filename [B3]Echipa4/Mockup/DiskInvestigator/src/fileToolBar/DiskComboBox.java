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
			}
		});
	}
	
	public void setButtonStatus (String state) {
		switch(state) {
			case "pre-choice":
				diskScan.setScanButtonStatus(false);
				break;
			case "pre-scan":
				diskScan.setScanButtonStatus(true);
				break;
		}
	}

	public DiskScan getDiskScan() {
		return diskScan;
	}

	public void setDiskScan(DiskScan diskScan) {
		this.diskScan = diskScan;
	}
}
