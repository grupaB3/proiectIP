package diskscan;
import java.nio.ByteBuffer;
import java.util.Arrays;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Resident {
	@Attribute(required=false)
	private int length;
	private short attrOffset;
	private byte indexedTag;
	private byte padding;
	
	public Resident(byte[] b) {
		if(b.length < 8)
			return;
		length = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 0, 4))).getInt();
		attrOffset = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 4, 6))).getShort();
		indexedTag = b[6];
		padding = b[7];
	}

	public int getLength() {
		return length;
	}

	public short getAttrOffset() {
		return attrOffset;
	}

	public byte getIndexedTag() {
		return indexedTag;
	}

	public byte getPadding() {
		return padding;
	}
	
}
