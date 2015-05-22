package gestionVoeu;

/** 
 * Helper class for : EtudiantFactory
 *  
 * @author OpenORB Compiler
 */ 
public class EtudiantFactoryHelper
{
    /**
     * Insert EtudiantFactory into an any
     * @param a an any
     * @param t EtudiantFactory value
     */
    public static void insert(org.omg.CORBA.Any a, gestionVoeu.EtudiantFactory t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract EtudiantFactory from an any
     * @param a an any
     * @return the extracted EtudiantFactory value
     */
    public static gestionVoeu.EtudiantFactory extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return gestionVoeu.EtudiantFactoryHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the EtudiantFactory TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"EtudiantFactory");
        }
        return _tc;
    }

    /**
     * Return the EtudiantFactory IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:gestionVoeu/EtudiantFactory:1.0";

    /**
     * Read EtudiantFactory from a marshalled stream
     * @param istream the input stream
     * @return the readed EtudiantFactory value
     */
    public static gestionVoeu.EtudiantFactory read(org.omg.CORBA.portable.InputStream istream)
    {
        return(gestionVoeu.EtudiantFactory)istream.read_Object(gestionVoeu._EtudiantFactoryStub.class);
    }

    /**
     * Write EtudiantFactory into a marshalled stream
     * @param ostream the output stream
     * @param value EtudiantFactory value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, gestionVoeu.EtudiantFactory value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to EtudiantFactory
     * @param obj the CORBA Object
     * @return EtudiantFactory Object
     */
    public static EtudiantFactory narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof EtudiantFactory)
            return (EtudiantFactory)obj;

        if (obj._is_a(id()))
        {
            _EtudiantFactoryStub stub = new _EtudiantFactoryStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to EtudiantFactory
     * @param obj the CORBA Object
     * @return EtudiantFactory Object
     */
    public static EtudiantFactory unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof EtudiantFactory)
            return (EtudiantFactory)obj;

        _EtudiantFactoryStub stub = new _EtudiantFactoryStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
