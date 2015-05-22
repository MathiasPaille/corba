package gestionVoeu;

/**
 * Interface definition : Academie
 * 
 * @author OpenORB Compiler
 */
public class _AcademieStub extends org.omg.CORBA.portable.ObjectImpl
        implements Academie
{
    static final String[] _ids_list =
    {
        "IDL:gestionVoeu/Academie:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = gestionVoeu.AcademieOperations.class;

    /**
     * Operation traiter
     */
    public void traiter(gestionVoeu.CandidatureDetail CD)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("traiter",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("traiter",_opsClass);
                if (_so == null)
                   continue;
                gestionVoeu.AcademieOperations _self = (gestionVoeu.AcademieOperations) _so.servant;
                try
                {
                    _self.traiter( CD);
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
     * Operation deciderCandidature
     */
    public void deciderCandidature(String code, String etat)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("deciderCandidature",true);
                    _output.write_string(code);
                    _output.write_string(etat);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("deciderCandidature",_opsClass);
                if (_so == null)
                   continue;
                gestionVoeu.AcademieOperations _self = (gestionVoeu.AcademieOperations) _so.servant;
                try
                {
                    _self.deciderCandidature( code,  etat);
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
     * Operation getCandidatures
     */
    public gestionVoeu.CandidatureDetail[] getCandidatures(String code)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getCandidatures",true);
                    _output.write_string(code);
                    _input = this._invoke(_output);
                    gestionVoeu.CandidatureDetail[] _arg_ret = gestionVoeu.CandidatureListHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getCandidatures",_opsClass);
                if (_so == null)
                   continue;
                gestionVoeu.AcademieOperations _self = (gestionVoeu.AcademieOperations) _so.servant;
                try
                {
                    return _self.getCandidatures( code);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation creerCandidature
     */
    public void creerCandidature(gestionVoeu.EtudiantDetail EtuDetail, gestionVoeu.VoeuxDetail VDetail)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("creerCandidature",true);
                    gestionVoeu.EtudiantDetailHelper.write(_output,EtuDetail);
                    gestionVoeu.VoeuxDetailHelper.write(_output,VDetail);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("creerCandidature",_opsClass);
                if (_so == null)
                   continue;
                gestionVoeu.AcademieOperations _self = (gestionVoeu.AcademieOperations) _so.servant;
                try
                {
                    _self.creerCandidature( EtuDetail,  VDetail);
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
