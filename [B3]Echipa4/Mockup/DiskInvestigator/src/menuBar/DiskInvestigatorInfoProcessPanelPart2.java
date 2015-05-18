package menuBar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class DiskInvestigatorInfoProcessPanelPart2 extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8978989351230968588L;
	private JScrollPane scrollPane=new JScrollPane();
	private NavigationEvent myEvent=new NavigationEvent();
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public DiskInvestigatorInfoProcessPanelPart2(Dimension frameSize, Observer observer){
		init(frameSize,observer);
	}

	private void init(Dimension frameSize,Observer observer){
			myEvent.addObserver(observer);
	    	setLayout(new FlowLayout(FlowLayout.CENTER));
	    	setPreferredSize(new Dimension(frameSize.width,frameSize.height));
	    	setBackground(new Color(255,255,255));
	    	JScrollPane scrollPane = new JScrollPane();
	    	scrollPane.setViewportView(this);
	    	JPanel descriptionPanel=new JPanel();
	    	descriptionPanel.setBackground(new Color(255,255,255));
	    	descriptionPanel.setLayout(new FlowLayout(FlowLayout.LEADING));;
	    	JTextArea descriptionTitleTextArea=new JTextArea();
	    	descriptionTitleTextArea.setBackground(new Color(255,255,255));
	    	descriptionTitleTextArea.setSize(new Dimension(this.getPreferredSize().width-30,10));
	    	descriptionTitleTextArea.setEditable(false);
	    	descriptionTitleTextArea.setText("      Disk Manager Process Module");
	    	Font textAreaDescFont=new Font("Calibri",Font.PLAIN,36);
	    	descriptionTitleTextArea.setFont(textAreaDescFont);
	    	descriptionTitleTextArea.setForeground(Color.DARK_GRAY);
	    	JTextArea descriptionTextArea=new JTextArea();
	    	descriptionTextArea.setBackground(new Color(255,255,255));
	    	descriptionTextArea.setSize(new Dimension(this.getPreferredSize().width-30,10));
	    	descriptionTextArea.setLineWrap(true);
	    	descriptionTextArea.setWrapStyleWord(true);
	    	descriptionTextArea.setEditable(false);
	    	descriptionTextArea.setText("         The Disk Manager Process Module is composed of the Process Toolbar"
	    			+ ", Process Display Area and Process Tab Bar. It is designed to help you work with processes, tasks and services, giving "
	    			+ "you the possibility to scan for suspicious processes, start a new process or stop an already running one. Below you can "
	    			+ "find infomations about the Process Toolbar and its respective Display Area. If you wish to find more about tasks or services"
	    			+ " click somewhere");
	    	textAreaDescFont=new Font("Calibri",Font.PLAIN,18);
	    	descriptionTextArea.setFont(textAreaDescFont);    	
	    	descriptionPanel.add(descriptionTitleTextArea);
	    	descriptionPanel.add(descriptionTextArea);
	    	JPanel componentsPanel=new JPanel();
	    	componentsPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
	    	componentsPanel.setBackground(new Color(255,255,255));
	    	componentsPanel.setPreferredSize(new Dimension(this.getSize().width,300));
	    	JTextArea componentsTitleTextArea=new JTextArea();
	    	componentsTitleTextArea.setBackground(new Color(255,255,255));
	    	componentsTitleTextArea.setSize(new Dimension(this.getPreferredSize().width-30,10));
	    	componentsTitleTextArea.setEditable(false);
	    	componentsTitleTextArea.setText("          Disk Manager Service Tab Components");
	    	textAreaDescFont=new Font("Calibri",Font.PLAIN,24);
	    	componentsTitleTextArea.setFont(textAreaDescFont);
	    	componentsTitleTextArea.setForeground(Color.DARK_GRAY);
	    	componentsPanel.add(componentsTitleTextArea);
	    	JTextArea componentsIntroTextArea=new JTextArea();
	    	componentsIntroTextArea.setSize(new Dimension(this.getPreferredSize().width-30,10));
	    	componentsIntroTextArea.setLineWrap(true);
	    	componentsIntroTextArea.setWrapStyleWord(true);
	    	componentsIntroTextArea.setEditable(false);
	    	componentsIntroTextArea.setText("         Below you can see the Processes Module window of the application, with the Services Tab being selected.");
	    	componentsIntroTextArea.setBackground(new Color(255,255,255));
	    	textAreaDescFont=new Font("Calibri",Font.PLAIN,18);
	    	componentsIntroTextArea.setFont(textAreaDescFont);
	    	componentsPanel.add(componentsIntroTextArea);
	    	BufferedImage myPicture = null;
			try {
				myPicture = ImageIO.read(getClass().getResource("processPanel_serviceTab.png"));
			} catch (IOException e) {
				System.out.println("Eroare!");
			}
			JLabel picLabel = new JLabel(new ImageIcon(myPicture.getScaledInstance(700, 500, Image.SCALE_DEFAULT)));
	    	componentsPanel.add(picLabel);
	    	JTextArea pictureDescriptionTextArea=new JTextArea();
	    	pictureDescriptionTextArea.setSize(new Dimension(this.getPreferredSize().width-30,10));
	    	pictureDescriptionTextArea.setLineWrap(true);
	    	pictureDescriptionTextArea.setEditable(false);
	    	pictureDescriptionTextArea.setText("          Disk Investigator Processes Module Window. See the following table for more info about each numbered area.");
	    	pictureDescriptionTextArea.setBackground(new Color(255,255,255));
	    	textAreaDescFont=new Font("Calibri",Font.ITALIC,13);
	    	pictureDescriptionTextArea.setFont(textAreaDescFont);
	    	componentsPanel.add(pictureDescriptionTextArea);
	    	JPanel descriptionTabelPanel=descriptionTabel(componentsPanel);
	    	componentsPanel.add(descriptionTabelPanel);
	    	this.add(descriptionPanel);
	    	this.add(componentsPanel);
	    	scrollPane.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
	    	int primaryPanelwidth=frameSize.width;
	    	this.addComponentListener(new ComponentAdapter(){
	            public void componentResized(ComponentEvent event){
	            	descriptionPanel.setPreferredSize(new Dimension(getSize().width-30,descriptionTextArea.getSize().height+descriptionTitleTextArea.getSize().height+10));
	            	descriptionTextArea.setSize(getSize().width-30,descriptionTextArea.getSize().height);
	            	descriptionTitleTextArea.setSize(getSize().width-30,descriptionTitleTextArea.getSize().height);
	            	componentsIntroTextArea.setSize(getSize().width-30, componentsIntroTextArea.getSize().height);
	            	componentsTitleTextArea.setSize(new Dimension(getPreferredSize().width-30,30));
	            	pictureDescriptionTextArea.setSize(getSize().width-30, pictureDescriptionTextArea.getSize().height);
	            	componentsPanel.setPreferredSize(new Dimension(getParent().getSize().width-10,componentsTitleTextArea.getSize().height+
	            			+picLabel.getPreferredSize().height+pictureDescriptionTextArea.getSize().height+10
	            			+descriptionTabelPanel.getSize().height));
	            	int primaryPanelheight=descriptionPanel.getSize().height+componentsPanel.getSize().height;
	            	setPreferredSize(new Dimension(primaryPanelwidth,primaryPanelheight-50));
	            }
			});
	    	descriptionPanel.setVisible(true);
	    	setVisible(true);
			scrollPane.setVisible(true);
			componentsPanel.setVisible(true);
			this.scrollPane=scrollPane;
		}

		private JPanel descriptionTabel(JPanel componentsPanel) {
	    	JPanel componentPartPanel=new JPanel();
	    	SpringLayout springLayout =new SpringLayout();
	    	componentPartPanel.setLayout(springLayout);
	    	componentPartPanel.setBackground(new Color(255,255,255));
	    	Font textAreaTitleFont=new Font("Calibri",Font.BOLD,18);
	    	Font textAreaDescFont=new Font("Calibri",Font.ITALIC,18);
	    	JTextArea tableComponentPart=new JTextArea();
	    	tableComponentPart.setBackground(new Color(255,255,255));
	    	tableComponentPart.setText("Component");
	    	tableComponentPart.setEditable(false);
	    	tableComponentPart.setFont(textAreaTitleFont);
	    	tableComponentPart.setForeground(Color.DARK_GRAY);
	    	JTextArea tableComponentDesc=new JTextArea();
	    	tableComponentDesc.setSize(new Dimension(200,10));
	    	tableComponentDesc.setBackground(new Color(255,255,255));
	    	tableComponentDesc.setText("Component Description");
	    	tableComponentDesc.setLineWrap(true);
	    	tableComponentDesc.setEditable(false);
	    	tableComponentDesc.setFont(textAreaTitleFont);
	    	tableComponentDesc.setForeground(Color.DARK_GRAY);
	    	JSeparator firstSeparator=new JSeparator(SwingConstants.HORIZONTAL);
	    	firstSeparator.setAlignmentY(CENTER_ALIGNMENT);
	    	firstSeparator.setPreferredSize(new Dimension(2000, 3));
	    	firstSeparator.setBackground(new Color(200,200,200));
	    	firstSeparator.setVisible(true);
	    	componentPartPanel.add(tableComponentPart);
	    	componentPartPanel.add(tableComponentDesc);
	    	componentPartPanel.add(firstSeparator);
	    	springLayout.putConstraint(SpringLayout.WEST, tableComponentPart,38,SpringLayout.WEST, componentPartPanel);
	    	springLayout.putConstraint(SpringLayout.NORTH, tableComponentPart,5,SpringLayout.NORTH, componentPartPanel);
	    	springLayout.putConstraint(SpringLayout.WEST, tableComponentDesc,134,SpringLayout.EAST, tableComponentPart);
	    	springLayout.putConstraint(SpringLayout.NORTH, tableComponentDesc,5,SpringLayout.NORTH, componentPartPanel);
	    	springLayout.putConstraint(SpringLayout.WEST, firstSeparator, 0, SpringLayout.WEST, componentPartPanel);
	    	springLayout.putConstraint(SpringLayout.NORTH,firstSeparator,10,SpringLayout.SOUTH,tableComponentPart);
	    	JTextArea firstComponent=new JTextArea();
	    	firstComponent.setBackground(new Color(255,255,255));
	    	firstComponent.setText("1. Process Tab Bar");
	    	firstComponent.setSize(new Dimension(100,20));
	    	firstComponent.setEditable(false);
	    	firstComponent.setFont(textAreaTitleFont);
	    	firstComponent.setForeground(Color.DARK_GRAY);
	    	JTextArea firstComponentDesc=new JTextArea();
	    	firstComponentDesc.setBackground(new Color(255,255,255));
	    	firstComponentDesc.setText("The Tab Bar is responsible with the buttons and processes that are shown at a certain time. There are three tabs:"
	    			+ " Processes, Tasks and Services. Choosing one of them will change the display area and buttons.");
	    	firstComponentDesc.setEditable(false);
	    	firstComponentDesc.setLineWrap(true);
	    	firstComponentDesc.setWrapStyleWord(true);
	    	firstComponentDesc.setFont(textAreaDescFont);
	    	JSeparator secondSeparator=new JSeparator(SwingConstants.HORIZONTAL);
	    	secondSeparator.setAlignmentY(CENTER_ALIGNMENT);
	    	secondSeparator.setPreferredSize(new Dimension(2000, 3));
	    	secondSeparator.setBackground(new Color(200,200,200));
	    	secondSeparator.setVisible(true);
	    	componentPartPanel.add(firstComponent);
	    	componentPartPanel.add(firstComponentDesc);
	    	componentPartPanel.add(secondSeparator);
	    	springLayout.putConstraint(SpringLayout.WEST,firstComponent,38,SpringLayout.WEST,componentPartPanel);
	    	springLayout.putConstraint(SpringLayout.NORTH,firstComponent,10,SpringLayout.SOUTH,firstSeparator);
	    	springLayout.putConstraint(SpringLayout.WEST,firstComponentDesc,87,SpringLayout.EAST,firstComponent);
	    	springLayout.putConstraint(SpringLayout.NORTH,firstComponentDesc,10,SpringLayout.SOUTH,firstSeparator);
	    	springLayout.putConstraint(SpringLayout.WEST,secondSeparator,0,SpringLayout.WEST,componentPartPanel);
	    	springLayout.putConstraint(SpringLayout.NORTH,secondSeparator,10,SpringLayout.SOUTH,firstComponentDesc);
	    	JTextArea secondComponent=new JTextArea();
	    	secondComponent.setBackground(new Color(255,255,255));
	    	secondComponent.setText("2. Back Button");
	    	secondComponent.setSize(new Dimension(100,20));
	    	secondComponent.setEditable(false);
	    	secondComponent.setFont(textAreaTitleFont);
	    	secondComponent.setForeground(Color.DARK_GRAY);
	    	JTextArea secondComponentDesc=new JTextArea();
	    	secondComponentDesc.setBackground(new Color(255,255,255));
	    	secondComponentDesc.setText("Pressing this button will take you back to the main window of the application.");
	    	secondComponentDesc.setEditable(false);
	    	secondComponentDesc.setLineWrap(true);
	    	secondComponentDesc.setWrapStyleWord(true);
	    	secondComponentDesc.setFont(textAreaDescFont);
	    	JSeparator thirdSeparator=new JSeparator(SwingConstants.HORIZONTAL);
	    	thirdSeparator.setAlignmentY(CENTER_ALIGNMENT);
	    	thirdSeparator.setPreferredSize(new Dimension(2000, 3));
	    	thirdSeparator.setBackground(new Color(200,200,200));
	    	thirdSeparator.setVisible(true);
	    	componentPartPanel.add(secondComponent);
	    	componentPartPanel.add(secondComponentDesc);
	    	componentPartPanel.add(thirdSeparator);
	    	springLayout.putConstraint(SpringLayout.WEST,secondComponent,38,SpringLayout.WEST,componentPartPanel);
	    	springLayout.putConstraint(SpringLayout.NORTH,secondComponent,10,SpringLayout.SOUTH,secondSeparator);
	    	springLayout.putConstraint(SpringLayout.WEST,secondComponentDesc,113,SpringLayout.EAST,secondComponent);
	    	springLayout.putConstraint(SpringLayout.NORTH,secondComponentDesc,10,SpringLayout.SOUTH,secondSeparator);
	    	springLayout.putConstraint(SpringLayout.WEST,thirdSeparator,0,SpringLayout.WEST,componentPartPanel);
	    	springLayout.putConstraint(SpringLayout.NORTH,thirdSeparator,10,SpringLayout.SOUTH,secondComponentDesc);
	    	JTextArea thirdComponent=new JTextArea();
	    	thirdComponent.setBackground(new Color(255,255,255));
	    	thirdComponent.setText("3. Start Service Button");
	    	thirdComponent.setSize(new Dimension(100,20));
	    	thirdComponent.setEditable(false);
	    	thirdComponent.setFont(textAreaTitleFont);
	    	thirdComponent.setForeground(Color.DARK_GRAY);
	    	JTextArea thirdComponentDesc=new JTextArea();
	    	thirdComponentDesc.setBackground(new Color(255,255,255));
	    	thirdComponentDesc.setText("Start Service Button Description");
	    	thirdComponentDesc.setEditable(false);
	    	thirdComponentDesc.setLineWrap(true);
	    	thirdComponentDesc.setWrapStyleWord(true);
	    	thirdComponentDesc.setFont(textAreaDescFont);
	    	JSeparator fourthSeparator=new JSeparator(SwingConstants.HORIZONTAL);
	    	fourthSeparator.setAlignmentY(CENTER_ALIGNMENT);
	    	fourthSeparator.setPreferredSize(new Dimension(2000, 3));
	    	fourthSeparator.setBackground(new Color(200,200,200));
	    	fourthSeparator.setVisible(true);
	    	componentPartPanel.add(thirdComponent);
	    	componentPartPanel.add(thirdComponentDesc);
	    	componentPartPanel.add(fourthSeparator);
	    	springLayout.putConstraint(SpringLayout.WEST,thirdComponent,38,SpringLayout.WEST,componentPartPanel);
	    	springLayout.putConstraint(SpringLayout.NORTH,thirdComponent,10,SpringLayout.SOUTH,thirdSeparator);
	    	springLayout.putConstraint(SpringLayout.WEST,thirdComponentDesc,56,SpringLayout.EAST,thirdComponent);
	    	springLayout.putConstraint(SpringLayout.NORTH,thirdComponentDesc,10,SpringLayout.SOUTH,thirdSeparator);
	    	springLayout.putConstraint(SpringLayout.WEST,fourthSeparator,0,SpringLayout.WEST,componentPartPanel);
	    	springLayout.putConstraint(SpringLayout.NORTH,fourthSeparator,10,SpringLayout.SOUTH,thirdComponentDesc);
	    	JTextArea fourthComponent=new JTextArea();
	    	fourthComponent.setBackground(new Color(255,255,255));
	    	fourthComponent.setText("4. Stop Service Button");
	    	fourthComponent.setSize(new Dimension(100,20));
	    	fourthComponent.setEditable(false);
	    	fourthComponent.setFont(textAreaTitleFont);
	    	fourthComponent.setForeground(Color.DARK_GRAY);
	    	JTextArea fourthComponentDesc=new JTextArea();
	    	fourthComponentDesc.setBackground(new Color(255,255,255));
	    	fourthComponentDesc.setText("Stop Service Button Description");
	    	fourthComponentDesc.setEditable(false);
	    	fourthComponentDesc.setLineWrap(true);
	    	fourthComponentDesc.setWrapStyleWord(true);
	    	fourthComponentDesc.setFont(textAreaDescFont);
	    	JSeparator fifthSeparator=new JSeparator(SwingConstants.HORIZONTAL);
	    	fifthSeparator.setAlignmentY(CENTER_ALIGNMENT);
	    	fifthSeparator.setPreferredSize(new Dimension(2000, 3));
	    	fifthSeparator.setBackground(new Color(200,200,200));
	    	fifthSeparator.setVisible(true);
	    	componentPartPanel.add(fourthComponent);
	    	componentPartPanel.add(fourthComponentDesc);
	    	componentPartPanel.add(fifthSeparator);
	    	springLayout.putConstraint(SpringLayout.WEST,fourthComponent,38,SpringLayout.WEST,componentPartPanel);
	    	springLayout.putConstraint(SpringLayout.NORTH,fourthComponent,10,SpringLayout.SOUTH,fourthSeparator);
	    	springLayout.putConstraint(SpringLayout.WEST,fourthComponentDesc,57,SpringLayout.EAST,fourthComponent);
	    	springLayout.putConstraint(SpringLayout.NORTH,fourthComponentDesc,10,SpringLayout.SOUTH,fourthSeparator);
	    	springLayout.putConstraint(SpringLayout.WEST,fifthSeparator,0,SpringLayout.WEST,componentPartPanel);
	    	springLayout.putConstraint(SpringLayout.NORTH,fifthSeparator,10,SpringLayout.SOUTH,fourthComponentDesc);
	    	JTextArea fifthComponent=new JTextArea();
	    	fifthComponent.setBackground(new Color(255,255,255));
	    	fifthComponent.setText("5. Service Info Area");
	    	fifthComponent.setSize(new Dimension(100,20));
	    	fifthComponent.setEditable(false);
	    	fifthComponent.setFont(textAreaTitleFont);
	    	fifthComponent.setForeground(Color.DARK_GRAY);
	    	JTextArea fifthComponentDesc=new JTextArea();
	    	fifthComponentDesc.setBackground(new Color(255,255,255));
	    	fifthComponentDesc.setText("Service Info Area Description");
	    	fifthComponentDesc.setEditable(false);
	    	fifthComponentDesc.setLineWrap(true);
	    	fifthComponentDesc.setWrapStyleWord(true);
	    	fifthComponentDesc.setFont(textAreaDescFont);
	    	JSeparator sixthSeparator=new JSeparator(SwingConstants.HORIZONTAL);
	    	sixthSeparator.setAlignmentY(CENTER_ALIGNMENT);
	    	sixthSeparator.setPreferredSize(new Dimension(2000, 3));
	    	sixthSeparator.setBackground(new Color(200,200,200));
	    	sixthSeparator.setVisible(true);
	    	componentPartPanel.add(fifthComponent);
	    	componentPartPanel.add(fifthComponentDesc);
	    	componentPartPanel.add(sixthSeparator);
	    	springLayout.putConstraint(SpringLayout.WEST,fifthComponent,38,SpringLayout.WEST,componentPartPanel);
	    	springLayout.putConstraint(SpringLayout.NORTH,fifthComponent,10,SpringLayout.SOUTH,fifthSeparator);
	    	springLayout.putConstraint(SpringLayout.WEST,fifthComponentDesc,79,SpringLayout.EAST,fifthComponent);
	    	springLayout.putConstraint(SpringLayout.NORTH,fifthComponentDesc,10,SpringLayout.SOUTH,fifthSeparator);
	    	springLayout.putConstraint(SpringLayout.WEST,sixthSeparator,0,SpringLayout.WEST,componentPartPanel);
	    	springLayout.putConstraint(SpringLayout.NORTH,sixthSeparator,10,SpringLayout.SOUTH,fifthComponentDesc);
	    	JTextArea sixthComponent=new JTextArea();
	    	sixthComponent.setBackground(new Color(255,255,255));
	    	sixthComponent.setText("6. Service Display Area");
	    	sixthComponent.setSize(new Dimension(100,20));
	    	sixthComponent.setEditable(false);
	    	sixthComponent.setFont(textAreaTitleFont);
	    	sixthComponent.setForeground(Color.DARK_GRAY);
	    	JTextArea sixthComponentDesc=new JTextArea();
	    	sixthComponentDesc.setBackground(new Color(255,255,255));
	    	sixthComponentDesc.setText("Service Display Area Description");
	    	sixthComponentDesc.setEditable(false);
	    	sixthComponentDesc.setLineWrap(true);
	    	sixthComponentDesc.setWrapStyleWord(true);
	    	sixthComponentDesc.setFont(textAreaDescFont);
	    	JSeparator seventhSeparator=new JSeparator(SwingConstants.HORIZONTAL);
	    	seventhSeparator.setAlignmentY(CENTER_ALIGNMENT);
	    	seventhSeparator.setPreferredSize(new Dimension(2000, 3));
	    	seventhSeparator.setBackground(new Color(200,200,200));
	    	seventhSeparator.setVisible(true);
	    	componentPartPanel.add(sixthComponent);
	    	componentPartPanel.add(sixthComponentDesc);
	    	componentPartPanel.add(seventhSeparator);
	    	springLayout.putConstraint(SpringLayout.WEST,sixthComponent,38,SpringLayout.WEST,componentPartPanel);
	    	springLayout.putConstraint(SpringLayout.NORTH,sixthComponent,10,SpringLayout.SOUTH,sixthSeparator);
	    	springLayout.putConstraint(SpringLayout.WEST,sixthComponentDesc,56,SpringLayout.EAST,sixthComponent);
	    	springLayout.putConstraint(SpringLayout.NORTH,sixthComponentDesc,10,SpringLayout.SOUTH,sixthSeparator);
	    	springLayout.putConstraint(SpringLayout.WEST,seventhSeparator,0,SpringLayout.WEST,componentPartPanel);
	    	springLayout.putConstraint(SpringLayout.NORTH,seventhSeparator,10,SpringLayout.SOUTH,sixthComponentDesc);
	    	this.addComponentListener(new ComponentAdapter(){
	            public void componentResized(ComponentEvent event){
	            	firstComponentDesc.setSize(new Dimension(componentsPanel.getWidth()-220, firstComponentDesc.getHeight()));
	            	secondComponentDesc.setSize(new Dimension(componentsPanel.getWidth()-220, secondComponentDesc.getHeight()));
	            	thirdComponentDesc.setSize(new Dimension(componentsPanel.getWidth()-220, thirdComponentDesc.getHeight()));
	            	fourthComponentDesc.setSize(new Dimension(componentsPanel.getWidth()-220, fourthComponentDesc.getHeight()));
	            	fifthComponentDesc.setSize(new Dimension(componentsPanel.getWidth()-220, fifthComponentDesc.getHeight()));
	            	sixthComponentDesc.setSize(new Dimension(componentsPanel.getWidth()-220, sixthComponentDesc.getHeight()));
	            	int componentPartPanelHeight=70+9/*separator*/*3+tableComponentPart.getHeight()+tableComponentDesc.getHeight()
	            			+firstComponent.getHeight()+firstComponentDesc.getHeight()
	            			+secondComponent.getHeight()+secondComponentDesc.getHeight()
	            			+thirdComponent.getHeight()+thirdComponentDesc.getHeight()
	            			+fourthComponentDesc.getHeight()+fourthComponent.getHeight()
	            			+fifthComponentDesc.getHeight()+fifthComponent.getHeight()
	            			+sixthComponentDesc.getHeight()+sixthComponent.getHeight();
	            	if(componentPartPanelHeight<580){
	            		componentPartPanel.setPreferredSize(new Dimension(2000,componentPartPanelHeight));
	            	}else{
	            		componentPartPanel.setPreferredSize(new Dimension(2000,580));
	            	}
	            }
			});
	    	componentPartPanel.setVisible(true);
	    	return componentPartPanel;
		}
}
