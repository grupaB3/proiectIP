package model;

public class Service {

	String name;
	String displayName;
	String type;
	String state;
	String startType;  // sc qc SERVICE_NAME
	String serviceStartName;  // sc qc SERVICE_NAME
	String win32ExitCode;
	String serviceExitCode;
	String checkpoint;
	String waitHint;

	public Service() {

	}

	public Service(String name, String displayName, String type, String state, String win32ExitCode, String serviceExitCode, String checkpoint,
			String waitHint) {
		super();
		this.name = name;
		this.displayName = displayName;
		this.type = type;
		this.state = state;
		this.win32ExitCode = win32ExitCode;
		this.serviceExitCode = serviceExitCode;
		this.checkpoint = checkpoint;
		this.waitHint = waitHint;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStartType() {
		return startType;
	}

	public void setStartType(String startType) {
		this.startType = startType;
	}

	public String getServiceStartName() {
		return serviceStartName;
	}

	public void setServiceStartName(String serviceStartName) {
		this.serviceStartName = serviceStartName;
	}

	public String getWin32ExitCode() {
		return win32ExitCode;
	}

	public void setWin32ExitCode(String win32ExitCode) {
		this.win32ExitCode = win32ExitCode;
	}

	public String getServiceExitCode() {
		return serviceExitCode;
	}

	public void setServiceExitCode(String serviceExitCode) {
		this.serviceExitCode = serviceExitCode;
	}

	public String getCheckpoint() {
		return checkpoint;
	}

	public void setCheckpoint(String checkpoint) {
		this.checkpoint = checkpoint;
	}

	public String getWaitHint() {
		return waitHint;
	}

	public void setWaitHint(String waitHint) {
		this.waitHint = waitHint;
	}

}
