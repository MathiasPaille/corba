package gestionVoeu;

/** 
 * Helper class for : DiplomeDetail
 *  
 * @author OpenORB Compiler
 */ 
public class DiplomeDetailHelper
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
     * Insert DiplomeDetail into an any
     * @param a an any
     * @param t DiplomeDetail value
     */
    public static void insert(org.omg.CORBA.Any a, gestionVoeu.DiplomeDetail t)
    {
        a.insert_Streamable(new gestionVoeu.DiplomeDetailHolder(t));
    }

    /**
     * Extract DiplomeDetail from an any
     * @param a an any
     * @return the extracted DiplomeDetail value
     */
    public static gestionVoeu.DiplomeDetail extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof gestionVoeu.DiplomeDetailHolder)
                    return ((gestionVoeu.DiplomeDetailHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            gestionVoeu.DiplomeDetailHolder h = new gestionVoeu.DiplomeDetailHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;
    private static boolean _working = false;

    /**
     * Return the DiplomeDetail TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            synchronized(org.omg.CORBA.TypeCode.class) {
                if (_tc != null)
                    return _tc;
                if (_working)
                    return org.omg.CORBA.ORB.init().create_recursive_tc(id());
                _working = true;
                org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[2];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "id";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "libelle";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_struct_tc(id(),"DiplomeDetail",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the DiplomeDetail IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:gestionVoeu/DiplomeDetail:1.0";

    /**
     * Read DiplomeDetail from a marshalled stream
     * @param istream the input stream
     * @return the readed DiplomeDetail value
     */
    public static gestionVoeu.DiplomeDetail read(org.omg.CORBA.portable.InputStream istream)
    {
        gestionVoeu.DiplomeDetail new_one = new gestionVoeu.DiplomeDetail();

        new_one.id = istream.read_long();
        new_one.libelle = istream.read_string();

        return new_one;
    }

    /**
     * Write DiplomeDetail into a marshalled stream
     * @param ostream the output stream
     * @param value DiplomeDetail value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, gestionVoeu.DiplomeDetail value)
    {
        ostream.write_long(value.id);
        ostream.write_string(value.libelle);
    }

}
