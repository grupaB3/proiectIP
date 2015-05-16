package processToolBar;

import java.awt.Dimension;
import javax.swing.JButton;


public class EndProcessButton extends JButton {

	private static final long serialVersionUID = -604762861486061083L;

	protected EndProcessButton(){
		super("End Process");
		setPreferredSize(new Dimension(60,40));
		setMaximumSize(new Dimension(60,40));
		setMinimumSize(new Dimension(60,40));
	}
}
