package gestionVoeu;

/**
 * Interface definition : Ministere
 * 
 * @author OpenORB Compiler
 */
public class _MinistereStub extends org.omg.CORBA.portable.ObjectImpl
        implements Ministere
{
    static final String[] _ids_list =
    {
        "IDL:gestionVoeu/Ministere:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = gestionVoeu.MinistereOperations.class;

    /**
     * Operation getListDiplomes
     */
    public gestionVoeu.DiplomeDetail[] getListDiplomes()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getListDiplomes",true);
                    _input = this._invoke(_output);
                    gestionVoeu.DiplomeDetail[] _arg_ret = gestionVoeu.DiplomeListHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getListDiplomes",_opsClass);
                if (_so == null)
                   continue;
                gestionVoeu.MinistereOperations _self = (gestionVoeu.MinistereOperations) _so.servant;
                try
                {
                    return _self.getListDiplomes();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getListRectorats
     */
    public gestionVoeu.RectoratDetail[] getListRectorats()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getListRectorats",true);
                    _input = this._invoke(_output);
                    gestionVoeu.RectoratDetail[] _arg_ret = gestionVoeu.ListeRectoratHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getListRectorats",_opsClass);
                if (_so == null)
                   continue;
                gestionVoeu.MinistereOperations _self = (gestionVoeu.MinistereOperations) _so.servant;
                try
                {
                    return _self.getListRectorats();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getPhase
     */
    public gestionVoeu.Phase getPhase()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getPhase",true);
                    _input = this._invoke(_output);
                    gestionVoeu.Phase _arg_ret = gestionVoeu.PhaseHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPhase",_opsClass);
                if (_so == null)
                   continue;
                gestionVoeu.MinistereOperations _self = (gestionVoeu.MinistereOperations) _so.servant;
                try
                {
                    return _self.getPhase();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
