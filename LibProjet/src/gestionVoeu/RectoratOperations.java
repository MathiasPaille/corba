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
    public gestionVoeu.EtudiantDetail connexion(String num_etu, String pwd)
        throws gestionVoeu.compteInconnu;

    /**
     * Operation creerVoeux
     */
    public void creerVoeux(gestionVoeu.VoeuxDetail monVoeux);

    /**
     * Operation recupererVoeuxEtudiant
     */
    public gestionVoeu.CandidatureDetail[] recupererVoeuxEtudiant(String num_etu)
        throws gestionVoeu.compteInconnu;

    /**
     * Operation recupererUniversite
     */
    public String[] recupererUniversite();

    /**
     * Operation recupererVoeuxMaster
     */
    public gestionVoeu.CandidatureDetail[] recupererVoeuxMaster(int master)
        throws gestionVoeu.diplomeInconnu;

    /**
     * Operation modifierCandidatureEtat
     */
    public void modifierCandidatureEtat(gestionVoeu.CandidatureDetail maCandidature)
        throws gestionVoeu.malformedInformation;

    /**
     * Operation redistribuerCandidature
     */
    public void redistribuerCandidature(int mandant, gestionVoeu.CandidatureDetail CD);

}
