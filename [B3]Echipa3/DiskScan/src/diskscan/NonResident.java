package diskscan;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class NonResident {
	private long startVCN;
	private long endVCN;
	private short datarunOffset;
	private short compressionSize;
	private byte[] padding = new byte[4];
	private long allocSize;
	@Attribute(required=false)
	private long realSize;
	private long streamSize;
	private List<DataRun> runs = new ArrayList<DataRun>();
	
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
		int off = 48;
		while(b.length > off && datarunOffset != 0) {
			int lenLen = b[off] & 0x0F;
			int lenClusterOffset = (b[off] & 0xF0) >> 4;
			if(b[off] == 0x00 || lenLen > 4 || lenClusterOffset > 4)break;
			byte[] dr = new byte[4];
			for(int i = 0; i < lenLen; i++) {
				dr[i] = b[off + i + 1];
			}
			int len = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(dr, 0, 4))).getInt();
			for(int i = 0; i < 4; i++)dr[i] = 0;
			for(int i = 0; i < lenClusterOffset; i++) {
				dr[i] = b[off + lenLen + i + 1];
			}
			int clusterOffset = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(dr, 0, 4))).getInt();
			runs.add(new DataRun(len, clusterOffset));
			off = off + lenLen + lenClusterOffset + 1;
		}
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
	public List<DataRun> getDataRuns() {
		return runs;
	}
	
}
