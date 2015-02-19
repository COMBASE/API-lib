package error;

import java.util.HashMap;
import java.util.Map;

/**
 * Holds a Map<String,String> wherefor the first String refers to KORONA.CLOUD.API error message and
 * the second to the certain object.
 *
 * The Client Application should use the error map for further exception handling.
 *
 * @author mas
 *
 */
public class PostAllException extends Exception
{

	private static final long serialVersionUID = 4569447626999614413L;

	Map<String, String> errorObjects = new HashMap<String, String>();

	public Map<String, String> getErrorObjects()
	{
		return errorObjects;
	}

	public PostAllException(final Throwable cause, final Map<String, String> errorsObjects)
	{

		super(cause);
		this.errorObjects = errorsObjects;

	}

	@Override
	public String getMessage()
	{
		final StringBuilder ret = new StringBuilder();
		ret.append("KORONA.CLOUD.API has returned error codes");
		ret.append(errorObjects.toString());

		return ret.toString();
	}

}
