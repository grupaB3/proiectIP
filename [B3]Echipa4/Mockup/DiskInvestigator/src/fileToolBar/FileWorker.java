package fileToolBar;

import javax.swing.JComboBox;

public class FileWorker {
    private SearchButton searchButton;
    private ShredButton shredButton;

    public FileWorker(){
        searchButton = new SearchButton();
        shredButton = new ShredButton();  
    }
    
    public SearchButton getSearchButton(){
    	return searchButton;
    }
    public ShredButton getShredButton(){
    	return shredButton;
    }
}
