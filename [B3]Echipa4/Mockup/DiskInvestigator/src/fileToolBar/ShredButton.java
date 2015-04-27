package fileToolBar;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ShredButton extends JButton{

	public ShredButton(){

        addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent evt) {
                ShredButtonActionPerformed(evt);
            }
        });
	}
	

	private void ShredButtonActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
		
		
    }
	
}
