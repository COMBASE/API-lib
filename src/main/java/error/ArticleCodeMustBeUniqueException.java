package error;


public class ArticleCodeMustBeUniqueException extends Exception
{

	private static final long serialVersionUID = 4569447626999614413L;


	public ArticleCodeMustBeUniqueException(final Throwable cause)
	{
		super(cause);

	}

	@Override
	public String getLocalizedMessage()
	{
		final StringBuilder ret = new StringBuilder();
		ret.append("Article code must be unique!");
		ret.append(super.getMessage());
		return ret.toString();
	}


}
