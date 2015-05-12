import java.nio.ByteBuffer;
import java.util.Arrays;


public class MFTEntryHeader {
	private char[] fileSignature = new char[4];
	private short fixupOffset;
	private short fixupSize;
	private long logSeqNumber;
	private short sequence;
	private short hardlinks;
	private short attrOffset;
	private short flags;
	private int recLength;
	private int allLength;
	private long mftRec;
	private short nextAttrId;
	private short fixupPattern;
	private int mftRecNumber;
	
	public MFTEntryHeader(byte[] b) {
		for(int i = 0; i < 4; i++)
			fileSignature[i] = (char)(b[i] & 0xFF);
		fixupOffset = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 4, 6))).getShort();
		fixupSize = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 6, 8))).getShort();
		logSeqNumber = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 8, 16))).getLong();
		sequence = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 16, 18))).getShort();
		hardlinks = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 18, 20))).getShort();
		attrOffset = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 20, 22))).getShort();
		flags = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 22, 24))).getShort();
		recLength = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 24, 28))).getInt();
		allLength = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 28, 32))).getInt();
		mftRec = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 32, 40))).getLong();
		nextAttrId = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 40, 42))).getShort();
		fixupPattern = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 42, 44))).getShort();
		mftRecNumber = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 44, 48))).getInt();
	}

	public String getFileSignature() {
		return String.valueOf(fileSignature);
	}

	public short getFixupOffset() {
		return fixupOffset;
	}

	public short getFixupSize() {
		return fixupSize;
	}

	public long getLogSeqNumber() {
		return logSeqNumber;
	}

	public short getSequence() {
		return sequence;
	}

	public short getHardlinks() {
		return hardlinks;
	}

	public short getAttrOffset() {
		return attrOffset;
	}

	public short getFlags() {
		return flags;
	}

	public int getRecLength() {
		return recLength;
	}

	public int getAllLength() {
		return allLength;
	}

	public long getMftRec() {
		return mftRec;
	}

	public short getNextAttrId() {
		return nextAttrId;
	}

	public short getFixupPattern() {
		return fixupPattern;
	}

	public int getMftRecNumber() {
		return mftRecNumber;
	}

	@Override
	public String toString() {
		return "MFTEntryHeader [fileSignature="
				+ Arrays.toString(fileSignature) + "\n fixupOffset="
				+ fixupOffset + "\n fixupSize=" + fixupSize + "\n logSeqNumber="
				+ logSeqNumber + "\n sequence=" + sequence + "\n hardlinks="
				+ hardlinks + "\n attrOffset=" + attrOffset + "\n flags=" + flags
				+ "\n recLength=" + recLength + "\n allLength=" + allLength
				+ "\n mftRec=" + mftRec + "\n nextAttrId=" + nextAttrId
				+ "\n fixupPattern=" + fixupPattern + "\n mftRecNumber="
				+ mftRecNumber + "]";
	}
	
}
