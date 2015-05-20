package displayArea;

import java.awt.FlowLayout;
import javax.swing.JPanel;

public class AreaOfDisplay extends JPanel {

	private static final long serialVersionUID = -1492665909386157548L;

	private FilesDisplayer filesArea;
	private ProcessesDisplayer processesArea;
	private ServicesDisplayer servicesArea;
	private TasksDisplayer tasksArea = new TasksDisplayer();
	private StartUpDisplayer startUp = new StartUpDisplayer();
	
	public AreaOfDisplay() {
	}
	
	public void initUI() {
		
		add(startUp);
		add(filesArea);
		add(processesArea);
		add(servicesArea);
		add(tasksArea);
		
		setArea("start");
		setLayout(new FlowLayout());
	}
	
	public void setArea(String areaName) {

		switch(areaName) {
			case "start":
				startUp.setVisible(true);
				filesArea.setVisible(false);
				processesArea.setVisible(false);
				servicesArea.setVisible(false);
				tasksArea.setVisible(false);
				break;
			case "file":
				startUp.setVisible(false);
				filesArea.setVisible(true);
				processesArea.setVisible(false);
				servicesArea.setVisible(false);
				tasksArea.setVisible(false);
				break;
			case "process":
				startUp.setVisible(false);
				filesArea.setVisible(false);
				processesArea.setVisible(true);
				servicesArea.setVisible(false);
				tasksArea.setVisible(false);
				break;
			case "service":
				startUp.setVisible(false);
				filesArea.setVisible(false);
				processesArea.setVisible(false);
				servicesArea.setVisible(true);
				tasksArea.setVisible(false);
				break;
			case "task":
				startUp.setVisible(false);
				filesArea.setVisible(false);
				processesArea.setVisible(false);
				servicesArea.setVisible(false);
				tasksArea.setVisible(true);
				break;
		}
	}
	
	public FilesDisplayer getFilesArea() {
		return filesArea;
	}

	public void setFilesArea(FilesDisplayer filesArea) {
		this.filesArea = filesArea;
	}

	public StartUpDisplayer getStartUp() {
		return startUp;
	}

	public void setStartUp(StartUpDisplayer startUp) {
		this.startUp = startUp;
	}

	public ServicesDisplayer getServicesArea() {
		return servicesArea;
	}

	public void setServicesArea(ServicesDisplayer servicesArea) {
		this.servicesArea = servicesArea;
	}

	public ProcessesDisplayer getProcessesArea() {
		return processesArea;
	}

	public void setProcessesArea(ProcessesDisplayer processesArea) {
		this.processesArea = processesArea;
	}
}
