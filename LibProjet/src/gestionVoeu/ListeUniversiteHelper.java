package gestionVoeu;

/** 
 * Helper class for : ListeUniversite
 *  
 * @author OpenORB Compiler
 */ 
public class ListeUniversiteHelper
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
     * Insert ListeUniversite into an any
     * @param a an any
     * @param t ListeUniversite value
     */
    public static void insert(org.omg.CORBA.Any a, gestionVoeu.UniversiteDetail[] t)
    {
        a.insert_Streamable(new gestionVoeu.ListeUniversiteHolder(t));
    }

    /**
     * Extract ListeUniversite from an any
     * @param a an any
     * @return the extracted ListeUniversite value
     */
    public static gestionVoeu.UniversiteDetail[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof gestionVoeu.ListeUniversiteHolder)
                    return ((gestionVoeu.ListeUniversiteHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            gestionVoeu.ListeUniversiteHolder h = new gestionVoeu.ListeUniversiteHolder(read(a.create_input_stream()));
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
     * Return the ListeUniversite TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"ListeUniversite",orb.create_sequence_tc(0,gestionVoeu.UniversiteDetailHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the ListeUniversite IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:gestionVoeu/ListeUniversite:1.0";

    /**
     * Read ListeUniversite from a marshalled stream
     * @param istream the input stream
     * @return the readed ListeUniversite value
     */
    public static gestionVoeu.UniversiteDetail[] read(org.omg.CORBA.portable.InputStream istream)
    {
        gestionVoeu.UniversiteDetail[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new gestionVoeu.UniversiteDetail[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = gestionVoeu.UniversiteDetailHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write ListeUniversite into a marshalled stream
     * @param ostream the output stream
     * @param value ListeUniversite value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, gestionVoeu.UniversiteDetail[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            gestionVoeu.UniversiteDetailHelper.write(ostream,value[i7]);

        }
    }

}
