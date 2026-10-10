// Phan Thị Hải Yến
// 202419124
import java.util.ArrayList;
import java.util.List;

public class LabRoom {
    private String roomId;
    private String roomName;
    private int capacity;
    private List<Device> devices;

    public LabRoom(String roomId, String roomName, int capacity) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.capacity = capacity;
        this.devices = new ArrayList<>();
    }

    public void addDevice(Device device) {
        if (device == null) {
            throw new IllegalArgumentException("Không thể thêm thiết bị null.");
        }
        if (devices.size() >= capacity) {
            System.out.println("Lỗi: Phòng " + roomName + " đã đầy.");
            return;
        }
        // Kiểm tra trùng mã thiết bị
        for (Device d : devices) {
            if (d.getId().equals(device.getId())) {
                System.out.println("Lỗi: Mã thiết bị " + device.getId() + " đã tồn tại trong phòng.");
                return;
            }
        }
        devices.add(device);
        System.out.println("Đã thêm thành công: " + device.getName());
    }

    public boolean removeDevice(String deviceId) {
        Device d = findDevice(deviceId);
        if (d != null) {
            devices.remove(d);
            return true;
        }
        return false;
    }

    public Device findDevice(String deviceId) {
        for (Device d : devices) {
            if (d.getId().equals(deviceId)) {
                return d;
            }
        }
        return null;
    }

    // Áp dụng tính đa hình ở đây
    public double calculateAnnualMaintenanceCost() {
        double totalCost = 0;
        for (Device d : devices) {
            totalCost += d.calculateAnnualMaintenanceCost(); // Đa hình
        }
        return totalCost;
    }

    public List<Device> getDevicesRequiringMaintenance() {
        List<Device> maintenanceList = new ArrayList<>();
        for (Device d : devices) {
            if (d.getStatus() == DeviceStatus.UNDER_MAINTENANCE || d.getYearsUsed() > 5) {
                maintenanceList.add(d);
            }
        }
        return maintenanceList;
    }

    public void printDevices() {
        System.out.println("=== Danh sách thiết bị phòng " + roomName + " ===");
        for (Device d : devices) {
            System.out.println(d.toString());
        }
    }
    
    public List<Device> getDevices() {
        return devices;
    }
}