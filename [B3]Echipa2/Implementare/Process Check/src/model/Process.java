package model;

public class Process {
	private int pid;
	private String nume;
	private int threads;
	private double readBit;
	private double writeBit;
	private double memoryUsage;
	
	
	public Process(int pid, String nume,int threads,double readBit,double writeBit,double memoryUsage)
	{
		this.pid = pid;
		this.nume = nume;
		this.threads= threads;
		this.readBit = readBit;
		this.writeBit = writeBit;
		this.memoryUsage = memoryUsage;
	}

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getThreads() {
		return threads;
	}
	public void setThreads(int threads) {
		this.threads = threads;
	}
	public double getReadBit() {
		return readBit;
	}
	public void setReadBit(double readBit) {
		this.readBit = readBit;
	}
	public double getWriteBit() {
		return writeBit;
	}
	public void setWriteBit(double writeBit) {
		this.writeBit = writeBit;
	}
	public double getMemoryUsage() {
		return memoryUsage;
	}
	public void setMemoryUsage(double memoryUsage) {
		this.memoryUsage = memoryUsage;
	}
	
	public void show(){}
}
