package gestionVoeu;

/**
 * Interface definition : Ministere
 * 
 * @author OpenORB Compiler
 */
public interface MinistereOperations
{
    /**
     * Operation redistribuerCandidature
     */
    public void redistribuerCandidature(gestionVoeu.CandidatureDetail CD);

    /**
     * Operation redistribuerVoeux
     */
    public void redistribuerVoeux(gestionVoeu.VoeuxDetail VD);

    /**
     * Operation getAffiliations
     */
    public gestionVoeu.affiliationMaster[] getAffiliations();

}
