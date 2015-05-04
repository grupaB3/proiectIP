package model;

import java.util.List;

public class Process {

	private String name;
	private int PID;
	private String sessionName;
	private int sessionNo;
	private String status;
	private double memoryUsage;
	private double readBites;
	private double writtenBites;
	private List<String> readsFromThreads;
	private List<String> writesToThreads;

	public Process() {
	}

	public Process(String name, int pID, String sessionName, int sessionNo, String status, double memoryUsage) {
		super();
		this.name = name;
		this.PID = pID;
		this.sessionName = sessionName;
		this.sessionNo = sessionNo;
		this.status = status;
		this.memoryUsage = memoryUsage;
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

	public void setMemoryUsage(double memoryUsage) {
		this.memoryUsage = memoryUsage;
	}

	public double getReadBites() {
		return readBites;
	}

	public void setReadBites(double readBites) {
		this.readBites = readBites;
	}

	public double getWrittenBites() {
		return writtenBites;
	}

	public void setWrittenBites(double writtenBites) {
		this.writtenBites = writtenBites;
	}

	public List<String> getReadsFromThreads() {
		return readsFromThreads;
	}

	public void setReadsFromThreads(List<String> readsFromThreads) {
		this.readsFromThreads = readsFromThreads;
	}

	public List<String> getWritesToThreads() {
		return writesToThreads;
	}

	public void setWritesToThreads(List<String> writesToThreads) {
		this.writesToThreads = writesToThreads;
	}

	@Override
	public String toString() {
		return "Process [name=" + name + ", PID=" + PID + ", sessionName=" + sessionName + ", sessionNo=" + sessionNo + ", memoryUsage="
				+ memoryUsage + "]";
	}
	
	public String showActivity(){
		double total = writtenBites + readBites;
		return "Process [name="+ name + ", PID=" + PID + ", Read(B/sec)=" + readBites + ",Write(B/sec)=" + writtenBites + ",Total(B/sec)="
				+ total + "]";
		
	}

}
