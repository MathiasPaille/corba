package gestionVoeu;

/**
 * Interface definition : Academie
 * 
 * @author OpenORB Compiler
 */
public abstract class AcademiePOA extends org.omg.PortableServer.Servant
        implements AcademieOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Academie _this()
    {
        return AcademieHelper.narrow(_this_object());
    }

    public Academie _this(org.omg.CORBA.ORB orb)
    {
        return AcademieHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:gestionVoeu/Academie:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("creerCandidature")) {
                return _invoke_creerCandidature(_is, handler);
        } else if (opName.equals("deciderCandidature")) {
                return _invoke_deciderCandidature(_is, handler);
        } else if (opName.equals("getCandidatures")) {
                return _invoke_getCandidatures(_is, handler);
        } else if (opName.equals("traiter")) {
                return _invoke_traiter(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_traiter(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        gestionVoeu.CandidatureDetail arg0_in = gestionVoeu.CandidatureDetailHelper.read(_is);

        traiter(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_deciderCandidature(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        deciderCandidature(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getCandidatures(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        gestionVoeu.CandidatureDetail[] _arg_result = getCandidatures(arg0_in);

        _output = handler.createReply();
        gestionVoeu.CandidatureListHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_creerCandidature(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        gestionVoeu.EtudiantDetail arg0_in = gestionVoeu.EtudiantDetailHelper.read(_is);
        gestionVoeu.VoeuxDetail arg1_in = gestionVoeu.VoeuxDetailHelper.read(_is);

        creerCandidature(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

}
