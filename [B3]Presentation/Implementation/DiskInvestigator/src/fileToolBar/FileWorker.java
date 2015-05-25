package fileToolBar;

public class FileWorker {
    private SearchButton searchButton;
    private ShredButton shredButton;

    public FileWorker(){
        searchButton = new SearchButton();
        shredButton = new ShredButton();  
    }
    
    public void setSearchButtonStatus(boolean state) {
    }
    
    public void setShredButtonStatus(boolean state) {
    	shredButton.setEnabled(state);
    }
    
    public SearchButton getSearchButton(){
    	return searchButton;
    }
    public ShredButton getShredButton(){
    	return shredButton;
    }
}
