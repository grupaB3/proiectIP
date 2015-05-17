package displayArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StartUpDisplayer extends JPanel{

	protected StartUpDisplayer() {
		initUI();
	}
	
	private void initUI() {
		setPreferredSize(new Dimension(900, 600));
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		DrawPanel drawingPanel = new DrawPanel();
		drawingPanel.setPreferredSize(new Dimension(900, 440));
	
		add(drawingPanel,BorderLayout.NORTH);
	}
}