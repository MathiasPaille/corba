package gestionVoeu;

/**
 * Holder class for : VoeuxList
 * 
 * @author OpenORB Compiler
 */
final public class VoeuxListHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal VoeuxList value
     */
    public gestionVoeu.VoeuxDetail[] value;

    /**
     * Default constructor
     */
    public VoeuxListHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public VoeuxListHolder(gestionVoeu.VoeuxDetail[] initial)
    {
        value = initial;
    }

    /**
     * Read VoeuxList from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = VoeuxListHelper.read(istream);
    }

    /**
     * Write VoeuxList into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        VoeuxListHelper.write(ostream,value);
    }

    /**
     * Return the VoeuxList TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return VoeuxListHelper.type();
    }

}
