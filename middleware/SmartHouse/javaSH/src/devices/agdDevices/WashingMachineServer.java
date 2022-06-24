package devices.agdDevices;

import com.zeroc.Ice.Current;
import home.agdDevices.WashingMachines.Program;
import home.agdDevices.WashingMachines.WashingMachine;

public class WashingMachineServer implements WashingMachine {

    private String name;
    private boolean on;
    private Program program;

    public WashingMachineServer(boolean on, Program p, String n) {
        this.on = on;
        this.program = p;
        this.name = n;
    }

    public WashingMachineServer(boolean on, String n) {
        this.on = on;
        this.program = null;
        this.name = n;
    }

    public WashingMachineServer(String n) {
        this.on = false;
        this.program = null;
        this.name = n;
    }
    @Override
    public void setWashingProgram(Program p, Current current) {
        System.out.println("#[WashingMachine::" + this.name + "] setWashingProgram");
        this.program = p;
    }

    @Override
    public Program getWashingProgram(Current current) {
        System.out.println("#[WashingMachine::" + this.name + "] getWashingProgram : return ws program");
        return this.program;
    }

    @Override
    public boolean isOn(Current current) {
        System.out.println("#[WashingMachine::" + this.name + "] isOn: return " + this.on);
        return this.on;
    }

    @Override
    public void startDevice(Current current) {
        System.out.println("#[WashingMachine::" + this.name + "] startDevice");
        this.on = true;
    }

    @Override
    public void stopDevice(Current current) {
        System.out.println("#[WashingMachine::" + this.name + "] stopDevice");
        this.on = false;
    }

    @Override
    public String getDeviceName(Current current) {
        System.out.println("#[WashingMachine::" + this.name + "] getDeviceName: return " + this.name);
        return this.name;
    }
}
