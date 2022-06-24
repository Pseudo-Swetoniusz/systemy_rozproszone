package devices.controls;

import com.zeroc.Ice.Current;
import home.controls.Boilers.Boiler;

public class BoilerServer implements Boiler {
    private String name;
    private float temp;

    public BoilerServer(String n, float t) {
        this.name = n;
        this.temp = t;
    }

    @Override
    public void setTemp(float t, Current current) {
        System.out.println("#[Boiler::" + this.name + "] setTemp");
        this.temp = t;
    }

    @Override
    public float readTemp(Current current) {
        System.out.println("#[Boiler::" + this.name + "] readTemp: return " + this.temp);
        return this.temp;
    }

    @Override
    public String getDeviceName(Current current) {
        System.out.println("#[Boiler::" + this.name + "] getDeviceName: return " + this.name);
        return this.name;
    }
}
