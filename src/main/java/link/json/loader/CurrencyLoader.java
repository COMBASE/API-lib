package link.json.loader;

import java.text.ParseException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Currency;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;
import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;



public class CurrencyLoader extends AbstractHasNameJsonLoader<Currency>
{

	public CurrencyLoader(final CloudLink cloudLink)
	{
		super(DataType.currency, cloudLink);
	}


	@Override
	public Currency fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Currency currency = Currency.fromJSON(obj);
		return currency;
	}


	@Override
	public Currency postAndResolve(final Currency obj) throws JSONException, ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		LOGGER.debug(super.getDataType() + ": Nothing to resolve and to pre-post");
		return post(obj);
	}


	@Override
	public JSONObject toJSON(final Currency value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}
}
