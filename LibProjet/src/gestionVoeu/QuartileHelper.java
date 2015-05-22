package gestionVoeu;

/** 
 * Helper class for : Quartile
 *  
 * @author OpenORB Compiler
 */ 
public class QuartileHelper
{
    /**
     * Insert Quartile into an any
     * @param a an any
     * @param t Quartile value
     */
    public static void insert(org.omg.CORBA.Any a, gestionVoeu.Quartile t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract Quartile from an any
     * @param a an any
     * @return the extracted Quartile value
     */
    public static gestionVoeu.Quartile extract(org.omg.CORBA.Any a)
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
     * Return the Quartile TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[4];
            _members[0] = "PREMIER_QUART";
            _members[1] = "DEUXIEME_QUART";
            _members[2] = "TROISIEME_QUART";
            _members[3] = "QUATRIEME_QUART";
            _tc = orb.create_enum_tc(id(),"Quartile",_members);
        }
        return _tc;
    }

    /**
     * Return the Quartile IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:gestionVoeu/Quartile:1.0";

    /**
     * Read Quartile from a marshalled stream
     * @param istream the input stream
     * @return the readed Quartile value
     */
    public static gestionVoeu.Quartile read(org.omg.CORBA.portable.InputStream istream)
    {
        return Quartile.from_int(istream.read_ulong());
    }

    /**
     * Write Quartile into a marshalled stream
     * @param ostream the output stream
     * @param value Quartile value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, gestionVoeu.Quartile value)
    {
        ostream.write_ulong(value.value());
    }

}
