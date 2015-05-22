package gestionVoeu;

/**
 * Struct definition : affiliationMaster
 * 
 * @author OpenORB Compiler
*/
public final class affiliationMaster implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member master
     */
    public int master;

    /**
     * Struct member universite
     */
    public int universite;

    /**
     * Default constructor
     */
    public affiliationMaster()
    { }

    /**
     * Constructor with fields initialization
     * @param master master struct member
     * @param universite universite struct member
     */
    public affiliationMaster(int master, int universite)
    {
        this.master = master;
        this.universite = universite;
    }

}
