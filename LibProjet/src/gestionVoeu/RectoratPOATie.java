package gestionVoeu;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public class RectoratPOATie extends RectoratPOA
{

    //
    // Private reference to implementation object
    //
    private RectoratOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public RectoratPOATie(RectoratOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public RectoratPOATie(RectoratOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public RectoratOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(RectoratOperations delegate_)
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
     * Operation creerVoeux
     */
    public void creerVoeux(gestionVoeu.VoeuxDetail monVoeux)
    {
        _tie.creerVoeux( monVoeux);
    }

    /**
     * Operation recupererVoeuxMaster
     */
    public gestionVoeu.VoeuxDetail[] recupererVoeuxMaster(int master)
        throws gestionVoeu.diplomeInconnu
    {
        return _tie.recupererVoeuxMaster( master);
    }

    /**
     * Operation recupererVoeuxEtudiant
     */
    public gestionVoeu.VoeuxDetail[] recupererVoeuxEtudiant(int num_etu)
        throws gestionVoeu.compteInconnu
    {
        return _tie.recupererVoeuxEtudiant( num_etu);
    }

    /**
     * Operation recupererEtatCandidatures
     */
    public gestionVoeu.CandidatureDetail[] recupererEtatCandidatures(gestionVoeu.VoeuxDetail[] listeVoeux)
        throws gestionVoeu.voeuInconnu
    {
        return _tie.recupererEtatCandidatures( listeVoeux);
    }

    /**
     * Operation modifierCandidatureEtat
     */
    public void modifierCandidatureEtat(gestionVoeu.CandidatureDetail maCandidature)
        throws gestionVoeu.malformedInformation
    {
        _tie.modifierCandidatureEtat( maCandidature);
    }

}
