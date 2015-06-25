package gestionVoeu;

/** 
 * Helper class for : Phase
 *  
 * @author OpenORB Compiler
 */ 
public class PhaseHelper
{
    /**
     * Insert Phase into an any
     * @param a an any
     * @param t Phase value
     */
    public static void insert(org.omg.CORBA.Any a, gestionVoeu.Phase t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract Phase from an any
     * @param a an any
     * @return the extracted Phase value
     */
    public static gestionVoeu.Phase extract(org.omg.CORBA.Any a)
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
     * Return the Phase TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[4];
            _members[0] = "PHASE_1";
            _members[1] = "PHASE_2";
            _members[2] = "PHASE_3";
            _members[3] = "PHASE_4";
            _tc = orb.create_enum_tc(id(),"Phase",_members);
        }
        return _tc;
    }

    /**
     * Return the Phase IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:gestionVoeu/Phase:1.0";

    /**
     * Read Phase from a marshalled stream
     * @param istream the input stream
     * @return the readed Phase value
     */
    public static gestionVoeu.Phase read(org.omg.CORBA.portable.InputStream istream)
    {
        return Phase.from_int(istream.read_ulong());
    }

    /**
     * Write Phase into a marshalled stream
     * @param ostream the output stream
     * @param value Phase value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, gestionVoeu.Phase value)
    {
        ostream.write_ulong(value.value());
    }

}
