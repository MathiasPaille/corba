package gestionVoeu;

/**
 * Holder class for : EtudiantDetail
 * 
 * @author OpenORB Compiler
 */
final public class EtudiantDetailHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EtudiantDetail value
     */
    public gestionVoeu.EtudiantDetail value;

    /**
     * Default constructor
     */
    public EtudiantDetailHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EtudiantDetailHolder(gestionVoeu.EtudiantDetail initial)
    {
        value = initial;
    }

    /**
     * Read EtudiantDetail from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EtudiantDetailHelper.read(istream);
    }

    /**
     * Write EtudiantDetail into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EtudiantDetailHelper.write(ostream,value);
    }

    /**
     * Return the EtudiantDetail TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EtudiantDetailHelper.type();
    }

}
