package processToolBar;

import java.awt.Dimension;
import javax.swing.JButton;

public class EndTaskButton extends JButton {

	private static final long serialVersionUID = -7886632775613251506L;

	protected EndTaskButton(){
		super("End Task");
		setPreferredSize(new Dimension(60,40));
		setMaximumSize(new Dimension(60,40));
		setMinimumSize(new Dimension(60,40));
	}
}
