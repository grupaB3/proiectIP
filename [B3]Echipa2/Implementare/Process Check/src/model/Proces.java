package model;

public class Proces {

	private String name;
	private int PID;
	private String sessionName;
	private int sessionNo;
	private String status;
	private double memoryUsage;
	private String readBites;
	private String writtenBites;
	private String readTransferBites;
	private String writtenTransferBites;

	public Proces(String name,int PID,String sessionName,int sessionNo,String status,double memoryUsage,String readBites,
			String writtenBites,String readTransferBites,String writtenTransferBites) {
		this.name = name;
		this.PID = PID;
		this.sessionName = sessionName;
		this.sessionNo = sessionNo;
		this.status = status;
		this.memoryUsage = memoryUsage;
		this.readBites = readBites;
		this.writtenBites = writtenBites;
		this.readTransferBites = readTransferBites;
		this.writtenTransferBites = writtenTransferBites;
	}
	
	
	public Proces(){}
	

	public void setActivity(String name, int pID, String readBites, String readTransferBites, String writtenBites, String writtenTransferBites) {
		this.name = name;
		this.PID = pID;
		this.readBites = readBites;
		this.readTransferBites = readTransferBites;
		this.writtenBites = writtenBites;
		this.writtenTransferBites = writtenTransferBites;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPID() {
		return PID;
	}

	public void setPID(int pID) {
		PID = pID;
	}

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public int getSessionNo() {
		return sessionNo;
	}

	public void setSessionNo(int sessionNo) {
		this.sessionNo = sessionNo;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getMemoryUsage() {
		return memoryUsage;
	}

	public void setMemoryUsage(int memoryUsage) {
		this.memoryUsage = memoryUsage;
	}

	public String getReadBites() {
		return readBites;
	}

	public void setReadBites(String readBites) {
		this.readBites = readBites;
	}

	public String getWrittenBites() {
		return writtenBites;
	}

	public void setWrittenBites(String writtenBites) {
		this.writtenBites = writtenBites;
	}


	@Override
	public String toString() {
		return "Process [name=" + name + ", PID=" + PID + ", sessionName=" + sessionName + ", sessionNo=" + sessionNo + ", memoryUsage="
				+ memoryUsage + "]";
	}
	
	public String showActivity(){
		int total = Integer.parseInt(writtenBites) + Integer.parseInt(readBites);
		return "Process [name="+ name + ", PID=" + PID + ", Read(B/sec)=" + readBites + ",Write(B/sec)=" + writtenBites + ",Total(B/sec)="
				+ total + "]";
		
	}

	public String getReadTransferBites() {
		return readTransferBites;
	}

	public void setReadTransferBites(String readTransferBites) {
		this.readTransferBites = readTransferBites;
	}

	public String getWrittenTransferBites() {
		return writtenTransferBites;
	}

	public void setWrittenTransferBites(String writtenTransferBites) {
		this.writtenTransferBites = writtenTransferBites;
	}

}
