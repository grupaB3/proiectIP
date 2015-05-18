package diskscan;
import java.nio.ByteBuffer;
import java.util.Arrays;


public class Data {
	private int bytesLengthRun;
	private int bytesStartClusterOffSet;
	private int lengthRun;
	private int startClusterOffSet;
	private long clusterSize;
	private long startOffSetPosition;
	private byte[] data;
	byte[] buff = new byte[512];
	
	public Data(byte[] b) {
		bytesLengthRun = (b[0] & 0xF) >> 0;
		bytesStartClusterOffSet = (b[0] & 0xF0) >> 4;
		System.out.println(bytesLengthRun + " " + bytesStartClusterOffSet);
		lengthRun = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 1, bytesLengthRun + 1))).getInt();
		startClusterOffSet = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, bytesLengthRun + 2, bytesLengthRun + 2 + bytesStartClusterOffSet))).getInt();
		clusterSize = lengthRun * 512;
		startOffSetPosition = startClusterOffSet * 512;
		data = Arrays.copyOfRange(buff, (int) startOffSetPosition, (int) (startOffSetPosition + clusterSize));
	}
	
	public byte[] getData(){
		return data;
	}
}
