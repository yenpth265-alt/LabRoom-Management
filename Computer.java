// Phan Thị Hải Yến
// 202419124
public class Computer extends Device implements INetworkable {
    private int ramCapacity;
    private String cpuType;
    private boolean hasDedicatedGpu;

    private String ipAddress;
    private boolean isConnected;

    public Computer(String id, String name, int yearInUse, double purchasePrice, DeviceStatus status,
                    int ramCapacity, String cpuType, boolean hasDedicatedGpu) {
        super(id, name, yearInUse, purchasePrice, status);
        if (ramCapacity <= 0) throw new IllegalArgumentException("Dung luong RAM phai lon hon 0.");
        this.ramCapacity = ramCapacity;
        this.cpuType = cpuType;
        this.hasDedicatedGpu = hasDedicatedGpu;
        this.isConnected = false;
        this.ipAddress = null;
    }

    @Override
    public double calculateAnnualMaintenanceCost() {
        double cost = getPurchasePrice() * 0.05; 
        if (hasDedicatedGpu) cost += getPurchasePrice() * 0.02; 
        if (getYearsUsed() > 5) cost += getPurchasePrice() * 0.01; 
        return cost;
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
            System.out.println("Loi: May tinh " + getName() + " dang ket noi mang!");
            return;
        }
        this.ipAddress = ipAddress;
        this.isConnected = true;
        System.out.println("May tinh " + getName() + " da ket noi IP: " + ipAddress);
    }

    @Override
    public void disconnect() {
        this.isConnected = false;
        this.ipAddress = null;
        System.out.println("May tinh " + getName() + " da ngat ket noi mang.");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | RAM: %dGB - CPU: %s - GPU Roi: %b", ramCapacity, cpuType, hasDedicatedGpu);
    }
}