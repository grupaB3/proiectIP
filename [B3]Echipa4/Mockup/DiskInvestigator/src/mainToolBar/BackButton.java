package mainToolBar;

import java.awt.Dimension;

import javax.swing.JButton;

public class BackButton extends JButton {
	
	private static final long serialVersionUID = 7412370022553305901L;

	public BackButton() {
		super("Back");
		setPreferredSize(new Dimension(60,40));
		setMaximumSize(new Dimension(60,40));
		setMinimumSize(new Dimension(60,40));
	}
}
