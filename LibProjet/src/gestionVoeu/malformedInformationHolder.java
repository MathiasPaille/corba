package gestionVoeu;

/**
 * Holder class for : malformedInformation
 * 
 * @author OpenORB Compiler
 */
final public class malformedInformationHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal malformedInformation value
     */
    public gestionVoeu.malformedInformation value;

    /**
     * Default constructor
     */
    public malformedInformationHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public malformedInformationHolder(gestionVoeu.malformedInformation initial)
    {
        value = initial;
    }

    /**
     * Read malformedInformation from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = malformedInformationHelper.read(istream);
    }

    /**
     * Write malformedInformation into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        malformedInformationHelper.write(ostream,value);
    }

    /**
     * Return the malformedInformation TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return malformedInformationHelper.type();
    }

}
