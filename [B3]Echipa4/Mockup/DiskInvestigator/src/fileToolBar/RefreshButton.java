package fileToolBar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class RefreshButton extends JButton{
	
	private static final long serialVersionUID = 4753677614771415350L;

	public RefreshButton(){
		super("Refresh");
		setPreferredSize(new Dimension(60,40));
		setMaximumSize(new Dimension(60,40));
		setMinimumSize(new Dimension(60,40));
		
        addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });
		
	}
	
	
	private void RefreshButtonActionPerformed(ActionEvent evt) {                                         
    }
}
