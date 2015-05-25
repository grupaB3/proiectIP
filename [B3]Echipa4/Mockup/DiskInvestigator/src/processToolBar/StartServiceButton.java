package processToolBar;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import observers.ServiceObserver;

public class StartServiceButton extends JButton {

	private static final long serialVersionUID = 3259570067502408586L;
	private ServiceObserver serviceObserver;
	private String selectedService;
	
	protected StartServiceButton(){
		try {
		    Image img = ImageIO.read(getClass().getResource("StartService.png"));
		    setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
		  }
		
		setToolTipText("Start Service");
		
		addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent evt) {
                StartButtonActionPerformed(evt);
            }
        });
		
		
	}
	
	private void StartButtonActionPerformed(ActionEvent evt) {
		serviceObserver.startService();
    }

	public ServiceObserver getServiceObserver() {
		return serviceObserver;
	}


	public void setServiceObserver(ServiceObserver serviceObserver) {
		this.serviceObserver = serviceObserver;
	}


	public String getSelectedService() {
		return selectedService;
	}

	public void setSelectedService(String selectedService) {
		this.selectedService = selectedService;
	}
}
