package gestionVoeu;

/**
 * Holder class for : SemestreList
 * 
 * @author OpenORB Compiler
 */
final public class SemestreListHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal SemestreList value
     */
    public gestionVoeu.SemestreDetail[] value;

    /**
     * Default constructor
     */
    public SemestreListHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public SemestreListHolder(gestionVoeu.SemestreDetail[] initial)
    {
        value = initial;
    }

    /**
     * Read SemestreList from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = SemestreListHelper.read(istream);
    }

    /**
     * Write SemestreList into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        SemestreListHelper.write(ostream,value);
    }

    /**
     * Return the SemestreList TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return SemestreListHelper.type();
    }

}
