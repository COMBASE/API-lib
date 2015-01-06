package error;

import java.util.Set;


public class ArticleCodeMustBeUniqueException extends Exception
{

	private static final long serialVersionUID = 4569447626999614413L;

	Set<String> errorObjects;

	public ArticleCodeMustBeUniqueException(final Throwable cause, final Set<String> errorsObjects)
	{

		super(cause);
		this.errorObjects = errorsObjects;

	}

	@Override
	public String getMessage()
	{
		final StringBuilder ret = new StringBuilder();
		ret.append("Article code must be unique!");
		ret.append("Following Products have non atomic Article Codes:");
		ret.append(errorObjects.toString());

		return ret.toString();
	}

}
