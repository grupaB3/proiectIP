package processToolBar;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import observers.ProcessesObserver;

public class ProcessScanButton extends JButton{

	private static final long serialVersionUID = 1378373445586830621L;
	private ProcessesObserver processesObserver;
	protected ProcessScanButton(){
		try {
		    Image img = ImageIO.read(getClass().getResource("ProcessScan.png"));
		    this.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
		  }
		this.setToolTipText("Scan Processes");
	
		addActionListener(new ActionListener() {           
            public void actionPerformed(ActionEvent evt) {
                ScanButtonActionPerformed(evt);
            }
        });
	}
	
	private void ScanButtonActionPerformed(ActionEvent evt) {
		System.out.println("Scanning processes...");
		processesObserver.startScan();
    }
	
	public ProcessesObserver getProcessesObserver() {
		return processesObserver;
	}
	public void setProcessesObserver(ProcessesObserver processesObserver) {
		this.processesObserver = processesObserver;
	}
}