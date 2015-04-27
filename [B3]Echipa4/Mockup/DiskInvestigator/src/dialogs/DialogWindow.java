package dialogs;
import javax.swing.JDialog;

@SuppressWarnings("serial")
public class DialogWindow extends JDialog {

	private int width;
	private int height;
	private String message;
	private JDialog dialog;
	
	public int getWidth() {
		return width;
	};
	public void setWidth(int width) {
		this.width = width;
	};
	public int getHeight() {
		return height;
	};
	public void setHeight(int height) {
		this.height = height;
	};
	public String getMessage() {
		return message;
	};
	public void setMessage(String message) {
		this.message = message;
	};
	public JDialog getDialog() {
		return dialog;
	};
	public void setDialog(JDialog dialog) {
		this.dialog = dialog;
	};
	
	DialogWindow(){
		width=0;
		height=0;
		message="";
		dialog=new JDialog();
	};

	DialogWindow(int width, int height, String message, JDialog dialog){
		this.width=width;
		this.height=height;
		this.message=message;
		this.dialog=dialog;
	};
	
	public void displayMessage(String message){};
	public void displayDialog() {};
	public void hideDialog() {};
	public void closeDialog() {};

}