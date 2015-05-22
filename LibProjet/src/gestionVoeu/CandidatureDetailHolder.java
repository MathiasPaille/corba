package gestionVoeu;

/**
 * Holder class for : CandidatureDetail
 * 
 * @author OpenORB Compiler
 */
final public class CandidatureDetailHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal CandidatureDetail value
     */
    public gestionVoeu.CandidatureDetail value;

    /**
     * Default constructor
     */
    public CandidatureDetailHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public CandidatureDetailHolder(gestionVoeu.CandidatureDetail initial)
    {
        value = initial;
    }

    /**
     * Read CandidatureDetail from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = CandidatureDetailHelper.read(istream);
    }

    /**
     * Write CandidatureDetail into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        CandidatureDetailHelper.write(ostream,value);
    }

    /**
     * Return the CandidatureDetail TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return CandidatureDetailHelper.type();
    }

}
