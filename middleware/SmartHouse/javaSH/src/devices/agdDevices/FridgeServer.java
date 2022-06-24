package devices.agdDevices;

import com.zeroc.Ice.Current;
import home.agdDevices.FridgeFreezers.Fridge;

public class FridgeServer implements Fridge {
    private String name;
    private float temp;
    private boolean on;

    public FridgeServer(String n, float t, boolean on) {
        this.name = n;
        this.temp = t;
        this.on = on;
    }
    @Override
    public void setFridgeTemp(float t, Current current) {
        System.out.println("#[Fridge::" + this.name + "] setFridgeTemp");
        this.temp = t;
    }

    @Override
    public float getFridgeTemp(Current current) {
        System.out.println("#[Fridge::" + this.name + "] getFridgeTemp: return " + this.temp);
        return this.temp;
    }

    @Override
    public boolean isOn(Current current) {
        System.out.println("#[Fridge::" + this.name + "] isOn: return " + this.on);
        return this.on;
    }

    @Override
    public void startDevice(Current current) {
        System.out.println("#[Fridge::" + this.name + "] startDevice");
        this.on = true;
    }

    @Override
    public void stopDevice(Current current) {
        System.out.println("#[Fridge::" + this.name + "] stopDevice");
        this.on = false;
    }

    @Override
    public String getDeviceName(Current current) {
        System.out.println("#[Fridge::" + this.name + "] getDeviceName: return " + this.name);
        return this.name;
    }
}
