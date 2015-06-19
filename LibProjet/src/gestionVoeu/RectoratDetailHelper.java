package gestionVoeu;

/** 
 * Helper class for : RectoratDetail
 *  
 * @author OpenORB Compiler
 */ 
public class RectoratDetailHelper
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
     * Insert RectoratDetail into an any
     * @param a an any
     * @param t RectoratDetail value
     */
    public static void insert(org.omg.CORBA.Any a, gestionVoeu.RectoratDetail t)
    {
        a.insert_Streamable(new gestionVoeu.RectoratDetailHolder(t));
    }

    /**
     * Extract RectoratDetail from an any
     * @param a an any
     * @return the extracted RectoratDetail value
     */
    public static gestionVoeu.RectoratDetail extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof gestionVoeu.RectoratDetailHolder)
                    return ((gestionVoeu.RectoratDetailHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            gestionVoeu.RectoratDetailHolder h = new gestionVoeu.RectoratDetailHolder(read(a.create_input_stream()));
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
     * Return the RectoratDetail TypeCode
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
                _tc = orb.create_struct_tc(id(),"RectoratDetail",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the RectoratDetail IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:gestionVoeu/RectoratDetail:1.0";

    /**
     * Read RectoratDetail from a marshalled stream
     * @param istream the input stream
     * @return the readed RectoratDetail value
     */
    public static gestionVoeu.RectoratDetail read(org.omg.CORBA.portable.InputStream istream)
    {
        gestionVoeu.RectoratDetail new_one = new gestionVoeu.RectoratDetail();

        new_one.id = istream.read_string();
        new_one.name = istream.read_string();

        return new_one;
    }

    /**
     * Write RectoratDetail into a marshalled stream
     * @param ostream the output stream
     * @param value RectoratDetail value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, gestionVoeu.RectoratDetail value)
    {
        ostream.write_string(value.id);
        ostream.write_string(value.name);
    }

}
