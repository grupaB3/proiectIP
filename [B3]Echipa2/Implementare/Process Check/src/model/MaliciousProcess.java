package model;

public class MaliciousProcess {
	private String execPath;
	private String verified;
	private String publisher;
	private String description;
	private String product;
	private int numberOfTests;
	private int testsFailed;
	
	public MaliciousProcess(String execPath, String verified, String publisher,
			String description, String product, int numberOfTests,
			int testsFailed) {
		this.execPath = execPath;
		this.verified = verified;
		this.publisher = publisher;
		this.description = description;
		this.product = product;
		this.numberOfTests = numberOfTests;
		this.testsFailed = testsFailed;
	}

	public MaliciousProcess() {
	}

	public String getExecPath() {
		return execPath;
	}

	public String getVerified() {
		return verified;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getDescription() {
		return description;
	}

	public String getProduct() {
		return product;
	}

	public int getNumberOfTests() {
		return numberOfTests;
	}

	public int getTestsFailed() {
		return testsFailed;
	}
	
	public double getDetectionRatio(){
		return (double)testsFailed/numberOfTests;
	}
}
