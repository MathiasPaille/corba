package gestionVoeu;

/**
 * Holder class for : affiliationMaster
 * 
 * @author OpenORB Compiler
 */
final public class affiliationMasterHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal affiliationMaster value
     */
    public gestionVoeu.affiliationMaster value;

    /**
     * Default constructor
     */
    public affiliationMasterHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public affiliationMasterHolder(gestionVoeu.affiliationMaster initial)
    {
        value = initial;
    }

    /**
     * Read affiliationMaster from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = affiliationMasterHelper.read(istream);
    }

    /**
     * Write affiliationMaster into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        affiliationMasterHelper.write(ostream,value);
    }

    /**
     * Return the affiliationMaster TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return affiliationMasterHelper.type();
    }

}
