package displayArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Date;

import javax.swing.JTextArea;
import javax.swing.JPanel;

import diskscan.MFTEntry;
import diskscan.NTFSAttribute;

@SuppressWarnings("serial")
public class FileInfoArea extends JPanel {

	private JPanel panel;
	private long maxSize;

	protected FileInfoArea() {
		initUI();
	}

	void initUI() {
		setBackground(new Color(42,41,40).darker());
		setOpaque(true);
		setPreferredSize(new Dimension(276, 440));
		setLayout(null);
		panel = new JPanel();
		panel.setBounds(15,15,244,405);
		panel.setLayout(null);
		add(panel);
	}

	public void setInfoRow(MFTEntry mftEntry){
		removeAll();
		panel = new JPanel();
		panel.setBounds(15,15,244,405);
		panel.setLayout(null);
		add(panel);
		
		String[] extensions = String.valueOf(mftEntry.getFileName().getName()).split("\\.");

		String name = "";
		String extension = "";
		if(extensions.length > 1 && extensions[extensions.length - 1].length()<5){
			name = extensions[0];
			for(int index = 1; index <= extensions.length - 2; index++){
				name = name + "." + extensions[index];
			}
			extension = extensions[extensions.length - 1];
		}
		else{
			name = String.valueOf(mftEntry.getFileName().getName()).trim().replaceAll("\\s+", "");
			extension = "No extension";
		}

		String path = String.valueOf(mftEntry.getCompletePath()).trim().replaceAll("\\s+", "");

		String size = "No physical size";
		String nonResident = "No data";
		for(NTFSAttribute attr : mftEntry.getAttributes()){
			if(attr.getType() == 0x80) {
				if(attr.getNonResFlag() == 0) {
					nonResident = "Resident";
					long convertionSize = attr.getrAttr().getLength();
					switch(convert(convertionSize)){
					case 0:
						size=String.valueOf(attr.getrAttr().getLength() + " B"); break;
					case 1:
						size=String.valueOf((int)(attr.getrAttr().getLength()/1024) + " KB"); break;
					case 2:
						size=String.valueOf((int)(attr.getrAttr().getLength()/1024/1024) + " MB"); break;
					case 3:
						size=String.valueOf((int)(attr.getrAttr().getLength()/1024/1024/1024) + " GB"); break;
					case -1:
						size="Corrupted Data Size"; break;
					}
				}
				else{
					nonResident = "NonResident";
					long convertionSize = attr.getNrAttr().getRealSize();
					switch(convert(convertionSize)){
					case 0:
						size=String.valueOf(attr.getNrAttr().getRealSize() + " B"); break;
					case 1:
						size=String.valueOf((int)(attr.getNrAttr().getRealSize()/1024) + " KB"); break;
					case 2:
						size=String.valueOf((int)(attr.getNrAttr().getRealSize()/1024/1024) + " MB"); break;
					case 3:
						size=String.valueOf((int)(attr.getNrAttr().getRealSize()/1024/1024/1024) + " GB"); break;
					case -1:
						size="Corrupted Data Size"; break;
					}
				}
			}
		}

		String createdTime = "";
		Date timeDate = filetimeToDate(mftEntry.getFileName().getCreatedTime());
		createdTime = timeDate.toString();

		String parentRecord = "";
		parentRecord = String.valueOf(mftEntry.getFileName().getParentRecNumber());

		JTextArea labelInfo = new JTextArea();
		labelInfo.setText("  Details: ");
		labelInfo.setLineWrap(true);
		labelInfo.setWrapStyleWord(true);
		labelInfo.setEditable(false);
		labelInfo.setFont(new Font("Verdana",1,18));
		labelInfo.setBounds(0, 5, 244, 20);
		labelInfo.setOpaque(false);

		JTextArea labelDetails = new JTextArea();
		labelDetails.setFont(new Font("Verdana",Font.ITALIC,11));
		labelDetails.setText("\n" + "  Name: " + name + "\n\n" + "  Extension: " + extension + "\n\n" + "  Path: " + path + "\n\n" + "  Size: " + size + "\n\n" + "  Created Time: " + createdTime + "\n\n" + "  Data: " + nonResident + "\n\n" + "  Parent Record Number: " + parentRecord);
		labelDetails.setLineWrap(true);
		labelDetails.setWrapStyleWord(true);
		labelDetails.setEditable(false);
		labelDetails.setBounds(0, 30, 244, 415);
		labelDetails.setOpaque(false);

		panel.add(labelInfo);
		panel.add(labelDetails);

		panel.repaint();

		System.out.println(String.valueOf(mftEntry.getFileName().getName()).trim().replaceAll("\\s+", ""));
	}

	public static long filetimeToMillis(long filetime)
	{
		filetime -= 116444736000000000L;
		if (filetime < 0)
		{
			filetime = -1 - ((-filetime - 1) / 10000);
		}
		else
		{
			filetime = filetime / 10000;
		}
		return filetime;
	}

	public static Date filetimeToDate(long filetime)
	{
		return new Date(filetimeToMillis(filetime));
	}	

	public int convert(long convertionSize){
		long auxiliarSize = convertionSize;
		if(auxiliarSize <= maxSize)
			if((double)(auxiliarSize / 1024) >= 1)
				if((double)(auxiliarSize / 1024 / 1024) >= 1)
					if((double)(auxiliarSize / 1024 / 1024 / 1024) >= 1)
						return 3;
					else
						return 2;
				else
					return 1;
			else
				return 0;
		else
			return -1;
	}

	public void setMaxSize(long maxSizePossible){
		maxSize = maxSizePossible;
	}

}