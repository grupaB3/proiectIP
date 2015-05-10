package displayArea;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class AreaOfDisplay extends JPanel {

	private static final long serialVersionUID = -1492665909386157548L;
	private OrderByArea orderArea = new OrderByArea();
	private ServicesDisplayer servicesArea = new ServicesDisplayer();
	
	public AreaOfDisplay() {
		initUI();
	}
	
	private void initUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(orderArea, BorderLayout.NORTH);
		add(servicesArea, BorderLayout.CENTER);
	}
	
	public void setArea(String areaName) {
		orderArea.setOrderBar(areaName);
	}
}
