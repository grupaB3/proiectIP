import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;


public class DiskScan extends JFrame{
	private JButton ScanButton;
    private JButton RecoveryButton;
    private JButton RefreshButton;
    
    private ScanButton scanObj;
    private RecoveryButton recoveryObj;
    private RefreshButton refreshObj;
    
    public DiskScan(){
    	ScanButton = new JButton();
    	RecoveryButton = new JButton();
        RefreshButton = new JButton();
   
        setScanButton();
        setRecoveryButton();
        setRefreshButton();
    	
    }
	
    public void setScanButton(){
    	ScanButton.setText("ScanButton");
        ScanButton.setFocusable(false);
        ScanButton.setHorizontalTextPosition(SwingConstants.CENTER);
        ScanButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        
        scanObj = new ScanButton();
        
    }
    
    public void setRecoveryButton(){
    	RecoveryButton.setText("RecoveryButton");
        RecoveryButton.setFocusable(false);
        RecoveryButton.setHorizontalTextPosition(SwingConstants.CENTER);
        RecoveryButton.setVerticalTextPosition(SwingConstants.BOTTOM);
   	
        recoveryObj = new RecoveryButton();
    }
    
    public void setRefreshButton(){
    	RefreshButton.setText("RefresButton");
        RefreshButton.setFocusable(false);
        RefreshButton.setHorizontalTextPosition(SwingConstants.CENTER);
        RefreshButton.setVerticalTextPosition(SwingConstants.BOTTOM);
  	
        refreshObj = new RefreshButton();
    }
    
    public JButton getScanButton(){
    	return ScanButton;
    }
    public JButton getRecoveryButton(){
    	return RecoveryButton;
    }
    public JButton getRefreshButton(){
    	return RefreshButton;
    }
    
    
}
