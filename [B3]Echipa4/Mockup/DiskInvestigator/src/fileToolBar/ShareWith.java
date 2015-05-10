package fileToolBar;

import java.awt.Dimension;

import javax.swing.JComboBox;

public class ShareWith extends JComboBox<String>{

	private static final long serialVersionUID = -422632527935194588L;

	public ShareWith(){
		super();
		
		setMaximumSize(new Dimension(100, 20) );
	}
	
}
