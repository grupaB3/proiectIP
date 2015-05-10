package fileToolBar;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ShredButton extends JButton{

	private static final long serialVersionUID = 1107443913731007899L;

	public ShredButton(){
		super("Shred File");
		
        addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent evt) {
                ShredButtonActionPerformed(evt);
            }
        });
	}
	

	private void ShredButtonActionPerformed(ActionEvent evt) {                                         
    }
	
}
