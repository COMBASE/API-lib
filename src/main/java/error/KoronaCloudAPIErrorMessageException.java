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
public class KoronaCloudAPIErrorMessageException extends Exception
{

	private static final long serialVersionUID = 4569447626999614413L;

	Map<String, String> errorMap = new HashMap<String, String>();

	/**
	 * returns a Map containing the error message as key and concerned items as value.
	 *
	 * @return Map<String,String>
	 */
	public Map<String, String> getErrorMap()
	{
		return errorMap;
	}

	public KoronaCloudAPIErrorMessageException(final Throwable cause,
		final Map<String, String> errorsObjects)
	{

		super(cause);
		this.errorMap = errorsObjects;

	}

	@Override
	public String getMessage()
	{
		final StringBuilder ret = new StringBuilder();
		ret.append("KORONA.CLOUD.API has returned error codes");
		ret.append(errorMap.toString());

		return ret.toString();
	}

}
