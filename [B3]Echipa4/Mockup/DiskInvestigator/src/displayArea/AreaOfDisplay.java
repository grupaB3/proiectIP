package displayArea;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import observers.FileObserver;

public class AreaOfDisplay extends JPanel {

	private static final long serialVersionUID = -1492665909386157548L;

	private FilesDisplayer filesArea = new FilesDisplayer();
	private ProcessesDisplayer processesArea = new ProcessesDisplayer();
	private ServicesDisplayer servicesArea = new ServicesDisplayer();
	private TasksDisplayer tasksArea = new TasksDisplayer();
	private StartUpDisplayer startUp = new StartUpDisplayer();
	private FileObserver fileObserver;
	
	public AreaOfDisplay() {
		initUI();
	}
	
	private void initUI() {
		
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

	public FileObserver getFileObserver() {
		return fileObserver;
	}

	public void setFileObserver(FileObserver fileObserver) {
		this.fileObserver = fileObserver;
	}
}
