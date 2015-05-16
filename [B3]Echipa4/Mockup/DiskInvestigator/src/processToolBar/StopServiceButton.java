package processToolBar;

import java.awt.Dimension;
import javax.swing.JButton;

public class StopServiceButton extends JButton {

	private static final long serialVersionUID = 3259570067502408586L;

	protected StopServiceButton(){
		super("Stop Service");
		setPreferredSize(new Dimension(60,40));
		setMaximumSize(new Dimension(60,40));
		setMinimumSize(new Dimension(60,40));
	}
}