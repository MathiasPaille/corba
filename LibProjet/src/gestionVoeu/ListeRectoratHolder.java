package gestionVoeu;

/**
 * Holder class for : ListeRectorat
 * 
 * @author OpenORB Compiler
 */
final public class ListeRectoratHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeRectorat value
     */
    public String[] value;

    /**
     * Default constructor
     */
    public ListeRectoratHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeRectoratHolder(String[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeRectorat from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeRectoratHelper.read(istream);
    }

    /**
     * Write ListeRectorat into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeRectoratHelper.write(ostream,value);
    }

    /**
     * Return the ListeRectorat TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeRectoratHelper.type();
    }

}
