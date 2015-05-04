package displayArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

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
		add(processesCategories, BorderLayout.LINE_START);
		add(servicesCategories, BorderLayout.LINE_START);
		add(tasksCategories, BorderLayout.LINE_START);
		
		setOrderBar("start");
		//setBackground(Color.green);
		setPreferredSize(new Dimension(70, 40));
		setLayout(new FlowLayout(FlowLayout.LEADING));
	}
	
	public void setOrderBar(String barName) {
		System.out.println("bar's name: "+barName);
		switch(barName) {
			case "start":
				filesCategories.setVisible(false);
				processesCategories.setVisible(false);
				servicesCategories.setVisible(false);
				tasksCategories.setVisible(false);
				System.out.println("Set orderBar2: none");
				break;
			case "file":
				filesCategories.setVisible(true);
				processesCategories.setVisible(false);
				servicesCategories.setVisible(false);
				tasksCategories.setVisible(false);
				System.out.println("Set orderBar2: file");
				break;
			case "process":
				filesCategories.setVisible(false);
				processesCategories.setVisible(true);
				servicesCategories.setVisible(false);
				tasksCategories.setVisible(false);
				System.out.println("Set orderBar2: process");
				break;
			case "service":
				filesCategories.setVisible(false);
				processesCategories.setVisible(false);
				servicesCategories.setVisible(true);
				tasksCategories.setVisible(false);
				System.out.println("Set orderBar2: service");
				break;
			case "task":
				filesCategories.setVisible(false);
				processesCategories.setVisible(false);
				servicesCategories.setVisible(false);
				tasksCategories.setVisible(true);
				System.out.println("Set orderBar2: task");
				break;
		}
	}
}
