package gestionVoeu;

/**
 * Holder class for : CandidatureList
 * 
 * @author OpenORB Compiler
 */
final public class CandidatureListHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal CandidatureList value
     */
    public gestionVoeu.CandidatureDetail[] value;

    /**
     * Default constructor
     */
    public CandidatureListHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public CandidatureListHolder(gestionVoeu.CandidatureDetail[] initial)
    {
        value = initial;
    }

    /**
     * Read CandidatureList from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = CandidatureListHelper.read(istream);
    }

    /**
     * Write CandidatureList into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        CandidatureListHelper.write(ostream,value);
    }

    /**
     * Return the CandidatureList TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return CandidatureListHelper.type();
    }

}
