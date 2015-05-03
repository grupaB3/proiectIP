package displayArea;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class OrderTasks extends JPanel {
	protected OrderTasks() {
		initUI();
	}
	
	private void initUI() {
		JLabel name = new JLabel("Task name");
		name.setPreferredSize(new Dimension(150, 30));
		JLabel status = new JLabel("Status");
		status.setPreferredSize(new Dimension(70, 30));
		
		JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, name, status);
	    splitPane1.setDividerSize(2);
	    splitPane1.setDividerLocation(0.5);
	    
		add(splitPane1, BorderLayout.LINE_START);
	}
}
