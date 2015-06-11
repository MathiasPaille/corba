package gestionVoeu;

/** 
 * Helper class for : EtatVoeu
 *  
 * @author OpenORB Compiler
 */ 
public class EtatVoeuHelper
{
    /**
     * Insert EtatVoeu into an any
     * @param a an any
     * @param t EtatVoeu value
     */
    public static void insert(org.omg.CORBA.Any a, gestionVoeu.EtatVoeu t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract EtatVoeu from an any
     * @param a an any
     * @return the extracted EtatVoeu value
     */
    public static gestionVoeu.EtatVoeu extract(org.omg.CORBA.Any a)
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
     * Return the EtatVoeu TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[6];
            _members[0] = "CREE";
            _members[1] = "ACCEPTE";
            _members[2] = "OUI_DEFINITIF";
            _members[3] = "OUI_MAIS";
            _members[4] = "NON_MAIS";
            _members[5] = "NON_DEFINITIF";
            _tc = orb.create_enum_tc(id(),"EtatVoeu",_members);
        }
        return _tc;
    }

    /**
     * Return the EtatVoeu IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:gestionVoeu/EtatVoeu:1.0";

    /**
     * Read EtatVoeu from a marshalled stream
     * @param istream the input stream
     * @return the readed EtatVoeu value
     */
    public static gestionVoeu.EtatVoeu read(org.omg.CORBA.portable.InputStream istream)
    {
        return EtatVoeu.from_int(istream.read_ulong());
    }

    /**
     * Write EtatVoeu into a marshalled stream
     * @param ostream the output stream
     * @param value EtatVoeu value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, gestionVoeu.EtatVoeu value)
    {
        ostream.write_ulong(value.value());
    }

}
