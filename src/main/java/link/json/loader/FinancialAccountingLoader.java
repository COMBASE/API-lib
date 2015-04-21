package link.json.loader;

import java.text.ParseException;

import link.CloudLink;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.FinancialAccounting;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

public class FinancialAccountingLoader
{

	public static final Logger LOGGER = Logger.getLogger(FinancialAccountingLoader.class);

	private final CloudLink cloudLink;

	public FinancialAccountingLoader(final CloudLink cloudLink)
	{
		super();
		this.cloudLink = cloudLink;
	}

	/**
	 * Returns an org.jettison.JSONArray of all JSONObjects greater than given revision.
	 *
	 * @param number
	 * @return org.jettison.JSONArray
	 * @throws ApiNotReachableException
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 */
	public JSONObject downloadByRevision(final long revision) throws ApiNotReachableException,
	KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		final String jStr = cloudLink.getJSONByRevision(getDataType(), Long.toString(revision));
		final JSONObject jObj = createJsonObject(jStr);
		return jObj;
	}

	public FinancialAccounting fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final FinancialAccounting financialAccounting = FinancialAccounting.fromJSON(obj);
		return financialAccounting;
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
			// JsonDownloader.LOGGER.warn("Empty JSON String.");
			return null;
		}
	}

	private DataType getDataType()
	{
		return DataType.financialAccountingItem;
	}
}
