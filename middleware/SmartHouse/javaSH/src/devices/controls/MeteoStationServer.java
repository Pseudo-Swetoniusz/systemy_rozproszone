package devices.controls;

import com.zeroc.Ice.Current;
import home.DateTime;
import home.controls.MeteoStations.LunarPhase;
import home.controls.MeteoStations.MeteoStation;
import home.controls.MeteoStations.Sensor;

public class MeteoStationServer implements MeteoStation {
    private String name;
    private DateTime date;
    private LunarPhase phase;
    private Sensor[] sensors;

    public MeteoStationServer(String n, DateTime dt, LunarPhase p, Sensor[] s) {
        this.name = n;
        this.date = dt;
        this.phase = p;
        this.sensors = s;
    }

    @Override
    public Sensor readSensor(int id, Current current) {
        System.out.println("#[MeteoStation::" + this.name + "] readSensor[" + id + "]: return sensor");
        return this.sensors[id];
    }

    @Override
    public Sensor[] readSensors(Current current) {
        System.out.println("#[MeteoStation::" + this.name + "] readSensors: return sensors");
        return this.sensors;
    }

    @Override
    public DateTime readDate(Current current) {
        System.out.println("#[MeteoStation::" + this.name + "] readDate: return " + this.date);
        return this.date;
    }

    @Override
    public LunarPhase readLunarPhase(Current current) {
        System.out.println("#[MeteoStation::" + this.name + "] readLunarPhase: return " + this.phase);
        return this.phase;
    }

    @Override
    public float readHumidity(Current current) {
        float humSum = 0;
        int l = this.sensors.length;
        for (Sensor s: this.sensors) {
            humSum = humSum + s.humidity;
        }
        float avgHum = humSum / l;
        System.out.println("#[MeteoStation::" + this.name + "] readHumidity: return " + avgHum);
        return avgHum;
    }

    @Override
    public float readPressure(Current current) {
        float presSum = 0;
        int l = this.sensors.length;
        for (Sensor s: this.sensors) {
            presSum = presSum + s.pressure;
        }
        float avgPres = presSum / l;
        System.out.println("#[MeteoStation::" + this.name + "] readPressure: return " + avgPres);
        return avgPres;
    }

    @Override
    public float readTemp(Current current) {
        float TempSum = 0;
        int l = this.sensors.length;
        for (Sensor s: this.sensors) {
            TempSum = TempSum + s.temp;
        }
        float avgTemp = TempSum / l;
        System.out.println("#[MeteoStation::" + this.name + "] readTemp: return " + avgTemp);
        return avgTemp;
    }

    @Override
    public String getDeviceName(Current current) {
        System.out.println("#[MeteoStation::" + this.name + "] getDeviceName: return " + this.name);
        return this.name;
    }
}
