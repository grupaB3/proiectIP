package dialogs;

import items.ProcessHandler;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InputDialog extends DialogWindow {
	
	private ProcessHandler processesHandler;
	private boolean visibility = false;
	JDialog dialog;
	private String text;
	
	public InputDialog(ProcessHandler processesHandler){
		super();
		setProcessHandler(processesHandler);
		this.getDialog().setModal(true);
		this.getDialog().setAlwaysOnTop(true);
		this.getDialog().setModalityType(ModalityType.APPLICATION_MODAL);
		this.getDialog().setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void displayMessage(String message){
		
		JPanel pane = new JPanel();
		pane.setLayout(null);
		pane.setMinimumSize(new Dimension(250, 85));
		pane.setMaximumSize(new Dimension(250, 85));
		pane.setPreferredSize(new Dimension(250, 85));
		
		JButton start = new JButton("Start");
		start.setBounds(30, 50, 80, 25);
		
		JButton cancel = new JButton("Cancel");
		cancel.setBounds(140, 50, 80, 25);
		
		JTextField  testField = new JTextField();
		testField.setBounds(30, 15, 190, 25);
		
		pane.add(testField);
		pane.add(start);
		pane.add(cancel);
		
		dialog = new JDialog();
		dialog.setTitle("New Process");
		
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisibility(false);
				dispose();
			}
		});
		
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				text = testField.getText();
				if (!text.equals(null) && !text.equals(" ") && !text.equals(""))
					{
					setText(text);
					}
				setVisibility(false);
				dispose();
			}
		});
		
		dialog.getContentPane().add(pane);
		dialog.pack();
		dialog.setAlwaysOnTop(true);
		dialog.setLocationRelativeTo(null);
		dialog.setModal(true);
		dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ImageIcon icon = new ImageIcon(getClass().getResource("../mainPackage/icon.png"));
		dialog.setIconImage(icon.getImage());
		this.setDialog(dialog);
		this.getDialog().setAlwaysOnTop(true);
		this.getDialog().setVisible(true);
	};
	
	public void setText(String t){
		text = t;
	}
	public String getText(){
		return text;
	}
	
	public void dispose() {
		super.dispose();
		dialog.dispose();
	}
	
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
	
	public ProcessHandler getProcessHandler() {
		return processesHandler;
	}

	public void setProcessHandler(ProcessHandler processesHandler) {
		this.processesHandler = processesHandler;
	}
	
	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}
}
