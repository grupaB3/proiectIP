package diskscan;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


public class FileListArea extends JScrollPane {
	private static final long serialVersionUID = -2809884889360505234L;
	private String[] columnNames = {"Name","Path","State","RecNumber"};
	private Object[][] data;
	
	
	public FileListArea(Map<Integer, MFTEntry> map) {
		data = new Object[map.size()][4];
		int i = 0;
		for(Map.Entry<Integer, MFTEntry> entry: map.entrySet()) {
			if(entry.getValue().getFileName() != null){
				data[i][0] = String.valueOf(entry.getValue().getFileName().getName()).trim().replaceAll("\\s+", "");
				data[i][1] = String.valueOf(entry.getValue().getCompletePath()).trim().replaceAll("\\s+", "");
				if((entry.getValue().getMftHeader().getFlags() & (1<<0)) > 0)
					data[i][2] = "I n - u s e";
				else
					data[i][2] = "D e l e t e d";
				data[i][3] = entry.getKey();
				i++;
			}
		}
		initUI();
	}
	
	private void initUI() {
		//setBackground(Color.orange);
		setPreferredSize(new Dimension(620, 450));
		@SuppressWarnings("serial")
		DefaultTableModel model = new DefaultTableModel(data, columnNames) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		}; 
		JTable table = new JTable(model); 
		table.setFillsViewportHeight(true);
		table.setForeground(Color.black);
		table.setShowGrid(false);
		getViewport().add(table);
		getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
	}

//	public static void main(String[] args) {
//		JFrame f = new JFrame();
//		f.setTitle("File list");
//		FileListArea file = new FileListArea();
//		file.setBounds(0,0,620, 450);
//		f.add(file);
//		f.setSize(620, 450);
//		f.setBounds(0, 55, 620, 450);
//		f.setLayout(new BorderLayout());
//		f.setLocationRelativeTo(null);
//		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
}