package displayArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.DigitalSignature;
import model.ProcessT;
import model.Service;

public class ProcessInfoArea extends JPanel {

	private static final long serialVersionUID = -2809884889360505234L;
	private JPanel panel;
	private JTextArea digital;
	
	protected ProcessInfoArea() {
		initUI();
	}
	
	void initUI() {
		setBackground(new Color(42,41,40).darker());
		setOpaque(true);
		setPreferredSize(new Dimension(276, 440));
		setLayout(null);
		panel = new JPanel();
		panel.setBounds(15,15,244,405);
		panel.setLayout(null);
		add(panel);
	}
	
	public void setProcessInfoRow(ProcessT process){
		removeAll();
		panel = new JPanel();
		panel.setBounds(15,15,244,405);
		panel.setLayout(null);
		add(panel);
		
		String name = String.valueOf(process.getName());
		String sessionNo = String.valueOf(process.getSessionNo());
		String sessionName = String.valueOf(process.getSessionName());
		String pid = String.valueOf(process.getPID());
		String memory = String.valueOf(process.getMemoryUsage());
		
		JTextArea labelInfo = new JTextArea();
		labelInfo.setText("  Details: ");
		labelInfo.setLineWrap(true);
		labelInfo.setWrapStyleWord(true);
		labelInfo.setEditable(false);
		labelInfo.setFont(new Font("Verdana",1,18));
		labelInfo.setBounds(0, 5, 244, 20);

		JTextArea labelDetails = new JTextArea();
		labelDetails.setText("\n" + "  Name: " + name + "\n\n" + "  Session Number: " + sessionNo + "\n\n" + "  Session Name: " + sessionName + "\n\n" + "  PID: " + pid + "\n\n" + "  Memory usage: " + memory);
		labelDetails.setLineWrap(true);
		labelDetails.setWrapStyleWord(true);
		labelDetails.setEditable(false);
		labelDetails.setFont(new Font("Verdana",Font.ITALIC,11));
		labelDetails.setBounds(0, 30, 244, 160);

		panel.add(labelInfo);
		panel.add(labelDetails);

		panel.repaint();
	}
	
	public void setSignature(DigitalSignature sign){
		digital= new JTextArea();		
		String data;
		if(sign != null)
		{
			if(sign.isSigned().contains("Signed"))
			{
				data = "yes";
				digital.setText("  Digital Signature: "+data+
						"\n\n  Signing Date: "+sign.getSigningDate()+"\n\n  Publisher: "
						+sign.getPublisher()+"\n\n  Product Version: "+sign.getProductVersion());
				
			}
			else{
				
				data = "no";
				digital.setText("  Digital Signature: "+data);
			}
				
		}
		else{
			data="N/A";
			digital.setText("  Digital Signature: "+data);
		}
		
		
		digital.setLineWrap(true);
		digital.setWrapStyleWord(true);
		digital.setEditable(false);
		digital.setFont(new Font("Verdana",Font.ITALIC,11));
		digital.setBounds(15,220, 244, 200);	
		
		add(digital);		
		repaint();
	}

	public void setServicesInfoRow(Service service) {
		removeAll();
		panel = new JPanel();
		panel.setBounds(15,15,244,405);
		panel.setLayout(null);
		add(panel);
		
		String name = String.valueOf(service.getName());
		String description = String.valueOf(service.getDescription());
		String state = String.valueOf(service.getState());
		String pid = String.valueOf(service.getPID());
		String startMode = String.valueOf(service.getStartMode());
		
		JTextArea labelInfo = new JTextArea();
		labelInfo.setText("  Details: ");
		labelInfo.setLineWrap(true);
		labelInfo.setWrapStyleWord(true);
		labelInfo.setEditable(false);
		labelInfo.setFont(new Font("Verdana",1,18));
		labelInfo.setBounds(0, 5, 244, 20);

		JTextArea labelDetails = new JTextArea();
		labelDetails.setText("\n" + "  Name: " + name + "\n\n" + "  State: " + state + "\n\n" + "  Start Mode: " + startMode + "\n\n" + "  PID: " + pid + "\n\n" + "  Description: " + description);
		labelDetails.setLineWrap(true);
		labelDetails.setWrapStyleWord(true);
		labelDetails.setEditable(false);
		labelDetails.setFont(new Font("Verdana",Font.ITALIC,11));
		labelDetails.setBounds(0, 30, 244, 415);

		panel.add(labelInfo);
		panel.add(labelDetails);

		panel.repaint();
	}
}