package error;

import domain.DataType;

/**
 * 
 * @author mas
 * 
 */
public class SubObjectInitializationException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3296958272284267484L;
	private final String reference;
	private final DataType type;

	public SubObjectInitializationException(final String reference, final DataType type,
		final Throwable cause)
	{
		super(cause);
		this.reference = reference;
		this.type = type;
	}

	@Override
	public String getLocalizedMessage()
	{
		final StringBuilder ret = new StringBuilder();
		ret.append("SubObject ");
		ret.append(type.toString());
		ret.append(" with reference \"");
		ret.append(reference);
		ret.append("\" not found. ");
		// ret.append(super.getLocalizedMessage());
		return ret.toString();
	}

	public String getReference()
	{
		return reference;
	}

	public DataType getType()
	{
		return type;
	}


}
