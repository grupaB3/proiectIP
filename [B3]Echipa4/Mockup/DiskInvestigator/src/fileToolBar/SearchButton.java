package fileToolBar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SearchButton extends JButton{

	private static final long serialVersionUID = 8255380646516987934L;

	public SearchButton(){
		super("Search");
		setPreferredSize(new Dimension(60,40));
		setMaximumSize(new Dimension(60,40));
		setMinimumSize(new Dimension(60,40));
		
        addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });
	}
	

	private void SearchButtonActionPerformed(ActionEvent evt) {                                         
    } 
	
}
