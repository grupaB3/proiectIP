package tabBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.ServiceMonitor;
import observers.TabObserver;

public class ProcessTabBar extends JPanel {
	private static final long serialVersionUID = -2764060480869773897L;
	
	private TabObserver observer = null;
	//private ServiceObserver serviceObserver = null;
	
	JLabel processLabel = new JLabel("Processes");
	JLabel serviceLabel = new JLabel("Services");
	
	public ServiceMonitor serviceMonitor = new ServiceMonitor();
	
	JPanel processPanel = new JPanel();
	JPanel servicePanel = new JPanel();
	
	
	protected ProcessTabBar(TabObserver observer) {
		this.observer = observer;
		initUI();
	}
	
	private void initUI() {
		
		
		processLabel.setOpaque(true);	
		serviceLabel.setOpaque(true);
		
		processPanel.add(processLabel);
		processPanel.setPreferredSize(new Dimension(70, 30));
		
		servicePanel.add(serviceLabel);
		servicePanel.setPreferredSize(new Dimension(70, 30));

		processPanel.setBackground(new Color(255, 178, 102));
		processLabel.setBackground(new Color(255, 178, 102));
		
		processPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {
				observer.setDisplayArea("process");
				processPanel.setBackground(new Color(255, 178, 102));
				processLabel.setBackground(new Color(255, 178, 102));
				servicePanel.setBackground(null);
				serviceLabel.setBackground(null);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		
		servicePanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {
				observer.setDisplayArea("service");
				
				//serviceObserver.displayServices();
				serviceMonitor.initiliaze();
				serviceMonitor.connect();
				//serviceMonitor.parse();
				
				servicePanel.setBackground(new Color(255, 178, 102));
				serviceLabel.setBackground(new Color(255, 178, 102));
				processPanel.setBackground(null);
				processLabel.setBackground(null);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		
		add(processPanel);
		add(servicePanel);

		setLayout(new FlowLayout());
	}

	public void selectProcessTab() {
		servicePanel.setBackground(null);
		serviceLabel.setBackground(null);
		processPanel.setBackground(new Color(255, 178, 102));
		processLabel.setBackground(new Color(255, 178, 102));
	}
}
