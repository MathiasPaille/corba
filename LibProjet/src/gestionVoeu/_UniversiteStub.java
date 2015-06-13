package gestionVoeu;

/**
 * Interface definition : Universite
 * 
 * @author OpenORB Compiler
 */
public class _UniversiteStub extends org.omg.CORBA.portable.ObjectImpl
        implements Universite
{
    static final String[] _ids_list =
    {
        "IDL:gestionVoeu/Universite:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = gestionVoeu.UniversiteOperations.class;

    /**
     * Operation getAffiliations
     */
    public int[] getAffiliations()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getAffiliations",true);
                    _input = this._invoke(_output);
                    int[] _arg_ret = gestionVoeu.AffiliationMasterListHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getAffiliations",_opsClass);
                if (_so == null)
                   continue;
                gestionVoeu.UniversiteOperations _self = (gestionVoeu.UniversiteOperations) _so.servant;
                try
                {
                    return _self.getAffiliations();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
