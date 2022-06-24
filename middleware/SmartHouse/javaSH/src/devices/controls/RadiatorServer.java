package devices.controls;

import com.zeroc.Ice.Current;
import home.controls.Radiators.Radiator;

public class RadiatorServer implements Radiator {

    private String name;
    private float temp;

    public RadiatorServer(String name, float t) {
        this.name = name;
        this.temp = t;
    }

    @Override
    public void setTemp(float t, Current current) {
        System.out.println("#[Radiator::" + this.name + "] setTemp");
        this.temp = t;
    }

    @Override
    public float readTemp(Current current) {
        System.out.println("#[Radiator::" + this.name + "] readTemp: return " + this.temp);
        return this.temp;
    }

    @Override
    public String getDeviceName(Current current) {
        System.out.println("#[Radiator::" + this.name + "] getDeviceName: return " + this.name);
        return this.name;
    }
}
