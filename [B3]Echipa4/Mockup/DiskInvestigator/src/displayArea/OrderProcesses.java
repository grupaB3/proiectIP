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
		JLabel user = new JLabel("User Name");
		user.setPreferredSize(new Dimension(150, 30));
		JLabel processor = new JLabel("CPU");
		processor.setPreferredSize(new Dimension(70, 30));
		JLabel memory = new JLabel("Memory");
		memory.setPreferredSize(new Dimension(450, 30));
		
		JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, processor, memory);
	    splitPane1.setDividerSize(2);
	    splitPane1.setDividerLocation(0.5);
		JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, user, splitPane1);
	    splitPane2.setDividerLocation(0.4);
	    splitPane2.setDividerSize(2);
	    JSplitPane splitPane3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, name, splitPane2);
	    splitPane3.setDividerLocation(0.4);
	    splitPane3.setDividerSize(2);
		add(splitPane3, BorderLayout.LINE_START);
	}
}
