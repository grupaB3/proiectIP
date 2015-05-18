package fileToolBar;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JToolBar;

import observers.FileObserver;

public class FileToolBar extends JToolBar{

	private static final long serialVersionUID = -6055582868733811684L;
	
	private DiskScan diskScan = new DiskScan();
    private FileWorker fileWorker = new FileWorker();
    private DiskComboBox diskBox = new DiskComboBox();
    
    public FileToolBar() {
    	diskBox.setDiskScan(diskScan);
    	setFloatable(false);
		setPreferredSize(new Dimension(100, 70));
    }
    
    public void initializeButtons() {
		add(new JLabel("          "));
		add(diskScan.getScanButton());
		add(new JLabel("          "));
		add(diskScan.getRefreshButton());
		add(new JLabel("          "));
		add(fileWorker.getShredButton());
		add(new JLabel("          "));
		add(diskScan.getRecoveryButton());
		add(new JLabel("                "));
		add(diskBox);
		add(new JLabel("                                                               "));
		//add(fileWorker.getSearchButton());
		
		diskBox.setButtonStatus("pre-choice");
	}
    
    public void setFileObserver (FileObserver fileObserver) {
    	diskScan.setObserver(fileObserver);
    }
}