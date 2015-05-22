package gestionVoeu;

/**
 * Exception definition : voeuInconnu
 * 
 * @author OpenORB Compiler
 */
public final class voeuInconnu extends org.omg.CORBA.UserException
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
    public voeuInconnu()
    {
        super(voeuInconnuHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     * @param id id exception member
     */
    public voeuInconnu(String raison, int id)
    {
        super(voeuInconnuHelper.id());
        this.raison = raison;
        this.id = id;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     * @param id id exception member
     */
    public voeuInconnu(String orb_reason, String raison, int id)
    {
        super(voeuInconnuHelper.id() +" " +  orb_reason);
        this.raison = raison;
        this.id = id;
    }

}
