package gestionVoeu;

/**
 * Holder class for : EtatDecision
 * 
 * @author OpenORB Compiler
 */
final public class EtatDecisionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EtatDecision value
     */
    public gestionVoeu.EtatDecision value;

    /**
     * Default constructor
     */
    public EtatDecisionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EtatDecisionHolder(gestionVoeu.EtatDecision initial)
    {
        value = initial;
    }

    /**
     * Read EtatDecision from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EtatDecisionHelper.read(istream);
    }

    /**
     * Write EtatDecision into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EtatDecisionHelper.write(ostream,value);
    }

    /**
     * Return the EtatDecision TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EtatDecisionHelper.type();
    }

}
