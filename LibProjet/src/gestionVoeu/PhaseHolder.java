package gestionVoeu;

/**
 * Holder class for : Phase
 * 
 * @author OpenORB Compiler
 */
final public class PhaseHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Phase value
     */
    public gestionVoeu.Phase value;

    /**
     * Default constructor
     */
    public PhaseHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public PhaseHolder(gestionVoeu.Phase initial)
    {
        value = initial;
    }

    /**
     * Read Phase from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = PhaseHelper.read(istream);
    }

    /**
     * Write Phase into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        PhaseHelper.write(ostream,value);
    }

    /**
     * Return the Phase TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return PhaseHelper.type();
    }

}
