package gestionVoeu;

/**
 * Holder class for : diplomeInconnu
 * 
 * @author OpenORB Compiler
 */
final public class diplomeInconnuHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal diplomeInconnu value
     */
    public gestionVoeu.diplomeInconnu value;

    /**
     * Default constructor
     */
    public diplomeInconnuHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public diplomeInconnuHolder(gestionVoeu.diplomeInconnu initial)
    {
        value = initial;
    }

    /**
     * Read diplomeInconnu from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = diplomeInconnuHelper.read(istream);
    }

    /**
     * Write diplomeInconnu into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        diplomeInconnuHelper.write(ostream,value);
    }

    /**
     * Return the diplomeInconnu TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return diplomeInconnuHelper.type();
    }

}
