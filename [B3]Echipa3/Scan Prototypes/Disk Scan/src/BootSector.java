import java.util.Arrays;


public class BootSector {
	private char[] chJumpInstruction = new char[3];
	private char[] chOEM = new char[8];
	private BPB bpb;
	private char[] chBootStrapCode = new char[426];
	private char endOfSector;
	
	public BootSector(byte[] b) {
		for(int i = 0; i < 3; i++)
			chJumpInstruction[i] = (char)(b[i] & 0xFF);
		for(int i = 3; i < 11; i++)
			chOEM[i - 3] = (char)(b[i] & 0xFF);
		bpb = new BPB(Arrays.copyOfRange(b, 11, 84));
		for(int i = 84; i < 84 + 426; i++)
			chBootStrapCode[i - 84] = (char)(b[i] & 0xFF);
		endOfSector = (char)(b[511] << 8 + b[510]); 
	}

	public char[] getChJumpInstruction() {
		return chJumpInstruction;
	}

	public char[] getChOEM() {
		return chOEM;
	}

	public BPB getBpb() {
		return bpb;
	}

	public char[] getChBootStrapCode() {
		return chBootStrapCode;
	}

	public int getEndOfSector() {
		return endOfSector;
	}
	
}
