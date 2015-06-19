package gestionVoeu;

/**
 * Holder class for : ListeLicence
 * 
 * @author OpenORB Compiler
 */
final public class ListeLicenceHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeLicence value
     */
    public String[] value;

    /**
     * Default constructor
     */
    public ListeLicenceHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeLicenceHolder(String[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeLicence from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeLicenceHelper.read(istream);
    }

    /**
     * Write ListeLicence into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeLicenceHelper.write(ostream,value);
    }

    /**
     * Return the ListeLicence TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeLicenceHelper.type();
    }

}
