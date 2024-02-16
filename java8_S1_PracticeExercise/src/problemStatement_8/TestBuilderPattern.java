package problemStatement_8;

public class TestBuilderPattern {
public static void main(String[] args) {
	MobileBuilder m = new MobileBuilder().with(builder->builder.setRam(4)).with(builder->builder.setStorage(0)).with(builder->builder.setBattery(4000)).with(builder->builder.setCamera(0)).with(builder->builder.setProcessor("A12 Bionic")).with(builder->builder.setScreenSize(0.0));
	System.out.println(m.createMobile());
}
}
