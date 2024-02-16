package problemStatement_8;

import java.util.function.Consumer;

public class MobileBuilder{
	private int ram;
	private int storage;
	private int battery;
	private int camera;
	private String processor;
	private double screenSize;
	
	public MobileBuilder with(Consumer<MobileBuilder> buildFields)
	{
		buildFields.accept(this);
		return this;
	}
	public Mobile createMobile()
	{
		return new Mobile(this);
	}
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
}

