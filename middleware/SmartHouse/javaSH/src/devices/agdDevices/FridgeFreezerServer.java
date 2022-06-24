package devices.agdDevices;

import com.zeroc.Ice.Current;
import home.agdDevices.FridgeFreezers.FridgeFreezer;

public class FridgeFreezerServer implements FridgeFreezer {

    private String name;
    private float freezerTemp;
    private float fridgeTemp;
    private boolean on;

    public FridgeFreezerServer(String name, float fridgeTemp, float freezerTemp, boolean on) {
        this.name = name;
        this.freezerTemp = freezerTemp;
        this.fridgeTemp = fridgeTemp;
        this.on = on;
    }

    @Override
    public void setFreezerTemp(float t, Current current) {
        System.out.println("#[FFreezer::" + this.name + "] setFreezerTemp");
        this.freezerTemp = t;
    }

    @Override
    public float getFreezerTemp(Current current) {
        System.out.println("#[FFreezer::" + this.name + "] getFreezerTemp: return " + this.freezerTemp);
        return this.freezerTemp;
    }

    @Override
    public void setFridgeTemp(float t, Current current) {
        System.out.println("#[FFridge::" + this.name + "] setFridgeTemp");
        this.fridgeTemp = t;
    }

    @Override
    public float getFridgeTemp(Current current) {
        System.out.println("#[FFridge::" + this.name + "] getFridgeTemp: return " + this.fridgeTemp);
        return this.fridgeTemp;
    }

    @Override
    public boolean isOn(Current current) {
        System.out.println("#[FridgeFreezer::" + this.name + "] isOn: return " + this.on);
        return this.on;
    }

    @Override
    public void startDevice(Current current) {
        System.out.println("#[FridgeFreezer::" + this.name + "] startDevice");
        this.on = true;
    }

    @Override
    public void stopDevice(Current current) {
        System.out.println("#[FridgeFreezer::" + this.name + "] stopDevice");
        this.on = false;
    }

    @Override
    public String getDeviceName(Current current) {
        System.out.println("#[FridgeFreezer::" + this.name + "] getDeviceName: return " + this.name);
        return this.name;
    }
}
