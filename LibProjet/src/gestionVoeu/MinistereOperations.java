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
     * Operation getListRectorats
     */
    public gestionVoeu.RectoratDetail[] getListRectorats();

    /**
     * Operation getPhase
     */
    public gestionVoeu.Phase getPhase();

}
