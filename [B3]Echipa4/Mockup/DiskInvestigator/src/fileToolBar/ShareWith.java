import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ShareWith extends JButton{

	public ShareWith(){

        addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent evt) {
                ShareWithActionPerformed(evt);
            }
        });
	}
	

	private void ShareWithActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
		
		
    }
	
}
