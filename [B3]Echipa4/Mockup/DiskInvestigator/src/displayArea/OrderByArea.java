package displayArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class OrderByArea extends JPanel {
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
		filesCategories.setVisible(false);
		add(processesCategories, BorderLayout.LINE_START);
		processesCategories.setVisible(false);
		add(servicesCategories, BorderLayout.LINE_START);
		servicesCategories.setVisible(false);
		add(tasksCategories, BorderLayout.LINE_START);
		//tasksCategories.setVisible(false);
		//setBackground(Color.green);
		setPreferredSize(new Dimension(70, 30));
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
