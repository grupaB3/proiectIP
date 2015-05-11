package model;

import java.util.List;

public class Proces {

	private String name;
	private int PID;
	private String sessionName;
	private int sessionNo;
	private String status;
	private double memoryUsage;
	private int readBites;
	private int writtenBites;
	private int readTransferBites;
	private int writtenTransferBites;
	private List<String> readsFromThreads;
	private List<String> writesToThreads;

	public Proces() {
	}

	public Proces(String name, int pID, int readBites, int readTransferBites, int writtenBites, int writtenTransferBites) {
		super();
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

	public int getReadBites() {
		return readBites;
	}

	public void setReadBites(int readBites) {
		this.readBites = readBites;
	}

	public int getWrittenBites() {
		return writtenBites;
	}

	public void setWrittenBites(int writtenBites) {
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
		int total = writtenBites + readBites;
		return "Process [name="+ name + ", PID=" + PID + ", Read(B/sec)=" + readBites + ",Write(B/sec)=" + writtenBites + ",Total(B/sec)="
				+ total + "]";
		
	}

	public int getReadTransferBites() {
		return readTransferBites;
	}

	public void setReadTransferBites(int readTransferBites) {
		this.readTransferBites = readTransferBites;
	}

	public int getWrittenTransferBites() {
		return writtenTransferBites;
	}

	public void setWrittenTransferBites(int writtenTransferBites) {
		this.writtenTransferBites = writtenTransferBites;
	}

}
