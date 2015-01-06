package link.json;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import link.CloudLink;
import link.thread.PostListThread;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.interfaces.HasId;
import error.ApiNotReachableException;
import error.ArticleCodeMustBeUniqueException;
import error.PostWithNoReferenceSetException;
import error.SubObjectInitializationException;

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

	public AbstractHasIdJsonLoader(final DataType dataType, final CloudLink cloudLink)
	{
		this.cloudLink = cloudLink;
		this.dataType = dataType;
	}


	public abstract T fromJSON(JSONObject obj) throws JSONException, ParseException;

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
	 * Used to return a JSONArray of all existing elements.
	 * 
	 * @return a JSONArray of existing (not deleted) objects
	 * @throws ApiNotReachableException
	 */

	public JSONArray downloadAllExisting() throws ApiNotReachableException
	{
		final String jStr = cloudLink.getJSONPageByOffset(getDataType(), limit, 0);
		JSONArray jArray = createJsonArray(jStr);
		jArray = downloadExistingJSONArrayBuilder(jArray, limit, limit);

		return null;
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
	 * @throws SubObjectInitializationException
	 */
	public T downloadByUUID(final String uuid) throws ApiNotReachableException, JSONException,
		ParseException, SubObjectInitializationException
	{
		final T cachedObject = idCache.get(uuid);
		if (cachedObject != null)
		{
			return cachedObject;
		}

		final String jStr = cloudLink.getJSONByUuid(getDataType(), uuid);
		final JSONObject jObject = createJsonObject(jStr);
		if (jObject == null)
			throw new SubObjectInitializationException(uuid, getDataType(), null);
		final T downloaded = fromJSON(jObject);
		idCache.put(uuid, downloaded);
		return downloaded;
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
	 * @throws ArticleCodeMustBeUniqueException
	 * @throws PostWithNoReferenceSetException
	 */
	public T post(final T obj) throws ApiNotReachableException, JSONException, ParseException,
		ArticleCodeMustBeUniqueException
	{
// if (obj == null || obj.getId() == null)
// throw new PostWithNoReferenceSetException(null);
// else
		return upload(obj);

	}

	protected T upload(final T obj) throws JSONException, ParseException,
		ArticleCodeMustBeUniqueException
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

	/**
	 * posts all Data
	 * 
	 * @param objs
	 * @param limit
	 * @return response:Set<object_type>
	 * @throws JSONException
	 * @throws ParseException
	 * @throws ApiNotReachableException
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public List<T> postList(final List<T> objs, final int limit, final int threads)
		throws JSONException, ParseException, ApiNotReachableException
	{
		final Set<PostListThread> threadSet = new HashSet<PostListThread>();
		final Set<PostListThread> removedThreadSet = new HashSet<PostListThread>();
		final Date date1 = new Date();
		LOGGER.info("start: " + date1);

		JSONArray jArray = new JSONArray();

		// Thread Executor init
// final ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime()
// .availableProcessors());

		final ExecutorService exec = Executors.newFixedThreadPool(threads);

		final Set<Future<String>> set = new HashSet<Future<String>>();

		int offset = 0;
		int i = 0;
		while (i < objs.size())
		{
			jArray = new JSONArray();
			offset = offset + limit;
			while (i < offset && i < objs.size())
			{
				final T obj = objs.get(i);

				jArray.put(toJSON(obj));

				i++;
			}

			final Callable<String> callable = new PostListThread(getDataType(), jArray);

// final PostListThread localThread = new PostListThread(getDataType(), jArray);
			final Future<String> future = exec.submit(callable);
			set.add(future);
// threadSet.add(localThread);
// exec.execute(localThread);


		}
		final List<T> objects = new ArrayList<T>();
		for (final Future<String> future : set)
		{
			JSONObject jsonObject;
			try
			{
				jsonObject = new JSONObject(future.get());


				if (jsonObject.has("resultList") && !jsonObject.isNull("resultList"))
				{
					final JSONArray jsonArray = jsonObject.getJSONArray("resultlist");
					for (int j = 0; j < jsonArray.length(); j++)
					{
						final T obj = fromJSON(jsonArray.getJSONObject(j));
						objects.add(obj);
					}
				}

				exec.shutdown();

			}
			catch (final CancellationException e)
			{
				System.out.println("exception3");
				e.printStackTrace();
			}
			catch (final InterruptedException e)
			{
				System.out.println("exception1");
				e.printStackTrace();
			}
			catch (final ExecutionException e)
			{
				System.out.println("exception2");
				e.printStackTrace();
			}
		}


// final List<T> objects = new ArrayList<T>();
// while (!exec.isTerminated())
// {
// while (!threadSet.isEmpty())
// {
// for (final PostListThread thread : threadSet)
// {
// if (thread.getReturn() != null)
// {
// final String jsonString = thread.getReturn();
//
// final JSONObject jsonObject = new JSONObject(jsonString);
// JSONArray jsonArray;
//
// if (jsonObject.has("resultList") && !jsonObject.isNull("resultList"))
// {
// jsonArray = jsonObject.getJSONArray("resultList");
//
// for (int j = 0; j < jsonArray.length(); j++)
// {
// final T obj = fromJSON(jsonArray.getJSONObject(j));
// objects.add(obj);
// }
// }
//
// removedThreadSet.add(thread);
//
// }
// }
//
// threadSet.removeAll(removedThreadSet);
//
// }
// }

		final Date date2 = new Date();
		LOGGER.info("end: " + date2);

		updateCache(objects);

		return objects;
	}

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

	/**
	 * updates given obj corresponding cached version for future loader actions.
	 * 
	 * @param obj
	 */
	public void updateCache(final T obj)
	{
		if (obj.getId() != null)
			idCache.put(obj.getId(), obj);
	}

	public void updateCache(final List<T> objs)
	{
		for (final T obj : objs)
		{
			if (obj.getId() != null)
				idCache.put(obj.getId(), obj);
		}

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
			LOGGER.error(e);
		}
		return jArray;
	}

	/**
	 * helper method for downloadAllExisting
	 * 
	 * @param jArray
	 * @param offset
	 * @param limit
	 * @return
	 * @throws ApiNotReachableException
	 */
	protected JSONArray downloadExistingJSONArrayBuilder(JSONArray jArray, final int offset,
		final int limit) throws ApiNotReachableException
	{

		final String jStr = cloudLink.getJSONPageByOffset(getDataType(), limit, offset);
		try
		{
			final JSONObject newStuff = new JSONObject(jStr);

			if (!newStuff.getString("resultList").equalsIgnoreCase("null"))
			{

				final JSONArray newStuffArray = newStuff.getJSONArray("resultList");
				for (int i = 0; i <= newStuffArray.length() - 1; i++)
					jArray.put(newStuffArray.getJSONObject(i));
				jArray = downloadExistingJSONArrayBuilder(jArray, offset + limit, limit);

			}
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
		}
		return jArray;
	}

	public abstract JSONObject toJSON(T value) throws JSONException;


}
