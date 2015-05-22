package gestionVoeu;

/** 
 * Helper class for : CandidatureList
 *  
 * @author OpenORB Compiler
 */ 
public class CandidatureListHelper
{
    private static final boolean HAS_OPENORB;
    static {
        boolean hasOpenORB = false;
        try {
            Thread.currentThread().getContextClassLoader().loadClass("org.openorb.CORBA.Any");
            hasOpenORB = true;
        }
        catch(ClassNotFoundException ex) {
        }
        HAS_OPENORB = hasOpenORB;
    }
    /**
     * Insert CandidatureList into an any
     * @param a an any
     * @param t CandidatureList value
     */
    public static void insert(org.omg.CORBA.Any a, gestionVoeu.CandidatureDetail[] t)
    {
        a.insert_Streamable(new gestionVoeu.CandidatureListHolder(t));
    }

    /**
     * Extract CandidatureList from an any
     * @param a an any
     * @return the extracted CandidatureList value
     */
    public static gestionVoeu.CandidatureDetail[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof gestionVoeu.CandidatureListHolder)
                    return ((gestionVoeu.CandidatureListHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            gestionVoeu.CandidatureListHolder h = new gestionVoeu.CandidatureListHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the CandidatureList TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"CandidatureList",orb.create_sequence_tc(0,gestionVoeu.CandidatureDetailHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the CandidatureList IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:gestionVoeu/CandidatureList:1.0";

    /**
     * Read CandidatureList from a marshalled stream
     * @param istream the input stream
     * @return the readed CandidatureList value
     */
    public static gestionVoeu.CandidatureDetail[] read(org.omg.CORBA.portable.InputStream istream)
    {
        gestionVoeu.CandidatureDetail[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new gestionVoeu.CandidatureDetail[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = gestionVoeu.CandidatureDetailHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write CandidatureList into a marshalled stream
     * @param ostream the output stream
     * @param value CandidatureList value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, gestionVoeu.CandidatureDetail[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            gestionVoeu.CandidatureDetailHelper.write(ostream,value[i7]);

        }
    }

}
