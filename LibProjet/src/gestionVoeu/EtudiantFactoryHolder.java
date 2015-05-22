package gestionVoeu;

/**
 * Holder class for : EtudiantFactory
 * 
 * @author OpenORB Compiler
 */
final public class EtudiantFactoryHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EtudiantFactory value
     */
    public gestionVoeu.EtudiantFactory value;

    /**
     * Default constructor
     */
    public EtudiantFactoryHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EtudiantFactoryHolder(gestionVoeu.EtudiantFactory initial)
    {
        value = initial;
    }

    /**
     * Read EtudiantFactory from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EtudiantFactoryHelper.read(istream);
    }

    /**
     * Write EtudiantFactory into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EtudiantFactoryHelper.write(ostream,value);
    }

    /**
     * Return the EtudiantFactory TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EtudiantFactoryHelper.type();
    }

}
