package link.json;

import java.util.Iterator;

import link.CloudLink;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import error.ApiNotReachableException;

/**
 * Initialize this class or extend it in order to shortcut proper JSON formatting. Offers several
 * methods for downloading JSON from KORONA.POS Cloud. Please refer to method description.
 * 
 * @author mas
 * 
 */
public class JsonDownloader implements JsonDownloaderInterface
{

	private final DataType dataType;


	protected CloudLink cloudLink;

	// protected static Logger LOGGER = LoggerFactory.getLogger(JsonDownloader.class);

	private int offset = 0;

	private final int limit = 50;

	public JsonDownloader(final DataType dataType, final String cloudUrl, final String token)
	{
		this.cloudLink = new CloudLink(cloudUrl, token);
		this.dataType = dataType;
	}

	private JSONArray createJsonArray(final String jStr) throws ApiNotReachableException
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

	@Override
	public JSONObject downloadByName(final String name) throws ApiNotReachableException
	{
		final String jStr = cloudLink.getJSONByName(getDataType(), name);
		final JSONObject jObject = createJsonObject(jStr);
		return jObject;
	}

	@Override
	public JSONObject downloadByNumber(final String number) throws ApiNotReachableException
	{
		final String jStr = cloudLink.getJSONByNumber(getDataType(), number);
		final JSONObject jObject = createJsonObject(jStr);
		return jObject;
	}

	@Override
	public JSONArray downloadAllByOffset(final long revision) throws ApiNotReachableException
	{
		final String jStr = cloudLink.getJSONByOffset(getDataType(), Long.toString(revision),
			limit, 0);
		JSONArray jArray = createJsonArray(jStr);
		jArray = recursiveOffsetIterator(jArray, limit, revision, limit);
		return jArray;
	}

	@Override
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

	public Iterator<JSONObject> iterator(final long revision) throws ApiNotReachableException
	{
		return new CloudResultIterator(this, revision);

	}

	@Override
	public JSONArray downloadByRevision(final long revision) throws ApiNotReachableException
	{
		final String jStr = cloudLink.getJSONByRevision(getDataType(), Long.toString(revision));
		final JSONArray jArray = createJsonArray(jStr);
		return jArray;
	}

	@Override
	public JSONObject downloadByUUID(final String uuid) throws ApiNotReachableException
	{
		final String jStr = cloudLink.getJSONByUuid(getDataType(), uuid);
		final JSONObject jObject = createJsonObject(jStr);
		return jObject;
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
	private JSONArray recursiveOffsetIterator(JSONArray jArray, final int offset,
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
