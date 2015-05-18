package dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import observers.FileObserver;

@SuppressWarnings("serial")
public class LoadingDialog extends DialogWindow {
	private FileObserver fileObserver;
	
	public LoadingDialog(FileObserver fileObserver){
		super();
		setFileObserver(fileObserver);
		this.getDialog().setModal(true);
		this.getDialog().setAlwaysOnTop(true);
		this.getDialog().setModalityType(ModalityType.APPLICATION_MODAL);
		this.getDialog().setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	@Override
	public void displayMessage(String message){
		ImageIcon icon = null;
		try {
		    Image img = ImageIO.read(getClass().getResource("3W2Vo.png"));
		    icon = new ImageIcon(img);
		  } catch (IOException ex) {
		  }
		
		Object[] options = {"Stop"};
		
		JPanel pane = new JPanel();
		pane.setLayout(null);
		pane.setMinimumSize(new Dimension(300, 100));
		pane.setMaximumSize(new Dimension(300, 100));
		pane.setPreferredSize(new Dimension(300, 100));
		
		JButton stop = new JButton("Stop");
		stop.setBounds(125, 70, 50, 20);
		
		JLabel iconLabel = new JLabel(icon);
		iconLabel.setBounds(40, 10, 50, 50);
		
		JLabel messageLabel = new JLabel(message);
		messageLabel.setBounds(130, 30, 70, 15);
		
		pane.add(iconLabel);
		pane.add(messageLabel);
		pane.add(stop);
		

		JDialog dialog = new JDialog();
		dialog.setTitle("Loading");
		stop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialog.dispose();
				fileObserver.stopScan();
			}
			
		});
		dialog.getContentPane().add(pane);
		dialog.pack();
		dialog.setAlwaysOnTop(true);
		dialog.setLocationRelativeTo(null);
		dialog.setModal(true);
		dialog.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setDialog(dialog);
		this.getDialog().setAlwaysOnTop(true);
		this.getDialog().setVisible(true);
	};
	
	@Override
	public void displayDialog(){
		this.getDialog().setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2, (Toolkit.getDefaultToolkit().getScreenSize().height)/2);
		this.getDialog().setVisible(true);
	}
	
	@Override
	public void hideDialog() {
		this.getDialog().setVisible(false);
	};
	
	@Override
	public void closeDialog() {
		this.getDialog().dispose();
	}

	public FileObserver getFileObserver() {
		return fileObserver;
	}

	public void setFileObserver(FileObserver fileObserver) {
		this.fileObserver = fileObserver;
	}
	
}
