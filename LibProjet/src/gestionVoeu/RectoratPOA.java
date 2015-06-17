package gestionVoeu;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public abstract class RectoratPOA extends org.omg.PortableServer.Servant
        implements RectoratOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Rectorat _this()
    {
        return RectoratHelper.narrow(_this_object());
    }

    public Rectorat _this(org.omg.CORBA.ORB orb)
    {
        return RectoratHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:gestionVoeu/Rectorat:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("connexion")) {
                return _invoke_connexion(_is, handler);
        } else if (opName.equals("creerVoeux")) {
                return _invoke_creerVoeux(_is, handler);
        } else if (opName.equals("modifierCandidatureEtat")) {
                return _invoke_modifierCandidatureEtat(_is, handler);
        } else if (opName.equals("recupererUniversite")) {
                return _invoke_recupererUniversite(_is, handler);
        } else if (opName.equals("recupererVoeuxEtudiant")) {
                return _invoke_recupererVoeuxEtudiant(_is, handler);
        } else if (opName.equals("recupererVoeuxMaster")) {
                return _invoke_recupererVoeuxMaster(_is, handler);
        } else if (opName.equals("redistribuerCandidature")) {
                return _invoke_redistribuerCandidature(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_connexion(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        try
        {
            gestionVoeu.EtudiantDetail _arg_result = connexion(arg0_in, arg1_in);

            _output = handler.createReply();
            gestionVoeu.EtudiantDetailHelper.write(_output,_arg_result);

        }
        catch (gestionVoeu.compteInconnu _exception)
        {
            _output = handler.createExceptionReply();
            gestionVoeu.compteInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_creerVoeux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        gestionVoeu.VoeuxDetail arg0_in = gestionVoeu.VoeuxDetailHelper.read(_is);

        creerVoeux(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_recupererVoeuxEtudiant(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        try
        {
            gestionVoeu.CandidatureDetail[] _arg_result = recupererVoeuxEtudiant(arg0_in);

            _output = handler.createReply();
            gestionVoeu.CandidatureListHelper.write(_output,_arg_result);

        }
        catch (gestionVoeu.compteInconnu _exception)
        {
            _output = handler.createExceptionReply();
            gestionVoeu.compteInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_recupererUniversite(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        String[] _arg_result = recupererUniversite();

        _output = handler.createReply();
        gestionVoeu.ListeUniversiteHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_recupererVoeuxMaster(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();

        try
        {
            gestionVoeu.CandidatureDetail[] _arg_result = recupererVoeuxMaster(arg0_in);

            _output = handler.createReply();
            gestionVoeu.CandidatureListHelper.write(_output,_arg_result);

        }
        catch (gestionVoeu.diplomeInconnu _exception)
        {
            _output = handler.createExceptionReply();
            gestionVoeu.diplomeInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_modifierCandidatureEtat(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        gestionVoeu.CandidatureDetail arg0_in = gestionVoeu.CandidatureDetailHelper.read(_is);

        try
        {
            modifierCandidatureEtat(arg0_in);

            _output = handler.createReply();

        }
        catch (gestionVoeu.malformedInformation _exception)
        {
            _output = handler.createExceptionReply();
            gestionVoeu.malformedInformationHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_redistribuerCandidature(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        gestionVoeu.CandidatureDetail arg1_in = gestionVoeu.CandidatureDetailHelper.read(_is);

        redistribuerCandidature(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

}
