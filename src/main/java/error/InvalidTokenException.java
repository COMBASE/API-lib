package error;


public class InvalidTokenException extends Exception
{

	private static final long serialVersionUID = 2242796447404800406L;

	public InvalidTokenException(final Throwable cause)
	{

		super(cause);

	}

	@Override
	public String getMessage()
	{
		final StringBuilder ret = new StringBuilder();
		ret.append("Invalid cloud token!");
		ret.append("Please check your authentication.");

		return ret.toString();
	}

}
