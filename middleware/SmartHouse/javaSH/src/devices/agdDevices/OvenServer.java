package devices.agdDevices;

import com.zeroc.Ice.Current;
import home.agdDevices.Ovens.Oven;
import home.agdDevices.Ovens.Program;

public class OvenServer implements Oven {
    private String name;
    private boolean on;
    private Program program;

    public OvenServer(String n, boolean on, Program p) {
        this.name = n;
        this.on = on;
        this.program = p;
    }

    public OvenServer(String n, boolean on) {
        this.name = n;
        this.on = on;
        this.program = null;
    }

    public OvenServer(String n) {
        this.name = n;
        this.on = false;
        this.program = null;
    }

    @Override
    public void setProgram(Program p, Current current) {
        System.out.println("#[Oven::" + this.name + "] setProgram");
        this.program = p;
    }

    @Override
    public Program getProgram(Current current) {
        System.out.println("#[Oven::" + this.name + "] getProgram: return oven program");
        return this.program;
    }

    @Override
    public boolean isOn(Current current) {
        System.out.println("#[Oven::" + this.name + "] isOn: return "+ this.on);
        return this.on;
    }

    @Override
    public void startDevice(Current current) {
        System.out.println("#[Oven::" + this.name + "] stopDevice");
        this.on = true;
    }

    @Override
    public void stopDevice(Current current) {
        System.out.println("#[Oven::" + this.name + "] stopDevice");
        this.on = false;
    }

    @Override
    public String getDeviceName(Current current) {
        System.out.println("#[Oven::" + this.name + "] getDeviceName: return " + this.name);
        return this.name;
    }
}
