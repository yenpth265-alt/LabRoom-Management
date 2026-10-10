// Phan Thị Hải Yến
// 202419124
import java.time.Year;

public abstract class Device {
    private final String id; // Mã thiết bị chỉ được thiết lập khi khởi tạo
    private String name;
    private int yearInUse;
    private double purchasePrice;
    private DeviceStatus status;

    public Device(String id, String name, int yearInUse, double purchasePrice, DeviceStatus status) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã thiết bị không được rỗng.");
        }
        if (purchasePrice <= 0) {
            throw new IllegalArgumentException("Giá mua phải lớn hơn 0.");
        }
        if (yearInUse > Year.now().getValue()) {
            throw new IllegalArgumentException("Năm đưa vào sử dụng không được lớn hơn năm hiện tại.");
        }

        this.id = id;
        this.name = name;
        this.yearInUse = yearInUse;
        this.purchasePrice = purchasePrice;
        this.status = status;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getYearInUse() { return yearInUse; }
    public void setYearInUse(int yearInUse) { this.yearInUse = yearInUse; }
    public double getPurchasePrice() { return purchasePrice; }
    public void setPurchasePrice(double purchasePrice) { this.purchasePrice = purchasePrice; }
    public DeviceStatus getStatus() { return status; }
    public void setStatus(DeviceStatus status) { this.status = status; }

    // Phương thức tính số năm sử dụng
    public int getYearsUsed() {
        return Year.now().getValue() - this.yearInUse;
    }

    // Phương thức trừu tượng tính chi phí bảo trì
    public abstract double calculateAnnualMaintenanceCost();

    @Override
    public String toString() {
        return String.format("[%s] %s - Giá: %.0f VND - Năm: %d - Trạng thái: %s",
                id, name, purchasePrice, yearInUse, status);
    }
}