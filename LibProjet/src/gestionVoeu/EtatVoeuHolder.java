package gestionVoeu;

/**
 * Holder class for : EtatVoeu
 * 
 * @author OpenORB Compiler
 */
final public class EtatVoeuHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EtatVoeu value
     */
    public gestionVoeu.EtatVoeu value;

    /**
     * Default constructor
     */
    public EtatVoeuHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EtatVoeuHolder(gestionVoeu.EtatVoeu initial)
    {
        value = initial;
    }

    /**
     * Read EtatVoeu from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EtatVoeuHelper.read(istream);
    }

    /**
     * Write EtatVoeu into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EtatVoeuHelper.write(ostream,value);
    }

    /**
     * Return the EtatVoeu TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EtatVoeuHelper.type();
    }

}
