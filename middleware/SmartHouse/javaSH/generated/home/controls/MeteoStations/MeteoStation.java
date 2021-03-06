//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.7
//
// <auto-generated>
//
// Generated from file `device.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package home.controls.MeteoStations;

public interface MeteoStation extends home.controls.TempControl
{
    Sensor readSensor(int id, com.zeroc.Ice.Current current);

    Sensor[] readSensors(com.zeroc.Ice.Current current);

    home.DateTime readDate(com.zeroc.Ice.Current current);

    LunarPhase readLunarPhase(com.zeroc.Ice.Current current);

    float readHumidity(com.zeroc.Ice.Current current);

    float readPressure(com.zeroc.Ice.Current current);

    /** @hidden */
    static final String[] _iceIds =
    {
        "::Ice::Object",
        "::home::Device",
        "::home::controls::MeteoStations::MeteoStation",
        "::home::controls::TempControl"
    };

    @Override
    default String[] ice_ids(com.zeroc.Ice.Current current)
    {
        return _iceIds;
    }

    @Override
    default String ice_id(com.zeroc.Ice.Current current)
    {
        return ice_staticId();
    }

    static String ice_staticId()
    {
        return "::home::controls::MeteoStations::MeteoStation";
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_readSensor(MeteoStation obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        int iceP_id;
        iceP_id = istr.readInt();
        inS.endReadParams();
        Sensor ret = obj.readSensor(iceP_id, current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        Sensor.ice_write(ostr, ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_readSensors(MeteoStation obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        inS.readEmptyParams();
        Sensor[] ret = obj.readSensors(current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        SensorSequenceHelper.write(ostr, ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_readDate(MeteoStation obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        inS.readEmptyParams();
        home.DateTime ret = obj.readDate(current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        home.DateTime.ice_write(ostr, ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_readLunarPhase(MeteoStation obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        inS.readEmptyParams();
        LunarPhase ret = obj.readLunarPhase(current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        LunarPhase.ice_write(ostr, ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_readHumidity(MeteoStation obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        inS.readEmptyParams();
        float ret = obj.readHumidity(current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        ostr.writeFloat(ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_readPressure(MeteoStation obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        inS.readEmptyParams();
        float ret = obj.readPressure(current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        ostr.writeFloat(ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /** @hidden */
    final static String[] _iceOps =
    {
        "getDeviceName",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "readDate",
        "readHumidity",
        "readLunarPhase",
        "readPressure",
        "readSensor",
        "readSensors",
        "readTemp"
    };

    /** @hidden */
    @Override
    default java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceDispatch(com.zeroc.IceInternal.Incoming in, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        int pos = java.util.Arrays.binarySearch(_iceOps, current.operation);
        if(pos < 0)
        {
            throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return home.Device._iceD_getDeviceName(this, in, current);
            }
            case 1:
            {
                return com.zeroc.Ice.Object._iceD_ice_id(this, in, current);
            }
            case 2:
            {
                return com.zeroc.Ice.Object._iceD_ice_ids(this, in, current);
            }
            case 3:
            {
                return com.zeroc.Ice.Object._iceD_ice_isA(this, in, current);
            }
            case 4:
            {
                return com.zeroc.Ice.Object._iceD_ice_ping(this, in, current);
            }
            case 5:
            {
                return _iceD_readDate(this, in, current);
            }
            case 6:
            {
                return _iceD_readHumidity(this, in, current);
            }
            case 7:
            {
                return _iceD_readLunarPhase(this, in, current);
            }
            case 8:
            {
                return _iceD_readPressure(this, in, current);
            }
            case 9:
            {
                return _iceD_readSensor(this, in, current);
            }
            case 10:
            {
                return _iceD_readSensors(this, in, current);
            }
            case 11:
            {
                return home.controls.TempControl._iceD_readTemp(this, in, current);
            }
        }

        assert(false);
        throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
    }
}
