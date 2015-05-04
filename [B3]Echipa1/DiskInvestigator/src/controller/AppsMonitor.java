package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import model.Application;
import model.Monitor;

public class AppsMonitor implements Monitor {
	
	private List<Application> appsList;
	private String appsListTxt;
	private boolean txtCreated = false;

	@Override
	public void removeComponentFromList(Object component) {
		appsList.remove(component);
	}

	@Override
	public void addComponentToList(Object component) {
		appsList.add((Application)component);
	}

	@Override
	public void sendCommand() {
		try {
			List<String> command = new ArrayList<String>();
			command.add("cmd.exe");
			command.add("/c");
			//command.add("start");
			command.add("tasklist");
			command.add("/FI");
			command.add("\"STATUS");
			command.add("eq");
			command.add("RUNNING\"");
			command.add(">");
			command.add(appsListTxt);
			Process servicesProcess = new ProcessBuilder(command).start();
			InputStream input = servicesProcess.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
		}
	}

	@Override
	public void printComponentsList() {
		if(appsList.size() == 0){
			return;
		}
		for(Application application : appsList){
			System.out.println(application.toString());
		}
	}

	@Override
	public void createFromTxt(String fileName) {
		if(!txtCreated){
			return;
		}
		initialize();
	}

	@Override
	public void refresh() {
		sendCommand();
		createFromTxt(appsListTxt);
	}
	
	public void initialize(){
		appsList = new ArrayList<Application>();
		String workingDirectory = System.getProperty("usr.dir");
		this.appsListTxt = workingDirectory + "\\servicesList.txt";
		this.appsListTxt = "C:\\Users\\IoanaAlexandra\\Desktop\\appsList.txt";
	}

}
