package menuBar;
import java.util.Observable;

public class NavigationEvent extends Observable implements Runnable{
	private int page;
	 @Override
	 public void run() {
		 	setChanged();
		 	notifyObservers(page);
	    }

	public void setPage(int received) {
		page=received;
	}
}