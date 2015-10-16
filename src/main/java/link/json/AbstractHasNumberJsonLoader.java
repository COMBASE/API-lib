package link.json;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.enums.DataType;
import domain.interfaces.HasId;
import domain.interfaces.HasNumber;
import error.ApiNotReachableException;
import error.ErrorMessages;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;
import link.CloudLink;



public abstract class AbstractHasNumberJsonLoader<T extends HasId & HasNumber> extends AbstractHasIdJsonLoader<T>
{

	private final Map<String, T> numberCache = new HashMap<String, T>();


	public AbstractHasNumberJsonLoader(final DataType dataType, final CloudLink cloudLink)
	{
		super(dataType, cloudLink);
	}


	/**
	 * @param number
	 * @return
	 * @throws ApiNotReachableException
	 * @throws JSONException
	 * @throws ParseException
	 * @throws SubObjectInitializationException
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 */
	public T downloadByNumber(final String number) throws ApiNotReachableException, ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		final T cachedObject = numberCache.get(number);
		if (cachedObject != null)
			return cachedObject;

		String jStr = null;
		try
		{

			jStr = cloudLink.getJSONByNumber(getDataType(), number);

		}
		catch (final KoronaCloudAPIErrorMessageException e)
		{

			final Map<String, String> errorMap = e.getErrorMap();

			if (errorMap.containsKey(ErrorMessages.No_object_found_for_number.getErrorString()))
				return null;
			else
				throw new KoronaCloudAPIErrorMessageException(e, errorMap);

		}

		final JSONObject jDownloaded = createJsonObject(jStr);

		final T downloaded;
		try
		{

			downloaded = fromJSON(jDownloaded);

		}
		catch (final JSONException e)
		{

			LOGGER.error("KORONA.CLOUD.API returned malformed JSON", e);

			return null;

		}

		numberCache.put(number, downloaded);
		return downloaded;
	}


	@Override
	public T find(final String reference) throws ApiNotReachableException, ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException, IllegalArgumentException
	{
		final T obj = super.find(reference);

		if (obj == null)
		{
			try
			{
				return downloadByNumber(reference);
			}
			catch (final KoronaCloudAPIErrorMessageException e)
			{
				if (e.getErrorMap().containsKey(ErrorMessages.No_object_found_for_number))
				{
					LOGGER.debug("Not a Number String");
					return null;
				}
			}
		}

		return obj;

	}


	@Override
	public T getCachedObject(final T object)
	{

		final T cachedObject = super.getCachedObject(object);
		if (cachedObject != null)
			return cachedObject;

		if (object != null && object.getNumber() != null)
			return numberCache.get(object.getNumber());

		return null;
	}


	@Override
	public T post(final T obj) throws ApiNotReachableException, JSONException, ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException

	{
		// if (obj == null || (obj.getNumber() == null && obj.getId() == null))
		// throw new PostWithNoReferenceSetException(null);
		// else
		return upload(obj);
	}


	@Override
	public void updateCache(final List<? extends T> objs)
	{
		for (final T obj : objs)
		{
			if (obj.getNumber() != null)
			{
				if (obj.isDeleted() != null && obj.isDeleted())
				{
					numberCache.remove(obj.getNumber());
				}
				else
				{
					numberCache.put(obj.getNumber(), obj);
				}
			}
		}

		super.updateCache(objs);

	}


	@Override
	public void updateCache(final T obj)
	{
		if (obj.getNumber() != null)
		{
			if (obj.isDeleted() != null && obj.isDeleted())
			{
				numberCache.remove(obj.getNumber());
			}
			else
			{
				numberCache.put(obj.getNumber(), obj);
			}
		}

		super.updateCache(obj);
	}
}
