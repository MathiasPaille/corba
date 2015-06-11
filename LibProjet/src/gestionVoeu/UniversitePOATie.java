package gestionVoeu;

/**
 * Interface definition : Universite
 * 
 * @author OpenORB Compiler
 */
public class UniversitePOATie extends UniversitePOA
{

    //
    // Private reference to implementation object
    //
    private UniversiteOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public UniversitePOATie(UniversiteOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public UniversitePOATie(UniversiteOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public UniversiteOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(UniversiteOperations delegate_)
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
     * Operation consulterCandidatures
     */
    public gestionVoeu.CandidatureDetail[] consulterCandidatures()
    {
        return _tie.consulterCandidatures();
    }

    /**
     * Operation modifierCandidature
     */
    public void modifierCandidature(gestionVoeu.CandidatureDetail candidature, gestionVoeu.EtatDecision etatDecision)
    {
        _tie.modifierCandidature( candidature,  etatDecision);
    }

    /**
     * Operation getAffiliations
     */
    public int[] getAffiliations()
    {
        return _tie.getAffiliations();
    }

}
