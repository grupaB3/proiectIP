package fileToolBar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import observers.FileObserver;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ShredButton extends JButton {

	private static final long serialVersionUID = 1107443913731007899L;
	private FileObserver fileObserver;

	public ShredButton() {
		try {
		    Image img = ImageIO.read(getClass().getResource("Shred.png"));
		    this.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
		  }
		setEnabled(false);
		this.setToolTipText("Shred File");
		
		addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent evt) {
                ShredButtonActionPerformed(evt);
            }
        });
	}
	
	private void ShredButtonActionPerformed(ActionEvent evt) {
		try {
			fileObserver.getFileHandler().shred();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public FileObserver getFileObserver() {
		return fileObserver;
	}

	public void setFileObserver(FileObserver fileObserver) {
		this.fileObserver = fileObserver;
	}
	
}
