package gestionVoeu;

/**
 * Exception definition : diplomeInconnu
 * 
 * @author OpenORB Compiler
 */
public final class diplomeInconnu extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Exception member id
     */
    public int id;

    /**
     * Default constructor
     */
    public diplomeInconnu()
    {
        super(diplomeInconnuHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     * @param id id exception member
     */
    public diplomeInconnu(String raison, int id)
    {
        super(diplomeInconnuHelper.id());
        this.raison = raison;
        this.id = id;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     * @param id id exception member
     */
    public diplomeInconnu(String orb_reason, String raison, int id)
    {
        super(diplomeInconnuHelper.id() +" " +  orb_reason);
        this.raison = raison;
        this.id = id;
    }

}
