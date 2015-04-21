package link;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.enums.DataType;
import domain.enums.ReferenceType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

/**
 * This is the most important Class of this library right after the JSONLoader classes. You
 * definetely want to initialize it!
 *
 * @author Gordon Bosch
 *
 */
public class CloudLink
{
	protected final static Logger LOGGER = Logger.getLogger(CloudLink.class);
	private static ApiConnector ApiCon;

	/**
	 * Gives us our Connector, which is the interface we need to interact with the Cloud
	 *
	 * @return
	 */
	public static ApiConnector getConnector()
	{
		if (ApiCon == null)
			LOGGER.error("Please initiliaze a CloudLink Object first!");
		return ApiCon;
	}

	/**
	 * Gets the number of an Object in the Cloud By Name/Uuid
	 *
	 * @param type
	 * @param reference
	 * @return
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 * @throws IOException
	 */
	public static String getNumberByName(final DataType type, String reference)
		throws KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		if (ApiCon == null)
			LOGGER.error("Please initiliaze a CloudLink Object first!");
		if (reference == null)
			return null;

		reference = reference.replaceAll(" ", "%20");
		reference = reference.replaceAll("/", "%2F");
		reference = reference.replaceAll("&", "%26");
		reference = reference.replaceAll("#", "%23");
		reference = reference.replaceAll("!", "%21");
		reference = reference.replaceAll("%", "%20");

		try
		{
			JSONObject obj = null;
			try
			{
				obj = new JSONObject(ApiCon.fetchData(type, ReferenceType.name, reference)
					.toString());
			}
			catch (final ApiNotReachableException e)
			{
				e.printStackTrace();
				return null;
			}
			if (obj.has("result") && !obj.opt("result").equals(null))
			{
				obj = obj.getJSONObject("result");
				if (obj.has("number") && !obj.opt("number").equals(null))
				{
					return obj.getString("number");
				}
			}
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static String getNumberByUuid(final DataType type, final String reference)
		throws ApiNotReachableException, KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		if (ApiCon == null)
			LOGGER.error("Please initiliaze a CloudLink Object first!");
		if (reference == null)
			return null;
		try
		{
			JSONObject obj = new JSONObject(ApiCon.fetchData(type, ReferenceType.number, reference)
				.toString());
			if (obj.has("result") && !obj.opt("result").equals(null))
			{
				obj = obj.getJSONObject("result");
				if (obj.has("number") && !obj.opt("number").equals(null))
				{
					return obj.getString("number");
				}
			}
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
			return null;

		}
		return null;
	}

	/**
	 * Gets the UUID of an Object in the Cloud by Name/Number
	 *
	 * @param type
	 * @param reference
	 * @return
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 */
	public static String getUUIDByName(final DataType type, String reference)
		throws KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		if (ApiCon == null)
			LOGGER.error("Please initiliaze a CloudLink Object first!");
		if (reference == null)
			return null;

		reference = reference.replaceAll(" ", "%20");
		reference = reference.replaceAll("/", "%2F");
		reference = reference.replaceAll("&", "%26");
		reference = reference.replaceAll("#", "%23");
		reference = reference.replaceAll("!", "%21");
		reference = reference.replaceAll("%", "%20");

		try
		{

			JSONObject obj = null;
			try
			{
				obj = new JSONObject(ApiCon.fetchData(type, ReferenceType.name, reference)
					.toString());
			}
			catch (final ApiNotReachableException e)
			{
				LOGGER.error(e);
				return null;
			}
			if (obj.has("result") && !obj.opt("result").equals(null))
			{
				obj = obj.getJSONObject("result");
				if (obj.has("uuid") && !obj.opt("uuid").equals(null))
				{
					return obj.get("uuid").toString();
				}
			}
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static String getUUIDByNumber(final DataType type, final String reference)
		throws ApiNotReachableException, KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		if (ApiCon == null)
			LOGGER.error("Please initiliaze a CloudLink Object first!");
		if (reference == null)
			return null;
		try
		{
			JSONObject obj = new JSONObject(ApiCon.fetchData(type, ReferenceType.number, reference)
				.toString());
			if (obj.has("result") && !obj.opt("result").equals(null))
			{
				obj = obj.getJSONObject("result");
				if (obj.has("uuid") && !obj.opt("uuid").equals(null))
				{
					return obj.get("uuid").toString();
				}
			}
		}
		catch (final JSONException e)
		{
			return null;
		}
		return null;
	}

	/**
	 * initializes the Link to the Cloud with the URL of the Cloud and the Token to Authenticate to
	 * generate the Token read this: http://www.combase-usa.com/qa/api-authentication/
	 *
	 * @param cloudUrl
	 * @param token
	 */
	public CloudLink(String cloudUrl, final String token)
	{
		super();
		if (!cloudUrl.endsWith("/api/v1"))
			cloudUrl = cloudUrl + "/api/v1";
		ApiCon = new ApiConnector(cloudUrl, token);
	}

	/**
	 * gets jsonstring by Article Code like EAN or GTIN
	 *
	 * @param type
	 * @param reference
	 * @return Product JSON String
	 * @throws ApiNotReachableException
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 * @throws JSONException
	 */
	public String getJSONByCode(String reference) throws ApiNotReachableException, JSONException,
		KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		reference = reference.replaceAll(" ", "%20");
		reference = reference.replaceAll("/", "%2F");
		reference = reference.replaceAll("&", "%26");
		reference = reference.replaceAll("#", "%23");
		reference = reference.replaceAll("!", "%21");
		reference = reference.replaceAll("%", "%20");
		return new String(ApiCon.fetchData(DataType.product, ReferenceType.code, reference));
	}

	/**
	 *
	 * @param reference
	 *            first and last name are necessary divided by a white space for a successful
	 * @return
	 * @throws ApiNotReachableException
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 * @throws JSONException
	 */
	public String getJSONByCustomerName(String reference) throws ApiNotReachableException,
		JSONException, KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		final String[] names = reference.split(" ");
		reference = names[0] + "/" + names[1];
		return new String(
			ApiCon.fetchData(DataType.customer, ReferenceType.customerName, reference));
	}

	/**
	 * gets jsonstring by name.
	 *
	 * @param type
	 * @param reference
	 * @return
	 * @throws ApiNotReachableException
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 * @throws JSONException
	 */
	public String getJSONByName(final DataType type, String reference)
		throws ApiNotReachableException, KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		reference = reference.replaceAll(" ", "%20");
		reference = reference.replaceAll("/", "%2F");
		reference = reference.replaceAll("&", "%26");
		reference = reference.replaceAll("#", "%23");
		reference = reference.replaceAll("!", "%21");
		reference = reference.replaceAll("%", "%20");
		return new String(ApiCon.fetchData(type, ReferenceType.name, reference));
	}


	public String getJSONByNumber(final DataType type, final String reference)
		throws ApiNotReachableException, KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		return new String(ApiCon.fetchData(type, ReferenceType.number, reference));
	}

	/**
	 * Getting JSONString from Cloud by revision, limit and offset offering the opportunity to load
	 * multiple JSONObjects page by page in order to avoid timeouts on huge database queries.
	 *
	 * @param type
	 * @param revision
	 * @param limit
	 *            (number of JSONObejcts per page)
	 * @param offset
	 *            (defines the page to be loaded i.e. offset=0 means all objects from 0 to limit)
	 * @return
	 * @throws ApiNotReachableException
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 * @throws JSONException
	 */
	public String getJSONByOffset(final DataType type, final String revision, final int limit,
		final int offset) throws ApiNotReachableException, KoronaCloudAPIErrorMessageException,
		InvalidTokenException
	{
		final String reference = revision + "/" + limit + "/" + offset;
		return new String(ApiCon.fetchData(type, ReferenceType.offset, reference));
	}

	/**
	 * fetches an Object in JSON-format from the Cloud
	 *
	 * @param type
	 * @param reference
	 * @return
	 * @throws ApiNotReachableException
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 */
	public String getJSONByRevision(final DataType type, final String reference)
		throws ApiNotReachableException, KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		return new String(ApiCon.fetchData(type, ReferenceType.revision, reference));
	}

	public String getJSONByUuid(final DataType type, final String reference)
		throws ApiNotReachableException, KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		return new String(ApiCon.fetchData(type, ReferenceType.uuid, reference));
	}

	/**
	 * Gets a JSONString from the cloud by offset, calling the page reference.
	 *
	 * @param type
	 * @param limit
	 * @param offset
	 * @return
	 * @throws ApiNotReachableException
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 */
	public String getJSONPageByOffset(final DataType type, final int limit, final int offset)
		throws ApiNotReachableException, KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		final String reference = limit + "/" + offset;
		return new String(ApiCon.fetchData(type, ReferenceType.page, reference));
	}

	public String getTokenByAuthData(final DataType type, final String reference)
		throws ApiNotReachableException, KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		if (ApiCon == null)
			LOGGER.error("Please initiliaze a CloudLink Object first!");
		if (reference == null)
			return null;

		String token = null;

		token = ApiCon.fetchData(type, ReferenceType.auth, reference);


		return token;
	}

	/**
	 * Saves an Object in JSON-format in the Cloud
	 *
	 * @param type
	 * @param obj
	 * @return
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 * @throws ArticleCodeMustBeUniqueException
	 */
	public String postJSON(final DataType type, final JSONObject obj)
		throws KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		return ApiCon.postData(type, obj);
	}

}
