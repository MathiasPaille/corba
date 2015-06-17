package gestionVoeu;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public class _RectoratStub extends org.omg.CORBA.portable.ObjectImpl
        implements Rectorat
{
    static final String[] _ids_list =
    {
        "IDL:gestionVoeu/Rectorat:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = gestionVoeu.RectoratOperations.class;

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
                gestionVoeu.RectoratOperations _self = (gestionVoeu.RectoratOperations) _so.servant;
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

    /**
     * Operation creerVoeux
     */
    public void creerVoeux(gestionVoeu.VoeuxDetail monVoeux)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("creerVoeux",true);
                    gestionVoeu.VoeuxDetailHelper.write(_output,monVoeux);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("creerVoeux",_opsClass);
                if (_so == null)
                   continue;
                gestionVoeu.RectoratOperations _self = (gestionVoeu.RectoratOperations) _so.servant;
                try
                {
                    _self.creerVoeux( monVoeux);
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
     * Operation recupererVoeuxEtudiant
     */
    public gestionVoeu.CandidatureDetail[] recupererVoeuxEtudiant(String num_etu)
        throws gestionVoeu.compteInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("recupererVoeuxEtudiant",true);
                    _output.write_string(num_etu);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("recupererVoeuxEtudiant",_opsClass);
                if (_so == null)
                   continue;
                gestionVoeu.RectoratOperations _self = (gestionVoeu.RectoratOperations) _so.servant;
                try
                {
                    return _self.recupererVoeuxEtudiant( num_etu);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation recupererUniversite
     */
    public String[] recupererUniversite()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("recupererUniversite",true);
                    _input = this._invoke(_output);
                    String[] _arg_ret = gestionVoeu.ListeUniversiteHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("recupererUniversite",_opsClass);
                if (_so == null)
                   continue;
                gestionVoeu.RectoratOperations _self = (gestionVoeu.RectoratOperations) _so.servant;
                try
                {
                    return _self.recupererUniversite();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation recupererVoeuxMaster
     */
    public gestionVoeu.CandidatureDetail[] recupererVoeuxMaster(int master)
        throws gestionVoeu.diplomeInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("recupererVoeuxMaster",true);
                    _output.write_long(master);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("recupererVoeuxMaster",_opsClass);
                if (_so == null)
                   continue;
                gestionVoeu.RectoratOperations _self = (gestionVoeu.RectoratOperations) _so.servant;
                try
                {
                    return _self.recupererVoeuxMaster( master);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation modifierCandidatureEtat
     */
    public void modifierCandidatureEtat(gestionVoeu.CandidatureDetail maCandidature)
        throws gestionVoeu.malformedInformation
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modifierCandidatureEtat",true);
                    gestionVoeu.CandidatureDetailHelper.write(_output,maCandidature);
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
                    if (_exception_id.equals(gestionVoeu.malformedInformationHelper.id()))
                    {
                        throw gestionVoeu.malformedInformationHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("modifierCandidatureEtat",_opsClass);
                if (_so == null)
                   continue;
                gestionVoeu.RectoratOperations _self = (gestionVoeu.RectoratOperations) _so.servant;
                try
                {
                    _self.modifierCandidatureEtat( maCandidature);
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
     * Operation redistribuerCandidature
     */
    public void redistribuerCandidature(int mandant, gestionVoeu.CandidatureDetail CD)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("redistribuerCandidature",true);
                    _output.write_long(mandant);
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
                gestionVoeu.RectoratOperations _self = (gestionVoeu.RectoratOperations) _so.servant;
                try
                {
                    _self.redistribuerCandidature( mandant,  CD);
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
