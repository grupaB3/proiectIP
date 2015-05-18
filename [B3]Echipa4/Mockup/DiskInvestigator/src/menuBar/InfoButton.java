package menuBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class InfoButton extends JFrame {

	private static final long serialVersionUID = -6058326491351599146L;
	private JScrollPane displayedScrollPane=new JScrollPane();Observer observer;
	private int currentPageNumber;
	private Stack backButtonStack=new Stack(),forwardButtonStack=new Stack();
	public InfoButton() {
		super("Disk Investigator Help and Support");
		init();
	}

	public void init(){
			observer = (Observable obj, Object arg) -> { 
				updatePanel((int)arg);	
	        };
	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int screenHeight = screenSize.height;
			int screenWidth = screenSize.width;
			setSize(400, screenHeight);
			setLocationRelativeTo(null);
			setLocation(screenWidth - getWidth(), screenHeight - getHeight());
			setResizable(true);
			setBackground(new Color(255,255,255));
			//setPreferredSize(new Dimension(350, screenHeight));
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setLayout(new FlowLayout(FlowLayout.LEADING));
			//setLayout(new GridLayout());
			this.setBackground(new Color(255,255,255));
			add(getHeaderPanel(this.getPreferredSize()));
			updatePanel(1);
	    	this.addComponentListener(new ComponentAdapter(){
	            public void componentResized(ComponentEvent event){
            		displayedScrollPane.setPreferredSize(new Dimension(getSize().width-15,getSize().height-139));
	            }
			});
	    	addWindowStateListener(new WindowAdapter() {
	            public void windowStateChanged(WindowEvent evt) {
	              int oldState = evt.getOldState();
	              int newState = evt.getNewState();

	              if ((oldState & Frame.ICONIFIED) == 0 && (newState & Frame.ICONIFIED) != 0) {
	                //System.out.println("Frame was iconized");
	              } else if ((oldState & Frame.ICONIFIED) != 0 && (newState & Frame.ICONIFIED) == 0) {
	                //System.out.println("Frame was deiconized");
	              }

	              if ((oldState & Frame.MAXIMIZED_BOTH) == 0 && (newState & Frame.MAXIMIZED_BOTH) != 0) {
	                updatePanel(currentPageNumber);
	                displayedScrollPane.setSize(new Dimension(getSize().width-224,getSize().height-147));
	                
	              } else if ((oldState & Frame.MAXIMIZED_BOTH) != 0 && (newState & Frame.MAXIMIZED_BOTH) == 0) {
	                updatePanel(currentPageNumber);
	                displayedScrollPane.setSize(new Dimension(getSize().width-24,getSize().height-147));
	              }
	            }
	          });
	}

		private JPanel getHeaderPanel(Dimension frameSize) {
			JPanel headerPanel=new JPanel();
			headerPanel.setBackground(new Color(255,255,255));
			headerPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
			JPanel navButPanel=new JPanel();
			navButPanel.setBackground(new Color(255,255,255));
			navButPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
			JButton backButton=new JButton("Back Button");
			JButton forwardButton = new JButton("Forward Button");
			backButton.setEnabled(false);
			forwardButton.setEnabled(false);
			backButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(backButtonStack.isEmpty()){
						backButton.setEnabled(false);
					}else{
						backButton.setEnabled(true);
						
					}
				}
			});
			forwardButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(forwardButtonStack.isEmpty()){
						forwardButton.setEnabled(false);
					}else{
						forwardButton.setEnabled(true);
					}
				}
				
			});
			navButPanel.add(backButton);
			navButPanel.add(forwardButton);
			JPanel searchPanel=new JPanel();
			searchPanel.setBackground(new Color(255,255,255));
			searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			JTextField searchField=new JTextField("\t                             ");
			Border border = BorderFactory.createLineBorder(Color.BLACK);
			searchField.setBorder(BorderFactory.createCompoundBorder(border, 
    	            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
			searchField.setBorder(border);
			Font textAreaFont=new Font("Calibri",Font.PLAIN,15);
			searchField.setFont(textAreaFont);
			JButton searchButton=new JButton("Search Button");
			searchPanel.add(searchField);
			searchPanel.add(searchButton);
			navButPanel.setPreferredSize(new Dimension(frameSize.width,40));
			searchPanel.setPreferredSize(new Dimension(frameSize.width,40));
			headerPanel.setPreferredSize(new Dimension(frameSize.width,90));
			this.addComponentListener(new ComponentAdapter(){
	            public void componentResized(ComponentEvent event){
	            	navButPanel.setPreferredSize(new Dimension(getSize().width,40));
	            	searchPanel.setPreferredSize(new Dimension(getSize().width,40));
	            	headerPanel.setPreferredSize(new Dimension(getSize().width,90)); 	
	            }
			});
			addWindowStateListener(new WindowAdapter() {
	            public void windowStateChanged(WindowEvent evt) {
	              int oldState = evt.getOldState();
	              int newState = evt.getNewState();

	              if ((oldState & Frame.ICONIFIED) == 0 && (newState & Frame.ICONIFIED) != 0) {
	                System.out.println("Frame was iconized");
	              } else if ((oldState & Frame.ICONIFIED) != 0 && (newState & Frame.ICONIFIED) == 0) {
	                System.out.println("Frame was deiconized");
	              }

	              if ((oldState & Frame.MAXIMIZED_BOTH) == 0 && (newState & Frame.MAXIMIZED_BOTH) != 0) {
	                updatePanel(currentPageNumber);
	                displayedScrollPane.setPreferredSize(new Dimension(getSize().width-524,getSize().height-547));
	                navButPanel.setPreferredSize(new Dimension(getSize().width,40));
	            	searchPanel.setPreferredSize(new Dimension(getSize().width,40));
	            	headerPanel.setPreferredSize(new Dimension(getSize().width,90));
	                
	              } else if ((oldState & Frame.MAXIMIZED_BOTH) != 0 && (newState & Frame.MAXIMIZED_BOTH) == 0) {
	                updatePanel(currentPageNumber);
	                displayedScrollPane.setPreferredSize(new Dimension(getSize().width-24,getSize().height-147));
	                navButPanel.setPreferredSize(new Dimension(getSize().width,40));
	            	searchPanel.setPreferredSize(new Dimension(getSize().width,40));
	            	headerPanel.setPreferredSize(new Dimension(getSize().width,90));
	              }
	            }
	          });
			headerPanel.add(navButPanel);
			headerPanel.add(searchPanel);
			return headerPanel;
		}

		public void setVisible(){
			setVisible(true);
		}
		private void updatePanel(int page){
			if(page==1){
				remove(displayedScrollPane);
				DiskInvestigatorInfoStartupPanel panel=new DiskInvestigatorInfoStartupPanel(this.getSize(),observer);
				displayedScrollPane=panel.getScrollPane();
				add(displayedScrollPane);
				currentPageNumber=1;
				SwingUtilities.updateComponentTreeUI(this);
			}else{
				if(page==2){
					remove(displayedScrollPane);
					DiskInvestigatorInfoFilePanel panel=new DiskInvestigatorInfoFilePanel(getSize());
					displayedScrollPane=panel.getScrollPane();
					add(displayedScrollPane);
					currentPageNumber=2;
					SwingUtilities.updateComponentTreeUI(this);
				}else{
					if(page==3){
						remove(displayedScrollPane);
						DiskInvestigatorInfoProcessPanelPart1 panel=new DiskInvestigatorInfoProcessPanelPart1(this.getSize(),observer);
						displayedScrollPane=panel.getScrollPane();
						add(displayedScrollPane);
						currentPageNumber=3;
						SwingUtilities.updateComponentTreeUI(this);	
					}else{
						if(page==4){
							remove(displayedScrollPane);
							DiskInvestigatorInfoProcessPanelPart2 panel=new DiskInvestigatorInfoProcessPanelPart2(this.getSize(),observer);
							displayedScrollPane=panel.getScrollPane();
							add(displayedScrollPane);
							currentPageNumber=4;
							SwingUtilities.updateComponentTreeUI(this);	
						}else{
							if(page==5){
								remove(displayedScrollPane);
								DiskInvestigatorInfoProcessPanelPart3 panel=new DiskInvestigatorInfoProcessPanelPart3(this.getSize(),observer);
								displayedScrollPane=panel.getScrollPane();
								add(displayedScrollPane);
								currentPageNumber=5;
								SwingUtilities.updateComponentTreeUI(this);									
							}
						}
					}
				}
			}
			
		}
		public class PanelObserver implements Observer{
			@Override
			public void update(Observable o, Object arg) {
				updatePanel((int)arg);	
			}

		}
}

