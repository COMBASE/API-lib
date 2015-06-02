package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasIdJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.PosBalance;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

public class PosBalanceLoader extends AbstractHasIdJsonLoader<PosBalance>
{
	CashierLoader cashierLoader;

	POSLoader posLoader;

	public PosBalanceLoader(final CloudLink cloudLink)
	{
		super(DataType.posBalance, cloudLink);
	}

	@Override
	public PosBalance fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final PosBalance posBalance = PosBalance.fromJSON(obj);
		return posBalance;
	}

	@Override
	public PosBalance postAndResolve(final PosBalance obj) throws JSONException, ParseException,
	KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		if (obj.getCashier() != null)
		{
			if (cashierLoader == null)
			{
				cashierLoader = new CashierLoader(cloudLink);
			}
			cashierLoader.postAndResolve(obj.getCashier());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No Cashier to resolve and to pre-post");
		}

		if (obj.getPos() != null)
		{
			if (posLoader == null)
			{
				posLoader = new POSLoader(cloudLink);
			}
			posLoader.postAndResolve(obj.getPos());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No POS to resolve and to pre-post");
		}

		return post(obj);
	}

	@Override
	public JSONObject toJSON(final PosBalance value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}

}
