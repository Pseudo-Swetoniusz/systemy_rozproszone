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

package home;

public class DateTime implements java.lang.Cloneable,
                                 java.io.Serializable
{
    public Time t;

    public Date d;

    public DateTime()
    {
        this.t = new Time();
        this.d = new Date();
    }

    public DateTime(Time t, Date d)
    {
        this.t = t;
        this.d = d;
    }

    public boolean equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        DateTime r = null;
        if(rhs instanceof DateTime)
        {
            r = (DateTime)rhs;
        }

        if(r != null)
        {
            if(this.t != r.t)
            {
                if(this.t == null || r.t == null || !this.t.equals(r.t))
                {
                    return false;
                }
            }
            if(this.d != r.d)
            {
                if(this.d == null || r.d == null || !this.d.equals(r.d))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int h_ = 5381;
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::home::DateTime");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, t);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, d);
        return h_;
    }

    public DateTime clone()
    {
        DateTime c = null;
        try
        {
            c = (DateTime)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        Time.ice_write(ostr, this.t);
        Date.ice_write(ostr, this.d);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.t = Time.ice_read(istr);
        this.d = Date.ice_read(istr);
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, DateTime v)
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

    static public DateTime ice_read(com.zeroc.Ice.InputStream istr)
    {
        DateTime v = new DateTime();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<DateTime> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, DateTime v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.VSize))
        {
            ostr.writeSize(12);
            ice_write(ostr, v);
        }
    }

    static public java.util.Optional<DateTime> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.VSize))
        {
            istr.skipSize();
            return java.util.Optional.of(DateTime.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final DateTime _nullMarshalValue = new DateTime();

    /** @hidden */
    public static final long serialVersionUID = 1138846357L;
}