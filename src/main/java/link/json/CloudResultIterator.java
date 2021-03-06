package link.json;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import error.ApiNotReachableException;
import error.ErrorMessages;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;



/**
 * Iterates over org.codehaus.jettison.json.JSONArray buffer automatically
 * loaded from KORONA.Cloud API Service using KORONA.CloudAPI-Lib.
 *
 * @author mas
 */

public class CloudResultIterator implements Iterator<JSONObject>
{

	protected static Logger LOGGER = Logger.getLogger(CloudResultIterator.class);

	private JSONArray buffer;

	int currentBufferIndex;

	private final AbstractHasIdJsonLoader<?> downloader;

	private final long revision;

	private boolean emptyData;

	private long totalElements;


	/**
	 * ctor
	 *
	 * @param jsonDownloader
	 * @param revision
	 * @throws ApiNotReachableException
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 * @throws JSONException
	 */
	public CloudResultIterator(final AbstractHasIdJsonLoader<?> jsonDownloader, final long revision) throws ApiNotReachableException, JSONException, KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		this.revision = revision;
		currentBufferIndex = -1;
		downloader = jsonDownloader;
		emptyData = false;
		refreshBuffer();
	}


	/**
	 * Returns true if the iteration has more elements. (In other words, returns
	 * true if next would return an element rather than throwing an exception.)
	 * If end of buffer is reached buffer will be reloaded with new offset for
	 * next 50 JSONObjects. If refresh returns empty JSONArray this method
	 * returns false.
	 *
	 * @return true if next JSONObject is not null or JSONArray is not empty.
	 */
	@Override
	public boolean hasNext()
	{
		if (emptyData)
			return false;
		if (currentBufferIndex == buffer.length() - 1)
		{
			try
			{
				refreshBuffer();
			}
			catch (final ApiNotReachableException e)
			{
				e.printStackTrace();
				return false;
			}
			catch (final JSONException e)
			{
				e.printStackTrace();
				return false;
			}
			catch (final KoronaCloudAPIErrorMessageException e)
			{
				e.printStackTrace();
				return false;
			}
			catch (final InvalidTokenException e)
			{
				e.printStackTrace();
				return false;
			}
			return hasNext();
		}
		return true;
	}


	@Override
	public JSONObject next()
	{
		try
		{
			currentBufferIndex++;

			final JSONObject nextJSONObject = buffer.getJSONObject(currentBufferIndex);

			LOGGER.debug("PROCESSING " + nextJSONObject.toString());

			return nextJSONObject;
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
			return null;
		}

	}


	@Override
	public void remove()
	{

	}


	private void refreshBuffer() throws ApiNotReachableException, JSONException, KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		try
		{
			buffer = downloader.downloadByOffset(revision);
		}
		catch (final KoronaCloudAPIErrorMessageException e)
		{
			if (e.getErrorMap().containsKey(ErrorMessages.No_object_found_for_revision.getErrorString()))
			{
				buffer = null;
			}
			else
			{
				throw new KoronaCloudAPIErrorMessageException(e, e.getErrorMap());
			}
		}

		try
		{
			totalElements = downloader.getTotalElements();
		}
		catch (final NumberFormatException e)
		{
			LOGGER.error("could not parse totalElements");
		}

		LOGGER.debug("iterator detected " + totalElements + " elements");

		currentBufferIndex = -1;

		if (buffer == null)
		{
			emptyData = true;
		}
	}
}
