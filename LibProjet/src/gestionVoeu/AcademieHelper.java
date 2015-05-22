package gestionVoeu;

/** 
 * Helper class for : Academie
 *  
 * @author OpenORB Compiler
 */ 
public class AcademieHelper
{
    /**
     * Insert Academie into an any
     * @param a an any
     * @param t Academie value
     */
    public static void insert(org.omg.CORBA.Any a, gestionVoeu.Academie t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Academie from an any
     * @param a an any
     * @return the extracted Academie value
     */
    public static gestionVoeu.Academie extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return gestionVoeu.AcademieHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Academie TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"Academie");
        }
        return _tc;
    }

    /**
     * Return the Academie IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:gestionVoeu/Academie:1.0";

    /**
     * Read Academie from a marshalled stream
     * @param istream the input stream
     * @return the readed Academie value
     */
    public static gestionVoeu.Academie read(org.omg.CORBA.portable.InputStream istream)
    {
        return(gestionVoeu.Academie)istream.read_Object(gestionVoeu._AcademieStub.class);
    }

    /**
     * Write Academie into a marshalled stream
     * @param ostream the output stream
     * @param value Academie value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, gestionVoeu.Academie value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Academie
     * @param obj the CORBA Object
     * @return Academie Object
     */
    public static Academie narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Academie)
            return (Academie)obj;

        if (obj._is_a(id()))
        {
            _AcademieStub stub = new _AcademieStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Academie
     * @param obj the CORBA Object
     * @return Academie Object
     */
    public static Academie unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Academie)
            return (Academie)obj;

        _AcademieStub stub = new _AcademieStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
