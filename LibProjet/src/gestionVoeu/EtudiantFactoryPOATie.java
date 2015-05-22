package gestionVoeu;

/**
 * Interface definition : EtudiantFactory
 * 
 * @author OpenORB Compiler
 */
public class EtudiantFactoryPOATie extends EtudiantFactoryPOA
{

    //
    // Private reference to implementation object
    //
    private EtudiantFactoryOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public EtudiantFactoryPOATie(EtudiantFactoryOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public EtudiantFactoryPOATie(EtudiantFactoryOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public EtudiantFactoryOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(EtudiantFactoryOperations delegate_)
    {
        _tie = delegate_;
    }

    /**
     * _default_POA method
     */
    public org.omg.PortableServer.POA _default_POA()
    {
        if (_poa != null)
            return _poa;
        else
            return super._default_POA();
    }

    /**
     * Operation getCandidatures
     */
    public gestionVoeu.CandidatureDetail[] getCandidatures(gestionVoeu.EtudiantDetail etu)
        throws gestionVoeu.compteInconnu
    {
        return _tie.getCandidatures( etu);
    }

    /**
     * Operation getSemestres
     */
    public gestionVoeu.SemestreDetail[] getSemestres(gestionVoeu.EtudiantDetail etu)
        throws gestionVoeu.compteInconnu
    {
        return _tie.getSemestres( etu);
    }

    /**
     * Operation creerCandidature
     */
    public void creerCandidature(gestionVoeu.CandidatureDetail candidature)
        throws gestionVoeu.diplomeInconnu
    {
        _tie.creerCandidature( candidature);
    }

    /**
     * Operation modifierCandidature
     */
    public void modifierCandidature(gestionVoeu.CandidatureDetail candidature, gestionVoeu.EtatVoeu voeuEtu)
        throws gestionVoeu.voeuInconnu
    {
        _tie.modifierCandidature( candidature,  voeuEtu);
    }

    /**
     * Operation connexion
     */
    public gestionVoeu.EtudiantDetail connexion(String num_etu, String pwd)
        throws gestionVoeu.compteInconnu
    {
        return _tie.connexion( num_etu,  pwd);
    }

}
