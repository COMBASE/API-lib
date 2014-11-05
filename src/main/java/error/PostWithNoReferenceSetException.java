package error;

public class PostWithNoReferenceSetException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7701047985933304013L;

	public PostWithNoReferenceSetException(final Throwable cause)
	{
		super(cause);
	}

	@Override
	public String getLocalizedMessage()
	{
		final StringBuilder ret = new StringBuilder();
		ret.append("Object Reference field is null. Could not post object.");
		ret.append(super.getLocalizedMessage());
		return ret.toString();
	}

}
