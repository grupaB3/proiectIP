package diskscan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;


public class MFTEntry {
	private MFTEntryHeader mftHeader;
	private List<NTFSAttribute> attributes;
	private List<Data> attributesData;
	private long offset;
	@Element(required=false)
	private FileName filename;
	private Data data;
	private boolean invalid;
	private long partitionStart;
	
	public MFTEntry(long offset, long partitionStart) {
		this.offset = offset;
		this.invalid = false;
		attributes = new ArrayList<NTFSAttribute>();
		attributesData = new ArrayList<Data>();
		this.partitionStart = partitionStart;
	}
	
	public boolean isInvalid() {
		return invalid;
	}
	
	public void scan(byte[] buffer) {
		if(buffer.length != 1024) {
			this.invalid = true;
			return;
		}
		this.mftHeader = new MFTEntryHeader(buffer);
		int attrStart = this.mftHeader.getAttrOffset();
		while(attrStart < buffer.length && attrStart > 0) {
			//System.out.println(attrStart + " " + buffer.length);
			NTFSAttribute attr = new NTFSAttribute(Arrays.copyOfRange(buffer, attrStart, buffer.length), attrStart);
			attributes.add(attr);
			if(attr.getType() == 0x30) {
				filename = new FileName(Arrays.copyOfRange(buffer,attrStart + attr.getrAttr().getAttrOffset(), attrStart + attr.getrAttr().getAttrOffset() + attr.getrAttr().getLength()));
				//System.out.println(filename.getName() + " " + filename.getParentRecNumber());
			}
//			if(attr.getType() == 0x80){
//				data = new Data(Arrays.copyOfRange(buffer,attrStart + attr.getNrAttr().getDatarunOffset(), attrStart + attr.getNrAttr().getDatarunOffset() + (int) attr.getNrAttr().getAllocSize()));
//				//System.out.println(data.getData());
//			}
			attrStart = attrStart + attr.getFullLength();
			if(attr.getFullLength() < 1)
				break;
		}
	}

	public MFTEntryHeader getMftHeader() {
		return mftHeader;
	}

	public List<NTFSAttribute> getAttributes() {
		return attributes;
	}
	
	public List<Data> getAttributesData(){
		return attributesData;
	}

	public long getOffset() {
		return offset;
	}
	
	public FileName getFileName() {
		return filename;
	}
	
	@Attribute(required=false)
	public String getCompletePath() {
		String path = "";
		if(filename == null)
			return "";
		if(filename.getParentRecNumber() != mftHeader.getMftRecNumber()) {
			MasterFileTable mft = MasterFileTable.getInstance();
			MFTEntry entry = mft.getEntry(new Integer((int)filename.getParentRecNumber()));
			if(entry != null)
				path = entry.getCompletePath();
		}
		return path + "/" + filename.getName();
	}

	public long getPartitionStart() {
		return partitionStart;
	}
	
	
}
