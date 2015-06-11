package gestionVoeu;

/**
 * Holder class for : DiplomeList
 * 
 * @author OpenORB Compiler
 */
final public class DiplomeListHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal DiplomeList value
     */
    public gestionVoeu.DiplomeDetail[] value;

    /**
     * Default constructor
     */
    public DiplomeListHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public DiplomeListHolder(gestionVoeu.DiplomeDetail[] initial)
    {
        value = initial;
    }

    /**
     * Read DiplomeList from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = DiplomeListHelper.read(istream);
    }

    /**
     * Write DiplomeList into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        DiplomeListHelper.write(ostream,value);
    }

    /**
     * Return the DiplomeList TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return DiplomeListHelper.type();
    }

}
