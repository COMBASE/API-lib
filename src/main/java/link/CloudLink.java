package link;

import java.io.IOException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.ReferenceType;
import error.ApiNotReachableException;

/**
 * This is the most important Class of this library you definetely want to initialize it
 * 
 * @author Gordon Bosch
 * 
 */
public class CloudLink
{
	private static ApiConnector ApiCon;

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
	 * fetches an Object in JSON-format from the Cloud
	 * 
	 * @param type
	 * @param reference
	 * @return
	 * @throws ApiNotReachableException
	 */
	public String getJSONByRevision(final DataType type, final String reference)
		throws ApiNotReachableException
	{
		return new String(ApiCon.fetchData(type, ReferenceType.revision, reference));
	}

	public String getJSONByUuid(final DataType type, final String reference)
		throws ApiNotReachableException
	{
		return new String(ApiCon.fetchData(type, ReferenceType.uuid, reference));
	}

	/**
	 * gets jsonstring by Article Code like EAN or GTIN
	 * 
	 * @param type
	 * @param reference
	 * @return Product JSON String
	 * @throws ApiNotReachableException
	 */
	public String getJSONByCode(String reference) throws ApiNotReachableException
	{
		reference = reference.replaceAll(" ", "%20");
		reference = reference.replaceAll("/", "%2F");
		reference = reference.replaceAll("&", "%26");
		reference = reference.replaceAll("#", "%23");
		reference = reference.replaceAll("!", "%21");
		return new String(ApiCon.fetchData(DataType.product, ReferenceType.code, reference));
	}

	/**
	 * gets jsonstring by name.
	 * 
	 * @param type
	 * @param reference
	 * @return
	 * @throws ApiNotReachableException
	 */
	public String getJSONByName(final DataType type, String reference)
		throws ApiNotReachableException
	{
		reference = reference.replaceAll(" ", "%20");
		reference = reference.replaceAll("/", "%2F");
		reference = reference.replaceAll("&", "%26");
		reference = reference.replaceAll("#", "%23");
		reference = reference.replaceAll("!", "%21");
		return new String(ApiCon.fetchData(type, ReferenceType.name, reference));
	}

	public String getJSONByNumber(final DataType type, final String reference)
		throws ApiNotReachableException
	{
		return new String(ApiCon.fetchData(type, ReferenceType.number, reference));
	}

	/**
	 * 
	 * @param reference
	 *            first and last name are necessary divided by a white space for a successful
	 * @return
	 * @throws ApiNotReachableException
	 */
	public String getJSONByCustomerName(String reference) throws ApiNotReachableException
	{
		final String[] names = reference.split(" ");
		reference = names[0] + "/" + names[1];
		return new String(
			ApiCon.fetchData(DataType.customer, ReferenceType.customerName, reference));
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
	 */
	public String getJSONByOffset(final DataType type, final String revision, final int limit,
		final int offset) throws ApiNotReachableException
	{
		final String reference = revision + "/" + limit + "/" + offset;
		return new String(ApiCon.fetchData(type, ReferenceType.offset, reference));
	}

// /**
// * Saves an Object in JSON-format in the Cloud
// *
// * @param type
// * @param obj
// * @return
// */
// public boolean postJSON(final DataType type, final JSONObject obj)
// {
// return ApiCon.postData(type, obj);
// }

	/**
	 * Gives us our Connector, which is the interface we need to interact with the Cloud
	 * 
	 * @return
	 */
	public static ApiConnector getConnector()
	{
		if (ApiCon == null)
			System.err.println("Please initiliaze a CloudLink Object first!");
		return ApiCon;
	}

	/**
	 * Gets the UUID of an Object in the Cloud by Name/Number
	 * 
	 * @param type
	 * @param reference
	 * @return
	 */
	public static String getUUIDByName(final DataType type, String reference)
	{
		if (ApiCon == null)
			System.err.println("Please initiliaze a CloudLink Object first!");
		if (reference == null)
			return null;

		reference = reference.replaceAll(" ", "%20");
		reference = reference.replaceAll("/", "%2F");
		reference = reference.replaceAll("&", "%26");
		reference = reference.replaceAll("#", "%23");
		reference = reference.replaceAll("!", "%21");

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
				System.out.println("ApiNotReachableException");
				e.printStackTrace();
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
		throws ApiNotReachableException
	{
		if (ApiCon == null)
			System.err.println("Please initiliaze a CloudLink Object first!");
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
	 * Gets the number of an Object in the Cloud By Name/Uuid
	 * 
	 * @param type
	 * @param reference
	 * @return
	 * @throws IOException
	 */
	public static String getNumberByName(final DataType type, String reference)
	{
		if (ApiCon == null)
			System.err.println("Please initiliaze a CloudLink Object first!");
		if (reference == null)
			return null;

		reference = reference.replaceAll(" ", "%20");
		reference = reference.replaceAll("/", "%2F");
		reference = reference.replaceAll("&", "%26");
		reference = reference.replaceAll("#", "%23");
		reference = reference.replaceAll("!", "%21");

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
		throws ApiNotReachableException
	{
		if (ApiCon == null)
			System.err.println("Please initiliaze a CloudLink Object first!");
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

}
