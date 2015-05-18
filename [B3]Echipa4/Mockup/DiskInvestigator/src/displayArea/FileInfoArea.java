package displayArea;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTable;
import diskscan.MFTEntry;

@SuppressWarnings("serial")
public class FileInfoArea extends JPanel {

	private JPanel panel;
	
	protected FileInfoArea() {
		initUI();
	}
	
	private void initUI() {
		setBackground(Color.gray);
		setPreferredSize(new Dimension(276, 450));
		setLayout(null);
		panel = new JPanel();
		panel.setBounds(15,15,244,420);
		panel.setLayout(null);
		add(panel);
	}
	
	public void setInfoRow(JTable table, int selectedRow, MFTEntry mftEntry){
		removeAll();
		panel = new JPanel();
		panel.setBounds(15,15,244,420);
		panel.setLayout(null);
		add(panel);
		
		System.out.println( String.valueOf(mftEntry.getFileName().getName()).trim().replaceAll("\\s+", ""));
	}
}