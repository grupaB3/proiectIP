package displayArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.pushingpixels.substance.internal.contrib.randelshofer.quaqua.util.Images;

@SuppressWarnings("serial")
public class StartUpBucket extends JPanel {
	
	private JLabel button1Label = new JLabel();
	private JLabel button1Label_logo_banner = new JLabel();
	private JLabel button1Label_logo_image = new JLabel();
	private JLabel button1Label_logo_text;
	
	public StartUpBucket(String numeLogo, String text){
		button1Label_logo_text = new JLabel(text);
		init(numeLogo);
	}
	
	public void init(String numeLogo){

		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		add(button1Label);
		setOpaque(false);
		button1Label.setPreferredSize(new Dimension(166, 162));
		button1Label.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		button1Label.add(button1Label_logo_banner);
		button1Label.add(button1Label_logo_image);
		button1Label.add(button1Label_logo_text);
		
		button1Label_logo_banner.setPreferredSize(new Dimension(166, 30));
		button1Label_logo_image.setPreferredSize(new Dimension(80, 80));
		
		String logo="/displayArea/"+numeLogo;
		ImageIcon imgThisImg = new ImageIcon(Images.class.getResource(logo));
		button1Label_logo_image.setIcon(imgThisImg);
		button1Label_logo_image.setOpaque(false);
		
		button1Label_logo_text.setPreferredSize(new Dimension(166, 52));
		button1Label_logo_text.setHorizontalAlignment(SwingConstants.CENTER);
		button1Label_logo_text.setVerticalAlignment(SwingConstants.CENTER);
		button1Label_logo_text.setFont(new Font("Arial", Font.BOLD, 16));
		button1Label_logo_text.setForeground(new Color(252, 223, 156));
	}
	
}
