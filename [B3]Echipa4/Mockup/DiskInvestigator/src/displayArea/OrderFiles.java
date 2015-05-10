package displayArea;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class OrderFiles extends JPanel {

	private static final long serialVersionUID = 442104390261958662L;

	protected OrderFiles() {
		initUI();
	}
	
	private void initUI() {
		JLabel name = new JLabel("Name");
		name.setPreferredSize(new Dimension(200, 30));
		name.setMinimumSize(new Dimension(100, 30));
		JLabel extension = new JLabel("Extension");
		extension.setPreferredSize(new Dimension(100, 30));
		extension.setMinimumSize(new Dimension(50, 30));
		JLabel size = new JLabel("Size");
		size.setPreferredSize(new Dimension(100, 30));
		size.setMinimumSize(new Dimension(50, 30));
		JLabel status = new JLabel("Status");
		status.setPreferredSize(new Dimension(120, 30));
		status.setMinimumSize(new Dimension(70, 30));
		JLabel path = new JLabel("Path");
		path.setPreferredSize(new Dimension(450, 30));
		path.setMinimumSize(new Dimension(200, 30));
		
		JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, status, path);
	    splitPane1.setDividerSize(2);
	    splitPane1.setDividerLocation(0.5);
	    splitPane1.setResizeWeight(0.5);
		JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, size, splitPane1);
	    splitPane2.setDividerLocation(0.5);
	    splitPane2.setDividerSize(2);
	    splitPane2.setResizeWeight(0.5);
	    JSplitPane splitPane3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, extension, splitPane2);
	    splitPane3.setDividerLocation(0.5);
	    splitPane3.setDividerSize(2);
	    splitPane3.setResizeWeight(0.5);
	    JSplitPane splitPane4 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, name, splitPane3);
	    splitPane4.setDividerLocation(0.5);
	    splitPane4.setDividerSize(2);
	    splitPane4.setResizeWeight(0.5);
	    
		add(splitPane4, BorderLayout.LINE_START);
	}
}
