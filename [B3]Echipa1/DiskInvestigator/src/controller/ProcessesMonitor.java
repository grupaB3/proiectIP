package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import model.Monitor;

public class ProcessesMonitor implements Monitor {

	private List<Process> processesList;
	private String processesListTxt;
	private boolean txtCreated = false;

	@Override
	public void removeComponentFromList(Object component) {
		processesList.remove(component);
	}

	@Override
	public void addComponentToList(Object component) {
		processesList.add((Process) component);
	}

	@Override
	public void sendCommand() {
		try {
			List<String> command = new ArrayList<String>();
			command.add("cmd.exe");
			command.add("/c");
			//command.add("start");
			command.add("tasklist");
			command.add(">");
			command.add(processesListTxt);
			Process servicesProcess = new ProcessBuilder(command).start();
			InputStream input = servicesProcess.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			servicesProcess.destroy();
		} catch (IOException e) {
		}
	}

	@Override
	public void printComponentsList() {
		if (processesList.size() == 0) {
			return;
		}
		for (Process process : processesList) {
			System.out.println(process.toString());
		}
	}

	@Override
	public void createFromTxt(String fileName) {
		if (!txtCreated) {
			return;
		}
	}

	@Override
	public void refresh() {
		sendCommand();
		createFromTxt(processesListTxt);
	}

	public void initialize() {
		processesList = new ArrayList<Process>();
		String workingDirectory = System.getProperty("usr.dir");
		this.processesListTxt = workingDirectory + "\\servicesList.txt";
		this.processesListTxt = "C:\\Users\\IoanaAlexandra\\Desktop\\processesList.txt";
	}

}
