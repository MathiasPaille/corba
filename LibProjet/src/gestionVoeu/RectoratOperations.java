package gestionVoeu;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public interface RectoratOperations
{
    /**
     * Operation connexion
     */
    public gestionVoeu.EtudiantDetail connexion(int mandant, String num_etu, String pwd)
        throws gestionVoeu.compteInconnu;

    /**
     * Operation creerVoeux
     */
    public void creerVoeux(gestionVoeu.VoeuxDetail monVoeux);

    /**
     * Operation recupererVoeuxMaster
     */
    public gestionVoeu.CandidatureDetail[] recupererVoeuxMaster(int mandant, int master)
        throws gestionVoeu.diplomeInconnu;

    /**
     * Operation recupererVoeuxEtudiant
     */
    public gestionVoeu.CandidatureDetail[] recupererVoeuxEtudiant(int mandant, String num_etu)
        throws gestionVoeu.compteInconnu;

    /**
     * Operation modifierCandidatureEtat
     */
    public void modifierCandidatureEtat(int mandant, gestionVoeu.CandidatureDetail maCandidature)
        throws gestionVoeu.malformedInformation;

}
