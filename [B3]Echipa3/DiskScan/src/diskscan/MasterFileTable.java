package diskscan;
import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class MasterFileTable {
	private static MasterFileTable instance = new MasterFileTable();
	
	@ElementMap(entry="RecordNumber", key="MFTEntry", attribute=true, inline=true, required=false)
	private Map<Integer, MFTEntry> map;
	private FileListArea fileListArea;
	private JFrame f;
	
	private MasterFileTable() {
		map = new HashMap<Integer, MFTEntry>();
	};
	
	public static MasterFileTable getInstance() {
		return instance;
	}
	
	public void addEntry(Integer recNumber, MFTEntry entry) {
		map.put(recNumber, entry);
	}
	
	public MFTEntry getEntry(Integer recNumber) {
		return map.get(recNumber);
	}
	
	public void afiseazaCaile() {
		JFrame f = new JFrame();
		f.setTitle("File list");
		fileListArea = new FileListArea(map);
		fileListArea.setBounds(0,0,1000, 550);
		f.add(fileListArea);
		f.setSize(1020, 600);
		f.setBounds(0, 55, 1020, 600);
		f.setLayout(new BorderLayout());
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Map<Integer,MFTEntry> getMap(){
		return map;
	}
}
