import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class SearchButton extends JButton{

	public SearchButton(){

        addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });
	}
	

	private void SearchButtonActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
		
		
    } 
	
}
