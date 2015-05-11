package displayArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class StartUpBucket extends JPanel {
	
	private static final long serialVersionUID = 6299494322243086012L;
	
	private JLabel button1Label = new JLabel();
	private JLabel button1Label_logo_banner = new JLabel();
	private JLabel button1Label_logo_image = new JLabel();
	private JLabel button1Label_logo_intermediar = new JLabel();
	private JLabel button1Label_logo_text;
	
	public StartUpBucket(String numeLogo, String text){
		button1Label_logo_text = new JLabel(text);
		init(numeLogo);
	}
	
	public void init(String numeLogo){
		
		setPreferredSize(new Dimension(280, 250));
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		add(button1Label);
		setOpaque(false);
		button1Label.setPreferredSize(new Dimension(200, 200));
		button1Label.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		button1Label.setBackground(Color.white);
		button1Label.setOpaque(true);
		button1Label.add(button1Label_logo_banner);
		button1Label.add(button1Label_logo_image);
		button1Label.add(button1Label_logo_intermediar);
		button1Label.add(button1Label_logo_text);
		
		button1Label.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				button1Label.setBackground(Color.lightGray);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				button1Label.setBackground(Color.white);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
	    });
		
		button1Label_logo_banner.setPreferredSize(new Dimension(200, 40));
		button1Label_logo_image.setPreferredSize(new Dimension(80, 80));
		button1Label_logo_image.setBackground(Color.red);
		ImageIcon imgThisImg = new ImageIcon(numeLogo);
		button1Label_logo_image.setIcon(imgThisImg);
		button1Label_logo_intermediar.setPreferredSize(new Dimension(200, 10));
		
		button1Label_logo_text.setPreferredSize(new Dimension(200, 50));
		button1Label_logo_text.setHorizontalAlignment(SwingConstants.CENTER);
		button1Label_logo_text.setVerticalAlignment(SwingConstants.CENTER);
		button1Label_logo_text.setFont(new Font("Arial", Font.BOLD, 16));
	}
	
}
