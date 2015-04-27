package mainPackage;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;



import menuBar.MenuBar;
import mainToolBar.ToolBar;
import dialogs.DialogWindow;

public class DiskInvestigatorWindow extends JFrame{
	protected DiskInvestigatorWindow() {
		windowInit();
	}
	
	public void windowInit() {
		
		MenuBar menuBar = new MenuBar();
		ToolBar toolBar = new ToolBar();
		
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
