package link;

import java.io.IOException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import error.ApiNotReachableException;

/**
 * This is the most important Class of this library you definetely want to
 * initialize it
 *
 * @author Gordon Bosch
 *
 */
public class CloudLink {
	private static ApiConnector ApiCon;

	/**
	 * initializes the Link to the Cloud with the URL of the Cloud and the Token
	 * to Authenticate to generate the Token read this:
	 * http://www.combase-usa.com/qa/api-authentication/
	 *
	 * @param cloudUrl
	 * @param token
	 */
	public CloudLink(String cloudUrl, String token) {
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
	public String getJSONByRevision(DataType type, String reference) throws ApiNotReachableException {
		reference = "/updates/" + reference;
		return new String(ApiCon.fetchData(type, reference));
	}

	public String getJSONByUuid(DataType type, String reference) throws ApiNotReachableException {
		reference = "/id/" + reference;
		return new String(ApiCon.fetchData(type, reference));
	}

	public String getJSONByName(DataType type, String reference) throws ApiNotReachableException {
		reference = reference.replaceAll("/", "%2F");
		reference = reference.replaceAll("&", "%26");
		reference = reference.replaceAll("#", "%23");
		reference = reference.replaceAll("!", "%21");
		//System.out.println("NameString: " + reference);
		reference = "/name/" + reference;
		return new String(ApiCon.fetchData(type, reference));
	}

	public String getJSONByNumber(DataType type, String reference) throws ApiNotReachableException {
		reference = "/number/" + reference;
		return new String(ApiCon.fetchData(type, reference));
	}

	/**
	 *
	 * @param reference
	 * first and last name are necessary divided by a white space
	 * for a successful
	 * @return
	 * @throws ApiNotReachableException
	 */
	public String getJSONByCustomerName(String reference) throws ApiNotReachableException {
		String[] names = reference.split(" ");
		reference = "/byName/" + names[0] + "/" + names[1];
		return new String(ApiCon.fetchData(DataType.customer, reference));
	}
	/**
	 * Getting JSONString from Cloud by revision, limit and offset offering the opportunity to load 
	 * multiple JSONObjects page by page in order to avoid timeouts on huge database queries. 
	 * 
	 * @param type
	 * @param revision
	 * @param limit (number of JSONObejcts per page)
	 * @param offset (defines the page to be loaded i.e. offset=0 means all objects from 0 to limit)
	 * @return
	 * @throws ApiNotReachableException
	 */
	public String getJSONByOffset(DataType type, String revision,int limit,int offset) throws ApiNotReachableException{
		String reference="/updates/"+revision+"/"+limit+"/"+offset;
		return new String(ApiCon.fetchData(type, reference));
	}

	/**
	 * Saves an Object in JSON-format in the Cloud
	 *
	 * @param type
	 * @param obj
	 * @return
	 */
	public boolean postJSON(DataType type, JSONObject obj) {
		return ApiCon.postData(type, obj);
	}

	/**
	 * Gives us our Connector, which is the interface we need to interact with
	 * the Cloud
	 *
	 * @return
	 */
	public static ApiConnector getConnector() {
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
	public static String getUUIDByName(DataType type, String reference) {
		if (ApiCon == null)
			System.err.println("Please initiliaze a CloudLink Object first!");
		if (reference == null)
			return null;
		try {
			reference = reference.replaceAll("/", "%2F");
			reference = reference.replaceAll("&", "%26");
			reference = reference.replaceAll("#", "%23");
			reference = reference.replaceAll("!", "%21");
			JSONObject obj = null;
			try {
				obj = new JSONObject(ApiCon.fetchData(type, "/name/" + reference).toString());
			} catch (ApiNotReachableException e) {
				return null;
			}
			if (obj.has("result") && !obj.opt("result").equals(null)) {
				obj = obj.getJSONObject("result");
				if (obj.has("uuid") && !obj.opt("uuid").equals(null)) {
					return obj.get("uuid").toString();
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getUUIDByNumber(DataType type, String reference) throws ApiNotReachableException {
		if (ApiCon == null)
			System.err.println("Please initiliaze a CloudLink Object first!");
		if (reference == null)
			return null;
		try {
			reference = reference.replaceAll("/", "%2F");
			reference = reference.replaceAll("&", "%26");
			reference = reference.replaceAll("#", "%23");
			reference = reference.replaceAll("!", "%21");
			JSONObject obj = new JSONObject(ApiCon.fetchData(type, "/number/" + reference).toString());
			if (obj.has("result") && !obj.opt("result").equals(null)) {
				obj = obj.getJSONObject("result");
				if (obj.has("uuid") && !obj.opt("uuid").equals(null)) {
					return obj.get("uuid").toString();
				}
			}
		} catch (JSONException e) {
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
	public static int getNumberByName(DataType type, String reference) {
		if (ApiCon == null)
			System.err.println("Please initiliaze a CloudLink Object first!");
		if (reference == null)
			return 0;
		try {
			JSONObject obj = null;
			try {
				obj = new JSONObject(ApiCon.fetchData(type, "/name/" + reference).toString());
			} catch (ApiNotReachableException e) {
				return 0;
			}
			if (obj.has("result") && !obj.opt("result").equals(null)) {
				obj = obj.getJSONObject("result");
				if (obj.has("number") && !obj.opt("number").equals(null)) {
					return Integer.valueOf(obj.get("number").toString()).intValue();
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int getNumberByUuid(DataType type, String reference) throws ApiNotReachableException {
		if (ApiCon == null)
			System.err.println("Please initiliaze a CloudLink Object first!");
		if (reference == null)
			return 0;
		try {
			JSONObject obj = new JSONObject(ApiCon.fetchData(type, "/id/" + reference).toString());
			if (obj.has("result") && !obj.opt("result").equals(null)) {
				obj = obj.getJSONObject("result");
				if (obj.has("number") && !obj.opt("number").equals(null)) {
					return Integer.valueOf(obj.get("number").toString()).intValue();
				}
			}
		} catch (JSONException e) {
			return 0;
		}
		return 0;
	}

}
