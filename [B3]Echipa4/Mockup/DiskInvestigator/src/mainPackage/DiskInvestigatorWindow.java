package mainPackage;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JSeparator;

import displayArea.AreaOfDisplay;
import observers.BackObserver;
import observers.MenuObserver;
import observers.TabObserver;
import tabBar.MainTabBar;
import menuBar.MenuBar;
import mainToolBar.ToolBar;

public class DiskInvestigatorWindow extends JFrame{
	protected DiskInvestigatorWindow() {
		windowInit();
	}
	
	public void windowInit() {
		AreaOfDisplay mainDisplayArea = new AreaOfDisplay();
		TabObserver observerTab = new TabObserver(mainDisplayArea);
		MainTabBar tabBar = new MainTabBar(observerTab);
		BackObserver observerBack = new BackObserver(tabBar, mainDisplayArea);
		ToolBar toolBar = new ToolBar(observerBack);
		observerTab.setToolBar(toolBar);
		MenuObserver observer = new MenuObserver(toolBar, tabBar, mainDisplayArea);
		MenuBar menuBar = new MenuBar(observer);	
		
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
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
