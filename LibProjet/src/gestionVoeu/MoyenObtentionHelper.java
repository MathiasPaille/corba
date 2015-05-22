package gestionVoeu;

/** 
 * Helper class for : MoyenObtention
 *  
 * @author OpenORB Compiler
 */ 
public class MoyenObtentionHelper
{
    /**
     * Insert MoyenObtention into an any
     * @param a an any
     * @param t MoyenObtention value
     */
    public static void insert(org.omg.CORBA.Any a, gestionVoeu.MoyenObtention t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract MoyenObtention from an any
     * @param a an any
     * @return the extracted MoyenObtention value
     */
    public static gestionVoeu.MoyenObtention extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the MoyenObtention TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[3];
            _members[0] = "PREMIERE_SESSION";
            _members[1] = "SECONDE_SESSION";
            _members[2] = "REDOUBLEMENT";
            _tc = orb.create_enum_tc(id(),"MoyenObtention",_members);
        }
        return _tc;
    }

    /**
     * Return the MoyenObtention IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:gestionVoeu/MoyenObtention:1.0";

    /**
     * Read MoyenObtention from a marshalled stream
     * @param istream the input stream
     * @return the readed MoyenObtention value
     */
    public static gestionVoeu.MoyenObtention read(org.omg.CORBA.portable.InputStream istream)
    {
        return MoyenObtention.from_int(istream.read_ulong());
    }

    /**
     * Write MoyenObtention into a marshalled stream
     * @param ostream the output stream
     * @param value MoyenObtention value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, gestionVoeu.MoyenObtention value)
    {
        ostream.write_ulong(value.value());
    }

}
