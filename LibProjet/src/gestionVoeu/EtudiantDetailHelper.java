package gestionVoeu;

/** 
 * Helper class for : EtudiantDetail
 *  
 * @author OpenORB Compiler
 */ 
public class EtudiantDetailHelper
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
     * Insert EtudiantDetail into an any
     * @param a an any
     * @param t EtudiantDetail value
     */
    public static void insert(org.omg.CORBA.Any a, gestionVoeu.EtudiantDetail t)
    {
        a.insert_Streamable(new gestionVoeu.EtudiantDetailHolder(t));
    }

    /**
     * Extract EtudiantDetail from an any
     * @param a an any
     * @return the extracted EtudiantDetail value
     */
    public static gestionVoeu.EtudiantDetail extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof gestionVoeu.EtudiantDetailHolder)
                    return ((gestionVoeu.EtudiantDetailHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            gestionVoeu.EtudiantDetailHolder h = new gestionVoeu.EtudiantDetailHolder(read(a.create_input_stream()));
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
     * Return the EtudiantDetail TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[7];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "num_etudiant";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "nom";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "prenom";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "adresse";
                _members[3].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[4] = new org.omg.CORBA.StructMember();
                _members[4].name = "universite";
                _members[4].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[5] = new org.omg.CORBA.StructMember();
                _members[5].name = "license";
                _members[5].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[6] = new org.omg.CORBA.StructMember();
                _members[6].name = "listeSeum";
                _members[6].type = gestionVoeu.SemestreListHelper.type();
                _tc = orb.create_struct_tc(id(),"EtudiantDetail",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the EtudiantDetail IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:gestionVoeu/EtudiantDetail:1.0";

    /**
     * Read EtudiantDetail from a marshalled stream
     * @param istream the input stream
     * @return the readed EtudiantDetail value
     */
    public static gestionVoeu.EtudiantDetail read(org.omg.CORBA.portable.InputStream istream)
    {
        gestionVoeu.EtudiantDetail new_one = new gestionVoeu.EtudiantDetail();

        new_one.num_etudiant = istream.read_string();
        new_one.nom = istream.read_string();
        new_one.prenom = istream.read_string();
        new_one.adresse = istream.read_string();
        new_one.universite = istream.read_long();
        new_one.license = istream.read_long();
        new_one.listeSeum = gestionVoeu.SemestreListHelper.read(istream);

        return new_one;
    }

    /**
     * Write EtudiantDetail into a marshalled stream
     * @param ostream the output stream
     * @param value EtudiantDetail value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, gestionVoeu.EtudiantDetail value)
    {
        ostream.write_string(value.num_etudiant);
        ostream.write_string(value.nom);
        ostream.write_string(value.prenom);
        ostream.write_string(value.adresse);
        ostream.write_long(value.universite);
        ostream.write_long(value.license);
        gestionVoeu.SemestreListHelper.write(ostream,value.listeSeum);
    }

}
