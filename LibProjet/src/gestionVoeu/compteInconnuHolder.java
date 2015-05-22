package gestionVoeu;

/**
 * Holder class for : compteInconnu
 * 
 * @author OpenORB Compiler
 */
final public class compteInconnuHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal compteInconnu value
     */
    public gestionVoeu.compteInconnu value;

    /**
     * Default constructor
     */
    public compteInconnuHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public compteInconnuHolder(gestionVoeu.compteInconnu initial)
    {
        value = initial;
    }

    /**
     * Read compteInconnu from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = compteInconnuHelper.read(istream);
    }

    /**
     * Write compteInconnu into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        compteInconnuHelper.write(ostream,value);
    }

    /**
     * Return the compteInconnu TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return compteInconnuHelper.type();
    }

}
