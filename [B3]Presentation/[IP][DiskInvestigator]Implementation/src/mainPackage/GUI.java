package mainPackage;

import java.awt.EventQueue;

public class GUI {
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
	        
            @Override
            public void run() {
               DiskInvestigatorWindow mainWindow = new DiskInvestigatorWindow();
            }
        });
	}
}