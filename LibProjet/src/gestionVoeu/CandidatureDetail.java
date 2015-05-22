package gestionVoeu;

/**
 * Struct definition : CandidatureDetail
 * 
 * @author OpenORB Compiler
*/
public final class CandidatureDetail implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member voeuxDetail
     */
    public gestionVoeu.VoeuxDetail voeuxDetail;

    /**
     * Struct member etatInscription
     */
    public gestionVoeu.EtatInscription etatInscription;

    /**
     * Struct member etatVoeu
     */
    public gestionVoeu.EtatVoeu etatVoeu;

    /**
     * Struct member etatDecision
     */
    public gestionVoeu.EtatDecision etatDecision;

    /**
     * Default constructor
     */
    public CandidatureDetail()
    { }

    /**
     * Constructor with fields initialization
     * @param voeuxDetail voeuxDetail struct member
     * @param etatInscription etatInscription struct member
     * @param etatVoeu etatVoeu struct member
     * @param etatDecision etatDecision struct member
     */
    public CandidatureDetail(gestionVoeu.VoeuxDetail voeuxDetail, gestionVoeu.EtatInscription etatInscription, gestionVoeu.EtatVoeu etatVoeu, gestionVoeu.EtatDecision etatDecision)
    {
        this.voeuxDetail = voeuxDetail;
        this.etatInscription = etatInscription;
        this.etatVoeu = etatVoeu;
        this.etatDecision = etatDecision;
    }

}
