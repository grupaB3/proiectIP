package fileToolBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class RefreshButton extends JButton{
	

	public RefreshButton(){
       
        addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });
		
	}
	
	
	private void RefreshButtonActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
    }
}
