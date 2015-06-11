package gestionVoeu;

/**
 * Holder class for : AffiliationMasterList
 * 
 * @author OpenORB Compiler
 */
final public class AffiliationMasterListHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal AffiliationMasterList value
     */
    public int[] value;

    /**
     * Default constructor
     */
    public AffiliationMasterListHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AffiliationMasterListHolder(int[] initial)
    {
        value = initial;
    }

    /**
     * Read AffiliationMasterList from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AffiliationMasterListHelper.read(istream);
    }

    /**
     * Write AffiliationMasterList into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AffiliationMasterListHelper.write(ostream,value);
    }

    /**
     * Return the AffiliationMasterList TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AffiliationMasterListHelper.type();
    }

}
