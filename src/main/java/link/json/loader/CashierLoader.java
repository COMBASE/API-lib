package link.json.loader;

import java.text.ParseException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Cashier;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;
import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;



public class CashierLoader extends AbstractHasNameJsonLoader<Cashier>
{

	public CashierLoader(final CloudLink cloudLink)
	{
		super(DataType.cashier, cloudLink);
	}


	@Override
	public Cashier fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Cashier cashier = Cashier.fromJSON(obj);
		return cashier;
	}


	@Override
	public Cashier postAndResolve(final Cashier obj) throws JSONException, ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		LOGGER.debug(super.getDataType() + ": Nothing to resolve and to pre-post");
		return post(obj);
	}


	@Override
	public JSONObject toJSON(final Cashier value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}
}
