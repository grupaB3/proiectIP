package displayArea;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class FilesDisplayer extends JPanel {

	private static final long serialVersionUID = -2809884889360505234L;

	private FileListArea fileListArea = new FileListArea();
	private FileInfoArea fileInfoArea = new FileInfoArea();
	
	protected FilesDisplayer() {
		initUI();
	}
	
	private void initUI() {
		
		JPanel space = new JPanel();
		space.setPreferredSize(new Dimension(2, 450));
		
		add(space);
		add(fileListArea);
		add(fileInfoArea);
		
		//setBackground(Color.cyan);
		setPreferredSize(new Dimension(898, 450));
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
	}
}
