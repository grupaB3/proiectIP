package displayArea;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class AreaOfDisplay extends JPanel {

	private static final long serialVersionUID = -1492665909386157548L;
	//private OrderByArea orderArea = new OrderByArea();
	private FilesDisplayer filesArea = new FilesDisplayer();
	private ProcessesDisplayer processesArea = new ProcessesDisplayer();
	private ServicesDisplayer servicesArea = new ServicesDisplayer();
	private TasksDisplayer tasksArea = new TasksDisplayer();
	
	public AreaOfDisplay() {
		initUI();
	}
	
	private void initUI() {
		
		//add(orderArea, BorderLayout.NORTH);
		add(filesArea);
		add(processesArea);
		add(servicesArea);
		add(tasksArea);
		
		setArea("start");
		setLayout(new FlowLayout());
	}
	
	public void setArea(String areaName) {
		//orderArea.setOrderBar(areaName);
		switch(areaName) {
			case "start":
				filesArea.setVisible(false);
				processesArea.setVisible(false);
				servicesArea.setVisible(false);
				tasksArea.setVisible(false);
				break;
			case "file":
				filesArea.setVisible(true);
				processesArea.setVisible(false);
				servicesArea.setVisible(false);
				tasksArea.setVisible(false);
				break;
			case "process":
				filesArea.setVisible(false);
				processesArea.setVisible(true);
				servicesArea.setVisible(false);
				tasksArea.setVisible(false);
				break;
			case "service":
				filesArea.setVisible(false);
				processesArea.setVisible(false);
				servicesArea.setVisible(true);
				tasksArea.setVisible(false);
				break;
			case "task":
				filesArea.setVisible(false);
				processesArea.setVisible(false);
				servicesArea.setVisible(false);
				tasksArea.setVisible(true);
				break;
		}
	}
}
