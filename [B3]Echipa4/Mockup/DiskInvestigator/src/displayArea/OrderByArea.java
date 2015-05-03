package displayArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class OrderByArea extends JPanel {
	private OrderFiles filesCategories = new OrderFiles();
	protected OrderByArea() {
		initUI();
	}
	
	private void initUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(filesCategories, BorderLayout.LINE_START);
		//setBackground(Color.green);
		setPreferredSize(new Dimension(70, 30));
	}
}
