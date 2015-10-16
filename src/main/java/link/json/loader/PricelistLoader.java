package link.json.loader;

import java.text.ParseException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Pricelist;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;
import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;



public class PricelistLoader extends AbstractHasNameJsonLoader<Pricelist>
{

	public PricelistLoader(final CloudLink cloudLink)
	{
		super(DataType.priceList, cloudLink);
	}


	@Override
	public Pricelist fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Pricelist pricelist = Pricelist.fromJSON(obj);
		return pricelist;
	}


	@Override
	public Pricelist postAndResolve(final Pricelist obj) throws JSONException, ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		LOGGER.debug(super.getDataType() + ": Nothing to resolve and to pre-post");

		return post(obj);
	}


	@Override
	public JSONObject toJSON(final Pricelist value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}
}
