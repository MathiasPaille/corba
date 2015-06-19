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
     * Struct member listeDip
     */
    public String[] listeDip;

    /**
     * Default constructor
     */
    public DiplomeDetail()
    { }

    /**
     * Constructor with fields initialization
     * @param id id struct member
     * @param libelle libelle struct member
     * @param listeDip listeDip struct member
     */
    public DiplomeDetail(int id, String libelle, String[] listeDip)
    {
        this.id = id;
        this.libelle = libelle;
        this.listeDip = listeDip;
    }

}
