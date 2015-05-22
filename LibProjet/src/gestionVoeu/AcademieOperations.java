package gestionVoeu;

/**
 * Interface definition : Academie
 * 
 * @author OpenORB Compiler
 */
public interface AcademieOperations
{
    /**
     * Operation traiter
     */
    public void traiter(gestionVoeu.CandidatureDetail CD);

    /**
     * Operation deciderCandidature
     */
    public void deciderCandidature(String code, String etat);

    /**
     * Operation getCandidatures
     */
    public gestionVoeu.CandidatureDetail[] getCandidatures(String code);

    /**
     * Operation creerCandidature
     */
    public void creerCandidature(gestionVoeu.EtudiantDetail EtuDetail, gestionVoeu.VoeuxDetail VDetail);

}
