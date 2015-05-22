package gestionVoeu;

/** 
 * Helper class for : EtatInscription
 *  
 * @author OpenORB Compiler
 */ 
public class EtatInscriptionHelper
{
    /**
     * Insert EtatInscription into an any
     * @param a an any
     * @param t EtatInscription value
     */
    public static void insert(org.omg.CORBA.Any a, gestionVoeu.EtatInscription t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract EtatInscription from an any
     * @param a an any
     * @return the extracted EtatInscription value
     */
    public static gestionVoeu.EtatInscription extract(org.omg.CORBA.Any a)
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
     * Return the EtatInscription TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[3];
            _members[0] = "VALIDE";
            _members[1] = "NON_VALIDE";
            _members[2] = "CLOTURE";
            _tc = orb.create_enum_tc(id(),"EtatInscription",_members);
        }
        return _tc;
    }

    /**
     * Return the EtatInscription IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:gestionVoeu/EtatInscription:1.0";

    /**
     * Read EtatInscription from a marshalled stream
     * @param istream the input stream
     * @return the readed EtatInscription value
     */
    public static gestionVoeu.EtatInscription read(org.omg.CORBA.portable.InputStream istream)
    {
        return EtatInscription.from_int(istream.read_ulong());
    }

    /**
     * Write EtatInscription into a marshalled stream
     * @param ostream the output stream
     * @param value EtatInscription value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, gestionVoeu.EtatInscription value)
    {
        ostream.write_ulong(value.value());
    }

}
