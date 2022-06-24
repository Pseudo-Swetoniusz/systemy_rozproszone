import sys, Ice

import home

with Ice.initialize(sys.argv) as communicator:
    manager_1_base = communicator.stringToProxy("manager/manager:tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p "
                                                "10000 -z")
    manager_1 = home.manager.DeviceManagerPrx.checkedCast(manager_1_base)
    if not manager_1:
        print("Invalid proxy -> DeviceManager")
        exit(-1)
    freezer_base = communicator.stringToProxy("agd/freezer:tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p 10000 -z")
    freezer = home.agdDevices.FridgeFreezers.FreezerPrx.checkedCast(freezer_base)
    if not freezer:
        print("Invalid proxy -> Freezer")
        exit(-1)
    ffridge_base = communicator.stringToProxy("agd/ffridge:tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p 10000 -z")
    ffridge = home.agdDevices.FridgeFreezers.FridgeFreezerPrx.checkedCast(ffridge_base)
    if not ffridge:
        print("Invalid proxy -> FridgeFreezer")
        exit(-1)
    oven_base = communicator.stringToProxy("agd/oven:tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p 10000 -z")
    oven = home.agdDevices.Ovens.OvenPrx.checkedCast(oven_base)
    if not oven:
        print("Invalix proxy -> Oven")
        exit(-1)
    dishwasher_base = communicator.stringToProxy("agd/dishwasher:tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p "
                                                 "10000 -z")
    dishwasher = home.agdDevices.Dishwashers.DishwasherPrx.checkedCast(dishwasher_base)
    if not dishwasher:
        print("Invalid proxy -> Dishwasher")
        exit(-1)
    meteo_base = communicator.stringToProxy("controls/meteoStation:tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p "
                                            "10000 -z")
    meteo = home.controls.MeteoStations.MeteoStationPrx.checkedCast(meteo_base)
    if not meteo:
        print("Invalid proxy -> MeteoStation")
        exit(-1)
    radiator_base = communicator.stringToProxy("controls/radiator:tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p "
                                               "10000 -z")
    radiator = home.controls.Radiators.RadiatorPrx.checkedCast(radiator_base)
    if not radiator:
        print("Invalid proxy -> Radiator")
        exit(-1)
    cameraPTZ_base = communicator.stringToProxy("monitoring/cameraPTZ:tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 "
                                                "-p 10000 -z")
    cameraPTZ = home.monitoring.ptzCameras.CameraPTZPrx.checkedCast(cameraPTZ_base)
    if not cameraPTZ:
        print("Invalid proxy -> CameraPTZ")
        exit(-1)
    camera_base = communicator.stringToProxy("monitoring/camera:tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p "
                                             "10000 -z")
    camera = home.monitoring.CameraPrx.checkedCast(camera_base)
    if not camera:
        print("Invalid proxy -> Camera")
        exit(-1)
    manager_2_base = communicator.stringToProxy("manager/manager:tcp -h 127.0.0.2 -p 10002 -z : udp -h 127.0.0.2 -p "
                                                "10002 -z")
    manager_2 = home.manager.DeviceManagerPrx.checkedCast(manager_2_base)
    if not manager_2:
        print("Invalid proxy -> Camera")
        exit(-1)
    fridge_base = communicator.stringToProxy("agd/fridge:tcp -h 127.0.0.2 -p 10002 -z : udp -h 127.0.0.2 -p 10002 -z")
    fridge = home.agdDevices.FridgeFreezers.FridgePrx.checkedCast(fridge_base)
    if not fridge:
        print("Invalid proxy -> Fridge")
        exit(-1)
    washing_machine_base = communicator.stringToProxy("agd/washingMachine:tcp -h 127.0.0.2 -p 10002 -z : udp -h "
                                                      "127.0.0.2 -p 10002 -z")
    washing_machine = home.agdDevices.WashingMachines.WashingMachinePrx.checkedCast(washing_machine_base)
    if not washing_machine:
        print("Invalid proxy -> WashingMachine")
        exit(-1)
    boiler_base = communicator.stringToProxy("controls/boiler:tcp -h 127.0.0.2 -p 10002 -z : udp -h 127.0.0.2 -p "
                                             "10002 -z")
    boiler = home.controls.Boilers.BoilerPrx.checkedCast(boiler_base)
    if not boiler:
        print("Invalid proxy -> Boiler")
        exit(-1)
    radiatorD_base = communicator.stringToProxy("controls/radiatorD:tcp -h 127.0.0.2 -p 10002 -z : udp -h 127.0.0.2 "
                                                "-p 10002 -z")
    radiatorD = home.controls.Radiators.RadiatorPrx.checkedCast(radiatorD_base)
    if not radiatorD:
        print("Invalid proxy -> RadiatorD")
        exit(-1)
    radiatorU_base = communicator.stringToProxy("controls/radiatorU:tcp -h 127.0.0.2 -p 10002 -z : udp -h 127.0.0.2 "
                                                "-p 10002 -z")
    radiatorU = home.controls.Radiators.RadiatorPrx.checkedCast(radiatorU_base)
    if not radiatorU:
        print("Invalid proxy -> RadiatorD")
        exit(-1)
    cameraPTZFD_base = communicator.stringToProxy("monitoring/cameraPTZFD:tcp -h 127.0.0.2 -p 10002 -z : udp -h "
                                                  "127.0.0.2 -p 10002 -z")
    cameraPTZFD = home.monitoring.ptzCameras.CameraPTZPrx.checkedCast(cameraPTZFD_base)
    if not cameraPTZFD:
        print("Invalid proxy -> CameraPTZFD")
        exit(-1)
    cameraPTZBU_base = communicator.stringToProxy("monitoring/cameraPTZBU:tcp -h 127.0.0.2 -p 10002 -z : udp -h "
                                                  "127.0.0.2 -p 10002 -z")
    cameraPTZBU = home.monitoring.ptzCameras.CameraPTZPrx.checkedCast(cameraPTZBU_base)
    if not cameraPTZFD:
        print("Invalid proxy -> CameraPTZBU")
        exit(-1)
    cameraBB_base = communicator.stringToProxy("monitoring/cameraBB:tcp -h 127.0.0.2 -p 10002 -z : udp -h "
                                               "127.0.0.2 -p 10002 -z")
    cameraBB = home.monitoring.CameraPrx.checkedCast(cameraBB_base)
    if not cameraBB:
        print("Invalid proxy -> CameraBB")
        exit(-1)
    cameraBY_base = communicator.stringToProxy("monitoring/cameraBY:tcp -h 127.0.0.2 -p 10002 -z : udp -h "
                                               "127.0.0.2 -p 10002 -z")
    cameraBY = home.monitoring.CameraPrx.checkedCast(cameraBY_base)
    if not cameraBY:
        print("Invalid proxy -> CameraBY")
        exit(-1)

    while True:
        device_id = str(input("Enter device identity: "))
        if device_id == "manager":
            nr_id = int(input("manager number id: "))
            if nr_id == 1:
                while True:
                    function = str(input("name of the function: "))
                    if function == "get_name":
                        print("name of the device:", manager_1.getDeviceName())
                    elif function == "get_devices":
                        all_devices = manager_1.getAllDevices()
                        for d in all_devices:
                            print("Device name:", d.Name, "device id:", d.id, "device identity:", d.identity,
                                  "device category:", d.category)
                    elif function == "break":
                        break
                    else:
                        print("command not recognized")
            else:
                while True:
                    function = str(input("name of the function: "))
                    if function == "get_name":
                        print("name of the device:", manager_2.getDeviceName())
                    elif function == "get_devices":
                        all_devices = manager_1.getAllDevices()
                        for d in all_devices:
                            print("Device name:", d.Name, "device id:", d.id, "device identity:", d.identity,
                                  "device category:", d.category)
                    elif function == "break":
                        break
                    else:
                        print("command not recognized")
        elif device_id == "freezer":
            while True:
                function = str(input("name of the function: "))
                if function == "get_name":
                    print("name of the device:", freezer.getDeviceName())
                elif function == "get_temp":
                    print("temperature in freezer:", freezer.getFreezerTemp())
                elif function == "set_temp":
                    try:
                        temp = float(input("New temperature: "))
                        if temp < 0 or temp > 10:
                            raise ValueError
                    except ValueError:
                        print("you must enter a valid number in range (0-10)")
                    else:
                        freezer.setFreezerTemp(temp)
                        print("temperature is now:", freezer.getFreezerTemp())
                elif function == "is_on":
                    if freezer.isOn():
                        print("freezer is on")
                    else:
                        print("freezer is off")
                elif function == "on":
                    freezer.startDevice()
                    if freezer.isOn():
                        print("freezer is now on")
                    else:
                        print("error occurred - freezer is off")
                elif function == "off":
                    freezer.stopDevice()
                    if freezer.isOn():
                        print("error occurred - freezer is on")
                    else:
                        print("freezer is now off")
                elif function == "break":
                    break
                else:
                    print("command not recognized")
        elif device_id == "ffridge":
            while True:
                function = str(input("name of the function: "))
                if function == "get_name":
                    print("name of the device:", ffridge.getDeviceName())
                elif function == "get_temp_freezer":
                    print("temperature in freezer:", ffridge.getFreezerTemp())
                elif function == "get_temp_fridge":
                    print("temperature in fridge:", ffridge.getFridgeTemp())
                elif function == "set_temp_freezer":
                    try:
                        temp = float(input("New temperature: "))
                        if temp < -20 or temp > 0:
                            raise ValueError
                    except ValueError:
                        print("you must enter a valid number in range(-20,0)")
                    else:
                        ffridge.setFreezerTemp(temp)
                        print("temperature is now:", ffridge.getFreezerTemp())
                elif function == "set_temp_fridge":
                    try:
                        temp = float(input("New temperature: "))
                        if temp < 0 or temp > 10:
                            raise ValueError
                    except ValueError:
                        print("you must enter a valid number in range (0-10)")
                    else:
                        ffridge.setFridgeTemp(temp)
                        print("temperature is now:", ffridge.getFridgeTemp())
                elif function == "is_on":
                    if ffridge.isOn():
                        print("fridge_freezer is on")
                    else:
                        print("fridge_freezer is off")
                elif function == "on":
                    ffridge.startDevice()
                    if ffridge.isOn():
                        print("fridge_freezer is now on")
                    else:
                        print("error occurred - fridge_freezer is off")
                elif function == "off":
                    ffridge.stopDevice()
                    if ffridge.isOn():
                        print("error occurred - fridge_freezer is on")
                    else:
                        print("fridge_freezer is now off")
                elif function == "break":
                    break
                else:
                    print("command not recognized")
        elif device_id == "oven":
            while True:
                function = str(input("name of the function: "))
                if function == "get_name":
                    print("name of the device", oven.getDeviceName())
                elif function == "is_on":
                    if oven.isOn():
                        print("oven is on")
                    else:
                        print("oven is off")
                elif function == "on":
                    oven.startDevice()
                    if oven.isOn():
                        print("oven is now on")
                        ready = True
                        p_settings = str(input("oven setting: "))
                        s = None
                        if p_settings == "Fan":
                            s = home.agdDevices.Ovens.Settings.Fan
                        elif p_settings == "Grill":
                            s = home.agdDevices.Ovens.Settings.Grill
                        elif p_settings == "Bottom":
                            s = home.agdDevices.Ovens.Settings.Bottom
                        elif p_settings == "TopBottom":
                            s = home.agdDevices.Ovens.Settings.TopBottom
                        elif p_settings == "Defrosting":
                            s = home.agdDevices.Ovens.Settings.Defrosting
                        else:
                            ready = False
                            print("no such setting")
                            oven.stopDevice()
                            print("oven is off")
                        if ready:
                            try:
                                p_duration = float(input("program duration: "))
                                p_temp = int(input("oven temperature: "))
                                if p_duration > 4 or p_duration < 0:
                                    raise ValueError
                                if p_temp > 200 or p_temp < 50:
                                    raise ValueError
                            except ValueError:
                                ready = False
                                print("enter a valid number (hours (0,4) or temperature(50,200)")
                                oven.stopDevice()
                                print("oven is off")
                            else:
                                if ready:
                                    p = home.agdDevices.Ovens.Program(s, p_duration, p_temp)
                                    oven.setProgram(p)
                                    program = oven.getProgram()
                                    print("Oven setting:", program.s, "duration:", program.duration, "temperature",
                                          program.temp)
                    else:
                        print("error occurred - oven is off")
                elif function == "off":
                    oven.stopDevice()
                    if oven.isOn():
                        print("error occurred - oven is on")
                    else:
                        p = home.agdDevices.Ovens.Program(home.agdDevices.Ovens.Settings.Off, 0, 0)
                        oven.setProgram(p)
                        print("oven is now off")
                elif function == "get_program":
                    program = oven.getProgram()
                    if program.s == home.agdDevices.Ovens.Settings.Off:
                        print("program has not been set - oven is off")
                    else:
                        print("Oven setting:", program.s, "duration:", program.duration, "temperature", program.temp)
                elif function == "set_program":
                    if oven.isOn():
                        ready = True
                        p_settings = str(input("oven setting: "))
                        s = None
                        if p_settings == "Fan":
                            s = home.agdDevices.Ovens.Settings.Fan
                        elif p_settings == "Grill":
                            s = home.agdDevices.Ovens.Settings.Grill
                        elif p_settings == "Bottom":
                            s = home.agdDevices.Ovens.Settings.Bottom
                        elif p_settings == "TopBottom":
                            s = home.agdDevices.Ovens.Settings.TopBottom
                        elif p_settings == "Defrosting":
                            s = home.agdDevices.Ovens.Settings.Defrosting
                        else:
                            ready = False
                            print("no such setting")
                        if ready:
                            try:
                                p_duration = float(input("program duration: "))
                                p_temp = int(input("oven temperature: "))
                                if p_duration > 4 or p_duration < 0:
                                    raise ValueError
                                if p_temp > 200 or p_temp < 50:
                                    raise ValueError
                            except ValueError:
                                ready = False
                                print("enter a valid number (hours (0,4) or temperature(50,200)")
                            else:
                                if ready:
                                    p = home.agdDevices.Ovens.Program(s, p_duration, p_temp)
                                    oven.setProgram(p)
                                    program = oven.getProgram()
                                    print("Oven setting:", program.s, "duration:", program.duration, "temperature",
                                          program.temp)
                    else:
                        print("you must turn the oven on first")
                elif function == "break":
                    break
                else:
                    print("command not recognized")
        elif device_id == "dishwasher":
            while True:
                function = str(input("name of the function: "))
                if function == "get_name":
                    print("name of the device", dishwasher.getDeviceName())
                elif function == "is_on":
                    if dishwasher.isOn():
                        print("dishwasher is on")
                    else:
                        print("dishwasher is off")
                elif function == "on":
                    dishwasher.startDevice()
                    if dishwasher.isOn():
                        print("dishwasher is now on")
                        ready = True
                        p_settings = str(input("dishwasher setting: "))
                        s = None
                        if p_settings == "EnergySave":
                            s = home.agdDevices.Dishwashers.WashingProgram.EnergySave
                        elif p_settings == "Normal":
                            s = home.agdDevices.Dishwashers.WashingProgram.Normal
                        elif p_settings == "Automatic":
                            s = home.agdDevices.Dishwashers.WashingProgram.Automatic
                        elif p_settings == "Fast":
                            s = home.agdDevices.Dishwashers.WashingProgram.Fast
                        else:
                            ready = False
                            print("no such setting")
                            dishwasher.stopDevice()
                            print("dishwasher is off")
                        if ready:
                            try:
                                print("Enter date and time:")
                                p_day = int(input("day: "))
                                p_month = int(input("month: "))
                                p_year = 2022
                                p_hour = int(input("hour: "))
                                p_min = int(input("minutes: "))
                                p_duration = float(input("duration: "))
                                if p_day <= 0 or p_day >31:
                                    raise ValueError
                                if p_month <=0 or p_month > 12:
                                    raise ValueError
                                if p_hour < 0 or p_hour >23:
                                    raise ValueError
                                if p_min < 0 or p_min >59:
                                    raise ValueError
                                if p_duration < 0 or p_duration > 7:
                                    raise ValueError
                            except ValueError:
                                ready = False
                                print("enter a valid number")
                                dishwasher.stopDevice()
                                print("dishwasher is off")
                            else:
                                if ready:
                                    t = home.Time(p_hour, p_min, 0)
                                    d = home.Date(p_day, p_month, p_year)
                                    dt = home.DateTime(t, d)
                                    p = home.agdDevices.Dishwashers.Program(dt, s, p_duration)
                                    dishwasher.setWashingProgram(p)
                                    program = dishwasher.getWashingProgram()
                                    date_string = str(program.time.d.day) + "/" + str(program.time.d.month) + "/" \
                                                  + str(program.time.d.year) + " " + str(program.time.t.hour) + ":" \
                                                  + str(program.time.t.minute)
                                    print("Dishwasher setting:", program.wp, "duration:", program.duration, "date",
                                          date_string)
                    else:
                        print("error occurred - dishwasher is off")
                elif function == "off":
                    dishwasher.stopDevice()
                    if dishwasher.isOn():
                        print("error occurred - dishwasher is on")
                    else:
                        t = home.Time(0, 0, 0)
                        d = home.Date(0, 0, 0)
                        dt = home.DateTime(t, d)
                        p = home.agdDevices.Dishwashers.Program(dt, home.agdDevices.Dishwashers.WashingProgram.Off, 0)
                        dishwasher.setWashingProgram(p)
                        print("dishwasher is now off")
                elif function == "set_program":
                    if dishwasher.isOn():
                        ready = True
                        p_settings = str(input("dishwasher setting: "))
                        s = None
                        if p_settings == "EnergySave":
                            s = home.agdDevices.Dishwashers.WashingProgram.EnergySave
                        elif p_settings == "Normal":
                            s = home.agdDevices.Dishwashers.WashingProgram.Normal
                        elif p_settings == "Automatic":
                            s = home.agdDevices.Dishwashers.WashingProgram.Automatic
                        elif p_settings == "Fast":
                            s = home.agdDevices.Dishwashers.WashingProgram.Fast
                        else:
                            ready = False
                            print("no such setting")
                        if ready:
                            try:
                                print("Enter date and time:")
                                p_day = int(input("day: "))
                                p_month = int(input("month: "))
                                p_year = 2022
                                p_hour = int(input("hour: "))
                                p_min = int(input("minutes: "))
                                p_duration = float(input("duration: "))
                                if p_day <= 0 or p_day >31:
                                    raise ValueError
                                if p_month <=0 or p_month > 12:
                                    raise ValueError
                                if p_hour < 0 or p_hour >23:
                                    raise ValueError
                                if p_min < 0 or p_min >59:
                                    raise ValueError
                                if p_duration < 0 or p_duration > 7:
                                    raise ValueError
                            except ValueError:
                                ready = False
                                print("enter a valid number")
                            else:
                                if ready:
                                    t = home.Time(p_hour, p_min, 0)
                                    d = home.Date(p_day, p_month, p_year)
                                    dt = home.DateTime(t, d)
                                    p = home.agdDevices.Dishwashers.Program(dt, s, p_duration)
                                    dishwasher.setWashingProgram(p)
                                    program = dishwasher.getWashingProgram()
                                    date_string = str(program.time.d.day) + "/" + str(program.time.d.month) + "/" \
                                                  + str(program.time.d.year) + " " + str(program.time.t.hour) + ":" \
                                                  + str(program.time.t.minute)
                                    print("Dishwasher setting:", program.wp, "duration:", program.duration, "date",
                                          date_string)
                    else:
                        print("you must turn the dishwasher on first")
                elif function == "break":
                    break
                else:
                    print("command not recognized")
        elif device_id == "meteo":
            while True:
                function = str(input("name of the function: "))
                if function == "get_name":
                    print("name of the device", meteo.getDeviceName())
                elif function == "read_sensor":
                    try:
                        sensor_id = int(input("enter sensor id: "))
                    except ValueError:
                        print("id must be a valid number")
                    else:
                        sensor = meteo.readSensor(sensor_id)
                        name = sensor.Name
                        temp = sensor.temp
                        hum = sensor.humidity
                        pres = sensor.pressure
                        print("Sensor", sensor_id, ": name:", name, " temp:", temp, " C humidity:", hum, "% pressure:",
                              pres, " hPa", sep="")
                elif function == "read_sensors":
                    sensors = meteo.readSensors()
                    for s in sensors:
                        name = s.Name
                        s_id = s.id
                        temp = s.temp
                        hum = s.humidity
                        pres = s.pressure
                        print("Sensor", s_id, ": name:", name, " temp:", temp, " C humidity:", hum, "% pressure:",
                              pres, " hPa", sep="")
                elif function == "read_date":
                    date = meteo.readDate()
                    print("Date: ", date.d.day, "/", date.d.month, "/", date.d.year, sep="")
                    print("Time: ", date.t.hour, ":", date.t.minute, ":", date.t.second, sep="")
                elif function == "read_phase":
                    phase = meteo.readLunarPhase()
                    p = None
                    if phase == home.controls.MeteoStations.LunarPhase.NewMoon:
                        p = "new moon"
                    elif phase == home.controls.MeteoStations.LunarPhase.WaxingCrescent:
                        p = "waxing crescent"
                    elif phase == home.controls.MeteoStations.LunarPhase.FirstQuarter:
                        p = "first quarter"
                    elif phase == home.controls.MeteoStations.LunarPhase.WaxingGibbous:
                        p = "waxing gibbous"
                    elif phase == home.controls.MeteoStations.LunarPhase.FullMoon:
                        p = "full moon"
                    elif phase == home.controls.MeteoStations.LunarPhase.WaningGibbous:
                        p = "waning gibbous"
                    elif phase == home.controls.MeteoStations.LunarPhase.WaningCrescent:
                        p = "waning crescent"
                    elif phase == home.controls.MeteoStations.LunarPhase.LastQuarter:
                        p = "last quarter"
                    print("Lunar phase:", p)
                elif function == "read_humidity":
                    print("Average humidity:", meteo.readHumidity())
                elif function == "read_temperature":
                    print("Average temperature:", meteo.readTemp())
                elif function == "read_pressure":
                    print("Average pressure:", meteo.readPressure())
                elif function == "break":
                    break
                else:
                    print("command not recognized")
        elif device_id == "radiator":
            while True:
                function = str(input("name of the function: "))
                if function == "get_name":
                    print("name of the device", radiator.getDeviceName())
                elif function == "read_temperature":
                    print("Temperature:", radiator.readTemp(), "C")
                elif function == "set_temperature":
                    try:
                        t = float(input("enter temperature (C): "))
                        if t < 10 or t>30:
                            raise ValueError
                    except ValueError:
                        print("temperature must be a valid number in range (10,30)")
                    else:
                        radiator.setTemp(t)
                        print("Temperature:", radiator.readTemp(), "C")
                elif function == "break":
                    break
                else:
                    print("command not recognized")
        elif device_id == "cameraPTZ":
            while True:
                function = str(input("name of the function: "))
                if function == "get_name":
                    print("name of the device", cameraPTZ.getDeviceName())
                elif function == "get_view":
                    view = cameraPTZ.getView()
                    print("View: ", view.width, "x", view.height, sep="")
                    date = view.t
                    print("Date: ", date.d.day, "/", date.d.month, "/", date.d.year, sep="")
                    print(view.v)
                elif function == "get_rotation":
                    rot = cameraPTZ.getRotation()
                    print("Rotation: horizontal:", rot.horizontal, "vertical:", rot.vertical)
                elif function == "set_rotation":
                    try:
                        v = int(input("vertical rotation: "))
                        h = int(input("horizontal rotation: "))
                        if v < 0 or v > 360:
                            raise ValueError
                        if h < 0 or h > 360:
                            raise ValueError
                    except ValueError:
                        print("rotation angle must be a valid number")
                    else:
                        r = home.monitoring.ptzCameras.Rotation(v, h)
                        cameraPTZ.setRotation(r)
                        rot = cameraPTZ.getRotation()
                        print("Rotation: horizontal:", rot.horizontal, "vertical:", rot.vertical)
                elif function == "break":
                    break
                else:
                    print("command not recognized")
        elif device_id == "cameraPTZBU":
            while True:
                function = str(input("name of the function: "))
                if function == "get_name":
                    print("name of the device", cameraPTZBU.getDeviceName())
                elif function == "get_view":
                    view = cameraPTZBU.getView()
                    print("View: ", view.width, "x", view.height, sep="")
                    date = view.t
                    print("Date: ", date.d.day, "/", date.d.month, "/", date.d.year, sep="")
                    print(view.v)
                elif function == "get_rotation":
                    rot = cameraPTZBU.getRotation()
                    print("Rotation: horizontal:", rot.horizontal, "vertical:", rot.vertical)
                elif function == "set_rotation":
                    try:
                        v = int(input("vertical rotation: "))
                        h = int(input("horizontal rotation: "))
                        if v < 0 or v > 360:
                            raise ValueError
                        if h < 0 or h > 360:
                            raise ValueError
                    except ValueError:
                        print("rotation angle must be a valid number")
                    else:
                        r = home.monitoring.ptzCameras.Rotation(v, h)
                        cameraPTZBU.setRotation(r)
                        rot = cameraPTZBU.getRotation()
                        print("Rotation: horizontal:", rot.horizontal, "vertical:", rot.vertical)
                elif function == "break":
                    break
                else:
                    print("command not recognized")
        elif device_id == "cameraPTZFD":
            while True:
                function = str(input("name of the function: "))
                if function == "get_name":
                    print("name of the device", cameraPTZFD.getDeviceName())
                elif function == "get_view":
                    view = cameraPTZFD.getView()
                    print("View: ", view.width, "x", view.height, sep="")
                    date = view.t
                    print("Date: ", date.d.day, "/", date.d.month, "/", date.d.year, sep="")
                    print(view.v)
                elif function == "get_rotation":
                    rot = cameraPTZFD.getRotation()
                    print("Rotation: horizontal:", rot.horizontal, "vertical:", rot.vertical)
                elif function == "set_rotation":
                    try:
                        v = int(input("vertical rotation: "))
                        h = int(input("horizontal rotation: "))
                        if v < 0 or v > 360:
                            raise ValueError
                        if h < 0 or h > 360:
                            raise ValueError
                    except ValueError:
                        print("rotation angle must be a valid number")
                    else:
                        r = home.monitoring.ptzCameras.Rotation(v, h)
                        cameraPTZFD.setRotation(r)
                        rot = cameraPTZFD.getRotation()
                        print("Rotation: horizontal:", rot.horizontal, "vertical:", rot.vertical)
                elif function == "break":
                    break
                else:
                    print("command not recognized")
        elif device_id == "camera":
            while True:
                function = str(input("name of the function: "))
                if function == "get_name":
                    print("name of the device", camera.getDeviceName())
                elif function == "get_view":
                    view = camera.getView()
                    print("View: ", view.width, "x", view.height, sep="")
                    date = view.t
                    print("Date: ", date.d.day, "/", date.d.month, "/", date.d.year, sep="")
                    print(view.v)
                elif function == "break":
                    break
                else:
                    print("command not recognized")
        elif device_id == "cameraBB":
            while True:
                function = str(input("name of the function: "))
                if function == "get_name":
                    print("name of the device", cameraBB.getDeviceName())
                elif function == "get_view":
                    view = cameraBB.getView()
                    print("View: ", view.width, "x", view.height, sep="")
                    date = view.t
                    print("Date: ", date.d.day, "/", date.d.month, "/", date.d.year, sep="")
                    print(view.v)
                elif function == "break":
                    break
                else:
                    print("command not recognized")
        elif device_id == "cameraBY":
            while True:
                function = str(input("name of the function: "))
                if function == "get_name":
                    print("name of the device", cameraBY.getDeviceName())
                elif function == "get_view":
                    view = cameraBY.getView()
                    print("View: ", view.width, "x", view.height, sep="")
                    date = view.t
                    print("Date: ", date.d.day, "/", date.d.month, "/", date.d.year, sep="")
                    print(view.v)
                elif function == "break":
                    break
                else:
                    print("command not recognized")
        elif device_id == "fridge":
            while True:
                function = str(input("name of the function: "))
                if function == "get_name":
                    print("name of the device", fridge.getDeviceName())
                elif function == "get_temp":
                    print("temperature in fridge:", fridge.getFridgeTemp())
                elif function == "set_temp":
                    try:
                        temp = float(input("New temperature: "))
                        if temp < 0 or temp>10:
                            raise ValueError
                    except ValueError:
                        print("you must enter a valid number")
                    else:
                        fridge.setFridgeTemp(temp)
                        print("temperature is now:", fridge.getFridgeTemp())
                elif function == "is_on":
                    if fridge.isOn():
                        print("fridge is on")
                    else:
                        print("fridge is off")
                elif function == "on":
                    fridge.startDevice()
                    if fridge.isOn():
                        print("fridge is now on")
                    else:
                        print("error occurred - fridge is off")
                elif function == "off":
                    fridge.stopDevice()
                    if fridge.isOn():
                        print("error occurred - fridge is on")
                    else:
                        print("fridge is now off")
                elif function == "break":
                    break
                else:
                    print("command not recognized")
        elif device_id == "washingMachine":
            while True:
                function = str(input("name of the function: "))
                if function == "get_name":
                    print("name of the device", washing_machine.getDeviceName())
                elif function == "is_on":
                    if washing_machine.isOn():
                        print("washingMachine is on")
                    else:
                        print("washingMachine is off")
                elif function == "on":
                    washing_machine.startDevice()
                    if washing_machine.isOn():
                        print("washingMachine is now on")
                        ready = True
                        p_settings = str(input("washingMachine setting: "))
                        s = None
                        if p_settings == "Cotton":
                            s = home.agdDevices.WashingMachines.WashingProgram.Cotton
                        elif p_settings == "Wool":
                            s = home.agdDevices.WashingMachines.WashingProgram.Wool
                        elif p_settings == "AntiCrease":
                            s = home.agdDevices.WashingMachines.WashingProgram.AntiCrease
                        elif p_settings == "ExtraRinse":
                            s = home.agdDevices.WashingMachines.WashingProgram.ExtraRinse
                        elif p_settings == "Quick":
                            s = home.agdDevices.WashingMachines.WashingProgram.Quick
                        else:
                            ready = False
                            print("no such setting")
                            washing_machine.stopDevice()
                            print("washingMachine is off")
                        if ready:
                            try:
                                print("Enter date and time:")
                                p_day = int(input("day: "))
                                p_month = int(input("month: "))
                                p_year = 2022
                                p_hour = int(input("hour: "))
                                p_min = int(input("minutes: "))
                                p_duration = float(input("duration: "))
                                if p_day <= 0 or p_day >31:
                                    raise ValueError
                                if p_month <=0 or p_month > 12:
                                    raise ValueError
                                if p_hour < 0 or p_hour >23:
                                    raise ValueError
                                if p_min < 0 or p_min >59:
                                    raise ValueError
                                if p_duration < 0 or p_duration > 7:
                                    raise ValueError
                            except ValueError:
                                ready = False
                                print("enter a valid number")
                                washing_machine.stopDevice()
                                print("washingMachine is off")
                            else:
                                if ready:
                                    t = home.Time(p_hour, p_min, 0)
                                    d = home.Date(p_day, p_month, p_year)
                                    dt = home.DateTime(t, d)
                                    p = home.agdDevices.WashingMachines.Program(dt, s, p_duration)
                                    washing_machine.setWashingProgram(p)
                                    program = washing_machine.getWashingProgram()
                                    date_string = str(program.time.d.day) + "/" + str(program.time.d.month) + "/" \
                                                  + str(program.time.d.year) + " " + str(program.time.t.hour) + ":" \
                                                  + str(program.time.t.minute)
                                    print("WashingMachine setting:", program.wp, "duration:", program.duration, "date",
                                          date_string)
                    else:
                        print("error occurred - washingMachine is off")
                elif function == "off":
                    washing_machine.stopDevice()
                    if washing_machine.isOn():
                        print("error occurred - washingMachine is on")
                    else:
                        t = home.Time(0, 0, 0)
                        d = home.Date(0, 0, 0)
                        dt = home.DateTime(t, d)
                        p = home.agdDevices.WashingMachines.Program(dt,
                                                                    home.agdDevices.WashingMachines.WashingProgram.Off,
                                                                    0)
                        washing_machine.setWashingProgram(p)
                        print("washingMachine is now off")
                elif function == "set_program":
                    if washing_machine.isOn():
                        ready = True
                        p_settings = str(input("washingMachine setting: "))
                        s = None
                        if p_settings == "Cotton":
                            s = home.agdDevices.WashingMachines.WashingProgram.Cotton
                        elif p_settings == "Wool":
                            s = home.agdDevices.WashingMachines.WashingProgram.Wool
                        elif p_settings == "AntiCrease":
                            s = home.agdDevices.WashingMachines.WashingProgram.AntiCrease
                        elif p_settings == "ExtraRinse":
                            s = home.agdDevices.WashingMachines.WashingProgram.ExtraRinse
                        elif p_settings == "Quick":
                            s = home.agdDevices.WashingMachines.WashingProgram.Quick
                        else:
                            ready = False
                            print("no such setting")
                            washing_machine.stopDevice()
                            print("washingMachine is off")
                        if ready:
                            try:
                                print("Enter date and time:")
                                p_day = int(input("day: "))
                                p_month = int(input("month: "))
                                p_year = 2022
                                p_hour = int(input("hour: "))
                                p_min = int(input("minutes: "))
                                p_duration = float(input("duration: "))
                                if p_day <= 0 or p_day >31:
                                    raise ValueError
                                if p_month <=0 or p_month > 12:
                                    raise ValueError
                                if p_hour < 0 or p_hour >23:
                                    raise ValueError
                                if p_min < 0 or p_min >59:
                                    raise ValueError
                                if p_duration < 0 or p_duration > 7:
                                    raise ValueError
                            except ValueError:
                                ready = False
                                print("enter a valid number")
                                washing_machine.stopDevice()
                                print("washingMachine is off")
                            else:
                                if ready:
                                    t = home.Time(p_hour, p_min, 0)
                                    d = home.Date(p_day, p_month, p_year)
                                    dt = home.DateTime(t, d)
                                    p = home.agdDevices.WashingMachines.Program(dt, s, p_duration)
                                    washing_machine.setWashingProgram(p)
                                    program = washing_machine.getWashingProgram()
                                    date_string = str(program.time.d.day) + "/" + str(program.time.d.month) + "/" \
                                                  + str(program.time.d.year) + " " + str(program.time.t.hour) + ":" \
                                                  + str(program.time.t.minute)
                                    print("WashingMachine setting:", program.wp, "duration:", program.duration, "date",
                                          date_string)
                    else:
                        print("you must turn the washingMachine on first")
                elif function == "break":
                    break
                else:
                    print("command not recognized")
        elif device_id == "boiler":
            while True:
                function = str(input("name of the function: "))
                if function == "get_name":
                    print("name of the device", boiler.getDeviceName())
                elif function == "read_temperature":
                    print("Temperature:", boiler.readTemp(), "C")
                elif function == "set_temperature":
                    try:
                        t = float(input("enter temperature (C): "))
                        if t < 20 or t>80:
                            raise ValueError
                    except ValueError:
                        print("temperature must be a valid number in range (20,80)")
                    else:
                        boiler.setTemp(t)
                        print("Temperature:", boiler.readTemp(), "C")
                elif function == "break":
                    break
                else:
                    print("command not recognized")
        elif device_id == "radiatorD":
            while True:
                function = str(input("name of the function: "))
                if function == "get_name":
                    print("name of the device", radiatorD.getDeviceName())
                elif function == "read_temperature":
                    print("Temperature:", radiatorD.readTemp(), "C")
                elif function == "set_temperature":
                    try:
                        t = float(input("enter temperature (C): "))
                        if t < 10 or t>30:
                            raise ValueError
                    except ValueError:
                        print("temperature must be a valid number in range (10,30)")
                    else:
                        radiatorD.setTemp(t)
                        print("Temperature:", radiatorD.readTemp(), "C")
                elif function == "break":
                    break
                else:
                    print("command not recognized")
        elif device_id == "radiatorU":
            while True:
                function = str(input("name of the function: "))
                if function == "get_name":
                    print("name of the device", radiatorU.getDeviceName())
                elif function == "read_temperature":
                    print("Temperature:", radiatorU.readTemp(), "C")
                elif function == "set_temperature":
                    try:
                        t = float(input("enter temperature (C): "))
                        if t < 10 or t>30:
                            raise ValueError
                    except ValueError:
                        print("temperature must be a valid number in range (10,30)")
                    else:
                        radiatorU.setTemp(t)
                        print("Temperature:", radiatorU.readTemp(), "C")
                elif function == "break":
                    break
                else:
                    print("command not recognized")
        elif device_id == "break":
            break
        else:
            print("command not recognized")
