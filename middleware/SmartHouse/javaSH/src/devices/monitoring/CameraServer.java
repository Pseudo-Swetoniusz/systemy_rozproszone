package devices.monitoring;

import com.zeroc.Ice.Current;
import home.monitoring.Camera;
import home.monitoring.View;

public class CameraServer implements Camera {
    private View view;
    private String name;

    public CameraServer(String n, View v) {
        this.name = n;
        this.view = v;
    }
    @Override
    public View getView(Current current) {
        System.out.println("#[Camera::" + this.name + "] getView: return view");
        return this.view;
    }

    @Override
    public String getDeviceName(Current current) {
        System.out.println("#[Camera::" + this.name + "] getDeviceName: return " + this.name);
        return this.name;
    }
}
