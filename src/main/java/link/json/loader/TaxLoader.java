package link.json.loader;

import java.text.ParseException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Tax;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;
import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;



public class TaxLoader extends AbstractHasNameJsonLoader<Tax>
{
	private EconomicZoneLoader economicZoneLoader;


	public TaxLoader(final CloudLink cloudLink)
	{
		super(DataType.tax, cloudLink);
	}


	@Override
	public Tax fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Tax tax = Tax.fromJSON(obj);
		return tax;
	}


	@Override
	public Tax postAndResolve(final Tax obj) throws JSONException, ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		if (obj.getEconomicZone() != null)
		{
			if (economicZoneLoader == null)
			{
				economicZoneLoader = new EconomicZoneLoader(cloudLink);
			}
			economicZoneLoader.postAndResolve(obj.getEconomicZone());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No EconomicZone to resolve and to pre-post");
		}

		return post(obj);
	}


	@Override
	public JSONObject toJSON(final Tax value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}
}
