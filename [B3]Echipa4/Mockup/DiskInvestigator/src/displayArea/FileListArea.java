package displayArea;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class FileListArea extends JPanel {

	private static final long serialVersionUID = -2809884889360505234L;

	protected FileListArea() {
		initUI();
	}
	
	private void initUI() {
		setBackground(Color.orange);
		setPreferredSize(new Dimension(620, 450));
	}
}
