package processToolBar;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import observers.ProcessesObserver;

@SuppressWarnings("serial")
public class StartProcessButton extends JButton {
	private ProcessesObserver processesObserver;
	protected StartProcessButton(){
		try {
		    Image img = ImageIO.read(getClass().getResource("StartProcess.png"));
		    this.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
		  }
		this.setToolTipText("Start Process");
		
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				processesObserver.getProcessHandler().startProcesses();
			}
			
		});
	}
	
	public ProcessesObserver getProcessesObserver() {
		return processesObserver;
	}
	public void setProcessesObserver(ProcessesObserver processesObserver) {
		this.processesObserver = processesObserver;
	}
}
