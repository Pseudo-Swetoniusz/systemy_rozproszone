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

public class Sensor implements java.lang.Cloneable,
                               java.io.Serializable
{
    public String Name;

    public int id;

    public float temp;

    public short humidity;

    public float pressure;

    public Sensor()
    {
        this.Name = "";
    }

    public Sensor(String Name, int id, float temp, short humidity, float pressure)
    {
        this.Name = Name;
        this.id = id;
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public boolean equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        Sensor r = null;
        if(rhs instanceof Sensor)
        {
            r = (Sensor)rhs;
        }

        if(r != null)
        {
            if(this.Name != r.Name)
            {
                if(this.Name == null || r.Name == null || !this.Name.equals(r.Name))
                {
                    return false;
                }
            }
            if(this.id != r.id)
            {
                return false;
            }
            if(this.temp != r.temp)
            {
                return false;
            }
            if(this.humidity != r.humidity)
            {
                return false;
            }
            if(this.pressure != r.pressure)
            {
                return false;
            }

            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int h_ = 5381;
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::home::controls::MeteoStations::Sensor");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, Name);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, id);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, temp);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, humidity);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, pressure);
        return h_;
    }

    public Sensor clone()
    {
        Sensor c = null;
        try
        {
            c = (Sensor)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeString(this.Name);
        ostr.writeInt(this.id);
        ostr.writeFloat(this.temp);
        ostr.writeShort(this.humidity);
        ostr.writeFloat(this.pressure);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.Name = istr.readString();
        this.id = istr.readInt();
        this.temp = istr.readFloat();
        this.humidity = istr.readShort();
        this.pressure = istr.readFloat();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, Sensor v)
    {
        if(v == null)
        {
            _nullMarshalValue.ice_writeMembers(ostr);
        }
        else
        {
            v.ice_writeMembers(ostr);
        }
    }

    static public Sensor ice_read(com.zeroc.Ice.InputStream istr)
    {
        Sensor v = new Sensor();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<Sensor> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, Sensor v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ice_write(ostr, v);
            ostr.endSize(pos);
        }
    }

    static public java.util.Optional<Sensor> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            return java.util.Optional.of(Sensor.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final Sensor _nullMarshalValue = new Sensor();

    /** @hidden */
    public static final long serialVersionUID = -123217116L;
}
