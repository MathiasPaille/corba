package gestionVoeu;

/**
 * Enum definition : MoyenObtention
 *
 * @author OpenORB Compiler
*/
public final class MoyenObtention implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member PREMIERE_SESSION value 
     */
    public static final int _PREMIERE_SESSION = 0;

    /**
     * Enum member PREMIERE_SESSION
     */
    public static final MoyenObtention PREMIERE_SESSION = new MoyenObtention(_PREMIERE_SESSION);

    /**
     * Enum member SECONDE_SESSION value 
     */
    public static final int _SECONDE_SESSION = 1;

    /**
     * Enum member SECONDE_SESSION
     */
    public static final MoyenObtention SECONDE_SESSION = new MoyenObtention(_SECONDE_SESSION);

    /**
     * Enum member REDOUBLEMENT value 
     */
    public static final int _REDOUBLEMENT = 2;

    /**
     * Enum member REDOUBLEMENT
     */
    public static final MoyenObtention REDOUBLEMENT = new MoyenObtention(_REDOUBLEMENT);

    /**
     * Internal member value 
     */
    private final int _MoyenObtention_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    private MoyenObtention( final int value )
    {
        _MoyenObtention_value = value;
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
        return _MoyenObtention_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static MoyenObtention from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return PREMIERE_SESSION;
        case 1 :
            return SECONDE_SESSION;
        case 2 :
            return REDOUBLEMENT;
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

    /**
     * Return a string representation
     * @return a string representation of the enumeration
     */
    public java.lang.String toString()
    {
        switch (_MoyenObtention_value)
        {
        case 0 :
            return "PREMIERE_SESSION";
        case 1 :
            return "SECONDE_SESSION";
        case 2 :
            return "REDOUBLEMENT";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
