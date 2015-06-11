package gestionVoeu;

/** 
 * Helper class for : SemestreDetail
 *  
 * @author OpenORB Compiler
 */ 
public class SemestreDetailHelper
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
     * Insert SemestreDetail into an any
     * @param a an any
     * @param t SemestreDetail value
     */
    public static void insert(org.omg.CORBA.Any a, gestionVoeu.SemestreDetail t)
    {
        a.insert_Streamable(new gestionVoeu.SemestreDetailHolder(t));
    }

    /**
     * Extract SemestreDetail from an any
     * @param a an any
     * @return the extracted SemestreDetail value
     */
    public static gestionVoeu.SemestreDetail extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof gestionVoeu.SemestreDetailHolder)
                    return ((gestionVoeu.SemestreDetailHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            gestionVoeu.SemestreDetailHolder h = new gestionVoeu.SemestreDetailHolder(read(a.create_input_stream()));
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
     * Return the SemestreDetail TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[4];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "moyenne";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_float);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "quartile";
                _members[1].type = gestionVoeu.QuartileHelper.type();
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "moyenObtention";
                _members[2].type = gestionVoeu.MoyenObtentionHelper.type();
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "numSemestre";
                _members[3].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _tc = orb.create_struct_tc(id(),"SemestreDetail",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the SemestreDetail IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:gestionVoeu/SemestreDetail:1.0";

    /**
     * Read SemestreDetail from a marshalled stream
     * @param istream the input stream
     * @return the readed SemestreDetail value
     */
    public static gestionVoeu.SemestreDetail read(org.omg.CORBA.portable.InputStream istream)
    {
        gestionVoeu.SemestreDetail new_one = new gestionVoeu.SemestreDetail();

        new_one.moyenne = istream.read_float();
        new_one.quartile = gestionVoeu.QuartileHelper.read(istream);
        new_one.moyenObtention = gestionVoeu.MoyenObtentionHelper.read(istream);
        new_one.numSemestre = istream.read_long();

        return new_one;
    }

    /**
     * Write SemestreDetail into a marshalled stream
     * @param ostream the output stream
     * @param value SemestreDetail value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, gestionVoeu.SemestreDetail value)
    {
        ostream.write_float(value.moyenne);
        gestionVoeu.QuartileHelper.write(ostream,value.quartile);
        gestionVoeu.MoyenObtentionHelper.write(ostream,value.moyenObtention);
        ostream.write_long(value.numSemestre);
    }

}
