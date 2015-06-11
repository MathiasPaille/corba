package gestionVoeu;

/**
 * Interface definition : Ministere
 * 
 * @author OpenORB Compiler
 */
public interface MinistereOperations
{
    /**
     * Operation getListDiplomes
     */
    public gestionVoeu.DiplomeDetail[] getListDiplomes();

    /**
     * Operation redistribuerCandidature
     */
    public void redistribuerCandidature(gestionVoeu.CandidatureDetail CD);

    /**
     * Operation redistribuerVoeux
     */
    public void redistribuerVoeux(gestionVoeu.VoeuxDetail VD);

}
