// Phan Thị Hải Yến
// 202419124
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo các thiết bị theo yêu cầu test
        Computer comp1 = new Computer("C01", "Máy tính GV", 2023, 15000000, DeviceStatus.ACTIVE, 16, "Core i7", true); // Có GPU rời
        Computer comp2 = new Computer("C02", "Máy tính SV", 2019, 10000000, DeviceStatus.UNDER_MAINTENANCE, 8, "Core i5", false); // Dùng > 5 năm
        
        Printer print1 = new Printer("P01", "Máy in Laser", 2022, 5000000, DeviceStatus.ACTIVE, "Laser", 150000, false); // Đã in > 100.000 trang
        NetworkPrinter print2 = new NetworkPrinter("P02", "Máy in mạng HP", 2024, 7000000, DeviceStatus.ACTIVE, "Phun", 1000, true); // Máy in có mạng
        
        Projector proj1 = new Projector("PRJ01", "Máy chiếu Sony", 2021, 12000000, DeviceStatus.ACTIVE, 3500, 3200, "LCD"); // Bóng đèn > 3000 giờ

        // Khởi tạo 2 phòng thực hành
        LabRoom lab1 = new LabRoom("LAB01", "Phòng Thực hành A", 10);
        LabRoom lab2 = new LabRoom("LAB02", "Phòng Thực hành B", 5);

        System.out.println("\n--- 1. Them thiet bi vao phong ---");
        lab1.addDevice(comp1);
        lab1.addDevice(print1);
        lab1.addDevice(proj1);
        
        lab2.addDevice(comp2);
        lab2.addDevice(print2);

        System.out.println("\n--- 2. Thử thêm thiết bị trùng mã ---");
        Computer compDuplicate = new Computer("C01", "Máy tính Fake", 2024, 10000000, DeviceStatus.ACTIVE, 8, "Core i3", false);
        lab1.addDevice(compDuplicate); // Sẽ báo lỗi

        System.out.println("\n--- 3. In danh sách thiết bị từng phòng ---");
        lab1.printDevices();
        lab2.printDevices();

        System.out.println("\n--- 4. Tính tổng chi phí bảo trì dự kiến ---");
        System.out.printf("Tổng phí bảo trì Lab A: %,.0f VND\n", lab1.calculateAnnualMaintenanceCost());
        System.out.printf("Tổng phí bảo trì Lab B: %,.0f VND\n", lab2.calculateAnnualMaintenanceCost());

        System.out.println("\n--- 5. Liệt kê thiết bị cần bảo trì ---");
        List<Device> allDevices = new ArrayList<>(lab1.getDevices());
        allDevices.addAll(lab2.getDevices());
        
        for (Device d : allDevices) {
            if (d.getStatus() == DeviceStatus.UNDER_MAINTENANCE || d.getYearsUsed() > 5) {
                System.out.println("Cần bảo trì: " + d.getName() + " (Lý do: " 
                    + (d.getStatus() == DeviceStatus.UNDER_MAINTENANCE ? "Đang báo lỗi" : "Dùng quá 5 năm") + ")");
            }
        }

        System.out.println("\n--- 6. Kết nối mạng ---");
        comp1.connect("192.168.1.10");
        comp1.connect("192.168.1.11"); // Thử kết nối lại khi đang kết nối -> Báo lỗi
        print2.connect("192.168.1.50");

        System.out.println("\n--- 7. Duyệt thiết bị mạng thông qua INetworkable ---");
        // Gom tất cả các thiết bị trong hệ thống để duyệt
        for (Device d : allDevices) {
            if (d instanceof INetworkable) {
                INetworkable netDevice = (INetworkable) d;
                if (netDevice.isConnected()) {
                    System.out.println(d.getName() + " đang kết nối tại IP: " + netDevice.getIpAddress());
                    // Thử ngắt kết nối
                    netDevice.disconnect();
                }
            }
        }
    }
}
