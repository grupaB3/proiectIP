package processToolBar;

import java.awt.Dimension;
import javax.swing.JButton;


public class NewTaskButton extends JButton {

	private static final long serialVersionUID = 8036356612846484755L;

	protected NewTaskButton(){
		super("New Task");
		setPreferredSize(new Dimension(60,40));
		setMaximumSize(new Dimension(60,40));
		setMinimumSize(new Dimension(60,40));
	}
}
