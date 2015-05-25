package processToolBar;

import java.awt.Dimension;

import javax.swing.JComboBox;

public class StartupTypeBox extends JComboBox<String>{

	private static final long serialVersionUID = 970216431291512678L;

	public StartupTypeBox(){
		super();
		setMaximumSize(new Dimension(100, 20) );
	}
	
}
