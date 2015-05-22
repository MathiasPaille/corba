package gestionVoeu;

/** 
 * Helper class for : VoeuxList
 *  
 * @author OpenORB Compiler
 */ 
public class VoeuxListHelper
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
     * Insert VoeuxList into an any
     * @param a an any
     * @param t VoeuxList value
     */
    public static void insert(org.omg.CORBA.Any a, gestionVoeu.VoeuxDetail[] t)
    {
        a.insert_Streamable(new gestionVoeu.VoeuxListHolder(t));
    }

    /**
     * Extract VoeuxList from an any
     * @param a an any
     * @return the extracted VoeuxList value
     */
    public static gestionVoeu.VoeuxDetail[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof gestionVoeu.VoeuxListHolder)
                    return ((gestionVoeu.VoeuxListHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            gestionVoeu.VoeuxListHolder h = new gestionVoeu.VoeuxListHolder(read(a.create_input_stream()));
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
     * Return the VoeuxList TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"VoeuxList",orb.create_sequence_tc(0,gestionVoeu.VoeuxDetailHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the VoeuxList IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:gestionVoeu/VoeuxList:1.0";

    /**
     * Read VoeuxList from a marshalled stream
     * @param istream the input stream
     * @return the readed VoeuxList value
     */
    public static gestionVoeu.VoeuxDetail[] read(org.omg.CORBA.portable.InputStream istream)
    {
        gestionVoeu.VoeuxDetail[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new gestionVoeu.VoeuxDetail[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = gestionVoeu.VoeuxDetailHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write VoeuxList into a marshalled stream
     * @param ostream the output stream
     * @param value VoeuxList value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, gestionVoeu.VoeuxDetail[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            gestionVoeu.VoeuxDetailHelper.write(ostream,value[i7]);

        }
    }

}
