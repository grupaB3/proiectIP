package dialogs;
import javax.swing.ImageIcon;
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
		setDefaultLookAndFeelDecorated(true);
		width=0;
		height=0;
		message="";
		dialog=new JDialog();
		ImageIcon icon = new ImageIcon(getClass().getResource("../mainPackage/icon.png"));
		setIconImage(icon.getImage());
	};

	DialogWindow(int width, int height, String message, JDialog dialog){
		setDefaultLookAndFeelDecorated(true);
		this.width=width;
		this.height=height;
		this.message=message;
		this.dialog=dialog;
		ImageIcon icon = new ImageIcon(getClass().getResource("../mainPackage/icon.png"));
		setIconImage(icon.getImage());
	};
	
	public void displayMessage(String message){};
	public void displayDialog() {};
	public void hideDialog() {};
	public void closeDialog() {};
}