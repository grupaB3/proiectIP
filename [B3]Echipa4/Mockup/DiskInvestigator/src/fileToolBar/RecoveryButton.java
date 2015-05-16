package fileToolBar;

import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecoveryButton extends JButton {
	
	private static final long serialVersionUID = 4049711543317874759L;

	public RecoveryButton(){
		super("Recover File");
		setPreferredSize(new Dimension(60,40));
		setMaximumSize(new Dimension(60,40));
		setMinimumSize(new Dimension(60,40));
		
        addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent evt) {
                RecoveryButtonActionPerformed(evt);
            }
        });
        
	}
	
	
	private void RecoveryButtonActionPerformed(ActionEvent evt) {                                         
    } 
	
}
