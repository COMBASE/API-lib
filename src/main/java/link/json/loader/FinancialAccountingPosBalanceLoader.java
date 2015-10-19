package link.json.loader;

import java.text.ParseException;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.FinancialAccountingPosBalance;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.ErrorMessages;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;
import link.CloudLink;



public class FinancialAccountingPosBalanceLoader
{
	public static final Logger LOGGER = Logger.getLogger(FinancialAccountingPosBalanceLoader.class);

	private final CloudLink cloudLink;


	public FinancialAccountingPosBalanceLoader(final CloudLink cloudLink)
	{
		super();
		this.cloudLink = cloudLink;
	}


	public JSONObject downloadByDay(final int year, final int month, final int dayOfMonth) throws ApiNotReachableException, KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		try
		{
			final String jStr = cloudLink.getJSONByDay(getDataType(), year, month, dayOfMonth);
			final JSONObject jObj = createJsonObject(jStr);
			return jObj;
		}
		catch (final KoronaCloudAPIErrorMessageException e)
		{
			if (e.getErrorMap().containsKey(ErrorMessages.No_object_found_for_day.getErrorString()))
			{
				return null;
			}
			else
			{
				throw new KoronaCloudAPIErrorMessageException(e, e.getErrorMap());
			}
		}
	}


	/**
	 * Returns an org.jettison.JSONObject of all items greater than given
	 * revision.
	 *
	 * @param number
	 * @return org.jettison.JSONObject
	 * @throws ApiNotReachableException
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 */
	public JSONObject downloadByRevision(final long revision) throws ApiNotReachableException, KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		try
		{
			final String jStr = cloudLink.getJSONByRevision(getDataType(), Long.toString(revision));
			final JSONObject jObj = createJsonObject(jStr);
			return jObj;
		}
		catch (final KoronaCloudAPIErrorMessageException e)
		{
			if (e.getErrorMap().containsKey(ErrorMessages.No_object_found_for_revision.getErrorString()))
			{
				return null;
			}
			else
			{
				throw new KoronaCloudAPIErrorMessageException(e, e.getErrorMap());
			}
		}
	}


	public FinancialAccountingPosBalance fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final FinancialAccountingPosBalance accountingPosBalance = FinancialAccountingPosBalance.fromJSON(obj);
		return accountingPosBalance;
	}


	private JSONObject createJsonObject(final String jStr) throws ApiNotReachableException
	{

		try
		{
			JSONObject jsonObj = new JSONObject(jStr);
			jsonObj = jsonObj.getJSONObject("result");
			return jsonObj;
		}
		catch (final JSONException e)
		{
			LOGGER.warn("Empty JSON String.");
			return null;
		}
	}


	private DataType getDataType()
	{
		return DataType.financialAccountingPosBalances;
	}
}
