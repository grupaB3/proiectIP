package dialogs;

import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class ErrorDialog extends DialogWindow {

	private JOptionPane optionPane;
	
	public ErrorDialog(){
		super();
		this.getDialog().setModal(true);
		this.getDialog().setAlwaysOnTop(true);
		this.getDialog().setModalityType(ModalityType.APPLICATION_MODAL);
		this.getDialog().setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public void displayMessage(String message){
		optionPane=new JOptionPane(message, JOptionPane.ERROR_MESSAGE); 
		JDialog dialog = optionPane.createDialog("Error");
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
	};
}