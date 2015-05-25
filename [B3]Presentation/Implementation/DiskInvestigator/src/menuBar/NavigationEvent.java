package menuBar;
import java.util.Observable;

public class NavigationEvent extends Observable implements Runnable{
	private int[] obj;
	 @Override
	 public void run() {
		 	setChanged();
		 	notifyObservers(obj);
	    }

	public void setPage(Object received) {
		obj=(int[]) received;
	}
}