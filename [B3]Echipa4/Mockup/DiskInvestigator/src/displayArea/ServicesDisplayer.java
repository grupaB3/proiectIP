package displayArea;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ServicesDisplayer extends JPanel {

	private static final long serialVersionUID = -2809884889360505234L;
	
	private ServiceListArea serviceListArea = new ServiceListArea();
	private ProcessInfoArea processInfoArea = new ProcessInfoArea();

	protected ServicesDisplayer() {
		initUI();
	}
	
	private void initUI() {
		
		add(serviceListArea);
		add(processInfoArea);
		
		//setBackground(Color.magenta);
		setPreferredSize(new Dimension(900, 450));
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
	}
}
