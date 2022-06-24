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

public class Date implements java.lang.Cloneable,
                             java.io.Serializable
{
    public short day;

    public short month;

    public short year;

    public Date()
    {
    }

    public Date(short day, short month, short year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        Date r = null;
        if(rhs instanceof Date)
        {
            r = (Date)rhs;
        }

        if(r != null)
        {
            if(this.day != r.day)
            {
                return false;
            }
            if(this.month != r.month)
            {
                return false;
            }
            if(this.year != r.year)
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
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::home::Date");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, day);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, month);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, year);
        return h_;
    }

    public Date clone()
    {
        Date c = null;
        try
        {
            c = (Date)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeShort(this.day);
        ostr.writeShort(this.month);
        ostr.writeShort(this.year);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.day = istr.readShort();
        this.month = istr.readShort();
        this.year = istr.readShort();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, Date v)
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

    static public Date ice_read(com.zeroc.Ice.InputStream istr)
    {
        Date v = new Date();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<Date> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, Date v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.VSize))
        {
            ostr.writeSize(6);
            ice_write(ostr, v);
        }
    }

    static public java.util.Optional<Date> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.VSize))
        {
            istr.skipSize();
            return java.util.Optional.of(Date.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final Date _nullMarshalValue = new Date();

    /** @hidden */
    public static final long serialVersionUID = 1029940756L;
}
