package gestionVoeu;

/** 
 * Helper class for : CandidatureDetail
 *  
 * @author OpenORB Compiler
 */ 
public class CandidatureDetailHelper
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
     * Insert CandidatureDetail into an any
     * @param a an any
     * @param t CandidatureDetail value
     */
    public static void insert(org.omg.CORBA.Any a, gestionVoeu.CandidatureDetail t)
    {
        a.insert_Streamable(new gestionVoeu.CandidatureDetailHolder(t));
    }

    /**
     * Extract CandidatureDetail from an any
     * @param a an any
     * @return the extracted CandidatureDetail value
     */
    public static gestionVoeu.CandidatureDetail extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof gestionVoeu.CandidatureDetailHolder)
                    return ((gestionVoeu.CandidatureDetailHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            gestionVoeu.CandidatureDetailHolder h = new gestionVoeu.CandidatureDetailHolder(read(a.create_input_stream()));
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
     * Return the CandidatureDetail TypeCode
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
                _members[0].name = "voeuxDetail";
                _members[0].type = gestionVoeu.VoeuxDetailHelper.type();
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "etatInscription";
                _members[1].type = gestionVoeu.EtatInscriptionHelper.type();
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "etatVoeu";
                _members[2].type = gestionVoeu.EtatVoeuHelper.type();
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "etatDecision";
                _members[3].type = gestionVoeu.EtatDecisionHelper.type();
                _tc = orb.create_struct_tc(id(),"CandidatureDetail",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the CandidatureDetail IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:gestionVoeu/CandidatureDetail:1.0";

    /**
     * Read CandidatureDetail from a marshalled stream
     * @param istream the input stream
     * @return the readed CandidatureDetail value
     */
    public static gestionVoeu.CandidatureDetail read(org.omg.CORBA.portable.InputStream istream)
    {
        gestionVoeu.CandidatureDetail new_one = new gestionVoeu.CandidatureDetail();

        new_one.voeuxDetail = gestionVoeu.VoeuxDetailHelper.read(istream);
        new_one.etatInscription = gestionVoeu.EtatInscriptionHelper.read(istream);
        new_one.etatVoeu = gestionVoeu.EtatVoeuHelper.read(istream);
        new_one.etatDecision = gestionVoeu.EtatDecisionHelper.read(istream);

        return new_one;
    }

    /**
     * Write CandidatureDetail into a marshalled stream
     * @param ostream the output stream
     * @param value CandidatureDetail value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, gestionVoeu.CandidatureDetail value)
    {
        gestionVoeu.VoeuxDetailHelper.write(ostream,value.voeuxDetail);
        gestionVoeu.EtatInscriptionHelper.write(ostream,value.etatInscription);
        gestionVoeu.EtatVoeuHelper.write(ostream,value.etatVoeu);
        gestionVoeu.EtatDecisionHelper.write(ostream,value.etatDecision);
    }

}
