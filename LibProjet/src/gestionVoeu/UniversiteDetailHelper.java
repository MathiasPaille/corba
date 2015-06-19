package gestionVoeu;

/** 
 * Helper class for : UniversiteDetail
 *  
 * @author OpenORB Compiler
 */ 
public class UniversiteDetailHelper
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
     * Insert UniversiteDetail into an any
     * @param a an any
     * @param t UniversiteDetail value
     */
    public static void insert(org.omg.CORBA.Any a, gestionVoeu.UniversiteDetail t)
    {
        a.insert_Streamable(new gestionVoeu.UniversiteDetailHolder(t));
    }

    /**
     * Extract UniversiteDetail from an any
     * @param a an any
     * @return the extracted UniversiteDetail value
     */
    public static gestionVoeu.UniversiteDetail extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof gestionVoeu.UniversiteDetailHolder)
                    return ((gestionVoeu.UniversiteDetailHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            gestionVoeu.UniversiteDetailHolder h = new gestionVoeu.UniversiteDetailHolder(read(a.create_input_stream()));
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
     * Return the UniversiteDetail TypeCode
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
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "name";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_struct_tc(id(),"UniversiteDetail",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the UniversiteDetail IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:gestionVoeu/UniversiteDetail:1.0";

    /**
     * Read UniversiteDetail from a marshalled stream
     * @param istream the input stream
     * @return the readed UniversiteDetail value
     */
    public static gestionVoeu.UniversiteDetail read(org.omg.CORBA.portable.InputStream istream)
    {
        gestionVoeu.UniversiteDetail new_one = new gestionVoeu.UniversiteDetail();

        new_one.id = istream.read_string();
        new_one.name = istream.read_string();

        return new_one;
    }

    /**
     * Write UniversiteDetail into a marshalled stream
     * @param ostream the output stream
     * @param value UniversiteDetail value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, gestionVoeu.UniversiteDetail value)
    {
        ostream.write_string(value.id);
        ostream.write_string(value.name);
    }

}
