package mainPackage;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;


public class GUI {
	
	public static void main (String[] args) {
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		try {
			
			UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceDustCoffeeLookAndFeel");
			//UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceGeminiLookAndFeel");
			//UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceDustLookAndFeel");
			//UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceTwilightLookAndFeel");
			
		} catch (Exception e) {
	          System.out.println("Substance Graphite failed to initialize");
	        }
		
		EventQueue.invokeLater(new Runnable() {
	        
            @Override
            public void run() {
               DiskInvestigatorWindow mainWindow = new DiskInvestigatorWindow();
            }
        });
	}
}