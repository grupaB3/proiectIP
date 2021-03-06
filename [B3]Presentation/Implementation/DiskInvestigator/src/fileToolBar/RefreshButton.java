package fileToolBar;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import observers.FileObserver;

public class RefreshButton extends JButton{
	
	private static final long serialVersionUID = 4753677614771415350L;

	private FileObserver fileObserver;
	
	public RefreshButton(){
		try {
		    Image img = ImageIO.read(getClass().getResource("refresh.png"));
		    this.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
		  }
		setEnabled(false);
		this.setToolTipText("Refresh");
		
        addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });
		
	}
	
	private void RefreshButtonActionPerformed(ActionEvent evt) {
		String diskName = fileObserver.getFileHandler().getDiskName();
		fileObserver.startScan(diskName);
    }


	public FileObserver getFileObserver() {
		return fileObserver;
	}


	public void setFileObserver(FileObserver fileObserver) {
		this.fileObserver = fileObserver;
	}
	
}
