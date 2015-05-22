package gestionVoeu;

/**
 * Struct definition : EtudiantDetail
 * 
 * @author OpenORB Compiler
*/
public final class EtudiantDetail implements org.omg.CORBA.portable.IDLEntity
{
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
    public int universite;

    /**
     * Struct member license
     */
    public int license;

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
     * @param num_etudiant num_etudiant struct member
     * @param nom nom struct member
     * @param prenom prenom struct member
     * @param adresse adresse struct member
     * @param universite universite struct member
     * @param license license struct member
     * @param listeSeum listeSeum struct member
     */
    public EtudiantDetail(String num_etudiant, String nom, String prenom, String adresse, int universite, int license, gestionVoeu.SemestreDetail[] listeSeum)
    {
        this.num_etudiant = num_etudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.universite = universite;
        this.license = license;
        this.listeSeum = listeSeum;
    }

}
