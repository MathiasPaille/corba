package gestionVoeu;

/**
 * Holder class for : affiliationList
 * 
 * @author OpenORB Compiler
 */
final public class affiliationListHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal affiliationList value
     */
    public gestionVoeu.affiliationMaster[] value;

    /**
     * Default constructor
     */
    public affiliationListHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public affiliationListHolder(gestionVoeu.affiliationMaster[] initial)
    {
        value = initial;
    }

    /**
     * Read affiliationList from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = affiliationListHelper.read(istream);
    }

    /**
     * Write affiliationList into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        affiliationListHelper.write(ostream,value);
    }

    /**
     * Return the affiliationList TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return affiliationListHelper.type();
    }

}
