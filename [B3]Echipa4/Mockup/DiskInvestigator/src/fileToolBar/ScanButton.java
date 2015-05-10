package fileToolBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class ScanButton extends JButton{
	
	private static final long serialVersionUID = -3732017140531624631L;

	public ScanButton(){
		super("Scan");
        addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent evt) {
                ScanButtonActionPerformed(evt);
            }
        });
	}
	

	private void ScanButtonActionPerformed(ActionEvent evt) {                                         
    } 
	
}
