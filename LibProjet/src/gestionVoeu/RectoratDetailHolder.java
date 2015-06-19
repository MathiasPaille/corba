package gestionVoeu;

/**
 * Holder class for : RectoratDetail
 * 
 * @author OpenORB Compiler
 */
final public class RectoratDetailHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal RectoratDetail value
     */
    public gestionVoeu.RectoratDetail value;

    /**
     * Default constructor
     */
    public RectoratDetailHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public RectoratDetailHolder(gestionVoeu.RectoratDetail initial)
    {
        value = initial;
    }

    /**
     * Read RectoratDetail from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = RectoratDetailHelper.read(istream);
    }

    /**
     * Write RectoratDetail into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        RectoratDetailHelper.write(ostream,value);
    }

    /**
     * Return the RectoratDetail TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return RectoratDetailHelper.type();
    }

}
