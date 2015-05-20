package processToolBar;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import observers.ProcessesObserver;

public class ProcessCheckButton extends JButton {

	private static final long serialVersionUID = -604762861486061083L;
	private ProcessesObserver processesObserver;
	protected ProcessCheckButton(){
		try {
		    Image img = ImageIO.read(getClass().getResource("ProcessCheck2.png"));
		    this.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
		  }
		this.setToolTipText("Check Process");
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				processesObserver.getProcessHandler().checkProcesses();
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