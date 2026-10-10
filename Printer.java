// Phan Thị Hải Yến
//202419124
public class Printer extends Device {
    private String printerType; // Laser hoặc phun
    private int pagesPrinted;
    private boolean isColorPrinter; // Có phải máy in màu không

    public Printer(String id, String name, int yearInUse, double purchasePrice, DeviceStatus status,
                   String printerType, int pagesPrinted, boolean isColorPrinter) {
        super(id, name, yearInUse, purchasePrice, status);
        this.printerType = printerType;
        this.pagesPrinted = pagesPrinted;
        this.isColorPrinter = isColorPrinter;
    }

    @Override
    public double calculateAnnualMaintenanceCost() {
        double cost = getPurchasePrice() * 0.04; // 4% giá mua
        if (pagesPrinted > 100000) {
            cost += 500000;
        }
        if (isColorPrinter) {
            cost += 300000;
        }
        return cost;
    }
}