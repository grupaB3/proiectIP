import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class ScanButton extends JButton{
	
	
	public ScanButton(){

        addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent evt) {
                ScanButtonActionPerformed(evt);
            }
        });
	}
	

	private void ScanButtonActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
		
		
    } 
	
}
