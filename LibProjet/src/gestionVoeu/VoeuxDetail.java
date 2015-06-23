package gestionVoeu;

/**
 * Struct definition : VoeuxDetail
 * 
 * @author OpenORB Compiler
*/
public final class VoeuxDetail implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member master
     */
    public int master;

    /**
     * Struct member universite
     */
    public String universite;

    /**
     * Struct member rectorat
     */
    public String rectorat;

    /**
     * Struct member classement
     */
    public int classement;

    /**
     * Struct member etu
     */
    public gestionVoeu.EtudiantDetail etu;

    /**
     * Default constructor
     */
    public VoeuxDetail()
    { }

    /**
     * Constructor with fields initialization
     * @param master master struct member
     * @param universite universite struct member
     * @param rectorat rectorat struct member
     * @param classement classement struct member
     * @param etu etu struct member
     */
    public VoeuxDetail(int master, String universite, String rectorat, int classement, gestionVoeu.EtudiantDetail etu)
    {
        this.master = master;
        this.universite = universite;
        this.rectorat = rectorat;
        this.classement = classement;
        this.etu = etu;
    }

}
