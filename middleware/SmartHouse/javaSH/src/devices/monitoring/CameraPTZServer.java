package devices.monitoring;

import com.zeroc.Ice.Current;
import home.monitoring.View;
import home.monitoring.ptzCameras.CameraPTZ;
import home.monitoring.ptzCameras.Rotation;

public class CameraPTZServer implements CameraPTZ {
    private String name;
    private View view;
    private Rotation rotation;

    public CameraPTZServer(String name, View v, Rotation r) {
        this.name = name;
        this.view = v;
        this.rotation = r;
    }
    @Override
    public void setRotation(Rotation r, Current current) {
        System.out.println("#[CameraPTZ::" + this.name + "] setRotation");
        this.rotation = r;
    }

    @Override
    public Rotation getRotation(Current current) {
        System.out.println("#[CameraPTZ::" + this.name + "] getRotation: return rotation");
        return this.rotation;
    }

    @Override
    public View getView(Current current) {
        System.out.println("#[CameraPTZ::" + this.name + "] getView: return view");
        return this.view;
    }

    @Override
    public String getDeviceName(Current current) {
        System.out.println("#[CameraPTZ::" + this.name + "] getDeviceName: return " + this.name);
        return this.name;
    }
}
