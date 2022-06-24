package devices.manager;

import com.zeroc.Ice.Current;
import home.manager.DeviceInfo;
import home.manager.DeviceManager;

import java.util.ArrayList;

public class ManagerServer implements DeviceManager {
    public String name;
    public ArrayList<DeviceInfo> devices = new ArrayList<>();

    public ManagerServer(String name) {
        this.name = name;
    }

    @Override
    public void addDevice(DeviceInfo di, Current current) {
        System.out.println("#[DeviceManager::" + this.name + "] addDevice");
        this.devices.add(di);
    }

    @Override
    public DeviceInfo getDevice(int id, Current current) {
        System.out.println("#[DeviceManager::" + this.name + "] getDevice: return device");
        return this.devices.get(id);
    }

    @Override
    public DeviceInfo[] getAllDevices(Current current) {
        System.out.println("#[DeviceManager::" + this.name + "] getAllDevices: return devices");
        int l = this.devices.size();
        DeviceInfo[] devicesReturn = new DeviceInfo[l];
        for(int i=0; i<l; i++) {
            devicesReturn[i] = this.devices.get(i);
        }
        return devicesReturn;
    }

    @Override
    public String getDeviceName(Current current) {
        System.out.println("#[DeviceManager::" + this.name + "] getDeviceName: return " + this.name);
        return this.name;
    }

    public void addDevice(DeviceInfo di) {
        System.out.println("#[DeviceManager::" + this.name + "] addDevice");
        this.devices.add(di);
    }
}
