package gestionVoeu;

/**
 * Struct definition : RectoratDetail
 * 
 * @author OpenORB Compiler
*/
public final class RectoratDetail implements org.omg.CORBA.portable.IDLEntity
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
    public RectoratDetail()
    { }

    /**
     * Constructor with fields initialization
     * @param id id struct member
     * @param name name struct member
     */
    public RectoratDetail(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

}
