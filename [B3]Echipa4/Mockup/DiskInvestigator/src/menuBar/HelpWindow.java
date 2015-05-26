package menuBar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
public class HelpWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3164768491224551678L;
	final private JPanel primaryPanel=new JPanel();
	public HelpWindow(){
		super("Disk Manager Help");
		openFrame(); 
	}
	
	private void openFrame(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setResizable(true);
		setSize(700,550);
		//setPreferredSize(new Dimension(700,550));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(screenWidth - 750, screenHeight - 950);
		setLayout(new FlowLayout(FlowLayout.LEADING));
		this.setBackground(new Color(255,255,255));
		primaryPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		primaryPanel.setPreferredSize(new Dimension(this.getSize().width-45,this.getSize().height-73));
		primaryPanel.setBackground(new Color(255,255,255));
    	JScrollPane scrollPane = new JScrollPane(primaryPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    	add(scrollPane);
    	this.addComponentListener(new ComponentAdapter(){
            public void componentResized(ComponentEvent event){
            	scrollPane.setPreferredSize(new Dimension(getSize().width-25,getSize().height-55));
            }
		});
    	JPanel searchPanel=new JPanel();
    	searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    	searchPanel.setPreferredSize(new Dimension(primaryPanel.getSize().width-20,50));
    	searchPanel.setBackground(new Color(255,255,255));
    	JTextArea searchTextArea=new JTextArea();
    	searchTextArea.setPreferredSize(new Dimension(150,22));
    	searchTextArea.setName("Search");
    	Border border = BorderFactory.createLineBorder(Color.BLACK);
    	searchTextArea.setBorder(BorderFactory.createCompoundBorder(border, 
    	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
    	searchTextArea.setBorder(border);
    	searchPanel.add(searchTextArea);
    	JButton searchButton=new JButton("Search");
    	searchPanel.add(searchButton);
    	JSeparator firstSeparator=new JSeparator(SwingConstants.VERTICAL);
    	firstSeparator.setPreferredSize(new Dimension(primaryPanel.getPreferredSize().width, 3));
    	firstSeparator.setBackground(new Color(0,0,0));
    	primaryPanel.add(searchPanel);
    	JPanel descriptionPanel=new JPanel();
    	descriptionPanel.setBackground(new Color(255,255,255));
    	descriptionPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
    	//descriptionPanel.setPreferredSize(new Dimension(primaryPanel.getSize().width,primaryPanel.getSize().height-300));
    	JTextArea descriptionTitleTextArea=new JTextArea();
    	descriptionTitleTextArea.setBackground(new Color(255,255,255));
    	descriptionTitleTextArea.setSize(new Dimension(primaryPanel.getPreferredSize().width,10));
    	descriptionTitleTextArea.setEditable(false);
    	descriptionTitleTextArea.setText("      Disk Manager");
    	Font textAreaFont=new Font("Calibri",Font.PLAIN,36);
    	descriptionTitleTextArea.setFont(textAreaFont);
    	descriptionTitleTextArea.setForeground(Color.LIGHT_GRAY);
    	JTextArea descriptionTextArea=new JTextArea();
    	descriptionTextArea.setBackground(new Color(255,255,255));
    	descriptionTextArea.setSize(new Dimension(primaryPanel.getPreferredSize().width,10));
    	descriptionTextArea.setLineWrap(true);
    	descriptionTextArea.setEditable(false);
    	descriptionTextArea.setText("         Disk Manager is an application designed to simplify actions like erasing files, recover deleted ones or "
    			+ "monitoring suspicious processes, giving you the posibility to stop them, and more. "
    			+ "This help is at your disposal for a quick tutorial in using it.");
    	textAreaFont=new Font("Calibri",Font.PLAIN,18);
    	descriptionTextArea.setFont(textAreaFont);
    	descriptionPanel.add(descriptionTitleTextArea);
    	descriptionPanel.add(descriptionTextArea);
    	JPanel componentsPanel=new JPanel();
    	componentsPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
    	componentsPanel.setBackground(new Color(0,0,0));
    	componentsPanel.setPreferredSize(primaryPanel.getSize());
    	JTextArea componentsTitleTextArea=new JTextArea();
    	componentsTitleTextArea.setBackground(new Color(255,255,255));
    	componentsTitleTextArea.setSize(new Dimension(primaryPanel.getPreferredSize().width,10));
    	componentsTitleTextArea.setEditable(false);
    	componentsTitleTextArea.setText("          Disk Manager Components");
    	textAreaFont=new Font("Calibri",Font.PLAIN,24);
    	componentsTitleTextArea.setFont(textAreaFont);
    	componentsTitleTextArea.setForeground(Color.LIGHT_GRAY);
    	componentsPanel.add(componentsTitleTextArea);
    	JTextArea componentsIntroTextArea=new JTextArea();
    	componentsIntroTextArea.setSize(new Dimension(primaryPanel.getPreferredSize().width,10));
    	componentsIntroTextArea.setLineWrap(true);
    	componentsIntroTextArea.setEditable(false);
    	componentsIntroTextArea.setText("         Below you can see the main window of the application and it's primary components.");
    	componentsIntroTextArea.setBackground(new Color(255,255,255));
    	textAreaFont=new Font("Calibri",Font.PLAIN,18);
    	componentsIntroTextArea.setFont(textAreaFont);
    	componentsPanel.add(componentsIntroTextArea);
    	BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("mainWindow2.png"));
		} catch (IOException e) {
			System.out.println("Eroare!");
		}
    	JLabel picLabel = new JLabel(new ImageIcon(myPicture.getScaledInstance(1500, 1100, Image.SCALE_DEFAULT)));
    	componentsPanel.add(picLabel);
    	JTextArea componentsDescriptionTextArea=new JTextArea();
    	componentsDescriptionTextArea.setSize(new Dimension(primaryPanel.getPreferredSize().width,10));
    	componentsDescriptionTextArea.setLineWrap(true);
    	componentsDescriptionTextArea.setEditable(false);
    	componentsDescriptionTextArea.setText("         1-.\n         2-.\n         3-.\n");
    	componentsDescriptionTextArea.setBackground(new Color(255,255,255));
    	textAreaFont=new Font("Calibri",Font.PLAIN,18);
    	componentsDescriptionTextArea.setFont(textAreaFont);
    	componentsPanel.add(componentsDescriptionTextArea);
    	primaryPanel.addComponentListener(new ComponentAdapter(){
            public void componentResized(ComponentEvent event){
            	firstSeparator.setPreferredSize(new Dimension(primaryPanel.getSize().width, 3));
            	searchPanel.setPreferredSize(new Dimension(primaryPanel.getSize().width,50));
            	descriptionPanel.setPreferredSize(new Dimension(primaryPanel.getSize().width,descriptionTextArea.getSize().height+descriptionTitleTextArea.getSize().height+10));
            	descriptionTextArea.setSize(primaryPanel.getSize().width,descriptionTextArea.getSize().height);
            	descriptionTitleTextArea.setSize(primaryPanel.getSize().width,descriptionTitleTextArea.getSize().height);
            	componentsTitleTextArea.setSize(primaryPanel.getSize().width, componentsTitleTextArea.getSize().height);
            	componentsIntroTextArea.setSize(primaryPanel.getSize().width, componentsIntroTextArea.getSize().height);
            	componentsDescriptionTextArea.setSize(primaryPanel.getSize().width, componentsDescriptionTextArea.getSize().height);
            	componentsPanel.setPreferredSize(new Dimension(primaryPanel.getSize().width,componentsIntroTextArea.getSize().height+componentsTitleTextArea.getSize().height+picLabel.getPreferredSize().height));
            }
		});
    	primaryPanel.add(firstSeparator);
    	primaryPanel.add(descriptionPanel);
    	primaryPanel.add(componentsPanel);
    	descriptionPanel.setVisible(true);
    	firstSeparator.setVisible(true);
    	searchPanel.setVisible(true);
		scrollPane.setVisible(true);
		componentsPanel.setVisible(true);
		revalidate();
		setVisible(true);
	}
}

