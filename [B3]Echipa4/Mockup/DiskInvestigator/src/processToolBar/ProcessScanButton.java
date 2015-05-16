package processToolBar;

import java.awt.Dimension;
import javax.swing.JButton;

public class ProcessScanButton extends JButton{

	private static final long serialVersionUID = 1378373445586830621L;

	protected ProcessScanButton(){
		super("Process Scan");
		setPreferredSize(new Dimension(60,40));
		setMaximumSize(new Dimension(60,40));
		setMinimumSize(new Dimension(60,40));
	}
}
