// Phan Thị Hải Yến
// 202419124
import java.time.Year;

public abstract class Device {
    private final String id; 
    private String name;
    private int yearInUse;
    private double purchasePrice;
    private DeviceStatus status;

    public Device(String id, String name, int yearInUse, double purchasePrice, DeviceStatus status) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Ma thiet bi khong duoc rong.");
        }
        this.id = id;
        
        // Gọi setter để tận dụng logic kiểm tra dữ liệu thay vì viết lại
        setName(name);
        setYearInUse(yearInUse);
        setPurchasePrice(purchasePrice);
        setStatus(status);
    }

    public String getId() { return id; }
    
    public String getName() { return name; }
    public void setName(String name) { 
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Ten thiet bi khong duoc rong.");
        this.name = name; 
    }
    
    public int getYearInUse() { return yearInUse; }
    public void setYearInUse(int yearInUse) { 
        if (yearInUse > Year.now().getValue()) {
            throw new IllegalArgumentException("Nam dua vao su dung khong duoc lon hon nam hien tai.");
        }
        this.yearInUse = yearInUse; 
    }
    
    public double getPurchasePrice() { return purchasePrice; }
    public void setPurchasePrice(double purchasePrice) { 
        if (purchasePrice <= 0) {
            throw new IllegalArgumentException("Gia mua phai lon hon 0.");
        }
        this.purchasePrice = purchasePrice; 
    }
    
    public DeviceStatus getStatus() { return status; }
    public void setStatus(DeviceStatus status) { 
        if (status == null) {
            throw new IllegalArgumentException("Trang thai khong duoc null.");
        }
        this.status = status; 
    }

    public int getYearsUsed() {
        return Year.now().getValue() - this.yearInUse;
    }

    public abstract double calculateAnnualMaintenanceCost();

    @Override
    public String toString() {
        return String.format("[%s] %s - Gia: %,.0f VND - Nam: %d - Trang thai: %s",
                id, name, purchasePrice, yearInUse, status);
    }
}