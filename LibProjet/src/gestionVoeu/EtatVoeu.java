package gestionVoeu;

/**
 * Enum definition : EtatVoeu
 *
 * @author OpenORB Compiler
*/
public final class EtatVoeu implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member CREE value 
     */
    public static final int _CREE = 0;

    /**
     * Enum member CREE
     */
    public static final EtatVoeu CREE = new EtatVoeu(_CREE);

    /**
     * Enum member OUI_DEFINITIF value 
     */
    public static final int _OUI_DEFINITIF = 1;

    /**
     * Enum member OUI_DEFINITIF
     */
    public static final EtatVoeu OUI_DEFINITIF = new EtatVoeu(_OUI_DEFINITIF);

    /**
     * Enum member OUI_MAIS value 
     */
    public static final int _OUI_MAIS = 2;

    /**
     * Enum member OUI_MAIS
     */
    public static final EtatVoeu OUI_MAIS = new EtatVoeu(_OUI_MAIS);

    /**
     * Enum member NON_MAIS value 
     */
    public static final int _NON_MAIS = 3;

    /**
     * Enum member NON_MAIS
     */
    public static final EtatVoeu NON_MAIS = new EtatVoeu(_NON_MAIS);

    /**
     * Enum member NON_DEFINITIF value 
     */
    public static final int _NON_DEFINITIF = 4;

    /**
     * Enum member NON_DEFINITIF
     */
    public static final EtatVoeu NON_DEFINITIF = new EtatVoeu(_NON_DEFINITIF);

    /**
     * Internal member value 
     */
    private final int _EtatVoeu_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    private EtatVoeu( final int value )
    {
        _EtatVoeu_value = value;
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
        return _EtatVoeu_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static EtatVoeu from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return CREE;
        case 1 :
            return OUI_DEFINITIF;
        case 2 :
            return OUI_MAIS;
        case 3 :
            return NON_MAIS;
        case 4 :
            return NON_DEFINITIF;
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

    /**
     * Return a string representation
     * @return a string representation of the enumeration
     */
    public java.lang.String toString()
    {
        switch (_EtatVoeu_value)
        {
        case 0 :
            return "CREE";
        case 1 :
            return "OUI_DEFINITIF";
        case 2 :
            return "OUI_MAIS";
        case 3 :
            return "NON_MAIS";
        case 4 :
            return "NON_DEFINITIF";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
