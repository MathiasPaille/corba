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
     * Operation redistribuerCandidature
     */
    public void redistribuerCandidature(gestionVoeu.CandidatureDetail CD)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("redistribuerCandidature",true);
                    gestionVoeu.CandidatureDetailHelper.write(_output,CD);
                    _input = this._invoke(_output);
                    return;
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("redistribuerCandidature",_opsClass);
                if (_so == null)
                   continue;
                gestionVoeu.MinistereOperations _self = (gestionVoeu.MinistereOperations) _so.servant;
                try
                {
                    _self.redistribuerCandidature( CD);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation redistribuerVoeux
     */
    public void redistribuerVoeux(gestionVoeu.VoeuxDetail VD)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("redistribuerVoeux",true);
                    gestionVoeu.VoeuxDetailHelper.write(_output,VD);
                    _input = this._invoke(_output);
                    return;
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("redistribuerVoeux",_opsClass);
                if (_so == null)
                   continue;
                gestionVoeu.MinistereOperations _self = (gestionVoeu.MinistereOperations) _so.servant;
                try
                {
                    _self.redistribuerVoeux( VD);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
