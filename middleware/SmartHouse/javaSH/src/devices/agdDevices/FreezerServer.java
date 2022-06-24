package devices.agdDevices;

import com.zeroc.Ice.Current;
import home.agdDevices.FridgeFreezers.Freezer;

public class FreezerServer implements Freezer {
    private String name;
    private float temp;
    private boolean on;

    public FreezerServer(String n, float t, boolean on) {
        this.name = n;
        this.temp = t;
        this.on = on;
    }

    @Override
    public void setFreezerTemp(float t, Current current) {
        System.out.println("#[Freezer::" + this.name + "] setTemp");
        this.temp = t;
    }

    @Override
    public float getFreezerTemp(Current current) {
        System.out.println("#[Freezer::" + this.name + "] getFreezerTemp: return " + this.temp);
        return this.temp;
    }

    @Override
    public boolean isOn(Current current) {
        System.out.println("#[Freezer::" + this.name + "] isOn: return " + this.on);
        return this.on;
    }

    @Override
    public void startDevice(Current current) {
        System.out.println("#[Freezer::" + this.name + "] startDevice");
        this.on = true;
    }

    @Override
    public void stopDevice(Current current) {
        System.out.println("#[Freezer::" + this.name + "] stopDevice");
        this.on = false;
    }

    @Override
    public String getDeviceName(Current current) {
        System.out.println("#[Freezer::" + this.name + "] getDeviceName: return " + this.name);
        return this.name;
    }
}
