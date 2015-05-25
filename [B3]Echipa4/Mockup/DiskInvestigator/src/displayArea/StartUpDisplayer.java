package displayArea;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.JPanel;
import observers.MenuObserver;

@SuppressWarnings("serial")
public class StartUpDisplayer extends JPanel{

	private MenuObserver observer;
	
	protected StartUpDisplayer() {
		initUI();
	}
	
	private void initUI() {
		setPreferredSize(new Dimension(900, 600));
		setLayout(null);
		
		DrawPanel drawingPanel = new DrawPanel();
		drawingPanel.setPreferredSize(new Dimension(900, 440));
		drawingPanel.setBounds(0, 0, 900, 440);
		
		StartUpBucket bucket = new StartUpBucket("fileScan.png", "Disk Scan");
		bucket.setBounds(44, 46, 166, 162);
		bucket.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				observer.activateBar("file");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
		});
		add(bucket);

		StartUpBucket bucket_2 = new StartUpBucket("processScan.png", "Process Scan");
		bucket_2.setBounds(258, 46, 166, 162);
		bucket_2.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				observer.activateBar("process");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
		});
		add(bucket_2);
		
		StartUpBucket bucket_3 = new StartUpBucket("github.png", "Source code");
		bucket_3.setBounds(472, 46, 166, 162);
		bucket_3.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				Desktop desktop = Desktop.getDesktop();
                try {
                	URL url = new URL("https://github.com/grupaB3/proiectIP/tree/master/%5BB3%5DEchipa4/Mockup");
                    desktop.browse(url.toURI());
                } catch (Exception ex) {
                	ex.printStackTrace();
                }
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
		});
		add(bucket_3);
		
		StartUpBucket bucket_4 = new StartUpBucket("twitter.png", "Follow us");
		bucket_4.setBounds(686, 46, 166, 162);
		bucket_4.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				Desktop desktop = Desktop.getDesktop();
                try {
                	URL url = new URL("https://twitter.com/B3Investigator");
                    desktop.browse(url.toURI());
                } catch (Exception ex) {
                	ex.printStackTrace();
                }
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
		});
		add(bucket_4);

		add(drawingPanel);		
	}

	public MenuObserver getObserver() {
		return observer;
	}

	public void setObserver(MenuObserver observer) {
		this.observer = observer;
	}
}