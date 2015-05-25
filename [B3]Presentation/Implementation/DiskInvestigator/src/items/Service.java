package items;

public class Service {
	private String name, type, status, startupType;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStartupType() {
		return startupType;
	}
	public void setStartupType(String startupType) {
		this.startupType = startupType;
	}
}
