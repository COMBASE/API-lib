package link.json.loader;

import java.text.ParseException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.PriceStandalone;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;
import link.CloudLink;
import link.json.AbstractHasNumberJsonLoader;



/**
 * @author mas
 */
public class PriceStandaloneLoader extends AbstractHasNumberJsonLoader<PriceStandalone>
{
	private OrganizationalUnitLoader organizationalUnitLoader;


	public PriceStandaloneLoader(final CloudLink cloudLink)
	{
		super(DataType.priceStandalone, cloudLink);
	}


	@Override
	public PriceStandalone fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		return null;
	}


	@Override
	public PriceStandalone postAndResolve(final PriceStandalone obj) throws JSONException, ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		if (obj.getOrganizationalUnit() != null)
		{
			if (organizationalUnitLoader == null)
			{
				organizationalUnitLoader = new OrganizationalUnitLoader(cloudLink);
			}
			organizationalUnitLoader.postAndResolve(obj.getOrganizationalUnit());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No OrganizationalUnit to resolve and to pre-post");
		}
		return post(obj);
	}


	@Override
	public JSONObject toJSON(final PriceStandalone value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}
}
