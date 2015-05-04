package application;

import controller.ProcessesMonitor;
import controller.ServicesMonitor;
import controller.AppsMonitor;

public class LetsDoMagic {

	public static void main(String[] args) {

		ServicesMonitor sm = new ServicesMonitor();
		sm.initiliaze();
		sm.sendCommand();
		ProcessesMonitor pm = new ProcessesMonitor();
		pm.initialize();
		pm.sendCommand();
		AppsMonitor am = new AppsMonitor();
		am.initialize();
		am.sendCommand();
	}

}
