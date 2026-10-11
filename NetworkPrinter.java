// Phan Thị Hải Yến
// 202419124
public class NetworkPrinter extends Printer implements INetworkable {
    private String ipAddress;
    private boolean isConnected;

    public NetworkPrinter(String id, String name, int yearInUse, double purchasePrice, DeviceStatus status,
                          String printerType, int pagesPrinted, boolean isColorPrinter) {
        super(id, name, yearInUse, purchasePrice, status, printerType, pagesPrinted, isColorPrinter);
        this.isConnected = false;
        this.ipAddress = null;
    }

    @Override
    public String getIpAddress() { return ipAddress; }

    @Override
    public boolean isConnected() { return isConnected; }

    @Override
    public void connect(String ipAddress) {
        if (ipAddress == null || ipAddress.trim().isEmpty()) {
            System.out.println("Loi: Dia chi IP khong duoc rong!");
            return;
        }
        if (this.isConnected) {
            System.out.println("Loi: May in mang " + getName() + " dang ket noi mang!");
            return;
        }
        this.ipAddress = ipAddress;
        this.isConnected = true;
        System.out.println("May in mang " + getName() + " da ket noi IP: " + ipAddress);
    }

    @Override
    public void disconnect() {
        this.isConnected = false;
        this.ipAddress = null;
        System.out.println("May in mang " + getName() + " da ngat ket noi mang.");
    }
}