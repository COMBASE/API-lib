package link;

import java.io.IOException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;

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
	public CloudLink(String cloudUrl, String token)
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
	 * @throws IOException
	 */
	public String getJSON(DataType type, String reference) throws IOException
	{
		return new String(ApiCon.fetchData(type, reference));
	}

	/**
	 * Saves an Object in JSON-format in the Cloud
	 * 
	 * @param type
	 * @param obj
	 * @return
	 */
	public boolean postJSON(DataType type, JSONObject obj)
	{
		return ApiCon.postData(type, obj);
	}

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
	 * Gets the UUID of an Object in the Cloud
	 * 
	 * @param type
	 * @param reference
	 * @return
	 */
	public static String getUUID(DataType type, String reference) throws IOException
	{
		if (ApiCon == null)
			System.err.println("Please initiliaze a CloudLink Object first!");
		if (reference == null)
			return null;
		try
		{
			JSONObject obj = new JSONObject(ApiCon.fetchData(type, reference).toString());
			if (obj.has("result") && obj.get("result") != null)
			{
				obj = obj.getJSONObject("result");
				if (obj.has("uuid"))
				{
					return obj.get("uuid").toString();
				}
			}
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets the number of an Object in the Cloud
	 * 
	 * @param type
	 * @param reference
	 * @return
	 * @throws IOException
	 */
	public static int getNumber(DataType type, String reference) throws IOException
	{
		if (ApiCon == null)
			System.err.println("Please initiliaze a CloudLink Object first!");
		if (reference == null)
			return 0;
		try
		{
			JSONObject obj = new JSONObject(ApiCon.fetchData(type, reference).toString());
			if (obj.has("result") && obj.get("result") != null)
			{
				obj = obj.getJSONObject("result");
				if (obj.has("number"))
				{
					return Integer.valueOf(obj.get("number").toString()).intValue();
				}
			}
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return 0;
	}
}
