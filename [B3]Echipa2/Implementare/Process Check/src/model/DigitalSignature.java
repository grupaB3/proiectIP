package model;

public class DigitalSignature 
{
	private String name;
	private String signed;
	private String signingDate;
	private String publisher;
	private String description;
	private String product;
	private String productVersion;
	private String fileVerison;
	
	public DigitalSignature(String name,String signed,String signingDate,String publisher,String description,
			String product,String productVersion,String fileVersion)
		{
			this.setName(name);
			this.signed = signed;
			this.signingDate = signingDate;
			this.product = product;
			this.productVersion = productVersion;
			this.publisher = publisher;
			this.description = description;
			this.fileVerison = fileVersion;
		}
	
	
	public DigitalSignature() {
	}


	public String isSigned() {
		return signed;
	}
	public void setSigned(String signed) {
		this.signed = signed;
	}
	public String getSigningDate() {
		return signingDate;
	}
	public void setSigningDate(String signingDate) {
		this.signingDate = signingDate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getProductVersion() {
		return productVersion;
	}
	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}
	public String getFileVerison() {
		return fileVerison;
	}
	public void setFileVerison(String fileVerison) {
		this.fileVerison = fileVerison;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
