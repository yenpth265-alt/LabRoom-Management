// Phan Thị Hải Yến
// 202419124
public class Projector extends Device {
    private int brightnessLumen;
    private int lampHoursUsed;
    private String technologyType; 

    public Projector(String id, String name, int yearInUse, double purchasePrice, DeviceStatus status,
                     int brightnessLumen, int lampHoursUsed, String technologyType) {
        super(id, name, yearInUse, purchasePrice, status);
        if (brightnessLumen <= 0) throw new IllegalArgumentException("Do sang phai lon hon 0.");
        if (lampHoursUsed < 0) throw new IllegalArgumentException("So gio su dung bong den khong duoc am.");
        this.brightnessLumen = brightnessLumen;
        this.lampHoursUsed = lampHoursUsed;
        this.technologyType = technologyType;
    }

    @Override
    public double calculateAnnualMaintenanceCost() {
        double cost = getPurchasePrice() * 0.03; 
        if (lampHoursUsed > 3000) cost += 1500000;
        return cost;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Do sang: %d lm - Gio bong den: %d - Cong nghe: %s", brightnessLumen, lampHoursUsed, technologyType);
    }
}
