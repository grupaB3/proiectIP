package menuBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class InfoButton extends JFrame {

	private static final long serialVersionUID = -6058326491351599146L;
	private JScrollPane displayedScrollPane=new JScrollPane();
	private PanelObserver observer=new PanelObserver();
	private NavigationEvent myEvent=new NavigationEvent();
	private int currentPageNumber;
	@SuppressWarnings("rawtypes")
	private Stack backButtonStack=new Stack(),forwardButtonStack=new Stack();
	private	JButton backButton=new JButton("Back Button");
	private JButton forwardButton = new JButton("Forward Button");
	public InfoButton() {
		super("Disk Investigator Help and Support");
		init();
	}

	public void init(){
			myEvent.addObserver(observer);
	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int screenHeight = screenSize.height;
			int screenWidth = screenSize.width;
			setSize(new Dimension(400, screenHeight-50));
			setLocationRelativeTo(null);
			setLocation(screenWidth - getWidth(), screenHeight - getHeight()-50);
			setResizable(true);
			setBackground(new Color(255,255,255));
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setLayout(new FlowLayout(FlowLayout.LEADING));
			
			ImageIcon icon = new ImageIcon(getClass().getResource("../mainPackage/icon.png"));
			setIconImage(icon.getImage());
			
			this.setBackground(new Color(255,255,255));
			add(getHeaderPanel(this.getPreferredSize()));
			DiskInvestigatorInfoStartupPanel panel=new DiskInvestigatorInfoStartupPanel(this.getPreferredSize(),observer);
			displayedScrollPane=panel.getScrollPane();
			currentPageNumber=1;
			add(displayedScrollPane);
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
	                displayedScrollPane.setSize(new Dimension(getSize().width-24,getSize().height-147));
	                
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
			backButton.setEnabled(false);
			forwardButton.setEnabled(false);
			backButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					decreaseBackStack();
				}
			});
			forwardButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					decreaseForwardStack();
				}		
			});
			navButPanel.add(backButton);
			navButPanel.add(forwardButton);
			JPanel searchPanel=new JPanel();
			searchPanel.setBackground(new Color(255,255,255));
			searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			JTextField searchField=new JTextField();
			searchField.setPreferredSize(new Dimension(150,20));
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
		private class PanelObserver implements Observer{
			@Override
			public void update(Observable o, Object arg) {
				int[] obj=(int[]) arg;
				if(obj[0]==0){
					increaseBackStack(currentPageNumber);
					updatePanel(obj[1]);
				}else{
					System.out.println(obj[1]);
					updatePanel(obj[1]);
				}
				//restartForwardStack();
			}
		}
		@SuppressWarnings("unchecked")
		private void increaseBackStack(int page){
			backButtonStack.push(page);
			backButton.setEnabled(true);
		}
		private void decreaseBackStack(){
			int page=(int) backButtonStack.pop();
			increaseForwardStack(currentPageNumber);
			int[] args=new int[]{1,page};
			myEvent.setPage(args);
			myEvent.run();
			if(backButtonStack.isEmpty()){
				backButton.setEnabled(false);
			}
		}

		@SuppressWarnings("unchecked")
		private void increaseForwardStack(int page) {
			forwardButtonStack.push(page);
			forwardButton.setEnabled(true);
		}

		private void decreaseForwardStack() {
			int page=(int) forwardButtonStack.pop();
			increaseBackStack(currentPageNumber);
			int[] args=new int[]{1,page};
			myEvent.setPage(args);
			myEvent.run();
			if(forwardButtonStack.isEmpty()){
				forwardButton.setEnabled(false);
			}
		}
		@SuppressWarnings({ "unused", "rawtypes" })
		private void restartForwardStack(){
			forwardButtonStack=new Stack();	
			forwardButton.setEnabled(false);
		}
}

