package gestionVoeu;

/**
 * Exception definition : compteInconnu
 * 
 * @author OpenORB Compiler
 */
public final class compteInconnu extends org.omg.CORBA.UserException
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
    public compteInconnu()
    {
        super(compteInconnuHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     * @param id id exception member
     */
    public compteInconnu(String raison, int id)
    {
        super(compteInconnuHelper.id());
        this.raison = raison;
        this.id = id;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     * @param id id exception member
     */
    public compteInconnu(String orb_reason, String raison, int id)
    {
        super(compteInconnuHelper.id() +" " +  orb_reason);
        this.raison = raison;
        this.id = id;
    }

}
