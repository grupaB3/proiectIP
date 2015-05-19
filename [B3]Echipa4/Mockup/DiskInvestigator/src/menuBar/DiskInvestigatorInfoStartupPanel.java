package menuBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class DiskInvestigatorInfoStartupPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8978989351230968588L;
	private JScrollPane scrollPane=new JScrollPane();
	private NavigationEvent myEvent=new NavigationEvent();
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public DiskInvestigatorInfoStartupPanel(Dimension frameSize,Observer observer){
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
	    	descriptionPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
	    	JTextArea descriptionTitleTextArea=new JTextArea();
	    	descriptionTitleTextArea.setBackground(new Color(255,255,255));
	    	descriptionTitleTextArea.setSize(new Dimension(this.getPreferredSize().width-30,10));
	    	descriptionTitleTextArea.setEditable(false);
	    	descriptionTitleTextArea.setText("      Disk Manager");
	    	Font textAreaFont=new Font("Calibri",Font.PLAIN,36);
	    	descriptionTitleTextArea.setFont(textAreaFont);
	    	descriptionTitleTextArea.setForeground(Color.DARK_GRAY);
	    	JTextArea descriptionTextArea=new JTextArea();
	    	descriptionTextArea.setBackground(new Color(255,255,255));
	    	descriptionTextArea.setSize(new Dimension(this.getPreferredSize().width-30,10));
	    	descriptionTextArea.setLineWrap(true);
	    	descriptionTextArea.setWrapStyleWord(true);
	    	descriptionTextArea.setEditable(false);
	    	descriptionTextArea.setText("         Disk Manager is an application designed to simplify actions like erasing files, recover deleted ones or "
	    			+ "monitoring suspicious processes, giving you the posibility to stop them, and more. "
	    			+ "This help is at your disposal, mapping all the features of this application.");
	    	textAreaFont=new Font("Calibri",Font.PLAIN,18);
	    	descriptionTextArea.setFont(textAreaFont);
	    	descriptionPanel.add(descriptionTitleTextArea);
	    	descriptionPanel.add(descriptionTextArea);
	    	JPanel componentsPanel=new JPanel();
	    	//componentsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	    	componentsPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
	    	componentsPanel.setBackground(new Color(255,255,255));
	    	componentsPanel.setPreferredSize(new Dimension(this.getSize().width,300));
	    	JTextArea componentsTitleTextArea=new JTextArea();
	    	componentsTitleTextArea.setBackground(new Color(255,255,255));
	    	componentsTitleTextArea.setSize(new Dimension(this.getPreferredSize().width-30,10));
	    	componentsTitleTextArea.setEditable(false);
	    	componentsTitleTextArea.setText("          Disk Manager Main Components");
	    	textAreaFont=new Font("Calibri",Font.PLAIN,24);
	    	componentsTitleTextArea.setFont(textAreaFont);
	    	componentsTitleTextArea.setForeground(Color.DARK_GRAY);
	    	componentsPanel.add(componentsTitleTextArea);
	    	JTextArea componentsIntroTextArea=new JTextArea();
	    	componentsIntroTextArea.setSize(new Dimension(this.getPreferredSize().width-30,10));
	    	componentsIntroTextArea.setLineWrap(true);
	    	componentsIntroTextArea.setWrapStyleWord(true);
	    	componentsIntroTextArea.setEditable(false);
	    	componentsIntroTextArea.setText("         Below you can see the main window of the application and it's primary components.\n");
	    	componentsIntroTextArea.setBackground(new Color(255,255,255));
	    	textAreaFont=new Font("Calibri",Font.PLAIN,18);
	    	componentsIntroTextArea.setFont(textAreaFont);
	    	componentsPanel.add(componentsIntroTextArea);
	    	BufferedImage myPicture = null;
			try {
				myPicture = ImageIO.read(getClass().getResource("mainWindow.png"));
			} catch (IOException e) {
				System.out.println("Eroare!");
			}
	    	JLabel picLabel = new JLabel(new ImageIcon(myPicture.getScaledInstance(700, 500, Image.SCALE_DEFAULT)));
	    	picLabel.setAlignmentY(CENTER_ALIGNMENT);
	    	componentsPanel.add(picLabel);
	    	JTextArea pictureDescriptionTextArea=new JTextArea();
	    	pictureDescriptionTextArea.setSize(new Dimension(this.getPreferredSize().width-30,10));
	    	pictureDescriptionTextArea.setLineWrap(true);
	    	pictureDescriptionTextArea.setWrapStyleWord(true);
	    	pictureDescriptionTextArea.setEditable(false);
	    	pictureDescriptionTextArea.setText("          Disk Investigator Startup Window. See the following table for more info about each numbered area.");
	    	pictureDescriptionTextArea.setBackground(new Color(255,255,255));
	    	textAreaFont=new Font("Calibri",Font.ITALIC,13);
	    	pictureDescriptionTextArea.setFont(textAreaFont);
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
	            	componentsTitleTextArea.setSize(getSize().width-30, componentsTitleTextArea.getSize().height);
	            	componentsIntroTextArea.setSize(getSize().width-30, componentsIntroTextArea.getSize().height);
	            	pictureDescriptionTextArea.setSize(getSize().width-30, pictureDescriptionTextArea.getSize().height);
	            	componentsPanel.setPreferredSize(new Dimension(getParent().getSize().width-10,componentsIntroTextArea.getSize().height+componentsTitleTextArea.getSize().height+
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
	    	tableComponentPart.setText("Component*");
	    	tableComponentPart.setEditable(false);
	    	tableComponentPart.setFont(textAreaTitleFont);
	    	tableComponentPart.setForeground(Color.DARK_GRAY);
	    	JTextArea tableComponentDesc=new JTextArea();
	    	tableComponentDesc.setSize(new Dimension(200,10));
	    	tableComponentDesc.setBackground(new Color(255,255,255));
	    	tableComponentDesc.setText("Component Description");
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
	    	springLayout.putConstraint(SpringLayout.WEST, tableComponentDesc,87,SpringLayout.EAST, tableComponentPart);
	    	springLayout.putConstraint(SpringLayout.NORTH, tableComponentDesc,5,SpringLayout.NORTH, componentPartPanel);
	    	springLayout.putConstraint(SpringLayout.WEST, firstSeparator, 0, SpringLayout.WEST, componentPartPanel);
	    	springLayout.putConstraint(SpringLayout.NORTH,firstSeparator,10,SpringLayout.SOUTH,tableComponentPart);
	    	JTextArea firstComponent=new JTextArea();
	    	firstComponent.setBackground(new Color(255,255,255));
	    	firstComponent.setText("1. Disk Scan");
	    	firstComponent.setSize(new Dimension(100,20));
	    	firstComponent.setEditable(false);
	    	firstComponent.setFont(textAreaTitleFont);
	    	firstComponent.setForeground(Color.DARK_GRAY);
	    	firstComponent.addMouseListener(new MouseListener(){
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int[] args=new int[]{0,2};
					myEvent.setPage(args);
					myEvent.run();
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					firstComponent.setBackground(new Color(225,225,225));		
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					firstComponent.setBackground(new Color(255,255,255));
					
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
	    	JTextArea firstComponentDesc=new JTextArea();
	    	firstComponentDesc.setBackground(new Color(255,255,255));
	    	firstComponentDesc.setText("This component represents the part of the application that is designed to help you "
	    			+ "work with files. Clicking on this component will open the 'Files' toolbar.");
	    	firstComponentDesc.setEditable(false);
	    	firstComponentDesc.setWrapStyleWord(true);
	    	firstComponentDesc.setLineWrap(true);
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
	    	secondComponent.setText("2. Processes Scan");
	    	secondComponent.setSize(new Dimension(100,20));
	    	secondComponent.setEditable(false);
	    	secondComponent.setFont(textAreaTitleFont);
	    	secondComponent.setForeground(Color.DARK_GRAY);
	    	secondComponent.addMouseListener(new MouseListener(){
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int[] args=new int[]{0,3};
					myEvent.setPage(args);
					myEvent.run();
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					secondComponent.setBackground(new Color(225,225,225));		
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					secondComponent.setBackground(new Color(255,255,255));
					
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
	    	JTextArea secondComponentDesc=new JTextArea();
	    	secondComponentDesc.setBackground(new Color(255,255,255));
	    	secondComponentDesc.setText("This component, similar to the one that is left of it, represents the part of the application that is designed to work with processes"
	    			+ ". Hovering over this components will change its color and clicking it will open the 'Processes' tooolbar and interface.");
	    	secondComponentDesc.setEditable(false);
	    	secondComponentDesc.setWrapStyleWord(true);
	    	secondComponentDesc.setLineWrap(true);
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
	    	springLayout.putConstraint(SpringLayout.WEST,secondComponentDesc,45,SpringLayout.EAST,secondComponent);
	    	springLayout.putConstraint(SpringLayout.NORTH,secondComponentDesc,10,SpringLayout.SOUTH,secondSeparator);
	    	springLayout.putConstraint(SpringLayout.WEST,thirdSeparator,0,SpringLayout.WEST,componentPartPanel);
	    	springLayout.putConstraint(SpringLayout.NORTH,thirdSeparator,10,SpringLayout.SOUTH,secondComponentDesc);
	    	JTextArea thirdComponent=new JTextArea();
	    	thirdComponent.setBackground(new Color(255,255,255));
	    	thirdComponent.setText("3. Contact");
	    	thirdComponent.setSize(new Dimension(100,20));
	    	thirdComponent.setEditable(false);
	    	thirdComponent.setFont(textAreaTitleFont);
	    	thirdComponent.setForeground(Color.DARK_GRAY);
	    	JTextArea thirdComponentDesc=new JTextArea();
	    	thirdComponentDesc.setBackground(new Color(255,255,255));
	    	thirdComponentDesc.setText("This component, similar to the one that is left of it, represents the part of the application that is designed to work with processes"
	    			+ ". Hovering over this components will change its color and clicking it will open the 'Processes' tooolbar and interface.");
	    	thirdComponentDesc.setEditable(false);
	    	thirdComponentDesc.setWrapStyleWord(true);
	    	thirdComponentDesc.setLineWrap(true);
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
	    	springLayout.putConstraint(SpringLayout.WEST,thirdComponentDesc,98,SpringLayout.EAST,thirdComponent);
	    	springLayout.putConstraint(SpringLayout.NORTH,thirdComponentDesc,10,SpringLayout.SOUTH,thirdSeparator);
	    	springLayout.putConstraint(SpringLayout.WEST,fourthSeparator,0,SpringLayout.WEST,componentPartPanel);
	    	springLayout.putConstraint(SpringLayout.NORTH,fourthSeparator,10,SpringLayout.SOUTH,thirdComponentDesc);
	    	JTextArea fourthComponent=new JTextArea();
	    	fourthComponent.setBackground(new Color(255,255,255));
	    	fourthComponent.setText("*Click on each component name to open the help page for it");
	    	fourthComponent.setSize(new Dimension(200,20));
	    	fourthComponent.setEditable(false);
	    	Font textAreaCommFont=new Font("Calibri",Font.ITALIC,12);
	    	fourthComponent.setFont(textAreaCommFont);
	    	fourthComponent.setForeground(Color.DARK_GRAY);
	    	componentPartPanel.add(fourthComponent);
	    	springLayout.putConstraint(SpringLayout.WEST,fourthComponent,38,SpringLayout.WEST,componentPartPanel);
	    	springLayout.putConstraint(SpringLayout.NORTH,fourthComponent,10,SpringLayout.SOUTH,fourthSeparator);
	    	this.addComponentListener(new ComponentAdapter(){
	            public void componentResized(ComponentEvent event){
	            	firstComponentDesc.setSize(new Dimension(componentsPanel.getWidth()-220, firstComponentDesc.getHeight()));
	            	secondComponentDesc.setSize(new Dimension(componentsPanel.getWidth()-220, secondComponentDesc.getHeight()));
	            	thirdComponentDesc.setSize(new Dimension(componentsPanel.getWidth()-220, thirdComponentDesc.getHeight()));
	            	fourthComponent.setSize(new Dimension(componentsPanel.getWidth()-220, fourthComponent.getHeight()));
	            	int componentPartPanelHeight=firstComponentDesc.getHeight()+firstComponent.getHeight()+tableComponentPart.getHeight()
	            			+tableComponentDesc.getHeight()+firstSeparator.getHeight()+secondSeparator.getHeight()
	            			+secondComponent.getHeight()+secondComponentDesc.getHeight()+thirdComponentDesc.getHeight()+30
	            			+thirdComponentDesc.getHeight()+fourthComponent.getHeight()+30;
	            	if(componentPartPanelHeight<550){
	            		componentPartPanel.setPreferredSize(new Dimension(2000,componentPartPanelHeight));
	            	}else{
	            		componentPartPanel.setPreferredSize(new Dimension(2000,550));
	            	}
	            }
			});
	    	componentPartPanel.setVisible(true);
	    	return componentPartPanel;
		}

}
