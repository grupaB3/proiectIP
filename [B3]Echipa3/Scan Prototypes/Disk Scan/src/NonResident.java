import java.nio.ByteBuffer;
import java.util.Arrays;

public class NonResident {
	private long startVCN;
	private long endVCN;
	private short datarunOffset;
	private short compressionSize;
	private byte[] padding = new byte[4];
	private long allocSize;
	private long realSize;
	private long streamSize;
	
	public NonResident(byte[] b) {
		if(b.length < 48)
			return;
		startVCN = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 0, 8))).getLong();
		endVCN = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 8, 16))).getLong();
		datarunOffset = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 16, 18))).getShort();
		compressionSize = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 18, 20))).getShort();
		for(int i = 0; i < 4; i++)padding[i] = b[i + 20];
		allocSize = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 24, 32))).getLong();
		realSize = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 32, 40))).getLong();
		streamSize = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 40, 48))).getLong();
	}

	public long getStartVCN() {
		return startVCN;
	}

	public long getEndVCN() {
		return endVCN;
	}

	public short getDatarunOffset() {
		return datarunOffset;
	}

	public short getCompressionSize() {
		return compressionSize;
	}

	public byte[] getPadding() {
		return padding;
	}

	public long getAllocSize() {
		return allocSize;
	}

	public long getRealSize() {
		return realSize;
	}

	public long getStreamSize() {
		return streamSize;
	}
	
}
