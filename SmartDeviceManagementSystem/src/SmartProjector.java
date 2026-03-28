public class SmartProjector implements Connectable,Controllable{
    int deviceId;
    String brand;
    @Override
    public void connectToWifi() {
        System.out.println(deviceId+" is  connected to wifi successfully");
    }
    @Override
    public void turnOff() {
        System.out.println(deviceId+" is turned off");
    }
    @Override
    public void turnOn() {
        System.out.println(deviceId+" is turned on");
    }
    public void displayDeviceInfo() {
        System.out.println("Device ID:"+deviceId);
        System.out.println("Device brand:"+brand);
    }
    public static void main(String[] args){
        SmartProjector smartProjector=new SmartProjector();
        smartProjector.deviceId = 1;
        smartProjector.brand = "Sony sensor";
        smartProjector.displayDeviceInfo();
        smartProjector.connectToWifi();
        smartProjector.turnOn();
        smartProjector.turnOff();


    }

}

