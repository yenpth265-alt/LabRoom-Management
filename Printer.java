// Phan Thị Hải Yến
//202419124
public class Printer extends Device {
    private String printerType; 
    private int pagesPrinted;
    private boolean isColorPrinter; 

    public Printer(String id, String name, int yearInUse, double purchasePrice, DeviceStatus status,
                   String printerType, int pagesPrinted, boolean isColorPrinter) {
        super(id, name, yearInUse, purchasePrice, status);
        if (pagesPrinted < 0) throw new IllegalArgumentException("So trang in khong duoc am.");
        this.printerType = printerType;
        this.pagesPrinted = pagesPrinted;
        this.isColorPrinter = isColorPrinter;
    }

    @Override
    public double calculateAnnualMaintenanceCost() {
        double cost = getPurchasePrice() * 0.04; 
        if (pagesPrinted > 100000) cost += 500000;
        if (isColorPrinter) cost += 300000;
        return cost;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Loai: %s - Trang da in: %d - In mau: %b", printerType, pagesPrinted, isColorPrinter);
    }
}