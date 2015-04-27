import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class RecoveryButton extends JButton {
	
	public RecoveryButton(){
    
        addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent evt) {
                RecoveryButtonActionPerformed(evt);
            }
        });
        
	}
	
	
	private void RecoveryButtonActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
    } 
	
}
