package gestionVoeu;

/**
 * Exception definition : malformedInformation
 * 
 * @author OpenORB Compiler
 */
public final class malformedInformation extends org.omg.CORBA.UserException
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
    public malformedInformation()
    {
        super(malformedInformationHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     * @param id id exception member
     */
    public malformedInformation(String raison, int id)
    {
        super(malformedInformationHelper.id());
        this.raison = raison;
        this.id = id;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     * @param id id exception member
     */
    public malformedInformation(String orb_reason, String raison, int id)
    {
        super(malformedInformationHelper.id() +" " +  orb_reason);
        this.raison = raison;
        this.id = id;
    }

}
