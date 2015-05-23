package processToolBar;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import observers.ServiceObserver;

public class StopServiceButton extends JButton {

	private static final long serialVersionUID = 3259570067502408586L;
	private ServiceObserver serviceObserver;
	
	protected StopServiceButton(){
		try {
		    Image img = ImageIO.read(getClass().getResource("StopService.png"));
		    this.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
		  }
		this.setToolTipText("Stop Service");
		
		addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent evt) {
                StopButtonActionPerformed(evt);
            }
        });
		
	}

	
	private void StopButtonActionPerformed(ActionEvent evt) {
		serviceObserver.getServiceHandler().stopService();
    }
	
	
	public ServiceObserver getServiceObserver() {
		return serviceObserver;
	}

	public void setServiceObserver(ServiceObserver serviceObserver) {
		this.serviceObserver = serviceObserver;
	}
}