package displayArea;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class OrderProcesses extends JPanel {

	private static final long serialVersionUID = -267200151240694401L;

	protected OrderProcesses() {
		initUI();
	}
	
	private void initUI() {
		JLabel name = new JLabel("Name");
		name.setPreferredSize(new Dimension(300, 30));
		name.setMinimumSize(new Dimension(150, 30));
		JLabel user = new JLabel("Session Name");
		user.setPreferredSize(new Dimension(250, 30));
		user.setMinimumSize(new Dimension(100, 30));
		JLabel pID = new JLabel("PID");
		pID.setPreferredSize(new Dimension(150, 30));
		pID.setMinimumSize(new Dimension(50, 30));
		JLabel memory = new JLabel("Memory");
		memory.setPreferredSize(new Dimension(270, 30));
		memory.setMinimumSize(new Dimension(100, 30));
		
		JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, pID, memory);
	    splitPane1.setDividerSize(2);
	    splitPane1.setDividerLocation(0.5);
	    splitPane1.setResizeWeight(0.5);
		JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, user, splitPane1);
	    splitPane2.setDividerLocation(0.5);
	    splitPane2.setDividerSize(2);
	    splitPane2.setResizeWeight(0.5);
	    JSplitPane splitPane3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, name, splitPane2);
	    splitPane3.setDividerLocation(0.5);
	    splitPane3.setDividerSize(2);
	    splitPane3.setResizeWeight(0.5);
		add(splitPane3, BorderLayout.LINE_START);
	}
}
