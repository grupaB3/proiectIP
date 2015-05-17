package displayArea;

import java.awt.Dimension;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StartUpDisplayer extends JPanel{

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
		add(bucket);

		StartUpBucket bucket_2 = new StartUpBucket("processScan.png", "Process Scan");
		bucket_2.setBounds(258, 46, 166, 162);
		add(bucket_2);
		
		StartUpBucket bucket_3 = new StartUpBucket("github.png", "Source code");
		bucket_3.setBounds(472, 46, 166, 162);
		add(bucket_3);
		
		StartUpBucket bucket_4 = new StartUpBucket("twitter.png", "Follow us");
		bucket_4.setBounds(686, 46, 166, 162);
		add(bucket_4);

		add(drawingPanel);		
	}
}