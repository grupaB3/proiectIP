package displayArea;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class ServicesDisplayer extends JPanel {

	private static final long serialVersionUID = -2809884889360505234L;
	
	private ServiceListArea serviceListArea = new ServiceListArea();
	private ProcessInfoArea processInfoArea = new ProcessInfoArea();

	public ServicesDisplayer() {
		initUI();
	}
	
	private void initUI() {
		
		JPanel space = new JPanel();
		space.setPreferredSize(new Dimension(2, 450));
		
		add(space);
		add(serviceListArea);
		add(processInfoArea);
		
		//setBackground(Color.magenta);
		setPreferredSize(new Dimension(898, 450));
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
	}
	
	public ServiceListArea getServiceListArea() {
		return serviceListArea;
	}

	public void setServiceListArea(ServiceListArea serviceListArea) {
		this.serviceListArea = serviceListArea;
	}
}
