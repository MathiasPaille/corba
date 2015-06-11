package gestionVoeu;

/**
 * Interface definition : Universite
 * 
 * @author OpenORB Compiler
 */
public abstract class UniversitePOA extends org.omg.PortableServer.Servant
        implements UniversiteOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Universite _this()
    {
        return UniversiteHelper.narrow(_this_object());
    }

    public Universite _this(org.omg.CORBA.ORB orb)
    {
        return UniversiteHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:gestionVoeu/Universite:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("consulterCandidatures")) {
                return _invoke_consulterCandidatures(_is, handler);
        } else if (opName.equals("getAffiliations")) {
                return _invoke_getAffiliations(_is, handler);
        } else if (opName.equals("modifierCandidature")) {
                return _invoke_modifierCandidature(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_consulterCandidatures(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        gestionVoeu.CandidatureDetail[] _arg_result = consulterCandidatures();

        _output = handler.createReply();
        gestionVoeu.CandidatureListHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_modifierCandidature(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        gestionVoeu.CandidatureDetail arg0_in = gestionVoeu.CandidatureDetailHelper.read(_is);
        gestionVoeu.EtatDecision arg1_in = gestionVoeu.EtatDecisionHelper.read(_is);

        modifierCandidature(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getAffiliations(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        int[] _arg_result = getAffiliations();

        _output = handler.createReply();
        gestionVoeu.AffiliationMasterListHelper.write(_output,_arg_result);

        return _output;
    }

}
