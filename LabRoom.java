// Phan Thị Hải Yến
// 202419124
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LabRoom {
    private String roomId;
    private String roomName;
    private int capacity;
    private List<Device> devices;

    public LabRoom(String roomId, String roomName, int capacity) {
        if (roomId == null || roomId.trim().isEmpty()) throw new IllegalArgumentException("Ma phong khong duoc rong.");
        if (capacity <= 0) throw new IllegalArgumentException("Suc chua cua phong phai lon hon 0.");
        
        this.roomId = roomId;
        this.roomName = roomName;
        this.capacity = capacity;
        this.devices = new ArrayList<>();
    }

    public void addDevice(Device device) {
        if (device == null) {
            throw new IllegalArgumentException("Khong the them thiet bi null.");
        }
        
        // Kiem tra trung ma truoc
        for (Device d : devices) {
            if (d.getId().equals(device.getId())) {
                System.out.println("Loi: Ma thiet bi " + device.getId() + " da ton tai trong phong " + roomName);
                return;
            }
        }
        
        // Sau do moi kiem tra suc chua
        if (devices.size() >= capacity) {
            System.out.println("Loi: Phong " + roomName + " da day, khong the them thiet bi moi.");
            return;
        }
        
        devices.add(device);
        System.out.println("Da them thanh cong: " + device.getName() + " vao " + roomName);
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

    public double calculateAnnualMaintenanceCost() {
        double totalCost = 0;
        for (Device d : devices) {
            totalCost += d.calculateAnnualMaintenanceCost(); 
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
        System.out.println("=== Danh sach thiet bi phong " + roomName + " ===");
        for (Device d : devices) {
            System.out.println(d.toString());
        }
    }
    
    // Tra ve danh sach chi doc (Read-only list) de bao ve tinh dong goi
    public List<Device> getDevices() {
        return Collections.unmodifiableList(devices);
    }
}