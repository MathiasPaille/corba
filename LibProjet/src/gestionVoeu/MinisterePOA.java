package gestionVoeu;

/**
 * Interface definition : Ministere
 * 
 * @author OpenORB Compiler
 */
public abstract class MinisterePOA extends org.omg.PortableServer.Servant
        implements MinistereOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Ministere _this()
    {
        return MinistereHelper.narrow(_this_object());
    }

    public Ministere _this(org.omg.CORBA.ORB orb)
    {
        return MinistereHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:gestionVoeu/Ministere:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("getListDiplomes")) {
                return _invoke_getListDiplomes(_is, handler);
        } else if (opName.equals("redistribuerCandidature")) {
                return _invoke_redistribuerCandidature(_is, handler);
        } else if (opName.equals("redistribuerVoeux")) {
                return _invoke_redistribuerVoeux(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_getListDiplomes(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        gestionVoeu.DiplomeDetail[] _arg_result = getListDiplomes();

        _output = handler.createReply();
        gestionVoeu.DiplomeListHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_redistribuerCandidature(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        gestionVoeu.CandidatureDetail arg0_in = gestionVoeu.CandidatureDetailHelper.read(_is);

        redistribuerCandidature(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_redistribuerVoeux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        gestionVoeu.VoeuxDetail arg0_in = gestionVoeu.VoeuxDetailHelper.read(_is);

        redistribuerVoeux(arg0_in);

        _output = handler.createReply();

        return _output;
    }

}
