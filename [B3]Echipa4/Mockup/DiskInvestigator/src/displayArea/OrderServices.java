package displayArea;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class OrderServices extends JPanel {

	private static final long serialVersionUID = 786034936195262189L;

	protected OrderServices() {
		initUI();
	}
	
	private void initUI() {
		JLabel name = new JLabel("Name");
		name.setPreferredSize(new Dimension(300, 30));
		name.setMinimumSize(new Dimension(150, 30));
		JLabel type = new JLabel("Type");
		type.setPreferredSize(new Dimension(200, 30));
		type.setMinimumSize(new Dimension(100, 30));
		JLabel status = new JLabel("Status");
		status.setPreferredSize(new Dimension(200, 30));
		status.setMinimumSize(new Dimension(100, 30));
		JLabel startupType = new JLabel("Description");
		startupType.setPreferredSize(new Dimension(270, 30));
		startupType.setMinimumSize(new Dimension(150, 30));
		
		JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, status, startupType);
	    splitPane1.setDividerSize(2);
	    splitPane1.setDividerLocation(0.5);
	    splitPane1.setResizeWeight(0.5);
		JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, type, splitPane1);
	    splitPane2.setDividerLocation(0.4);
	    splitPane2.setDividerSize(2);
	    splitPane2.setResizeWeight(0.5);
	    JSplitPane splitPane3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, name, splitPane2);
	    splitPane3.setDividerLocation(0.4);
	    splitPane3.setDividerSize(2);
	    splitPane3.setResizeWeight(0.5);
		add(splitPane3, BorderLayout.LINE_START);
	}
}
