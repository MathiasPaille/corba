package gestionVoeu;

/**
 * - quartile est le quart dans lequel il se trouve par rapport a ses camarades de promotion
 */
public final class SemestreDetail implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member id
     */
    public String id;

    /**
     * Struct member moyenne
     */
    public float moyenne;

    /**
     * Struct member quartile
     */
    public gestionVoeu.Quartile quartile;

    /**
     * Struct member moyenObtention
     */
    public gestionVoeu.MoyenObtention moyenObtention;

    /**
     * Struct member numSemestre
     */
    public int numSemestre;

    /**
     * Default constructor
     */
    public SemestreDetail()
    { }

    /**
     * Constructor with fields initialization
     * @param id id struct member
     * @param moyenne moyenne struct member
     * @param quartile quartile struct member
     * @param moyenObtention moyenObtention struct member
     * @param numSemestre numSemestre struct member
     */
    public SemestreDetail(String id, float moyenne, gestionVoeu.Quartile quartile, gestionVoeu.MoyenObtention moyenObtention, int numSemestre)
    {
        this.id = id;
        this.moyenne = moyenne;
        this.quartile = quartile;
        this.moyenObtention = moyenObtention;
        this.numSemestre = numSemestre;
    }

}
