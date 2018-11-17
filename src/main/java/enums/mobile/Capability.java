package enums.mobile;

public enum Capability {
    EMULATOR_5554("deviceName", "emulator-5554", "platformName", "Android");

    private String deviceName;
    private String device;
    private String platformName;
    private String platform;


    public String getDeviceName() {
        return deviceName;
    }

    public String getDevice() {
        return device;
    }

    public String getPlatformName() {
        return platformName;
    }

    public String getPlatform() {
        return platform;
    }

    Capability(String deviceName, String device, String platformName, String platform) {
        this.deviceName = deviceName;
        this.device = device;
        this.platformName = platformName;
        this.platform = platform;
    }
}
