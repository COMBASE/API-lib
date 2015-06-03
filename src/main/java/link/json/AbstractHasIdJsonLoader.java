package link.json;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import link.CloudLink;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.enums.DataType;
import domain.interfaces.HasId;
import error.ApiNotReachableException;
import error.ErrorMessages;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;
import error.PostWithNoReferenceSetException;

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

	protected final CloudLink cloudLink;

	protected static Logger LOGGER = Logger.getLogger(AbstractHasIdJsonLoader.class);

	// extern gesteuert
	private int offset = 0;

	private final int limit = 50;

	private final Map<String, T> idCache = new HashMap<String, T>();

	private String totalElements;

	public AbstractHasIdJsonLoader(final DataType dataType, final CloudLink cloudLink)
	{
		this.cloudLink = cloudLink;
		this.dataType = dataType;
	}

	public JSONArray downloadAllByLimitedRevision(final long revision, final int limit)
		throws ApiNotReachableException, InvalidTokenException, KoronaCloudAPIErrorMessageException
	{
		try
		{
			final String jStr = cloudLink.getJSONByOffset(getDataType(), Long.toString(revision),
				limit, 0);
			final JSONArray jArray = createJsonArray(jStr);
			return jArray;
		}
		catch (final KoronaCloudAPIErrorMessageException e)
		{
			if (e.getErrorMap().containsKey(
				ErrorMessages.No_object_found_for_revision.getErrorString()))
			{
				totalElements = "0";
				return null;
			}
			else
				throw new KoronaCloudAPIErrorMessageException(e, e.getErrorMap());
		}
	}


	/**
	 * returns an org.jettison.JSONArray of all org.jettison.JSONObjects having the same or greater
	 * revision than the given one from KORONA.POS Cloud.
	 *
	 * @param revision
	 * @return
	 * @throws ApiNotReachableException
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 * @throws JSONException
	 */
	public JSONArray downloadAllByOffset(final long revision) throws ApiNotReachableException,
		KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		try
		{
			final String jStr = cloudLink.getJSONByOffset(getDataType(), Long.toString(revision),
				limit, 0);
			JSONArray jArray = createJsonArray(jStr);
			jArray = recursiveOffsetIterator(jArray, limit, revision, limit);
			return jArray;
		}
		catch (final KoronaCloudAPIErrorMessageException e)
		{
			if (e.getErrorMap().containsKey(
				ErrorMessages.No_object_found_for_revision.getErrorString()))
				return null;
			else
				throw new KoronaCloudAPIErrorMessageException(e, e.getErrorMap());
		}
	}

	/**
	 * Used to return a JSONArray of all existing elements.
	 *
	 * @return a JSONArray of existing (not deleted) objects
	 * @throws ApiNotReachableException
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 */
	public JSONArray downloadAllExisting() throws ApiNotReachableException,
	KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		try
		{
			JSONArray jArray = new JSONArray();
			jArray = downloadExistingJSONArrayBuilder(jArray, 0, limit);

			return jArray;
		}
		catch (final KoronaCloudAPIErrorMessageException e)
		{
			if (e.getErrorMap().containsKey(
				ErrorMessages.No_object_found_for_revision.getErrorString()))
				return null;
			else
				throw new KoronaCloudAPIErrorMessageException(e, e.getErrorMap());
		}
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
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 * @throws JSONException
	 */
	public JSONArray downloadByOffset(final long revision) throws ApiNotReachableException,
		KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		try
		{
			final String jStr = cloudLink.getJSONByOffset(getDataType(), Long.toString(revision),
				limit, offset);
			final JSONArray jArray = createJsonArray(jStr);
			if (jArray == null)
				return null;
			offset += limit;

			return jArray;
		}
		catch (final KoronaCloudAPIErrorMessageException e)
		{
			if (e.getErrorMap().containsKey(
				ErrorMessages.No_object_found_for_revision.getErrorString()))
				return null;
			else
				throw new KoronaCloudAPIErrorMessageException(e, e.getErrorMap());
		}
	}

	/**
	 * Downloads the next amountPerPage objects from the cloud starting by the next lowest revision
	 * provided to this method. The Offset is the page controller iterating over pages by
	 * offset+amountPerPage.
	 *
	 * @param revision
	 * @param amountPerPage
	 * @param offset
	 * @return JSONArray
	 * @throws ApiNotReachableException
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 */
	public JSONArray downloadByOffset(final long revision, final int amountPerPage, int offset)
		throws ApiNotReachableException, KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		try
		{
			final String jStr = cloudLink.getJSONByOffset(getDataType(), Long.toString(revision),
				amountPerPage, offset);
			final JSONArray jArray = createJsonArray(jStr);
			if (jArray == null)
				return null;
			offset += amountPerPage;

			return jArray;
		}
		catch (final KoronaCloudAPIErrorMessageException e)
		{
			if (e.getErrorMap().containsKey(
				ErrorMessages.No_object_found_for_revision.getErrorString()))
				return null;
			else
				throw new KoronaCloudAPIErrorMessageException(e, e.getErrorMap());
		}
	}

	/**
	 * Returns an org.jettison.JSONArray of all JSONObjects greater than given revision.
	 *
	 * @param number
	 * @return
	 * @throws ApiNotReachableException
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 */
	public JSONArray downloadByRevision(final long revision) throws ApiNotReachableException,
		KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		try
		{
			final String jStr = cloudLink.getJSONByRevision(getDataType(), Long.toString(revision));
			final JSONArray jArray = createJsonArray(jStr);
			return jArray;
		}
		catch (final KoronaCloudAPIErrorMessageException e)
		{
			if (e.getErrorMap().containsKey(
				ErrorMessages.No_object_found_for_revision.getErrorString()))
				return null;
			else
				throw new KoronaCloudAPIErrorMessageException(e, e.getErrorMap());
		}
	}

	/**
	 * returns the corresponding org.jettison.JSONObject by UUID from KORONA.POS Cloud or null if
	 * there is not such object.
	 *
	 * @param number
	 * @return
	 * @throws ApiNotReachableException
	 * @throws ParseException
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 */
	public T downloadByUUID(final String uuid) throws ApiNotReachableException, ParseException,
		KoronaCloudAPIErrorMessageException, InvalidTokenException
	{

		final T cachedObject = idCache.get(uuid);

		if (cachedObject != null)
			return cachedObject;

		final String jStr;

		try
		{

			jStr = cloudLink.getJSONByUuid(getDataType(), uuid);

		}
		catch (final KoronaCloudAPIErrorMessageException e)
		{

			if (e.getErrorMap().containsKey(ErrorMessages.No_object_found_for_id.getErrorString()))
				return null;
			else
				throw new KoronaCloudAPIErrorMessageException(e, e.getErrorMap());

		}

		final JSONObject jObject = createJsonObject(jStr);

		final T downloaded;
		try
		{

			downloaded = fromJSON(jObject);

		}
		catch (final JSONException e)
		{

			LOGGER.error("KORONA.CLOUD.API returned malformed JSON", e);

			return null;

		}

		idCache.put(uuid, downloaded);

		return downloaded;

	}

	public String downloadJSONStringByOffset(final long revision, final int amountPerPage,
		int offset) throws ApiNotReachableException, KoronaCloudAPIErrorMessageException,
		InvalidTokenException
	{
		try
		{
			final String jStr = cloudLink.getJSONByOffset(getDataType(), Long.toString(revision),
				amountPerPage, offset);
			if (jStr == null)
				return null;
			offset += amountPerPage;
			return jStr;
		}
		catch (final KoronaCloudAPIErrorMessageException e)
		{
			if (e.getErrorMap().containsKey(
				ErrorMessages.No_object_found_for_revision.getErrorString()))
				return null;
			else
				throw new KoronaCloudAPIErrorMessageException(e, e.getErrorMap());
		}
	}

	public T find(final String reference) throws ApiNotReachableException, ParseException,
	KoronaCloudAPIErrorMessageException, InvalidTokenException, IllegalArgumentException
	{
		try
		{
			final String[] components = reference.split("-");
			if (components.length != 5)
				throw new IllegalArgumentException("Invalid UUID string: " + reference);

			return downloadByUUID(reference);
		}
		catch (final KoronaCloudAPIErrorMessageException e)
		{
			if (e.getErrorMap().containsKey(ErrorMessages.Invalid_UUID_string.getErrorString()))
			{
				LOGGER.debug("Not an UID String: " + reference + " Type is " + dataType.toString());
				return null;
			}
			if (e.getErrorMap().containsKey(ErrorMessages.No_object_found_for_id))
			{
				LOGGER.debug("No Object for ID: " + reference + " Type is " + dataType.toString());
				return null;
			}
			else
				throw new KoronaCloudAPIErrorMessageException(e, e.getErrorMap());
		}

	}

	public abstract T fromJSON(JSONObject obj) throws JSONException, ParseException;

	/**
	 * gets the corresponding object out of the cache
	 *
	 * @param id
	 * @return the corresponding object
	 */
	public T getCachedObject(final T object)
	{

		if (object != null && object.getId() != null)
			return idCache.get(object.getId());

		return null;
	}

	public long getTotalElements()
	{
		return Long.parseLong(totalElements);
	}

	public Iterator<JSONObject> iterator(final long revision) throws ApiNotReachableException,
	JSONException, KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		return new CloudResultIterator(this, revision);
	}

	/**
	 * Puts the object into ID, Number and Name caches overriding existing objects with same ID,
	 * Number or Name. Invoking this method will automatically try to update all caches by calling
	 * super method super.post(obj).
	 *
	 * @param obj
	 * @return the updated obj:T previously inserted into this method.
	 * @throws ApiNotReachableException
	 * @throws JSONException
	 * @throws ParseException
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 * @throws ArticleCodeMustBeUniqueException
	 * @throws PostWithNoReferenceSetException
	 */
	public T post(final T obj) throws ApiNotReachableException, JSONException, ParseException,
	KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
// if (obj == null || obj.getId() == null)
// throw new PostWithNoReferenceSetException(null);
// else
		return upload(obj);

	}

	/**
	 * Puts the object into ID, Number and Name caches overriding existing objects with same ID,
	 * Number or Name. Invoking this method will automatically try to update all caches by calling
	 * super method super.post(obj).
	 *
	 * This Method auto posts all necessary subpojos like commodityGroup of Product as long as the
	 * corresponding subpojo is contained by the mainPojo.
	 *
	 * @param obj
	 * @return the updated obj:T previously inserted into this method.
	 * @throws JSONException
	 * @throws ParseException
	 * @throws KoronaCloudAPIErrorMessageException
	 * @throws InvalidTokenException
	 * @throws ApiNotReachableException
	 */
	public abstract T postAndResolve(final T obj) throws JSONException, ParseException,
		KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException;

// public T postAndResolve(final T obj) throws JSONException, ParseException,
// KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
// {
// return null;
// }

	/**
	 * posts all Data
	 *
	 * @param objs
	 * @param limit
	 * @return response:Set<object_type>
	 * @throws JSONException
	 * @throws ParseException
	 * @throws ApiNotReachableException
	 * @throws KoronaCloudAPIErrorMessageException
	 * @throws InvalidTokenException
	 * @throws ArticleCodeMustBeUniqueException
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public List<T> postList(final List<? extends T> objs, final int limit, final int threads)
		throws KoronaCloudAPIErrorMessageException, InvalidTokenException, JSONException,
		ParseException, ApiNotReachableException
	{

		if (objs == null || objs.size() == 0)
			return null;

		final JSONArray jsonObjs = new JSONArray();

		for (final T t : objs)
		{

			jsonObjs.put(toJSON(t));

		}

		updateCache(objs);


		JSONArray result = CloudLink.getConnector().postData(getDataType(), jsonObjs, limit,
			threads);

		List<T> ret = null;

		if (result != null)
		{
			result = result.getJSONArray(0);
			for (int i = 0; result.length() > i; i++)
			{

				final JSONObject resultObj = result.getJSONObject(i);

				final T obj = fromJSON(resultObj);

				if (ret == null)
				{
					ret = new ArrayList<>();
				}

				ret.add(obj);

			}
			updateCache(ret);
		}


		return ret;

	}

	public abstract JSONObject toJSON(T value) throws JSONException;

	public void updateCache(final List<? extends T> objs)
	{
		for (final T obj : objs)
		{
			if (obj.getId() != null)
			{
				if (obj.isDeleted())
				{
					idCache.remove(obj.getId());
				}
				else
				{
					idCache.put(obj.getId(), obj);
				}
			}
		}

	}

	/**
	 * updates given obj corresponding cached version for future loader actions.
	 *
	 * @param obj
	 */
	public void updateCache(final T obj)
	{
		if (obj.getId() != null)
		{
			if (obj.isDeleted())
			{
				idCache.remove(obj.getId());
			}
			else
			{
				idCache.put(obj.getId(), obj);
			}
		}
	}

	protected JSONArray createJsonArray(final String jStr) throws ApiNotReachableException
	{
		try
		{
			final JSONObject jsonObj = new JSONObject(jStr);

			if (jsonObj.has("totalElements") && jsonObj.has("totalPages"))
			{
				LOGGER.debug("requested JSONArray contains " + jsonObj.getString("totalElements") +
					" totalElements in " + jsonObj.getString("totalPages") + " totalPages.");

				totalElements = jsonObj.getString("totalElements");

			}

			JSONArray jsonArray = new JSONArray();
			jsonArray = jsonObj.getJSONArray("resultList");
			return jsonArray;
		}
		catch (final JSONException e)
		{
			LOGGER.debug("Empty JSON String.");
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
	 * helper method for downloadAllExisting
	 *
	 * @param jArray
	 * @param offset
	 * @param limit
	 * @return
	 * @throws ApiNotReachableException
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 * @throws JSONException
	 */
	protected JSONArray downloadExistingJSONArrayBuilder(JSONArray jArray, final int offset,
		final int limit) throws ApiNotReachableException, KoronaCloudAPIErrorMessageException,
		InvalidTokenException
	{

		final String jStr = cloudLink.getJSONPageByOffset(getDataType(), limit, offset);
		try
		{
			final JSONObject newStuff = new JSONObject(jStr);

			if (!newStuff.getString("resultList").equalsIgnoreCase("null"))
			{

				final JSONArray newStuffArray = newStuff.getJSONArray("resultList");
				for (int i = 0; i <= newStuffArray.length() - 1; i++)
				{
					jArray.put(newStuffArray.getJSONObject(i));
				}
				if (newStuff.length() >= limit)
				{
					jArray = downloadExistingJSONArrayBuilder(jArray, offset + limit, limit);
				}

			}
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
		}
		return jArray;
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
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 */
	protected JSONArray recursiveOffsetIterator(JSONArray jArray, final int offset,
		final long revision, final int limit) throws ApiNotReachableException,
		KoronaCloudAPIErrorMessageException, InvalidTokenException
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
				{
					jArray.put(newStuffArray.getJSONObject(i));
				}
				jArray = recursiveOffsetIterator(jArray, offset + limit, revision, limit);

			}
		}
		catch (final JSONException e)
		{
			LOGGER.error(e);
		}
		return jArray;
	}

	protected T upload(final T obj) throws JSONException, ParseException,
		KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		updateCache(obj);

		final String result = CloudLink.getConnector().postData(getDataType(), toJSON(obj));

		T ret;

		try
		{
			final JSONObject jObj = new JSONObject(result);
			ret = fromJSON(jObj);
		}
		catch (final JSONException e)
		{
			LOGGER.error("Malformed JSON Syntax inside response Message. Returning null.", e);
			return null;
		}

		final T cachedObject = getCachedObject(ret);
		if (cachedObject != null)
		{
			cachedObject.setId(ret.getId());
			updateCache(cachedObject);
			return cachedObject;
		}

		return ret;
	}
}
