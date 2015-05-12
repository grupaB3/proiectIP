import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MFTEntry {
	
	private MFTEntryHeader mftHeader;
	private List<NTFSAttribute> attributes;
	private long offset;
	private FileName filename;
	private boolean invalid;
	
	public MFTEntry(long offset) {
		this.offset = offset;
		this.invalid = false;
		attributes = new ArrayList<NTFSAttribute>();
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
			NTFSAttribute attr = new NTFSAttribute(Arrays.copyOfRange(buffer, attrStart, buffer.length));
			attributes.add(attr);
			if(attr.getType() == 0x30) {
				filename = new FileName(Arrays.copyOfRange(buffer,attrStart + attr.getrAttr().getAttrOffset(), attrStart + attr.getrAttr().getAttrOffset() + attr.getrAttr().getLength()));
				//System.out.println(filename.getName() + " " + filename.getParentRecNumber());
			}
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

	public long getOffset() {
		return offset;
	}
	
	public FileName getFileName() {
		return filename;
	}
	
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
}
