package gestionVoeu;

/**
 * Interface definition : EtudiantFactory
 * 
 * @author OpenORB Compiler
 */
public class _EtudiantFactoryStub extends org.omg.CORBA.portable.ObjectImpl
        implements EtudiantFactory
{
    static final String[] _ids_list =
    {
        "IDL:gestionVoeu/EtudiantFactory:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = gestionVoeu.EtudiantFactoryOperations.class;

    /**
     * Operation getCandidatures
     */
    public gestionVoeu.CandidatureDetail[] getCandidatures(gestionVoeu.EtudiantDetail etu)
        throws gestionVoeu.compteInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getCandidatures",true);
                    gestionVoeu.EtudiantDetailHelper.write(_output,etu);
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
                    if (_exception_id.equals(gestionVoeu.compteInconnuHelper.id()))
                    {
                        throw gestionVoeu.compteInconnuHelper.read(_exception.getInputStream());
                    }

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
                gestionVoeu.EtudiantFactoryOperations _self = (gestionVoeu.EtudiantFactoryOperations) _so.servant;
                try
                {
                    return _self.getCandidatures( etu);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getSemestres
     */
    public gestionVoeu.SemestreDetail[] getSemestres(gestionVoeu.EtudiantDetail etu)
        throws gestionVoeu.compteInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getSemestres",true);
                    gestionVoeu.EtudiantDetailHelper.write(_output,etu);
                    _input = this._invoke(_output);
                    gestionVoeu.SemestreDetail[] _arg_ret = gestionVoeu.SemestreListHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(gestionVoeu.compteInconnuHelper.id()))
                    {
                        throw gestionVoeu.compteInconnuHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getSemestres",_opsClass);
                if (_so == null)
                   continue;
                gestionVoeu.EtudiantFactoryOperations _self = (gestionVoeu.EtudiantFactoryOperations) _so.servant;
                try
                {
                    return _self.getSemestres( etu);
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
    public void creerCandidature(gestionVoeu.CandidatureDetail candidature)
        throws gestionVoeu.diplomeInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("creerCandidature",true);
                    gestionVoeu.CandidatureDetailHelper.write(_output,candidature);
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
                    if (_exception_id.equals(gestionVoeu.diplomeInconnuHelper.id()))
                    {
                        throw gestionVoeu.diplomeInconnuHelper.read(_exception.getInputStream());
                    }

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
                gestionVoeu.EtudiantFactoryOperations _self = (gestionVoeu.EtudiantFactoryOperations) _so.servant;
                try
                {
                    _self.creerCandidature( candidature);
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
     * Operation modifierCandidature
     */
    public void modifierCandidature(gestionVoeu.CandidatureDetail candidature, gestionVoeu.EtatVoeu voeuEtu)
        throws gestionVoeu.voeuInconnu
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
                    gestionVoeu.EtatVoeuHelper.write(_output,voeuEtu);
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
                    if (_exception_id.equals(gestionVoeu.voeuInconnuHelper.id()))
                    {
                        throw gestionVoeu.voeuInconnuHelper.read(_exception.getInputStream());
                    }

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
                gestionVoeu.EtudiantFactoryOperations _self = (gestionVoeu.EtudiantFactoryOperations) _so.servant;
                try
                {
                    _self.modifierCandidature( candidature,  voeuEtu);
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
     * Operation connexion
     */
    public gestionVoeu.EtudiantDetail connexion(String num_etu, String pwd)
        throws gestionVoeu.compteInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("connexion",true);
                    _output.write_string(num_etu);
                    _output.write_string(pwd);
                    _input = this._invoke(_output);
                    gestionVoeu.EtudiantDetail _arg_ret = gestionVoeu.EtudiantDetailHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(gestionVoeu.compteInconnuHelper.id()))
                    {
                        throw gestionVoeu.compteInconnuHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("connexion",_opsClass);
                if (_so == null)
                   continue;
                gestionVoeu.EtudiantFactoryOperations _self = (gestionVoeu.EtudiantFactoryOperations) _so.servant;
                try
                {
                    return _self.connexion( num_etu,  pwd);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
