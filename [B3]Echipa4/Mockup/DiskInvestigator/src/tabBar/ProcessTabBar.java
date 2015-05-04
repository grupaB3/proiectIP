package tabBar;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import observers.TabObserver;

public class ProcessTabBar extends JPanel {
	private JLabel processLabel = new JLabel("    Processes   ");
	private JLabel serviceLabel = new JLabel("   Services    ");
	private JLabel taskLabel = new JLabel("    Tasks    ");
	private TabObserver observer;
	
	protected ProcessTabBar(TabObserver observer) {
		this.observer = observer;
		initUI();
	}
	
	private void initUI() {
		processLabel.setOpaque(true);
		serviceLabel.setOpaque(true);
		taskLabel.setOpaque(true);
		
		processLabel.setBackground(Color.yellow);
		
		processLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {
				processLabel.setBackground(Color.yellow);
				serviceLabel.setBackground(null);
				taskLabel.setBackground(null);
				observer.setDisplayArea("process");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		
		serviceLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {
				serviceLabel.setBackground(Color.yellow);
				processLabel.setBackground(null);
				taskLabel.setBackground(null);
				observer.setDisplayArea("service");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		
		taskLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {
				taskLabel.setBackground(Color.yellow);
				processLabel.setBackground(null);
				serviceLabel.setBackground(null);
				observer.setDisplayArea("task");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		
		add(processLabel);
		add(serviceLabel);
		add(taskLabel);

		//setPreferredSize(new Dimension(70, 30));
		setLayout(new FlowLayout());
	}
}
