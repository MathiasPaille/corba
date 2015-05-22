package gestionVoeu;

/**
 * Interface definition : EtudiantFactory
 * 
 * @author OpenORB Compiler
 */
public abstract class EtudiantFactoryPOA extends org.omg.PortableServer.Servant
        implements EtudiantFactoryOperations, org.omg.CORBA.portable.InvokeHandler
{
    public EtudiantFactory _this()
    {
        return EtudiantFactoryHelper.narrow(_this_object());
    }

    public EtudiantFactory _this(org.omg.CORBA.ORB orb)
    {
        return EtudiantFactoryHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:gestionVoeu/EtudiantFactory:1.0"
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
        } else if (opName.equals("creerCandidature")) {
                return _invoke_creerCandidature(_is, handler);
        } else if (opName.equals("getCandidatures")) {
                return _invoke_getCandidatures(_is, handler);
        } else if (opName.equals("getSemestres")) {
                return _invoke_getSemestres(_is, handler);
        } else if (opName.equals("modifierCandidature")) {
                return _invoke_modifierCandidature(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_getCandidatures(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        gestionVoeu.EtudiantDetail arg0_in = gestionVoeu.EtudiantDetailHelper.read(_is);

        try
        {
            gestionVoeu.CandidatureDetail[] _arg_result = getCandidatures(arg0_in);

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

    private org.omg.CORBA.portable.OutputStream _invoke_getSemestres(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        gestionVoeu.EtudiantDetail arg0_in = gestionVoeu.EtudiantDetailHelper.read(_is);

        try
        {
            gestionVoeu.SemestreDetail[] _arg_result = getSemestres(arg0_in);

            _output = handler.createReply();
            gestionVoeu.SemestreListHelper.write(_output,_arg_result);

        }
        catch (gestionVoeu.compteInconnu _exception)
        {
            _output = handler.createExceptionReply();
            gestionVoeu.compteInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_creerCandidature(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        gestionVoeu.CandidatureDetail arg0_in = gestionVoeu.CandidatureDetailHelper.read(_is);

        try
        {
            creerCandidature(arg0_in);

            _output = handler.createReply();

        }
        catch (gestionVoeu.diplomeInconnu _exception)
        {
            _output = handler.createExceptionReply();
            gestionVoeu.diplomeInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_modifierCandidature(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        gestionVoeu.CandidatureDetail arg0_in = gestionVoeu.CandidatureDetailHelper.read(_is);
        gestionVoeu.EtatVoeu arg1_in = gestionVoeu.EtatVoeuHelper.read(_is);

        try
        {
            modifierCandidature(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (gestionVoeu.voeuInconnu _exception)
        {
            _output = handler.createExceptionReply();
            gestionVoeu.voeuInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

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

}
