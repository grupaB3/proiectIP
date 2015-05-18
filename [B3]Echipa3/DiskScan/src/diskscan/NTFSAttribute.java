package diskscan;
import java.nio.ByteBuffer;
import java.util.Arrays;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class NTFSAttribute {
	private int type;
	private int fullLength;
	@Attribute(required=false)
	private byte nonResFlag;
	private byte nameLength;
	private short nameOffset;
	@Attribute(required=false)
	private short flags;
	@Attribute(required=false)
	private short ID;
	@Element(required=false)
	private Resident rAttr;
	@Element(required=false)
	private NonResident nrAttr;
	private int start;
	
	public NTFSAttribute(byte[] b, int attrStart) {
		start = attrStart;
		if(b.length < 16)
			return;
		type = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 0, 4))).getInt();
		fullLength = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 4, 8))).getInt();
		nonResFlag = b[8];
		nameLength = b[9];
		nameOffset = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 10, 12))).getShort();
		flags = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 12, 14))).getShort();
		ID = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 14, 16))).getShort();
		if(nonResFlag == 0)
			rAttr = new Resident(Arrays.copyOfRange(b, 16, b.length));
		else
			nrAttr = new NonResident(Arrays.copyOfRange(b, 16, b.length));
	}

	public int getType() {
		return type;
	}

	public int getFullLength() {
		return fullLength;
	}

	public byte getNonResFlag() {
		return nonResFlag;
	}

	public byte getNameLength() {
		return nameLength;
	}

	public short getNameOffset() {
		return nameOffset;
	}

	public short getFlags() {
		return flags;
	}

	public short getID() {
		return ID;
	}

	public Resident getrAttr() {
		return rAttr;
	}

	public NonResident getNrAttr() {
		return nrAttr;
	}
	
	public int getStart(){
		return start;
	}
}
