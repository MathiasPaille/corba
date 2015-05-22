package gestionVoeu;

/**
 * Interface definition : Universite
 * 
 * @author OpenORB Compiler
 */
public interface UniversiteOperations
{
    /**
     * Operation consulterCandidatures
     */
    public gestionVoeu.CandidatureDetail[] consulterCandidatures();

    /**
     * Operation modifierCandidature
     */
    public void modifierCandidature(gestionVoeu.CandidatureDetail candidature, gestionVoeu.EtatDecision etatDecision);

}
