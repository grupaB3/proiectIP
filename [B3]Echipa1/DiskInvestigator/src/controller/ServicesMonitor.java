package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import model.Monitor;
import model.Service;

public class ServicesMonitor implements Monitor {

	private List<Service> servicesList;
	private String servicesListTxt;
	private boolean txtCreated = false;

	@Override
	public void removeComponentFromList(Object component) {
		servicesList.remove(component);
	}

	@Override
	public void addComponentToList(Object component) {
		servicesList.add((Service) component);
	}

	@Override
	public void sendCommand() {
		try {
			List<String> command = new ArrayList<String>();
			command.add("cmd.exe");
			command.add("/c");
			//command.add("start");
			command.add("sc");
			command.add("query");
			command.add("state=");
			command.add("all");
			command.add(">");
			command.add(servicesListTxt);
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
		if(servicesList.size() == 0){
			return;
		}
		for(Service service : servicesList){
			System.out.println(service.toString());
		}
	}

	@Override
	public void createFromTxt(String fileName) {
		if(!txtCreated){
			return;
		}
	}

	@Override
	public void refresh() {
		sendCommand();
		createFromTxt(servicesListTxt);
	}

	public void initiliaze() {
		servicesList = new ArrayList<Service>();
		String workingDirectory = System.getProperty("usr.dir");
		this.servicesListTxt = workingDirectory + "\\servicesList.txt";
		this.servicesListTxt = "C:\\Users\\IoanaAlexandra\\Desktop\\servicesList.txt";
	}

}
