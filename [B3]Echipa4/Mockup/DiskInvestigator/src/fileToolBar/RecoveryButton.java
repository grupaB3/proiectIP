package fileToolBar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import observers.FileObserver;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RecoveryButton extends JButton {

	private static final long serialVersionUID = 4049711543317874759L;
	private FileObserver fileObserver;

	public RecoveryButton() {
		try {
			Image img = ImageIO.read(getClass().getResource("Recover.png"));
			this.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		setEnabled(false);
		this.setToolTipText("Recover File");

		addActionListener(new ActionListener() {           
			public void actionPerformed(ActionEvent evt) {
				RecoveryButtonActionPerformed(evt);
			}
		});
	}

	private void RecoveryButtonActionPerformed(ActionEvent evt) {
		fileObserver.getFileHandler().recover();
	}

	public FileObserver getFileObserver() {
		return fileObserver;
	}

	public void setFileObserver(FileObserver fileObserver) {
		this.fileObserver = fileObserver;
	}
}
