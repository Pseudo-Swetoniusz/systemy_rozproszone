package server;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;
import devices.agdDevices.*;
import devices.controls.BoilerServer;
import devices.controls.MeteoStationServer;
import devices.controls.RadiatorServer;
import devices.manager.ManagerServer;
import devices.monitoring.CameraPTZServer;
import devices.monitoring.CameraServer;
import home.Date;
import home.DateTime;
import home.Time;
import home.agdDevices.FridgeFreezers.FridgeFreezer;
import home.agdDevices.WashingMachines.WashingMachine;
import home.controls.MeteoStations.LunarPhase;
import home.controls.MeteoStations.Sensor;
import home.manager.DeviceInfo;
import home.monitoring.View;
import home.monitoring.ptzCameras.Rotation;

import java.io.IOException;

// ASCII ART FROM: https://www.asciiart.eu/

public class Server {
    public void serverStart(String[] args) throws IOException {
        int status = 0;
        Communicator communicator = null;

        String line = null;
        java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

        System.out.println("Server port number:");
        line = in.readLine();
        int number = Integer.parseInt(line);

        try	{
            communicator = Util.initialize(args);

            // CONFIG + ADAPTER:
            String config = "tcp -h 127.0.0.2 -p " + number + " -z : udp -h 127.0.0.2 -p " + number + " -z";
            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("Adapter1", config);

            // SERVANTS:
            if(number == 10000) {
                ManagerServer manager = new ManagerServer("DeviceManager");
                FreezerServer freezer = new FreezerServer("DownstairsFreezer", -12, true);
                manager.addDevice(new DeviceInfo("DownstairsFreezer", 1, "freezer", "agd"));
                FridgeFreezerServer ffridge = new FridgeFreezerServer("KitchenFridge", 4, -15, true);
                manager.addDevice(new DeviceInfo("KitchenFridge", 2, "ffridge", "agd"));
                OvenServer oven = new OvenServer("KitchenOven", false);
                manager.addDevice(new DeviceInfo("KitchenOven", 3, "oven", "agd"));
                DishwasherServer dishwasher = new DishwasherServer(false,"KitchenDishwasher");
                manager.addDevice(new DeviceInfo("KitchenDishwasher", 4, "dishwasher", "agd"));
                Time t = new Time((short) 12, (short)32, (short)24);
                Date d = new Date((short) 2, (short) 9, (short) 2022);
                DateTime dt = new DateTime(t, d);
                Sensor s1 = new Sensor("Inside", 1, 23, (short) 50, 1000);
                Sensor s2 = new Sensor("InFront", 2, 27, (short) 67, 1010);
                Sensor s3 = new Sensor("Back", 3, 26, (short) 66, 1011);
                Sensor s4 = new Sensor("Yard", 4, 25, (short) 70, 1011);
                Sensor[] s = new Sensor[]{s1, s2, s3, s4};
                MeteoStationServer meteo = new MeteoStationServer("MeteoStation",dt, LunarPhase.FullMoon, s);
                manager.addDevice(new DeviceInfo("MeteoStation", 5, "meteoStation", "controls"));
                RadiatorServer radiator = new RadiatorServer("KitchenRadiator", 21);
                manager.addDevice(new DeviceInfo("KitchenRadiator", 6, "radiator", "controls"));
                View v = new View(400, 500, dt, """
                             .{{}}}}}}.
                            {{{{{{(`)}}}.
                           {{{(`)}}}}}}}}}
                          }}}}}}}}}{{(`){{{
                          }}}}{{{{(`)}}{{{{
                         {{{(`)}}}}}}}{}}}}}
                        {{{{{{{{(`)}}}}}}}}}}
                        {{{{{{{}{{{{(`)}}}}}}
                         {{{{{(`)   {{{{(`)}'
                          `""'" |   | "'"'`
                          (`) ||     ||
                         ~~~~~~~~~~~~~~~~~~~""");
                Rotation r = new Rotation(200, 45);
                CameraPTZServer cameraPTZ = new CameraPTZServer("Front", v, r);
                manager.addDevice(new DeviceInfo("Front", 3, "cameraPTZ", "controls"));
                View v2 = new View(400, 500, dt, """
                                      * *
                                   *    *  *
                              *  *    *     *  *
                             *     *    *  *    *
                         * *   *    *    *    *   *
                         *     *  *    * * .#  *   *
                         *   *     * #.  .# *   *
                          *     "#.  #: #" * *    *
                         *   * * "#. ##"       *
                           *       "###
                                     "##
                                      ##.
                                      .##:
                                      :###
                                      ;###
                                    ,####.
                        /||/||/||/.######.||/||/||/||/||""");
                CameraServer camera = new CameraServer("Back", v2);
                manager.addDevice(new DeviceInfo("Back", 3, "camera", "controls"));
                adapter.add(manager,new Identity("manager", "manager"));
                adapter.add(freezer, new Identity("freezer", "agd"));
                adapter.add(ffridge, new Identity("ffridge","agd"));
                adapter.add(oven, new Identity("oven", "agd"));
                adapter.add(dishwasher, new Identity("dishwasher", "agd"));
                adapter.add(meteo, new Identity("meteoStation", "controls"));
                adapter.add(radiator, new Identity("radiator","controls"));
                adapter.add(cameraPTZ, new Identity("cameraPTZ", "monitoring"));
                adapter.add(camera, new Identity("camera", "monitoring"));
            }
            else {
                ManagerServer manager = new ManagerServer("DeviceManager");
                FridgeServer miniFridge = new FridgeServer("MiniFridge",4, true);
                manager.addDevice(new DeviceInfo("MiniFridge", 1, "fridge", "agd"));
                WashingMachineServer washingMachine = new WashingMachineServer(false,"DownstairsWashingMachine");
                manager.addDevice(new DeviceInfo("DownstairsWashingMachine", 2, "washingMachine", "agd"));
                BoilerServer boiler = new BoilerServer("Boiler",45);
                manager.addDevice(new DeviceInfo("Boiler", 3, "boiler", "controls"));
                RadiatorServer radiator1 = new RadiatorServer("DownStairsRadiator", 21);
                manager.addDevice(new DeviceInfo("DownStairsRadiator", 3, "radiatorD", "controls"));
                RadiatorServer radiator2 = new RadiatorServer("UpstairsRadiator", 24);
                manager.addDevice(new DeviceInfo("UpstairsRadiator", 4, "radiatorU", "controls"));
                Time t = new Time((short) 12, (short)32, (short)24);
                Date d = new Date((short) 2, (short) 9, (short) 2022);
                DateTime dt = new DateTime(t, d);
                View v = new View(400, 500, dt, """
                             .{{}}}}}}.
                            {{{{{{(`)}}}.
                           {{{(`)}}}}}}}}}
                          }}}}}}}}}{{(`){{{
                          }}}}{{{{(`)}}{{{{
                         {{{(`)}}}}}}}{}}}}}
                        {{{{{{{{(`)}}}}}}}}}}
                        {{{{{{{}{{{{(`)}}}}}}
                         {{{{{(`)   {{{{(`)}'
                          `""'" |   | "'"'`
                          (`) ||     ||
                         ~~~~~~~~~~~~~~~~~~~""");
                View v2 = new View(400, 500, dt, """
                                      * *
                                   *    *  *
                              *  *    *     *  *
                             *     *    *  *    *
                         * *   *    *    *    *   *
                         *     *  *    * * .#  *   *
                         *   *     * #.  .# *   *
                          *     "#.  #: #" * *    *
                         *   * * "#. ##"       *
                           *       "###
                                     "##
                                      ##.
                                      .##:
                                      :###
                                      ;###
                                    ,####.
                        /||/||/||/.######.||/||/||/||/||""");
                Rotation r1 = new Rotation(200, 90);
                Rotation r2 = new Rotation(200, 60);
                CameraPTZServer cameraPTZ1 = new CameraPTZServer("FrontDown", v, r1);
                manager.addDevice(new DeviceInfo("FrontDown", 5, "cameraPTZFD", "monitoring"));
                CameraPTZServer cameraPTZ2 = new CameraPTZServer("BackUp", v2, r2);
                manager.addDevice(new DeviceInfo("BackUp", 6, "cameraPTZBU", "monitoring"));
                CameraServer camera1 = new CameraServer("BackBack", v);
                manager.addDevice(new DeviceInfo("BackBack", 7, "cameraBB", "monitoring"));
                CameraServer camera2 = new CameraServer("BackYard", v2);
                manager.addDevice(new DeviceInfo("BackYard", 8, "cameraBY", "monitoring"));

                adapter.add(manager,new Identity("manager", "manager"));
                adapter.add(miniFridge, new Identity("fridge", "agd"));
                adapter.add(washingMachine, new Identity("washingMachine", "agd"));
                adapter.add(boiler, new Identity("boiler", "controls"));
                adapter.add(radiator1, new Identity("radiatorD", "controls"));
                adapter.add(radiator2, new Identity("radiatorU", "controls"));
                adapter.add(cameraPTZ1, new Identity("cameraPTZFD", "monitoring"));
                adapter.add(cameraPTZ2, new Identity("cameraPTZBU", "monitoring"));
                adapter.add(camera1, new Identity("cameraBB", "monitoring"));
                adapter.add(camera2, new Identity("cameraBY", "monitoring"));
            }

            //ACTIVATION:
            adapter.activate();

            System.out.println("Entering event processing loop...");

            communicator.waitForShutdown();

        }
        catch (Exception e) {
            System.err.println(e);
            status = 1;
        }
        if (communicator != null) {
            try {
                communicator.destroy();
            }
            catch (Exception e) {
                System.err.println(e);
                status = 1;
            }
        }
        System.exit(status);
    }

    public static void main(String[] args) throws IOException {
        Server app = new Server();
        app.serverStart(args);
    }
}

