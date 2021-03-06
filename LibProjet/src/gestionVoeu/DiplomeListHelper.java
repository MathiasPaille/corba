package gestionVoeu;

/** 
 * Helper class for : DiplomeList
 *  
 * @author OpenORB Compiler
 */ 
public class DiplomeListHelper
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
     * Insert DiplomeList into an any
     * @param a an any
     * @param t DiplomeList value
     */
    public static void insert(org.omg.CORBA.Any a, gestionVoeu.DiplomeDetail[] t)
    {
        a.insert_Streamable(new gestionVoeu.DiplomeListHolder(t));
    }

    /**
     * Extract DiplomeList from an any
     * @param a an any
     * @return the extracted DiplomeList value
     */
    public static gestionVoeu.DiplomeDetail[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof gestionVoeu.DiplomeListHolder)
                    return ((gestionVoeu.DiplomeListHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            gestionVoeu.DiplomeListHolder h = new gestionVoeu.DiplomeListHolder(read(a.create_input_stream()));
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
     * Return the DiplomeList TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"DiplomeList",orb.create_sequence_tc(0,gestionVoeu.DiplomeDetailHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the DiplomeList IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:gestionVoeu/DiplomeList:1.0";

    /**
     * Read DiplomeList from a marshalled stream
     * @param istream the input stream
     * @return the readed DiplomeList value
     */
    public static gestionVoeu.DiplomeDetail[] read(org.omg.CORBA.portable.InputStream istream)
    {
        gestionVoeu.DiplomeDetail[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new gestionVoeu.DiplomeDetail[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = gestionVoeu.DiplomeDetailHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write DiplomeList into a marshalled stream
     * @param ostream the output stream
     * @param value DiplomeList value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, gestionVoeu.DiplomeDetail[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            gestionVoeu.DiplomeDetailHelper.write(ostream,value[i7]);

        }
    }

}
