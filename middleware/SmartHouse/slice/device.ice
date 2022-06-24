module home {

   struct Date {
      short day;
      short month;
      short year;
   }

   struct Time {
      short hour;
      short minute;
      short second;
   }

   struct DateTime {
      Time t;
      Date d;
   }

   interface Device {
      string getDeviceName();
   }

   module controls {
      interface TempControl extends Device{
         float readTemp();
      }

      module Radiators {
         interface Radiator extends TempControl {
            void setTemp(float t);
         }
      }

      module Boilers {
         interface Boiler extends TempControl {
            void setTemp(float t);
         }
      }

      module MeteoStations {
         struct Sensor {
            string Name;
            int id;
            float temp;
            short humidity;
            float pressure;
         }

         enum LunarPhase {NewMoon, WaxingCrescent, FirstQuarter, WaxingGibbous, FullMoon, WaningGibbous, LastQuarter, WaningCrescent}

         sequence<Sensor> SensorSequence;

         interface MeteoStation extends TempControl {
            Sensor readSensor(int id);
            SensorSequence readSensors();
            DateTime readDate();
            LunarPhase readLunarPhase();
            float readHumidity();
            float readPressure();
         }
      }
   }

   module agdDevices {
      interface AGD extends Device{
         bool isOn();
         void startDevice();
         void stopDevice();
      }

      module FridgeFreezers {
         interface Fridge extends AGD {
            void setFridgeTemp(float t);
            float getFridgeTemp();
         }
         interface Freezer extends AGD {
            void setFreezerTemp(float t);
            float getFreezerTemp();
         }

         interface FridgeFreezer extends Fridge, Freezer {
         }
      }

      module Dishwashers {

         enum WashingProgram {Off, EnergySave, Normal, Automatic, Fast}

         struct Program {
            DateTime time;
            WashingProgram wp;
            float duration;
         }
         interface Dishwasher extends AGD {
            void setWashingProgram(Program p);
            Program getWashingProgram();
         }
      }

      module WashingMachines {
         enum WashingProgram {Off, Cotton, Wool, AntiCrease, ExtraRinse, Quick}
         struct Program {
            DateTime time;
            WashingProgram wp;
            float duration;
         }

         interface WashingMachine extends AGD{
            void setWashingProgram(Program p);
            Program getWashingProgram();
         }
      }

      module Ovens {
         enum Settings {Off, Fan, Grill, Bottom, TopBottom, Defrosting}
         struct Program {
            Settings s;
            float duration;
            int temp;
         }
         interface Oven extends AGD{
            void setProgram(Program p);
            Program getProgram();
         }
      }
   }

   module monitoring {

      struct View {
         int width;
         int height;
         DateTime t;
         string v;
      }

      interface Camera extends Device{
         View getView();
      }

      module ptzCameras {

         struct Rotation {
            int vertical;
            int horizontal;
         }

         interface CameraPTZ extends Camera{
            void setRotation(Rotation r);
            Rotation getRotation();
         }
      }
   }

   module manager {
      struct DeviceInfo {
         string Name;
         int id;
         string identity;
         string category;
      }

      sequence<DeviceInfo> DeviceSequence;

      interface DeviceManager extends Device {
         void addDevice(DeviceInfo di);
         DeviceInfo getDevice(int id);
         DeviceSequence getAllDevices();
      }
   }
}