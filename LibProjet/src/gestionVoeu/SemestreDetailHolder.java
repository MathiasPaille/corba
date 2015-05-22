package gestionVoeu;

/**
 * Holder class for : SemestreDetail
 * 
 * @author OpenORB Compiler
 */
final public class SemestreDetailHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal SemestreDetail value
     */
    public gestionVoeu.SemestreDetail value;

    /**
     * Default constructor
     */
    public SemestreDetailHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public SemestreDetailHolder(gestionVoeu.SemestreDetail initial)
    {
        value = initial;
    }

    /**
     * Read SemestreDetail from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = SemestreDetailHelper.read(istream);
    }

    /**
     * Write SemestreDetail into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        SemestreDetailHelper.write(ostream,value);
    }

    /**
     * Return the SemestreDetail TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return SemestreDetailHelper.type();
    }

}
