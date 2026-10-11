// Phan Thị Hải Yến
// 202419124
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Computer comp1 = new Computer("C01", "May tinh GV", 2023, 15000000, DeviceStatus.ACTIVE, 16, "Core i7", true); 
        Computer comp2 = new Computer("C02", "May tinh SV", 2019, 10000000, DeviceStatus.UNDER_MAINTENANCE, 8, "Core i5", false); 
        
        Printer print1 = new Printer("P01", "May in Laser", 2022, 5000000, DeviceStatus.ACTIVE, "Laser", 150000, false); 
        NetworkPrinter print2 = new NetworkPrinter("P02", "May in mang HP", 2024, 7000000, DeviceStatus.ACTIVE, "Phun", 1000, true); 
        
        Projector proj1 = new Projector("PRJ01", "May chieu Sony", 2018, 12000000, DeviceStatus.UNDER_MAINTENANCE, 3500, 3200, "LCD"); 

        LabRoom lab1 = new LabRoom("LAB01", "Phong Thuc hanh A", 10);
        LabRoom lab2 = new LabRoom("LAB02", "Phong Thuc hanh B", 5);

        System.out.println("\n--- 1. Them thiet bi vao phong ---");
        lab1.addDevice(comp1);
        lab1.addDevice(print1);
        lab1.addDevice(proj1);
        
        lab2.addDevice(comp2);
        lab2.addDevice(print2);

        System.out.println("\n--- 2. Thu them thiet bi trung ma ---");
        Computer compDuplicate = new Computer("C01", "May tinh Fake", 2024, 10000000, DeviceStatus.ACTIVE, 8, "Core i3", false);
        lab1.addDevice(compDuplicate); 

        System.out.println("\n--- 3. In danh sach thiet bi tung phong (Co thong tin chi tiet) ---");
        lab1.printDevices();
        lab2.printDevices();

        System.out.println("\n--- 4. Tinh tong chi phi bao tri du kien ---");
        System.out.printf("Tong phi bao tri Lab A: %,.0f VND\n", lab1.calculateAnnualMaintenanceCost());
        System.out.printf("Tong phi bao tri Lab B: %,.0f VND\n", lab2.calculateAnnualMaintenanceCost());

        System.out.println("\n--- 5. Liet ke thiet bi can bao tri (Goi dung phuong thuc cua LabRoom) ---");
        // Goi truc tiep phuong thuc cua tung phong thay vi tu loc o Main
        List<Device> allMaintenanceDevices = new ArrayList<>();
        allMaintenanceDevices.addAll(lab1.getDevicesRequiringMaintenance());
        allMaintenanceDevices.addAll(lab2.getDevicesRequiringMaintenance());
        
        for (Device d : allMaintenanceDevices) {
            String reason = "";
            if (d.getStatus() == DeviceStatus.UNDER_MAINTENANCE) {
                reason += "[Dang bao loi] ";
            }
            if (d.getYearsUsed() > 5) {
                reason += "[Dung qua 5 nam] ";
            }
            System.out.println("Can bao tri: " + d.getName() + " - Ly do: " + reason.trim());
        }

        System.out.println("\n--- 6. Ket noi mang ---");
        comp1.connect("192.168.1.10");
        comp1.connect("192.168.1.11"); 
        print2.connect("192.168.1.50");

        System.out.println("\n--- 7. Duyet thiet bi mang thong qua INetworkable ---");
        List<Device> allDevices = new ArrayList<>(lab1.getDevices());
        allDevices.addAll(lab2.getDevices());
        
        for (Device d : allDevices) {
            if (d instanceof INetworkable) {
                INetworkable netDevice = (INetworkable) d;
                if (netDevice.isConnected()) {
                    System.out.println(d.getName() + " dang ket noi tai IP: " + netDevice.getIpAddress());
                    netDevice.disconnect();
                }
            }
        }
    }
}