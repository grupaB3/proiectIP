package displayArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class OrderByArea extends JPanel {

	private static final long serialVersionUID = 5517085176463400405L;
	private OrderFiles filesCategories = new OrderFiles();
	private OrderProcesses processesCategories = new OrderProcesses();
	private OrderServices servicesCategories = new OrderServices();
	private OrderTasks tasksCategories = new OrderTasks();
	
	protected OrderByArea() {
		initUI();
	}
	
	private void initUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(filesCategories, BorderLayout.LINE_START);
		add(processesCategories, BorderLayout.LINE_START);
		add(servicesCategories, BorderLayout.LINE_START);
		add(tasksCategories, BorderLayout.LINE_START);
		
		setOrderBar("start");
		//setBackground(Color.green);
		setPreferredSize(new Dimension(70, 40));
		setLayout(new FlowLayout(FlowLayout.LEADING));
	}
	
	public void setOrderBar(String barName) {
		switch(barName) {
			case "start":
				filesCategories.setVisible(false);
				processesCategories.setVisible(false);
				servicesCategories.setVisible(false);
				tasksCategories.setVisible(false);
				break;
			case "file":
				filesCategories.setVisible(true);
				processesCategories.setVisible(false);
				servicesCategories.setVisible(false);
				tasksCategories.setVisible(false);
				break;
			case "process":
				filesCategories.setVisible(false);
				processesCategories.setVisible(true);
				servicesCategories.setVisible(false);
				tasksCategories.setVisible(false);
				break;
			case "service":
				filesCategories.setVisible(false);
				processesCategories.setVisible(false);
				servicesCategories.setVisible(true);
				tasksCategories.setVisible(false);
				break;
			case "task":
				filesCategories.setVisible(false);
				processesCategories.setVisible(false);
				servicesCategories.setVisible(false);
				tasksCategories.setVisible(true);
				break;
		}
	}
}
