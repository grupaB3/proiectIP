package mainPackage;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;


public class GUI {
	
	public static void main (String[] args) {
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		try {
			
			UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceDustCoffeeLookAndFeel");
			UIDefaults defaults = UIManager.getLookAndFeelDefaults();
			if (defaults.get("Table.alternateRowColor") == null)
			    defaults.put("Table.alternateRowColor", new Color(222, 208, 177));
			
		} catch (Exception e) {
	          System.out.println("Substance Graphite failed to initialize");
	        }
		
		EventQueue.invokeLater(new Runnable() {
	        
            @Override
            public void run() {
               DiskInvestigatorWindow mainWindow = new DiskInvestigatorWindow();
               mainWindow.setVisible(true);
            }
        });
	}
}