package link.json.loader;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

import domain.DataType;
import error.ApiNotReachableException;
import link.CloudLink;

/**
 * Sends a request to the cloud to get an access token
 * 
 * @author art
 *
 */
public class TokenLoader {
	
	protected final CloudLink cloudLink;
	
	public TokenLoader(CloudLink cloudLink)
	{
		this.cloudLink = cloudLink;
	}

	public String downloadToken(final String appID, final String appSecret,
			final String userName, String password) throws ApiNotReachableException
	{
		
		String reference = null;
		
		String encName = Base64.encodeBase64String(StringUtils.getBytesUtf8(userName));
		String encPassword = Base64.encodeBase64String(StringUtils.getBytesUtf8(password));
		
		reference = appID + "/" + appSecret + "/?login=" + encName + "&password=" + encPassword;
		
		return cloudLink.getTokenByAuthData(DataType.auth, reference);
	}
	
}