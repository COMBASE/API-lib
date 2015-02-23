package link.json.loader;

import link.CloudLink;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

import domain.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

/**
 * Sends a request to the cloud to get an access token
 *
 * @author art
 *
 */
public class TokenLoader
{

	protected final CloudLink cloudLink;

	public TokenLoader(final CloudLink cloudLink)
	{
		this.cloudLink = cloudLink;
	}

	public String downloadToken(final String appID, final String appSecret, final String userName,
		final String password) throws ApiNotReachableException, KoronaCloudAPIErrorMessageException
	{

		String reference = null;

		final String encName = Base64.encodeBase64String(StringUtils.getBytesUtf8(userName));
		final String encPassword = Base64.encodeBase64String(StringUtils.getBytesUtf8(password));

		reference = appID + "/" + appSecret + "/?login=" + encName + "&password=" + encPassword;

		try
		{
			return cloudLink.getTokenByAuthData(DataType.auth, reference);
		}
		catch (final InvalidTokenException e)
		{
			// TODO check whether where is another way to avoid this method from throwing invalid
// token
			return "invalid token exception thrown";
		}
	}

}