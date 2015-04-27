package fileToolBar;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JToolBar;

public class FileToolBar extends JToolBar{

    private DiskScan diskScan = new DiskScan();
    private FileWorker fileWorker = new FileWorker();
    
    public FileToolBar(){
    	setFloatable(false);
		setPreferredSize(new Dimension(100, 70));
    }
    
    public void initializeButtons() {
		add(new JLabel("                 "));
		add(processScan.getNewTaskButton());
		add(new JLabel("                 "));
		add(processScan.getEndButton());
		add(new JLabel("                 "));
		add(processCheck.getCheckButton());
	}
}
