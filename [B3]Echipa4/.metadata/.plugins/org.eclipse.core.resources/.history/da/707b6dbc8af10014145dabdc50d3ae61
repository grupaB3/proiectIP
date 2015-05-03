package mainPackage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import observers.MenuObserver;
import menuBar.MenuBar;
import mainToolBar.ToolBar;

public class DiskInvestigatorWindow extends JFrame{
	protected DiskInvestigatorWindow() {
		windowInit();
	}
	
	public void windowInit() {
		ToolBar toolBar = new ToolBar();
		MenuObserver observer = new MenuObserver(toolBar);
		MenuBar menuBar = new MenuBar(observer);
		
		
		setJMenuBar(menuBar);
		toolBar.setPreferredSize(new Dimension(100, 70));
		add(toolBar, BorderLayout.NORTH);
		setTitle("Disk Investigator");
		setSize(1000, 700);
		setVisible(true);
		setLocation(150, 10);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
