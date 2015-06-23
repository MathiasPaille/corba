package gestionVoeu;

/** 
 * Helper class for : VoeuxDetail
 *  
 * @author OpenORB Compiler
 */ 
public class VoeuxDetailHelper
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
     * Insert VoeuxDetail into an any
     * @param a an any
     * @param t VoeuxDetail value
     */
    public static void insert(org.omg.CORBA.Any a, gestionVoeu.VoeuxDetail t)
    {
        a.insert_Streamable(new gestionVoeu.VoeuxDetailHolder(t));
    }

    /**
     * Extract VoeuxDetail from an any
     * @param a an any
     * @return the extracted VoeuxDetail value
     */
    public static gestionVoeu.VoeuxDetail extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof gestionVoeu.VoeuxDetailHolder)
                    return ((gestionVoeu.VoeuxDetailHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            gestionVoeu.VoeuxDetailHolder h = new gestionVoeu.VoeuxDetailHolder(read(a.create_input_stream()));
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
     * Return the VoeuxDetail TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[5];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "master";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "universite";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "rectorat";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "classement";
                _members[3].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[4] = new org.omg.CORBA.StructMember();
                _members[4].name = "etu";
                _members[4].type = gestionVoeu.EtudiantDetailHelper.type();
                _tc = orb.create_struct_tc(id(),"VoeuxDetail",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the VoeuxDetail IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:gestionVoeu/VoeuxDetail:1.0";

    /**
     * Read VoeuxDetail from a marshalled stream
     * @param istream the input stream
     * @return the readed VoeuxDetail value
     */
    public static gestionVoeu.VoeuxDetail read(org.omg.CORBA.portable.InputStream istream)
    {
        gestionVoeu.VoeuxDetail new_one = new gestionVoeu.VoeuxDetail();

        new_one.master = istream.read_long();
        new_one.universite = istream.read_string();
        new_one.rectorat = istream.read_string();
        new_one.classement = istream.read_long();
        new_one.etu = gestionVoeu.EtudiantDetailHelper.read(istream);

        return new_one;
    }

    /**
     * Write VoeuxDetail into a marshalled stream
     * @param ostream the output stream
     * @param value VoeuxDetail value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, gestionVoeu.VoeuxDetail value)
    {
        ostream.write_long(value.master);
        ostream.write_string(value.universite);
        ostream.write_string(value.rectorat);
        ostream.write_long(value.classement);
        gestionVoeu.EtudiantDetailHelper.write(ostream,value.etu);
    }

}
