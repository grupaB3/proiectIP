package model;

/**
 * Clasa MaliciousProcess reprezinta informatii despre procesele care au fost scanate.
 * Contine si informatii daca a fost semnat digital sau nu.
 * 
 * @author Razvan
 *
 */
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
	
	public void setNumberOfTests(int numberOfTests)
	{
		this.numberOfTests = numberOfTests;
	}
	
	public void setTestsFailed(int setTestsFailed)
	{
		this.testsFailed = setTestsFailed;
	}
	
	/**
	 * Gradul de infectare al procesului
	 * @return Un numar double intre 0 si 1
	 */
	
	public double getDetectionRatio(){
		if(numberOfTests==0)
			return 0;
		return (double)testsFailed/numberOfTests;
	}
}
