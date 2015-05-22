package gestionVoeu;

/**
 * Holder class for : VoeuxDetail
 * 
 * @author OpenORB Compiler
 */
final public class VoeuxDetailHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal VoeuxDetail value
     */
    public gestionVoeu.VoeuxDetail value;

    /**
     * Default constructor
     */
    public VoeuxDetailHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public VoeuxDetailHolder(gestionVoeu.VoeuxDetail initial)
    {
        value = initial;
    }

    /**
     * Read VoeuxDetail from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = VoeuxDetailHelper.read(istream);
    }

    /**
     * Write VoeuxDetail into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        VoeuxDetailHelper.write(ostream,value);
    }

    /**
     * Return the VoeuxDetail TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return VoeuxDetailHelper.type();
    }

}
