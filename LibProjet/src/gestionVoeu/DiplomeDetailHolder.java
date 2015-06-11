package gestionVoeu;

/**
 * Holder class for : DiplomeDetail
 * 
 * @author OpenORB Compiler
 */
final public class DiplomeDetailHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal DiplomeDetail value
     */
    public gestionVoeu.DiplomeDetail value;

    /**
     * Default constructor
     */
    public DiplomeDetailHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public DiplomeDetailHolder(gestionVoeu.DiplomeDetail initial)
    {
        value = initial;
    }

    /**
     * Read DiplomeDetail from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = DiplomeDetailHelper.read(istream);
    }

    /**
     * Write DiplomeDetail into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        DiplomeDetailHelper.write(ostream,value);
    }

    /**
     * Return the DiplomeDetail TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return DiplomeDetailHelper.type();
    }

}
