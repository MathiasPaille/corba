package gestionVoeu;

/**
 * Enum definition : Phase
 *
 * @author OpenORB Compiler
*/
public final class Phase implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member PHASE_1 value 
     */
    public static final int _PHASE_1 = 0;

    /**
     * Enum member PHASE_1
     */
    public static final Phase PHASE_1 = new Phase(_PHASE_1);

    /**
     * Enum member PHASE_2 value 
     */
    public static final int _PHASE_2 = 1;

    /**
     * Enum member PHASE_2
     */
    public static final Phase PHASE_2 = new Phase(_PHASE_2);

    /**
     * Enum member PHASE_3 value 
     */
    public static final int _PHASE_3 = 2;

    /**
     * Enum member PHASE_3
     */
    public static final Phase PHASE_3 = new Phase(_PHASE_3);

    /**
     * Enum member PHASE_4 value 
     */
    public static final int _PHASE_4 = 3;

    /**
     * Enum member PHASE_4
     */
    public static final Phase PHASE_4 = new Phase(_PHASE_4);

    /**
     * Internal member value 
     */
    private final int _Phase_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    private Phase( final int value )
    {
        _Phase_value = value;
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
        return _Phase_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static Phase from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return PHASE_1;
        case 1 :
            return PHASE_2;
        case 2 :
            return PHASE_3;
        case 3 :
            return PHASE_4;
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

    /**
     * Return a string representation
     * @return a string representation of the enumeration
     */
    public java.lang.String toString()
    {
        switch (_Phase_value)
        {
        case 0 :
            return "PHASE_1";
        case 1 :
            return "PHASE_2";
        case 2 :
            return "PHASE_3";
        case 3 :
            return "PHASE_4";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
