package fileToolBar;

import javax.swing.JComboBox;

public class FileWorker {
    private SearchButton searchButton;
    private ShredButton shredButton;
    private ShareWith shareButton;

    public FileWorker(){
        searchButton = new SearchButton();
        shredButton = new ShredButton();
        shareButton = new ShareWith();   
    }
    
    public SearchButton getSearchButton(){
    	return searchButton;
    }
    public ShredButton getShredButton(){
    	return shredButton;
    }
    public JComboBox getShareWith(){
    	return shareButton;
    }
	
}
