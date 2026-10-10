// Phan Thị Hải Yến
// 202419124
public class Projector extends Device {
    private int brightnessLumen;
    private int lampHoursUsed;
    private String technologyType; // Bổ sung thuộc tính (LCD, DLP, LED)

    public Projector(String id, String name, int yearInUse, double purchasePrice, DeviceStatus status,
                     int brightnessLumen, int lampHoursUsed, String technologyType) {
        super(id, name, yearInUse, purchasePrice, status);
        this.brightnessLumen = brightnessLumen;
        this.lampHoursUsed = lampHoursUsed;
        this.technologyType = technologyType;
    }

    @Override
    public double calculateAnnualMaintenanceCost() {
        double cost = getPurchasePrice() * 0.03; // 3% giá mua
        if (lampHoursUsed > 3000) {
            cost += 1500000;
        }
        return cost;
    }
}
