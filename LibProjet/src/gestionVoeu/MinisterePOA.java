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
        } else if (opName.equals("getListRectorats")) {
                return _invoke_getListRectorats(_is, handler);
        } else if (opName.equals("getPhase")) {
                return _invoke_getPhase(_is, handler);
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

    private org.omg.CORBA.portable.OutputStream _invoke_getListRectorats(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        gestionVoeu.RectoratDetail[] _arg_result = getListRectorats();

        _output = handler.createReply();
        gestionVoeu.ListeRectoratHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getPhase(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        gestionVoeu.Phase _arg_result = getPhase();

        _output = handler.createReply();
        gestionVoeu.PhaseHelper.write(_output,_arg_result);

        return _output;
    }

}
