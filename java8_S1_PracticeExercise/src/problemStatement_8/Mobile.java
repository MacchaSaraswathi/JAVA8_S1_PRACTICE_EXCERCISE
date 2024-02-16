package problemStatement_8;

public class Mobile {

	private int ram;
	private int storage;
	private int battery;
	private int camera;
	private String processor;
	private double screenSize;
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public int getBattery() {
		return battery;
	}
	public void setBattery(int battery) {
		this.battery = battery;
	}
	public int getCamera() {
		return camera;
	}
	public void setCamera(int camera) {
		this.camera = camera;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public double getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}
	
	public Mobile(MobileBuilder builder)
	{
		this.ram=builder.getRam();
		this.storage=builder.getStorage();
		this.battery=builder.getBattery();
		this.camera=builder.getCamera();
		this.processor=builder.getProcessor();
		this.screenSize=builder.getScreenSize();
	}
	@Override
	public String toString() {
		return "Specifications -RAM :" + ram + ", Storage :" + storage + ", Battery :" + battery + ", Camera :" + camera
				+ ", Processor :" + processor + ", ScreenSize :" + screenSize + "";
	}
	

}


