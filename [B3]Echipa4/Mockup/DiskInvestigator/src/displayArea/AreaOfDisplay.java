package displayArea;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class AreaOfDisplay extends JPanel {

	private static final long serialVersionUID = -1492665909386157548L;

	private FilesDisplayer filesArea;
	private ProcessesDisplayer processesArea;
	private ServicesDisplayer servicesArea;
	private StartUpDisplayer startUp = new StartUpDisplayer();
	
	public AreaOfDisplay() {
	}
	
	public void initUI() {
		
		add(startUp);
		add(filesArea);
		add(processesArea);
		add(servicesArea);
		
		setArea("start");
		setLayout(new FlowLayout());
	}
	
	public void setArea(String areaName) {

		processesArea.getProcessListArea().setScanned(false);
		switch(areaName) {
			case "start":
				processesArea.getProcessListArea().setFocus(false);
				processesArea.getProcessListArea().getProcessInfoArea().removeAll();
				processesArea.getProcessListArea().getProcessInfoArea().initUI();
				processesArea.getProcessListArea().getViewport().removeAll();
				processesArea.setVisible(false);
				
				startUp.setVisible(true);
				
				filesArea.setVisible(false);
				filesArea.getFileListArea().getFileInfoArea().removeAll();
				filesArea.getFileListArea().getFileInfoArea().initUI();
				
				servicesArea.setVisible(false);
				servicesArea.getServiceListArea().getProcessInfoArea().removeAll();
				servicesArea.getServiceListArea().getProcessInfoArea().initUI();
				break;
			case "file":
				processesArea.getProcessListArea().setFocus(false);
				processesArea.getProcessListArea().getProcessInfoArea().removeAll();
				processesArea.getProcessListArea().getProcessInfoArea().initUI();
				processesArea.getProcessListArea().getViewport().removeAll();
				processesArea.setVisible(false);
				
				startUp.setVisible(false);
				filesArea.setVisible(true);
				
				servicesArea.setVisible(false);
				servicesArea.getServiceListArea().getProcessInfoArea().removeAll();
				servicesArea.getServiceListArea().getProcessInfoArea().initUI();
				break;
			case "process":
				processesArea.getProcessListArea().setFocus(true);
				processesArea.setVisible(true);
				
				startUp.setVisible(false);
				
				filesArea.setVisible(false);
				filesArea.getFileListArea().getFileInfoArea().removeAll();
				filesArea.getFileListArea().getFileInfoArea().initUI();
				
				servicesArea.setVisible(false);
				servicesArea.getServiceListArea().getProcessInfoArea().removeAll();
				servicesArea.getServiceListArea().getProcessInfoArea().initUI();
				
				break;
			case "service":
				processesArea.getProcessListArea().setFocus(false);
				processesArea.getProcessListArea().getProcessInfoArea().removeAll();
				processesArea.getProcessListArea().getProcessInfoArea().initUI();
				processesArea.getProcessListArea().getViewport().removeAll();
				processesArea.setVisible(false);
				
				startUp.setVisible(false);
				
				filesArea.setVisible(false);
				filesArea.getFileListArea().getFileInfoArea().removeAll();
				filesArea.getFileListArea().getFileInfoArea().initUI();
				
				servicesArea.setVisible(true);
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
