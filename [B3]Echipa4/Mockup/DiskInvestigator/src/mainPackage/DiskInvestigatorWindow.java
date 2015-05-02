package mainPackage;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import displayArea.AreaOfDisplay;
import observers.MenuObserver;
import tabBar.MainTabBar;
import menuBar.MenuBar;
import mainToolBar.ToolBar;

public class DiskInvestigatorWindow extends JFrame{
	protected DiskInvestigatorWindow() {
		windowInit();
	}
	
	public void windowInit() {	
		ToolBar toolBar = new ToolBar();
		MainTabBar tabBar = new MainTabBar();
		MenuObserver observer = new MenuObserver(toolBar, tabBar);
		MenuBar menuBar = new MenuBar(observer);	
		AreaOfDisplay mainDisplayArea = new AreaOfDisplay();
		
		setJMenuBar(menuBar);
		toolBar.setPreferredSize(new Dimension(100, 70));
		add(toolBar, BorderLayout.NORTH);
		tabBar.setPreferredSize(new Dimension(1000, 30));
		add(tabBar, BorderLayout.CENTER);
		add(new JSeparator(), BorderLayout.LINE_START);
		mainDisplayArea.setPreferredSize(new Dimension(1000, 550));
		add(mainDisplayArea, BorderLayout.PAGE_END);
		setTitle("Disk Investigator");
		setSize(1000, 700);
		setResizable(false);
		setVisible(true);
		//pack();
		setLayout(new BorderLayout(0,0));
		setLocation(150, 10);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
