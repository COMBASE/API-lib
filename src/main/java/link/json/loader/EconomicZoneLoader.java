package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.EconomicZone;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

public class EconomicZoneLoader extends AbstractHasNameJsonLoader<EconomicZone>
{

	public EconomicZoneLoader(final CloudLink cloudLink)
	{
		super(DataType.economicZone, cloudLink);
	}

	@Override
	public EconomicZone fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final EconomicZone economicZone = EconomicZone.fromJSON(obj);
		return economicZone;
	}

	@Override
	public EconomicZone postAndResolve(final EconomicZone obj) throws JSONException,
		ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException,
		ApiNotReachableException
	{
		LOGGER.debug(super.getDataType() + ": Nothing to resolve and to pre-post");

		return post(obj);
	}

	@Override
	public JSONObject toJSON(final EconomicZone value) throws JSONException
	{
		final JSONObject obj = value.toJSON();

		return obj;
	}

}
