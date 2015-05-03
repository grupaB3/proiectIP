package displayArea;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class AreaOfDisplay extends JPanel {
	private OrderByArea orderArea = new OrderByArea();
	
	public AreaOfDisplay() {
		initUI();
	}
	
	private void initUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(orderArea, BorderLayout.NORTH);
		//setBackground(Color.blue);
	}
	
	public void setArea(String areaName) {
		orderArea.setOrderBar(areaName);
	}
}
