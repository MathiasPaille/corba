package gestionVoeu;

/**
 * Struct definition : EtudiantDetail
 * 
 * @author OpenORB Compiler
*/
public final class EtudiantDetail implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member rectorat_ref
     */
    public String rectorat_ref;

    /**
     * Struct member num_etudiant
     */
    public String num_etudiant;

    /**
     * Struct member nom
     */
    public String nom;

    /**
     * Struct member prenom
     */
    public String prenom;

    /**
     * Struct member adresse
     */
    public String adresse;

    /**
     * Struct member universite
     */
    public String universite;

    /**
     * Struct member license
     */
    public String license;

    /**
     * Struct member listeSeum
     */
    public gestionVoeu.SemestreDetail[] listeSeum;

    /**
     * Default constructor
     */
    public EtudiantDetail()
    { }

    /**
     * Constructor with fields initialization
     * @param rectorat_ref rectorat_ref struct member
     * @param num_etudiant num_etudiant struct member
     * @param nom nom struct member
     * @param prenom prenom struct member
     * @param adresse adresse struct member
     * @param universite universite struct member
     * @param license license struct member
     * @param listeSeum listeSeum struct member
     */
    public EtudiantDetail(String rectorat_ref, String num_etudiant, String nom, String prenom, String adresse, String universite, String license, gestionVoeu.SemestreDetail[] listeSeum)
    {
        this.rectorat_ref = rectorat_ref;
        this.num_etudiant = num_etudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.universite = universite;
        this.license = license;
        this.listeSeum = listeSeum;
    }

}
