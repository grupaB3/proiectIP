package model;

public class Application {

	String name;
	int PID;
	String sessionName;
	int sessionNo;
	String status;
	double memoryUsage;
	
	public Application(){
		
	}

	public Application(String name, int pID, String sessionName, int sessionNo, String status, double memoryUsage) {
		super();
		this.name = name;
		PID = pID;
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

}
