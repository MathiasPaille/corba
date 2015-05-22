package gestionVoeu;

/**
 * Holder class for : EtatInscription
 * 
 * @author OpenORB Compiler
 */
final public class EtatInscriptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EtatInscription value
     */
    public gestionVoeu.EtatInscription value;

    /**
     * Default constructor
     */
    public EtatInscriptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EtatInscriptionHolder(gestionVoeu.EtatInscription initial)
    {
        value = initial;
    }

    /**
     * Read EtatInscription from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EtatInscriptionHelper.read(istream);
    }

    /**
     * Write EtatInscription into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EtatInscriptionHelper.write(ostream,value);
    }

    /**
     * Return the EtatInscription TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EtatInscriptionHelper.type();
    }

}
