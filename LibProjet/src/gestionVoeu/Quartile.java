package gestionVoeu;

/**
 * Enum definition : Quartile
 *
 * @author OpenORB Compiler
*/
public final class Quartile implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member PREMIER_QUART value 
     */
    public static final int _PREMIER_QUART = 0;

    /**
     * Enum member PREMIER_QUART
     */
    public static final Quartile PREMIER_QUART = new Quartile(_PREMIER_QUART);

    /**
     * Enum member DEUXIEME_QUART value 
     */
    public static final int _DEUXIEME_QUART = 1;

    /**
     * Enum member DEUXIEME_QUART
     */
    public static final Quartile DEUXIEME_QUART = new Quartile(_DEUXIEME_QUART);

    /**
     * Enum member TROISIEME_QUART value 
     */
    public static final int _TROISIEME_QUART = 2;

    /**
     * Enum member TROISIEME_QUART
     */
    public static final Quartile TROISIEME_QUART = new Quartile(_TROISIEME_QUART);

    /**
     * Enum member QUATRIEME_QUART value 
     */
    public static final int _QUATRIEME_QUART = 3;

    /**
     * Enum member QUATRIEME_QUART
     */
    public static final Quartile QUATRIEME_QUART = new Quartile(_QUATRIEME_QUART);

    /**
     * Internal member value 
     */
    private final int _Quartile_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    private Quartile( final int value )
    {
        _Quartile_value = value;
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
        return _Quartile_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static Quartile from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return PREMIER_QUART;
        case 1 :
            return DEUXIEME_QUART;
        case 2 :
            return TROISIEME_QUART;
        case 3 :
            return QUATRIEME_QUART;
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

    /**
     * Return a string representation
     * @return a string representation of the enumeration
     */
    public java.lang.String toString()
    {
        switch (_Quartile_value)
        {
        case 0 :
            return "PREMIER_QUART";
        case 1 :
            return "DEUXIEME_QUART";
        case 2 :
            return "TROISIEME_QUART";
        case 3 :
            return "QUATRIEME_QUART";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
