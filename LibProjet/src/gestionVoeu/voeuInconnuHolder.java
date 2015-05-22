package gestionVoeu;

/**
 * Holder class for : voeuInconnu
 * 
 * @author OpenORB Compiler
 */
final public class voeuInconnuHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal voeuInconnu value
     */
    public gestionVoeu.voeuInconnu value;

    /**
     * Default constructor
     */
    public voeuInconnuHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public voeuInconnuHolder(gestionVoeu.voeuInconnu initial)
    {
        value = initial;
    }

    /**
     * Read voeuInconnu from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = voeuInconnuHelper.read(istream);
    }

    /**
     * Write voeuInconnu into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        voeuInconnuHelper.write(ostream,value);
    }

    /**
     * Return the voeuInconnu TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return voeuInconnuHelper.type();
    }

}
