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
		JLabel pid = new JLabel("PID");
		pid.setPreferredSize(new Dimension(70, 30));
		JLabel description = new JLabel("Description");
		description.setPreferredSize(new Dimension(500, 30));
		JLabel status = new JLabel("Status");
		status.setPreferredSize(new Dimension(100, 30));
		
		JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, description, status);
	    splitPane1.setDividerSize(2);
	    splitPane1.setDividerLocation(0.5);
		JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, pid, splitPane1);
	    splitPane2.setDividerLocation(0.4);
	    splitPane2.setDividerSize(2);
	    JSplitPane splitPane3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, name, splitPane2);
	    splitPane3.setDividerLocation(0.4);
	    splitPane3.setDividerSize(2);
		add(splitPane3, BorderLayout.LINE_START);
	}
}
