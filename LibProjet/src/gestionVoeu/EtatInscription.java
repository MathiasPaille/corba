package gestionVoeu;

/**
 * Enum definition : EtatInscription
 *
 * @author OpenORB Compiler
*/
public final class EtatInscription implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member VALIDE value 
     */
    public static final int _VALIDE = 0;

    /**
     * Enum member VALIDE
     */
    public static final EtatInscription VALIDE = new EtatInscription(_VALIDE);

    /**
     * Enum member NON_VALIDE value 
     */
    public static final int _NON_VALIDE = 1;

    /**
     * Enum member NON_VALIDE
     */
    public static final EtatInscription NON_VALIDE = new EtatInscription(_NON_VALIDE);

    /**
     * Enum member CLOTURE value 
     */
    public static final int _CLOTURE = 2;

    /**
     * Enum member CLOTURE
     */
    public static final EtatInscription CLOTURE = new EtatInscription(_CLOTURE);

    /**
     * Internal member value 
     */
    private final int _EtatInscription_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    private EtatInscription( final int value )
    {
        _EtatInscription_value = value;
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
        return _EtatInscription_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static EtatInscription from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return VALIDE;
        case 1 :
            return NON_VALIDE;
        case 2 :
            return CLOTURE;
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

    /**
     * Return a string representation
     * @return a string representation of the enumeration
     */
    public java.lang.String toString()
    {
        switch (_EtatInscription_value)
        {
        case 0 :
            return "VALIDE";
        case 1 :
            return "NON_VALIDE";
        case 2 :
            return "CLOTURE";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
