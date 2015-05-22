package gestionVoeu;

/**
 * Interface definition : Academie
 * 
 * @author OpenORB Compiler
 */
public class AcademiePOATie extends AcademiePOA
{

    //
    // Private reference to implementation object
    //
    private AcademieOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public AcademiePOATie(AcademieOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public AcademiePOATie(AcademieOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public AcademieOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(AcademieOperations delegate_)
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
     * Operation traiter
     */
    public void traiter(gestionVoeu.CandidatureDetail CD)
    {
        _tie.traiter( CD);
    }

    /**
     * Operation deciderCandidature
     */
    public void deciderCandidature(String code, String etat)
    {
        _tie.deciderCandidature( code,  etat);
    }

    /**
     * Operation getCandidatures
     */
    public gestionVoeu.CandidatureDetail[] getCandidatures(String code)
    {
        return _tie.getCandidatures( code);
    }

    /**
     * Operation creerCandidature
     */
    public void creerCandidature(gestionVoeu.EtudiantDetail EtuDetail, gestionVoeu.VoeuxDetail VDetail)
    {
        _tie.creerCandidature( EtuDetail,  VDetail);
    }

}
