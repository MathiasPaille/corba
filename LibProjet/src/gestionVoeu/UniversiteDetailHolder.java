package gestionVoeu;

/**
 * Holder class for : UniversiteDetail
 * 
 * @author OpenORB Compiler
 */
final public class UniversiteDetailHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal UniversiteDetail value
     */
    public gestionVoeu.UniversiteDetail value;

    /**
     * Default constructor
     */
    public UniversiteDetailHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public UniversiteDetailHolder(gestionVoeu.UniversiteDetail initial)
    {
        value = initial;
    }

    /**
     * Read UniversiteDetail from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = UniversiteDetailHelper.read(istream);
    }

    /**
     * Write UniversiteDetail into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        UniversiteDetailHelper.write(ostream,value);
    }

    /**
     * Return the UniversiteDetail TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return UniversiteDetailHelper.type();
    }

}
