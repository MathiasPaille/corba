package gestionVoeu;

/**
 * Interface definition : EtudiantFactory
 * 
 * @author OpenORB Compiler
 */
public interface EtudiantFactoryOperations
{
    /**
     * Operation getCandidatures
     */
    public gestionVoeu.CandidatureDetail[] getCandidatures(gestionVoeu.EtudiantDetail etu)
        throws gestionVoeu.compteInconnu;

    /**
     * Operation getSemestres
     */
    public gestionVoeu.SemestreDetail[] getSemestres(gestionVoeu.EtudiantDetail etu)
        throws gestionVoeu.compteInconnu;

    /**
     * Operation creerCandidature
     */
    public void creerCandidature(gestionVoeu.CandidatureDetail candidature)
        throws gestionVoeu.diplomeInconnu;

    /**
     * Operation modifierCandidature
     */
    public void modifierCandidature(gestionVoeu.CandidatureDetail candidature, gestionVoeu.EtatVoeu voeuEtu)
        throws gestionVoeu.voeuInconnu;

    /**
     * Operation connexion
     */
    public gestionVoeu.EtudiantDetail connexion(String num_etu, String pwd)
        throws gestionVoeu.compteInconnu;

}
