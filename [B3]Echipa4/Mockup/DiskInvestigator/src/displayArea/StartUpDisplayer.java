package displayArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartUpDisplayer extends JPanel{

	private static final long serialVersionUID = 7595444344718123253L;
	
	private JPanel canvas = new JPanel();
	private JLabel canvasLabel = new JLabel();
	
	private JPanel buttons = new JPanel();
	private JPanel buttonHeader = new JPanel();
	private StartUpBucket button1 = new StartUpBucket("logo1.png", "DISK SCAN");
	private StartUpBucket button2 = new StartUpBucket("logo2.png", "PROCESS SCAN");
	private StartUpBucket button3 = new StartUpBucket("logo3.png", "FOLLOW US");
	
	private JPanel panoramic = new JPanel();
	private JLabel panoramicImage = new JLabel();
	private JPanel social = new JPanel();
	
	protected StartUpDisplayer() {
		initUI();
	}
	
	private void initUI() {
		setPreferredSize(new Dimension(900, 600));
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		canvas.setPreferredSize(new Dimension(900, 400));
		canvas.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		canvas.add(canvasLabel);
		canvasLabel.setPreferredSize(new Dimension(840, 400));
		canvasLabel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		canvasLabel.setBackground(new Color(207,169,49));
		canvasLabel.setOpaque(true);
		
		canvasLabel.add(buttons);
		canvasLabel.add(panoramic);
		canvasLabel.add(social);
		
		buttons.setPreferredSize(new Dimension(840, 250));
		buttons.setBackground(new Color(239,202,56));
		buttons.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		buttons.add(buttonHeader);
		buttonHeader.setPreferredSize(new Dimension(840, 25));
		buttonHeader.setOpaque(false);
		
		buttons.add(button1);
		buttons.add(button2);
		buttons.add(button3);		
		
		panoramic.setPreferredSize(new Dimension(840, 100));
		panoramic.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		panoramicImage.setPreferredSize(new Dimension(840, 100));
		panoramicImage.setBackground(Color.black);
		panoramicImage.setOpaque(true);
		panoramic.add(panoramicImage);
		
		ImageIcon imgThisImg = new ImageIcon("panoramic.png");
		panoramicImage.setIcon(imgThisImg);

		social.setPreferredSize(new Dimension(840, 50));
		social.setBackground(new Color(207,169,49));

		add(canvas);
	}
}