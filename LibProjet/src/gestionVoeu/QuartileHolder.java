package gestionVoeu;

/**
 * Holder class for : Quartile
 * 
 * @author OpenORB Compiler
 */
final public class QuartileHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Quartile value
     */
    public gestionVoeu.Quartile value;

    /**
     * Default constructor
     */
    public QuartileHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public QuartileHolder(gestionVoeu.Quartile initial)
    {
        value = initial;
    }

    /**
     * Read Quartile from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = QuartileHelper.read(istream);
    }

    /**
     * Write Quartile into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        QuartileHelper.write(ostream,value);
    }

    /**
     * Return the Quartile TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return QuartileHelper.type();
    }

}
