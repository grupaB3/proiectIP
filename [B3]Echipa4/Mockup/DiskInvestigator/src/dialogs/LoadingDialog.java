package dialogs;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class LoadingDialog extends DialogWindow {
	private JOptionPane optionPane;
	
	public LoadingDialog(){
		super();
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
		
		optionPane=new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, icon, options); 
		JDialog dialog = optionPane.createDialog("Loading");
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
	
}
