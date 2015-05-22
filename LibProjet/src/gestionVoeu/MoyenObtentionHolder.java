package gestionVoeu;

/**
 * Holder class for : MoyenObtention
 * 
 * @author OpenORB Compiler
 */
final public class MoyenObtentionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal MoyenObtention value
     */
    public gestionVoeu.MoyenObtention value;

    /**
     * Default constructor
     */
    public MoyenObtentionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public MoyenObtentionHolder(gestionVoeu.MoyenObtention initial)
    {
        value = initial;
    }

    /**
     * Read MoyenObtention from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = MoyenObtentionHelper.read(istream);
    }

    /**
     * Write MoyenObtention into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        MoyenObtentionHelper.write(ostream,value);
    }

    /**
     * Return the MoyenObtention TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return MoyenObtentionHelper.type();
    }

}
