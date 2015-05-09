package menuBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class InfoButton extends JFrame {

	private JPanel panel = new JPanel();
	private JScrollPane scrollPanel = new JScrollPane();
	private JPanel searchPanel, canvasPanel, searchPanelButton, searchPanelButton_top, searchPanelButton_left, searchPanelButton_bottom, searchPanelButton_right;
	
	public InfoButton() {
		super("Disk Investigator Help and Support");
		init();
	}
	
	public void setHelpLocation(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(400, screenHeight);
		setLocationRelativeTo(null);
		setLocation(screenWidth - getWidth(), screenHeight - getHeight());
	}
	
	public void init(){
		setHelpLocation();
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        panel.setLayout(new BorderLayout());
		initSearch();
		initCanvas();
		panel.add(searchPanel, BorderLayout.NORTH);
        panel.add(canvasPanel);
        scrollPanel=new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPanel);
		setVisible(false);
		
		panel.addComponentListener(new ComponentAdapter(){
            public void componentResized(ComponentEvent event){
            	searchPanel.setPreferredSize(new Dimension(getWidth(), getHeight()/10));
            }
        });
		
		
	}
	
	public void initSearch(){	
		searchPanel = new JPanel();
		searchPanel.setLayout(new BorderLayout());
		searchPanel.setPreferredSize(new Dimension(getWidth(), getHeight()/10));
		searchPanel.setBackground(new Color(240, 240, 240));
		
		searchPanelButton_top=new JPanel();
		searchPanelButton_top.setPreferredSize(new Dimension(getWidth(), getHeight()/10/4));
		searchPanel.add(searchPanelButton_top, BorderLayout.NORTH);
		
		searchPanelButton_left=new JPanel();
		searchPanelButton_left.setPreferredSize(new Dimension(getWidth()/5-35, getHeight()));
		searchPanel.add(searchPanelButton_left, BorderLayout.WEST);
		
		searchPanelButton_bottom=new JPanel();
		searchPanelButton_bottom.setPreferredSize(new Dimension(getWidth(), getHeight()/10/4));
		searchPanel.add(searchPanelButton_bottom, BorderLayout.SOUTH);
		
		searchPanelButton_right=new JPanel();
		searchPanelButton_right.setPreferredSize(new Dimension(getWidth()/5, getHeight()));
		searchPanel.add(searchPanelButton_right, BorderLayout.EAST);
				
		searchPanelButton=new JPanel();
		searchPanelButton.setLayout(new BorderLayout());
		searchPanelButton.setBackground(new Color(248, 248, 248));
		searchPanelButton.setPreferredSize(new Dimension(getWidth()/5, getHeight()));
		
		JLabel textSearch = new JLabel("Search", SwingConstants.CENTER);
		textSearch.setFont(new Font("Serif", Font.ITALIC,18));
		textSearch.setForeground(new Color(220, 220, 220));
		textSearch.setVerticalAlignment(SwingConstants.CENTER);
		searchPanelButton.add(textSearch);
		
		searchPanel.add(searchPanelButton);
		searchPanel.addComponentListener(new ComponentAdapter(){
            public void componentResized(ComponentEvent event){
            	searchPanelButton_top.setPreferredSize(new Dimension(getWidth(), getHeight()/10/4));
            	searchPanelButton_left.setPreferredSize(new Dimension(getWidth()/5-35, getHeight()));
            	searchPanelButton_bottom.setPreferredSize(new Dimension(getWidth(), getHeight()/10/4));
            	searchPanelButton_right.setPreferredSize(new Dimension(getWidth()/5, getHeight()));
            	revalidate();
            	repaint();
            }
        });
	}
	
	public void initCanvas(){
		canvasPanel = new JPanel();
		canvasPanel.setBackground(new Color(248, 248, 248));
	}
	
}