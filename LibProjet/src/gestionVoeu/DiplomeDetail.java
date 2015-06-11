package gestionVoeu;

/**
 * Struct definition : DiplomeDetail
 * 
 * @author OpenORB Compiler
*/
public final class DiplomeDetail implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member id
     */
    public int id;

    /**
     * Struct member libelle
     */
    public String libelle;

    /**
     * Default constructor
     */
    public DiplomeDetail()
    { }

    /**
     * Constructor with fields initialization
     * @param id id struct member
     * @param libelle libelle struct member
     */
    public DiplomeDetail(int id, String libelle)
    {
        this.id = id;
        this.libelle = libelle;
    }

}
