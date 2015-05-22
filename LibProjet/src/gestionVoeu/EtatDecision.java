package gestionVoeu;

/**
 * Enum definition : EtatDecision
 *
 * @author OpenORB Compiler
*/
public final class EtatDecision implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member ADMIS value 
     */
    public static final int _ADMIS = 0;

    /**
     * Enum member ADMIS
     */
    public static final EtatDecision ADMIS = new EtatDecision(_ADMIS);

    /**
     * Enum member ATTENTE value 
     */
    public static final int _ATTENTE = 1;

    /**
     * Enum member ATTENTE
     */
    public static final EtatDecision ATTENTE = new EtatDecision(_ATTENTE);

    /**
     * Enum member REFUSE value 
     */
    public static final int _REFUSE = 2;

    /**
     * Enum member REFUSE
     */
    public static final EtatDecision REFUSE = new EtatDecision(_REFUSE);

    /**
     * Internal member value 
     */
    private final int _EtatDecision_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    private EtatDecision( final int value )
    {
        _EtatDecision_value = value;
    }

    /**
     * Maintains singleton property for serialized enums.
     * Issue 4271: IDL/Java issue, Mapping for IDL enum.
     */
    public java.lang.Object readResolve() throws java.io.ObjectStreamException
    {
        return from_int( value() );
    }

    /**
     * Return the internal member value
     * @return the member value
     */
    public int value()
    {
        return _EtatDecision_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static EtatDecision from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return ADMIS;
        case 1 :
            return ATTENTE;
        case 2 :
            return REFUSE;
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

    /**
     * Return a string representation
     * @return a string representation of the enumeration
     */
    public java.lang.String toString()
    {
        switch (_EtatDecision_value)
        {
        case 0 :
            return "ADMIS";
        case 1 :
            return "ATTENTE";
        case 2 :
            return "REFUSE";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
