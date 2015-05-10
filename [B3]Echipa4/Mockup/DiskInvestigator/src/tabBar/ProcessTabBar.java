package tabBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import observers.TabObserver;

public class ProcessTabBar extends JPanel {
	private static final long serialVersionUID = -2764060480869773897L;
	
	private TabObserver observer = null;
	
	protected ProcessTabBar(TabObserver observer) {
		this.observer = observer;
		initUI();
	}
	
	private void initUI() {
		
		JLabel processLabel = new JLabel("Processes");
		processLabel.setOpaque(true);
		JLabel serviceLabel = new JLabel("Services");
		serviceLabel.setOpaque(true);
		JLabel taskLabel = new JLabel("Tasks");
		taskLabel.setOpaque(true);
		
		JPanel processPanel = new JPanel();
		processPanel.add(processLabel);
		JPanel servicePanel = new JPanel();
		servicePanel.add(serviceLabel);
		JPanel taskPanel = new JPanel();
		taskPanel.add(taskLabel);
		
		processPanel.setBackground(Color.yellow);
		
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
				processPanel.setBackground(Color.yellow);
				servicePanel.setBackground(null);
				taskPanel.setBackground(null);
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
				servicePanel.setBackground(Color.yellow);
				processPanel.setBackground(null);
				taskPanel.setBackground(null);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		
		taskPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {
				observer.setDisplayArea("task");
				taskPanel.setBackground(Color.yellow);
				processPanel.setBackground(null);
				servicePanel.setBackground(null);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		
		add(processPanel);
		add(servicePanel);
		add(taskPanel);

		setLayout(new FlowLayout());
	}
}
