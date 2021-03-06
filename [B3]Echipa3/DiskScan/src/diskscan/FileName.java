package diskscan;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;


@Root(strict=false)
public class FileName {
	private long parentRecNumber;
	private short parentSeqNumber;
	private long createdTime;
	private long lastWrittenTime;
	private long recordModified;
	private long lastAccessedTime;
	private long logicalSize;
	@Attribute(required=false)
	private long physicalSize;
	private long flags;
	private byte fileLength;
	private byte namespace;
	@Attribute(required=false)
	private String name;
	
	public FileName(byte[] b) {
		byte[] aux = new byte[8];
		for(int i = 0; i < 6; i++)
			aux[i] = b[i];
		parentRecNumber = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(aux, 0, 8))).getLong();
		parentSeqNumber = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 6, 8))).getShort();
		createdTime = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 8, 16))).getLong();
		lastWrittenTime = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 16, 24))).getLong();
		recordModified = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 24, 32))).getLong();
		lastAccessedTime = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 32, 40))).getLong();
		logicalSize = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 40, 48))).getLong();
		physicalSize = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 48, 56))).getLong();
		flags = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 56, 64))).getLong();
		fileLength = b[64];
		namespace = b[65];
		char[] charName = new char[(b.length - 66)/2];
		for(int i = 66, cnt = 0; i < b.length; i+=2, cnt++) 
			charName[cnt] = (char)(b[i] & 0xFF);
		name = new String(charName);
	}
	
	public String getName() {
		//return name.trim().replaceAll("\\s+", "");
		return name;
	}
	
	public long getParentRecNumber() {
		return parentRecNumber;
	}
}
