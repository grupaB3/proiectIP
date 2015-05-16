package fileToolBar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class ScanButton extends JButton{
	
	private static final long serialVersionUID = -3732017140531624631L;

	public ScanButton(){
		super("Scan");
		setPreferredSize(new Dimension(60,40));
		setMaximumSize(new Dimension(60,40));
		setMinimumSize(new Dimension(60,40));
		
		addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent evt) {
                ScanButtonActionPerformed(evt);
            }
        });
	}
	

	private void ScanButtonActionPerformed(ActionEvent evt) {                                         
    } 
	
}
