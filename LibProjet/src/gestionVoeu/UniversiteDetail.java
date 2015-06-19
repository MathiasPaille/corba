package gestionVoeu;

/**
 * Struct definition : UniversiteDetail
 * 
 * @author OpenORB Compiler
*/
public final class UniversiteDetail implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member id
     */
    public String id;

    /**
     * Struct member name
     */
    public String name;

    /**
     * Default constructor
     */
    public UniversiteDetail()
    { }

    /**
     * Constructor with fields initialization
     * @param id id struct member
     * @param name name struct member
     */
    public UniversiteDetail(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

}
