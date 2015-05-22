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
     * Operation consulterCandidatures
     */
    public gestionVoeu.CandidatureDetail[] consulterCandidatures()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("consulterCandidatures",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("consulterCandidatures",_opsClass);
                if (_so == null)
                   continue;
                gestionVoeu.UniversiteOperations _self = (gestionVoeu.UniversiteOperations) _so.servant;
                try
                {
                    return _self.consulterCandidatures();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation modifierCandidature
     */
    public void modifierCandidature(gestionVoeu.CandidatureDetail candidature, gestionVoeu.EtatDecision etatDecision)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modifierCandidature",true);
                    gestionVoeu.CandidatureDetailHelper.write(_output,candidature);
                    gestionVoeu.EtatDecisionHelper.write(_output,etatDecision);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("modifierCandidature",_opsClass);
                if (_so == null)
                   continue;
                gestionVoeu.UniversiteOperations _self = (gestionVoeu.UniversiteOperations) _so.servant;
                try
                {
                    _self.modifierCandidature( candidature,  etatDecision);
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
