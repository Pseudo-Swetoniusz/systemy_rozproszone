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

package home.agdDevices.WashingMachines;

public class Program implements java.lang.Cloneable,
                                java.io.Serializable
{
    public home.DateTime time;

    public WashingProgram wp;

    public float duration;

    public Program()
    {
        this.time = new home.DateTime();
        this.wp = WashingProgram.Off;
    }

    public Program(home.DateTime time, WashingProgram wp, float duration)
    {
        this.time = time;
        this.wp = wp;
        this.duration = duration;
    }

    public boolean equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        Program r = null;
        if(rhs instanceof Program)
        {
            r = (Program)rhs;
        }

        if(r != null)
        {
            if(this.time != r.time)
            {
                if(this.time == null || r.time == null || !this.time.equals(r.time))
                {
                    return false;
                }
            }
            if(this.wp != r.wp)
            {
                if(this.wp == null || r.wp == null || !this.wp.equals(r.wp))
                {
                    return false;
                }
            }
            if(this.duration != r.duration)
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
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::home::agdDevices::WashingMachines::Program");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, time);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, wp);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, duration);
        return h_;
    }

    public Program clone()
    {
        Program c = null;
        try
        {
            c = (Program)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        home.DateTime.ice_write(ostr, this.time);
        WashingProgram.ice_write(ostr, this.wp);
        ostr.writeFloat(this.duration);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.time = home.DateTime.ice_read(istr);
        this.wp = WashingProgram.ice_read(istr);
        this.duration = istr.readFloat();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, Program v)
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

    static public Program ice_read(com.zeroc.Ice.InputStream istr)
    {
        Program v = new Program();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<Program> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, Program v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ice_write(ostr, v);
            ostr.endSize(pos);
        }
    }

    static public java.util.Optional<Program> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            return java.util.Optional.of(Program.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final Program _nullMarshalValue = new Program();

    /** @hidden */
    public static final long serialVersionUID = 1761923081L;
}
