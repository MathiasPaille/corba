package gestionVoeu;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public interface RectoratOperations
{
    /**
     * Operation creerVoeux
     */
    public void creerVoeux(gestionVoeu.VoeuxDetail monVoeux);

    /**
     * Operation recupererVoeuxMaster
     */
    public gestionVoeu.VoeuxDetail[] recupererVoeuxMaster(int master)
        throws gestionVoeu.diplomeInconnu;

    /**
     * Operation recupererVoeuxEtudiant
     */
    public gestionVoeu.VoeuxDetail[] recupererVoeuxEtudiant(int num_etu)
        throws gestionVoeu.compteInconnu;

    /**
     * Operation recupererEtatCandidatures
     */
    public gestionVoeu.CandidatureDetail[] recupererEtatCandidatures(gestionVoeu.VoeuxDetail[] listeVoeux)
        throws gestionVoeu.voeuInconnu;

    /**
     * Operation modifierCandidatureEtat
     */
    public void modifierCandidatureEtat(gestionVoeu.CandidatureDetail maCandidature)
        throws gestionVoeu.malformedInformation;

}
