package fileToolBar;

import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingConstants;


public class FileWorker extends JFrame{
	private JButton SearchButton;
    private JButton ShredButton;
    private JComboBox ShareWith;

    private SearchButton searchObj;
    private ShredButton shredObj;
    private ShareWith shareObj;

    public FileWorker(){
        SearchButton = new JButton();
        ShredButton = new JButton();
        ShareWith = new JComboBox();
        
        setSearchButton();
        setShredButton();
        setShareWith();
      
    }
    
    public void setSearchButton(){
    	SearchButton.setText("SearchButton");
        SearchButton.setFocusable(false);
        SearchButton.setHorizontalTextPosition(SwingConstants.CENTER);
        SearchButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        
        searchObj = new SearchButton();
    }
    
    public void setShredButton(){
    	ShredButton.setText("ShredButton");
    	shredObj = new ShredButton();
    }
    
    public void setShareWith(){
    	ShareWith.setModel(new DefaultComboBoxModel(new String[] { "ShareWith", "GoupRead1", "GoupRead2" }));
        ShareWith.setPreferredSize(new Dimension(10, 10));
       
        shareObj = new ShareWith();
    }
    
    
    
    public JButton getSearchButton(){
    	return SearchButton;
    }
    public JButton getShredButton(){
    	return ShredButton;
    }
    public JComboBox getShareWith(){
    	return ShareWith;
    }
	
}
