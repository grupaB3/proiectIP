package dialogs;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class WarningDialog extends DialogWindow {

	private JOptionPane optionPane;
	
	public WarningDialog(){
		super();
		this.getDialog().setModal(true);
		this.getDialog().setAlwaysOnTop(true);
		this.getDialog().setModalityType(ModalityType.APPLICATION_MODAL);
		this.getDialog().setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public void displayMessage(String message){
		optionPane=new JOptionPane(message, JOptionPane.WARNING_MESSAGE); 
		JDialog dialog = optionPane.createDialog("Warning");
		ImageIcon icon = new ImageIcon(getClass().getResource("../mainPackage/icon.png"));
		dialog.setIconImage(icon.getImage());
		this.setDialog(dialog);
		this.getDialog().setAlwaysOnTop(true);
		this.getDialog().setVisible(true);
		
		//this.checkChoice();
	}
	
	public void checkChoice(){
		int choice=this.displayConfirmDialog();
		if (choice==0) this.displayDialog();
	}
	
	public int displayConfirmDialog(){
		JDialog.setDefaultLookAndFeelDecorated(true);
	    int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    int choice = -1;
	    if (response == JOptionPane.NO_OPTION) 
	    	choice=0;
	    else
	    	if (response == JOptionPane.YES_OPTION)
	    		choice=1;
	    	else
	    		if (response == JOptionPane.CLOSED_OPTION)
	    			choice=2;
	    return choice;
	}
	 
	@Override
	public void displayDialog(){
		this.getDialog().setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2, (Toolkit.getDefaultToolkit().getScreenSize().height)/2);
		this.getDialog().setVisible(true);
		
		int choice=this.displayConfirmDialog();
		if (choice==0) this.displayDialog();
	}
	
	@Override
	public void hideDialog() {
		this.getDialog().setVisible(false);
	};
	
	@Override
	public void closeDialog() {
		this.getDialog().dispose();
		JOptionPane.getRootFrame().dispose();   
	};
}