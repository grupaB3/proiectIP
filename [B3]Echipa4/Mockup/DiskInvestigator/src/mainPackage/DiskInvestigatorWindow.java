package mainPackage;

import javax.swing.JFrame;

import menuBar.MenuBar;

public class DiskInvestigatorWindow extends JFrame{
	protected DiskInvestigatorWindow() {
		windowInit();
	}
	
	public void windowInit() {
		
		MenuBar menuBar = new MenuBar();
		
		setJMenuBar(menuBar);
		setTitle("Disk Investigator");
		setSize(1000, 700);
		setVisible(true);
		setLocation(150, 10);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
