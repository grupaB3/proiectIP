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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.border.Border;

import org.apache.lucene.analysis.standard.StandardAnalyzer;

public class InfoButton extends JFrame {

	private static final long serialVersionUID = -6058326491351599146L;
	private JScrollPane displayedScrollPane=new JScrollPane();
	private PanelObserver observer=new PanelObserver();
	private NavigationEvent myEvent=new NavigationEvent();
	private int currentPageNumber;
	private Stack backButtonStack=new Stack(),forwardButtonStack=new Stack();
	private	JButton backButton=new JButton("Back Button");
	private JButton forwardButton = new JButton("Forward Button");
	private StandardAnalyzer analyzer=new StandardAnalyzer();
	private HelpFinder finder;
	private JPanel panelCopy;
	private HelpHighlighter highlighter=new HelpHighlighter();
	public InfoButton() {
		super("Disk Investigator Help and Support");
		init();
	}

	public void init(){
			myEvent.addObserver(observer);
			//HelpTokenizer tokenizer=new HelpTokenizer(analyzer);
			finder=new HelpFinder(analyzer);
	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int screenHeight = screenSize.height;
			int screenWidth = screenSize.width;
			setSize(new Dimension(400, screenHeight-50));
			setPreferredSize(new Dimension(400, screenHeight-50));
			setLocationRelativeTo(null);
			setLocation(screenWidth - getWidth(), screenHeight - getHeight()-50);
			setResizable(true);
			setBackground(new Color(255,255,255));
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setLayout(new FlowLayout(FlowLayout.LEADING));
			this.setBackground(new Color(255,255,255));
			add(getHeaderPanel(this.getPreferredSize()));
			DiskInvestigatorInfoStartupPanel panel=new DiskInvestigatorInfoStartupPanel(this.getPreferredSize(),observer);
			panelCopy=panel;
			highlighter.setTextAreaList(panel.getIndexableTextAreas());
			displayedScrollPane=panel.getScrollPane();
			currentPageNumber=1;
			add(displayedScrollPane);
	    	this.addComponentListener(new ComponentAdapter(){
	            public void componentResized(ComponentEvent event){
            		((InfoButton) event.getComponent()).getDisplayedScrollPane().setPreferredSize(new Dimension(getSize().width-15,getSize().height-139));
    				displayedScrollPane.revalidate();
    				displayedScrollPane.repaint();
	            }
			});
			addWindowListener(new WindowAdapter(){
				@Override
				public void windowClosing(WindowEvent windowEvent){
					finder.close();
				}
			});	    	
	}

		protected JScrollPane getDisplayedScrollPane() {
			return displayedScrollPane;
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
			searchField.addKeyListener(new KeyListener(){

				@Override
				public void keyPressed(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyReleased(KeyEvent arg0) {
					if(!searchField.getText().equals("")){
						//refreshPanel();
						finder.find(searchField.getText(),panelCopy,highlighter);
						panelCopy.revalidate();
						panelCopy.repaint();
					}
				}

				@Override
				public void keyTyped(KeyEvent arg0) {

				}
				
			});
			JButton searchButton=new JButton("Search Button");
			searchButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(!searchField.getText().equals("")){
						finder.find(searchField.getText(),panelCopy,highlighter);
						panelCopy.revalidate();
						panelCopy.repaint();
					}
				}		
			});
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
	              } else if ((oldState & Frame.ICONIFIED) != 0 && (newState & Frame.ICONIFIED) == 0) {
	              }

	              if ((oldState & Frame.MAXIMIZED_BOTH) == 0 && (newState & Frame.MAXIMIZED_BOTH) != 0) {
	                updatePanel(currentPageNumber);
	                displayedScrollPane.setPreferredSize(new Dimension(getSize().width-24,getSize().height-147));
	                displayedScrollPane.revalidate();
	                displayedScrollPane.repaint();
	                navButPanel.setPreferredSize(new Dimension(getSize().width,40));
	            	searchPanel.setPreferredSize(new Dimension(getSize().width,40));
	            	headerPanel.setPreferredSize(new Dimension(getSize().width,90));
	                
	              } else if ((oldState & Frame.MAXIMIZED_BOTH) != 0 && (newState & Frame.MAXIMIZED_BOTH) == 0) {
	                updatePanel(currentPageNumber);
	                displayedScrollPane.setPreferredSize(new Dimension(getSize().width-24,getSize().height-147));
	                displayedScrollPane.revalidate();
	                displayedScrollPane.repaint();
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
				DiskInvestigatorInfoStartupPanel panel=new DiskInvestigatorInfoStartupPanel(this.getPreferredSize(),observer);
				panelCopy=panel;
				highlighter.setTextAreaList(panel.getIndexableTextAreas());
				displayedScrollPane=panel.getScrollPane();
				add(displayedScrollPane);
				this.setPreferredSize(new Dimension(this.getSize().width+1,this.getSize().height+1));
				panel.setPreferredSize(new Dimension(this.getSize().width+1,this.getSize().height+1));
				displayedScrollPane.setPreferredSize(new Dimension(this.getSize().width+1,this.getSize().height+1));
				currentPageNumber=1;
				revalidate();
				repaint();
			}else{
				if(page==2){
					remove(displayedScrollPane);
					DiskInvestigatorInfoFilePanel panel=new DiskInvestigatorInfoFilePanel(this.getPreferredSize());
					panelCopy=panel;
					highlighter.setTextAreaList(panel.getIndexableTextAreas());
					displayedScrollPane=panel.getScrollPane();
					add(displayedScrollPane);
					this.setPreferredSize(new Dimension(this.getSize().width+1,this.getSize().height+1));
					panel.setPreferredSize(new Dimension(this.getSize().width+1,this.getSize().height+1));
					displayedScrollPane.setPreferredSize(new Dimension(this.getSize().width+1,this.getSize().height+1));
					currentPageNumber=2;
					revalidate();
					repaint();
				}else{
					if(page==3){
						remove(displayedScrollPane);
						DiskInvestigatorInfoProcessPanelPart1 panel=new DiskInvestigatorInfoProcessPanelPart1(this.getPreferredSize(),observer);
						panelCopy=panel;
						highlighter.setTextAreaList(panel.getIndexableTextAreas());
						displayedScrollPane=panel.getScrollPane();
						add(displayedScrollPane); 
						this.setPreferredSize(new Dimension(this.getSize().width+1,this.getSize().height+1));
						panel.setPreferredSize(new Dimension(this.getSize().width+1,this.getSize().height+1));
						displayedScrollPane.setPreferredSize(new Dimension(this.getSize().width+1,this.getSize().height+1));
						currentPageNumber=3;
						revalidate();
						repaint();
					}else{
						if(page==4){
							remove(displayedScrollPane);
							DiskInvestigatorInfoProcessPanelPart2 panel=new DiskInvestigatorInfoProcessPanelPart2(this.getPreferredSize(),observer);
							panelCopy=panel;
							highlighter.setTextAreaList(panel.getIndexableTextAreas());
							displayedScrollPane=panel.getScrollPane();
							add(displayedScrollPane);
							this.setPreferredSize(new Dimension(this.getSize().width+1,this.getSize().height+1));
							panel.setPreferredSize(new Dimension(this.getSize().width+1,this.getSize().height+1));
							displayedScrollPane.setPreferredSize(new Dimension(this.getSize().width+1,this.getSize().height+1));
							currentPageNumber=4;
							revalidate();
							repaint();
						}else{
							if(page==5){
								remove(displayedScrollPane);
								DiskInvestigatorInfoProcessPanelPart3 panel=new DiskInvestigatorInfoProcessPanelPart3(this.getPreferredSize(),observer);
								panelCopy=panel;
								highlighter.setTextAreaList(panel.getIndexableTextAreas());
								displayedScrollPane=panel.getScrollPane();
								add(displayedScrollPane);
								this.setPreferredSize(new Dimension(this.getSize().width+1,this.getSize().height+1));
								panel.setPreferredSize(new Dimension(this.getSize().width+1,this.getSize().height+1));
								displayedScrollPane.setPreferredSize(new Dimension(this.getSize().width+1,this.getSize().height+1));
								currentPageNumber=5;
								revalidate();
								repaint();
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
					restartForwardStack();
				}else{
					updatePanel(obj[1]);
				}
			}
		}
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

		private void increaseForwardStack(int page) {
			forwardButtonStack.push(page);
			forwardButton.setEnabled(true);
		}

		private void decreaseForwardStack() {
			int page=(int) forwardButtonStack.pop();
			increaseBackStack(currentPageNumber);
			int[] args=new int[]{1 ,page};
			myEvent.setPage(args);
			myEvent.run();
			if(forwardButtonStack.isEmpty()){
				forwardButton.setEnabled(false);
			}
		}
		private void restartForwardStack(){
			forwardButtonStack=new Stack();	
			forwardButton.setEnabled(false);
		}
}

