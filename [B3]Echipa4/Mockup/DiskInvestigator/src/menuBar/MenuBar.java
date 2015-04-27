package menuBar;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import dialogs.ErrorDialog;
import dialogs.WarningDialog;
import observers.MenuObserver;

public class MenuBar extends JMenuBar {
	private JMenu fileMenu = new JMenu("Files");
	private JMenu processMenu = new JMenu("Processes");
	private JMenu infoMenu = new JMenu("Info");
	private MenuObserver observer;
	
	public MenuBar(MenuObserver observer) {
		this.observer = observer;
		init();
	}
	
	public void init() {
		add(fileMenu);
		add(processMenu);
		add(infoMenu);
		
		fileMenu.addMenuListener(new MenuListener() {

			@Override
			public void menuCanceled(MenuEvent e) {
				observer.activateBar("start");
			}

			@Override
			public void menuDeselected(MenuEvent e) {
			}

			@Override
			public void menuSelected(MenuEvent e) {
				observer.activateBar("file");
			}

		});
		
		processMenu.addMenuListener(new MenuListener() {

			@Override
			public void menuCanceled(MenuEvent e) {
				observer.activateBar("start");
			}

			@Override
			public void menuDeselected(MenuEvent e) {
			}

			@Override
			public void menuSelected(MenuEvent e) {
				observer.activateBar("process");
				WarningDialog err = new WarningDialog();
				err.displayMessage("Message");
			}
		});
	}
}