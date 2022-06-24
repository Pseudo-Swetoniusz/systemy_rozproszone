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

package home.manager;

/**
 * Helper class for marshaling/unmarshaling DeviceSequence.
 **/
public final class DeviceSequenceHelper
{
    public static void write(com.zeroc.Ice.OutputStream ostr, DeviceInfo[] v)
    {
        if(v == null)
        {
            ostr.writeSize(0);
        }
        else
        {
            ostr.writeSize(v.length);
            for(int i0 = 0; i0 < v.length; i0++)
            {
                DeviceInfo.ice_write(ostr, v[i0]);
            }
        }
    }

    public static DeviceInfo[] read(com.zeroc.Ice.InputStream istr)
    {
        final DeviceInfo[] v;
        final int len0 = istr.readAndCheckSeqSize(7);
        v = new DeviceInfo[len0];
        for(int i0 = 0; i0 < len0; i0++)
        {
            v[i0] = DeviceInfo.ice_read(istr);
        }
        return v;
    }

    public static void write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<DeviceInfo[]> v)
    {
        if(v != null && v.isPresent())
        {
            write(ostr, tag, v.get());
        }
    }

    public static void write(com.zeroc.Ice.OutputStream ostr, int tag, DeviceInfo[] v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            DeviceSequenceHelper.write(ostr, v);
            ostr.endSize(pos);
        }
    }

    public static java.util.Optional<DeviceInfo[]> read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            DeviceInfo[] v;
            v = DeviceSequenceHelper.read(istr);
            return java.util.Optional.of(v);
        }
        else
        {
            return java.util.Optional.empty();
        }
    }
}