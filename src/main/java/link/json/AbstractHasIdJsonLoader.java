package link.json;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import link.CloudLink;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.interfaces.HasId;
import error.ApiNotReachableException;

/**
 * Initialize this class or extend it in order to shortcut proper JSON formatting. Offers several
 * methods for downloading JSON from KORONA.POS Cloud. Please refer to method description.
 * 
 * @author mas
 * 
 */
public abstract class AbstractHasIdJsonLoader<T extends HasId>
{

	private final DataType dataType;

	protected CloudLink cloudLink;

	// protected static Logger LOGGER = LoggerFactory.getLogger(JsonDownloader.class);

	// extern gesteuert
	private int offset = 0;

	private final int limit = 50;

	private final Map<String, T> idCache = new HashMap<String, T>();

	public AbstractHasIdJsonLoader(final DataType dataType, final String cloudUrl,
		final String token)
	{
		this.cloudLink = new CloudLink(cloudUrl, token);
		this.dataType = dataType;
	}


	public abstract JSONObject toJSON(T value) throws JSONException;

	public abstract T fromJSON(JSONObject obj) throws JSONException, ParseException;

	public JSONObject appendTheJson(final T value) throws JSONException
	{
		final JSONObject obj = new JSONObject();

		obj.put("uuid", value.getId());
		obj.put("deleted", value.isDeleted());
		obj.put("revision", value.getRevision());


		return new JSONObject();
	}

	protected JSONArray createJsonArray(final String jStr) throws ApiNotReachableException
	{
		try
		{
			final JSONObject jsonObj = new JSONObject(jStr);
			JSONArray jsonArray = new JSONArray();
			jsonArray = jsonObj.getJSONArray("resultList");
			return jsonArray;
		}
		catch (final JSONException e)
		{
			// JsonDownloader.LOGGER.warn("Empty JSON String.");
			return null;
		}
	}

	protected JSONObject createJsonObject(final String jStr) throws ApiNotReachableException
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

	/**
	 * returns an org.jettison.JSONArray of all org.jettison.JSONObjects having the same or greater
	 * revision than the given one from KORONA.POS Cloud.
	 * 
	 * @param revision
	 * @return
	 * @throws ApiNotReachableException
	 */
	public JSONArray downloadAllByOffset(final long revision) throws ApiNotReachableException
	{
		final String jStr = cloudLink.getJSONByOffset(getDataType(), Long.toString(revision),
			limit, 0);
		JSONArray jArray = createJsonArray(jStr);
		jArray = recursiveOffsetIterator(jArray, limit, revision, limit);
		return jArray;
	}

	/**
	 * for proper use you have to ensure that the JSONDownloader Object is kept alive as long you
	 * haven't got all needed JsonObjects!
	 * 
	 * returns an org.jettison.JSONArray of all org.jettison.JSONObjects having the same or greater
	 * revision than the given one from KORONA.POS Cloud. This method is used to download a certain
	 * number of JSONObjects procede them and downloader the next amount of JSONOBjects. Each method
	 * call increases the offset. Ensure to stop looping as this method returns null.
	 * 
	 * @param number
	 * @return JSONArray
	 * @throws ApiNotReachableException
	 */
	public JSONArray downloadByOffset(final long revision) throws ApiNotReachableException
	{
		final String jStr = cloudLink.getJSONByOffset(getDataType(), Long.toString(revision),
			limit, offset);
		final JSONArray jArray = createJsonArray(jStr);
		if (jArray == null)
			return null;
		offset += limit;
		return jArray;
	}

	/**
	 * Returns an org.jettison.JSONArray of all JSONObjects equal or greater than given revision.
	 * 
	 * @param number
	 * @return
	 * @throws ApiNotReachableException
	 */
	public JSONArray downloadByRevision(final long revision) throws ApiNotReachableException
	{
		final String jStr = cloudLink.getJSONByRevision(getDataType(), Long.toString(revision));
		final JSONArray jArray = createJsonArray(jStr);
		return jArray;
	}

	/**
	 * returns the corresponding org.jettison.JSONObject by UUID from KORONA.POS Cloud
	 * 
	 * @param number
	 * @return
	 * @throws ApiNotReachableException
	 * @throws ParseException
	 */
	public T downloadByUUID(final String uuid) throws ApiNotReachableException, JSONException,
		ParseException
	{
		final T cachedObject = idCache.get(uuid);
		if (cachedObject != null)
		{
			return cachedObject;
		}

		final String jStr = cloudLink.getJSONByUuid(getDataType(), uuid);
		final JSONObject jObject = createJsonObject(jStr);
		final T downloaded = fromJSON(jObject);
		idCache.put(uuid, downloaded);
		return downloaded;
	}


	public T post(final T obj) throws ApiNotReachableException, JSONException, ParseException
	{
		final String result = CloudLink.getConnector().postData(getDataType(), toJSON(obj));
		final JSONObject jObj = new JSONObject(result);
		final T ret = fromJSON(jObj);
		updateCachedObject(ret);
		return ret;
	}


	public void updateCachedObject(final T obj)
	{
		if (obj.getId() != null)
			idCache.put(obj.getId(), obj);
	}

	public Iterator<JSONObject> iterator(final long revision) throws ApiNotReachableException
	{
		return new CloudResultIterator(this, revision);

	}

	protected DataType getDataType()
	{
		return dataType;
	}

	/**
	 * recursive helper method for downloadByOffset
	 * 
	 * @param jArray
	 * @param offset
	 * @param revision
	 * @param limit
	 * @return
	 * @throws ApiNotReachableException
	 */
	protected JSONArray recursiveOffsetIterator(JSONArray jArray, final int offset,
		final long revision, final int limit) throws ApiNotReachableException
	{

		final String jStr = cloudLink.getJSONByOffset(getDataType(), Long.toString(revision),
			limit, offset);
		try
		{
			final JSONObject newStuff = new JSONObject(jStr);

			if (!newStuff.getString("resultList").equalsIgnoreCase("null"))
			{

				final JSONArray newStuffArray = newStuff.getJSONArray("resultList");
				for (int i = 0; i <= newStuffArray.length() - 1; i++)
					jArray.put(newStuffArray.getJSONObject(i));
				jArray = recursiveOffsetIterator(jArray, offset + limit, revision, limit);

			}
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
		}
		return jArray;
	}


}
