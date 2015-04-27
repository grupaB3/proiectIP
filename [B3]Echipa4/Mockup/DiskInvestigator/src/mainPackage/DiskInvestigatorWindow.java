package mainPackage;

import javax.swing.JFrame;

public class DiskInvestigatorWindow extends JFrame{
	protected DiskInvestigatorWindow() {
		windowInit();
	}
	
	public void windowInit() {
		
		setTitle("Disk Investigator");
		setSize(1000, 700);
		setVisible(true);
		setLocation(150, 10);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
