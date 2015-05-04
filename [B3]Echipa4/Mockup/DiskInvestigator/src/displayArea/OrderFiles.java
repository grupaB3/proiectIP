package displayArea;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class OrderFiles extends JPanel {
	protected OrderFiles() {
		initUI();
	}
	
	private void initUI() {
		JLabel name = new JLabel("Name");
		name.setPreferredSize(new Dimension(150, 30));
		JLabel extension = new JLabel("Extension");
		extension.setPreferredSize(new Dimension(70, 30));
		JLabel path = new JLabel("Path");
		path.setPreferredSize(new Dimension(750, 30));
		
		JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, extension, path);
	    splitPane1.setDividerSize(2);
	    splitPane1.setDividerLocation(0.5);
		JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, name, splitPane1);
	    splitPane2.setDividerLocation(0.4);
	    splitPane2.setDividerSize(2);
		add(splitPane2, BorderLayout.LINE_START);
	}
}
