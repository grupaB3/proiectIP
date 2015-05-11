package displayArea;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class FileInfoArea extends JPanel {

	private static final long serialVersionUID = -2809884889360505234L;

	protected FileInfoArea() {
		initUI();
	}
	
	private void initUI() {
		
		setBackground(Color.gray);
		setPreferredSize(new Dimension(276, 450));
	}
}