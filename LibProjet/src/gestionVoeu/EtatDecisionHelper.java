package gestionVoeu;

/** 
 * Helper class for : EtatDecision
 *  
 * @author OpenORB Compiler
 */ 
public class EtatDecisionHelper
{
    /**
     * Insert EtatDecision into an any
     * @param a an any
     * @param t EtatDecision value
     */
    public static void insert(org.omg.CORBA.Any a, gestionVoeu.EtatDecision t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract EtatDecision from an any
     * @param a an any
     * @return the extracted EtatDecision value
     */
    public static gestionVoeu.EtatDecision extract(org.omg.CORBA.Any a)
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
     * Return the EtatDecision TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[3];
            _members[0] = "ADMIS";
            _members[1] = "ATTENTE";
            _members[2] = "REFUSE";
            _tc = orb.create_enum_tc(id(),"EtatDecision",_members);
        }
        return _tc;
    }

    /**
     * Return the EtatDecision IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:gestionVoeu/EtatDecision:1.0";

    /**
     * Read EtatDecision from a marshalled stream
     * @param istream the input stream
     * @return the readed EtatDecision value
     */
    public static gestionVoeu.EtatDecision read(org.omg.CORBA.portable.InputStream istream)
    {
        return EtatDecision.from_int(istream.read_ulong());
    }

    /**
     * Write EtatDecision into a marshalled stream
     * @param ostream the output stream
     * @param value EtatDecision value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, gestionVoeu.EtatDecision value)
    {
        ostream.write_ulong(value.value());
    }

}
