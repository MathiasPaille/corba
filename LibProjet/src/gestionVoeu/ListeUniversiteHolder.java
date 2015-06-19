package gestionVoeu;

/**
 * Holder class for : ListeUniversite
 * 
 * @author OpenORB Compiler
 */
final public class ListeUniversiteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeUniversite value
     */
    public gestionVoeu.UniversiteDetail[] value;

    /**
     * Default constructor
     */
    public ListeUniversiteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeUniversiteHolder(gestionVoeu.UniversiteDetail[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeUniversite from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeUniversiteHelper.read(istream);
    }

    /**
     * Write ListeUniversite into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeUniversiteHelper.write(ostream,value);
    }

    /**
     * Return the ListeUniversite TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeUniversiteHelper.type();
    }

}
