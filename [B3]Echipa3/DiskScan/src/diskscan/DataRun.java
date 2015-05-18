package diskscan;

public class DataRun {
	private int length;
	private int clusterOffset;
	
	public DataRun(int length, int clusterOffset) {
		this.length = length;
		this.clusterOffset = clusterOffset;
	}

	public int getLength() {
		return length;
	}

	public int getClusterOffset() {
		return clusterOffset;
	}
	
}
