package fileToolBar;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import observers.FileObserver;


public class ScanButton extends JButton{
	
	private static final long serialVersionUID = -3732017140531624631L;
	private FileObserver fileObserver;
	private String diskSelected;

	public ScanButton(){
		try {
		    Image img = ImageIO.read(getClass().getResource("fileScan.png"));
		    this.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
		  }
		this.setToolTipText("Scan Files");
		
		addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent evt) {
                ScanButtonActionPerformed(evt);
            }
        });
	}
	

	private void ScanButtonActionPerformed(ActionEvent evt) {
		fileObserver.startScan(getDiskSelected());
    }


	public FileObserver getFileObserver() {
		return fileObserver;
	}


	public void setFileObserver(FileObserver fileObserver) {
		this.fileObserver = fileObserver;
	}


	public String getDiskSelected() {
		return diskSelected;
	}


	public void setDiskSelected(String diskSelected) {
		this.diskSelected = diskSelected;
	}
	
}
