public class Computer extends Device implements INetworkable {
    private int ramCapacity;
    private String CpuType;
    private boolean hasDedicatedGpu;
    private String ipAddress;
    private boolean isConnected;

    public Computer(String id, String name, int yearInUse, double purchasePrice, DeviceStatus status,
                    int ramCapacity, String cpuType, boolean hasDedicatedGpu) {
        super(id, name, yearInUse, purchasePrice, status);
        this.ramCapacity = ramCapacity;
        this.CpuType = cpuType;
        this.hasDedicatedGpu = hasDedicatedGpu;
        this.ipAddress = null; // Initially not connected
        this.isConnected = false; // Initially not connected
    }

    @Override
    public double calculateAnnualMaintenanceCost() {
        double cost = getPurchasePrice() * 0.05; // 5% giá mua
        if (hasDedicatedGpu) {
            cost += getPurchasePrice() * 0.02; // Cộng 2% nếu có GPU rời
        }
        if (getYearsUsed() > 5) {
            cost += getPurchasePrice() * 0.01; // Cộng 1% nếu dùng trên 5 năm
        }
        return cost;
    }
    // --- Thực thi INetworkable ---
    @Override
    public String getIpAddress() { return ipAddress; }

    @Override
    public boolean isConnected() { return isConnected; }

    @Override
    public void connect(String ipAddress) {
        if (ipAddress == null || ipAddress.trim().isEmpty()) {
            System.out.println("Lỗi: Địa chỉ IP không được rỗng!");
            return;
        }
        if (this.isConnected) {
            System.out.println("Lỗi: Máy tính " + getName() + " đang được kết nối mạng, không thể kết nối lại!");
            return;
        }
        this.ipAddress = ipAddress;
        this.isConnected = true;
        System.out.println("Máy tính " + getName() + " đã kết nối thành công tới IP: " + ipAddress);
    }

    @Override
    public void disconnect() {
        this.isConnected = false;
        this.ipAddress = null;
        System.out.println("Máy tính " + getName() + " đã ngắt kết nối mạng.");
    }
}