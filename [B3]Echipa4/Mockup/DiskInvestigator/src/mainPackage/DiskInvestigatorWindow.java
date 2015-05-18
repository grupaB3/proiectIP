package mainPackage;

import items.FileHandler;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import displayArea.AreaOfDisplay;
import observers.BackObserver;
import observers.FileObserver;
import observers.MenuObserver;
import observers.TabObserver;
import tabBar.MainTabBar;
import menuBar.MenuBar;
import mainToolBar.ToolBar;

public class DiskInvestigatorWindow extends JFrame{

	private static final long serialVersionUID = 7722349641003921408L;

	protected DiskInvestigatorWindow() {
		windowInit();
	}
	
	public void windowInit() {
		FileHandler fileHandler = new FileHandler();
		FileObserver fileObserver = new FileObserver(fileHandler);
		
		AreaOfDisplay mainDisplayArea = new AreaOfDisplay();
		mainDisplayArea.setPreferredSize(new Dimension(900, 440));
		TabObserver observerTab = new TabObserver(mainDisplayArea);
		MainTabBar tabBar = new MainTabBar(observerTab);
		tabBar.setPreferredSize(new Dimension(900, 40));
		BackObserver observerBack = new BackObserver(tabBar, mainDisplayArea);
		ToolBar toolBar = new ToolBar();
		toolBar.setObserver(observerBack);
		toolBar.setObserver(fileObserver);
		toolBar.setPreferredSize(new Dimension(100, 60));
		observerTab.setToolBar(toolBar);
		MenuObserver observer = new MenuObserver(toolBar, tabBar, mainDisplayArea);
		MenuBar menuBar = new MenuBar(observer);	
		
		setJMenuBar(menuBar);
		add(toolBar, BorderLayout.NORTH);
		add(tabBar, BorderLayout.CENTER);
		add(mainDisplayArea, BorderLayout.SOUTH);
		setTitle("Disk Investigator");
		setSize(900, 600);
		setResizable(false);
		setVisible(true);

		setLayout(new BorderLayout(0,0));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
