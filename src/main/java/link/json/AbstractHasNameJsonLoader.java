package link.json;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.enums.DataType;
import domain.interfaces.HasId;
import domain.interfaces.HasName;
import domain.interfaces.HasNumber;
import error.ApiNotReachableException;
import error.ErrorMessages;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

public abstract class AbstractHasNameJsonLoader<T extends HasId & HasNumber & HasName> extends
	AbstractHasNumberJsonLoader<T>
{

	private final Map<String, T> nameCache = new HashMap<String, T>();

	public AbstractHasNameJsonLoader(final DataType dataType, final CloudLink cloudLink)
	{
		super(dataType, cloudLink);
	}

	/**
	 *
	 * @param name
	 * @return
	 * @throws ApiNotReachableException
	 * @throws ParseException
	 * @throws KoronaCloudAPIErrorMessageException
	 * @throws InvalidTokenException
	 */
	public T downloadByName(final String name) throws ApiNotReachableException, ParseException,
		KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		final T cachedObject = nameCache.get(name);

		if (cachedObject != null)
			return cachedObject;


		final String jStr;

		try
		{

			jStr = cloudLink.getJSONByName(getDataType(), name);

		}
		catch (final KoronaCloudAPIErrorMessageException e)
		{

			final Map<String, String> errorMap = e.getErrorMap();

			if (errorMap.containsKey(ErrorMessages.No_Object_found_for_name.getErrorString()))
				return null;
			else
				throw new KoronaCloudAPIErrorMessageException(e, errorMap);

		}

		final JSONObject jDownloaded = createJsonObject(jStr);

		T downloaded;

		try
		{

			downloaded = fromJSON(jDownloaded);

		}
		catch (final JSONException e)
		{

			LOGGER.error("KORONA.CLOUD.API returned malformed JSON", e);

			return null;

		}

		nameCache.put(name, downloaded);

		return downloaded;

	}

	@Override
	public T find(final String reference) throws ApiNotReachableException, ParseException,
		KoronaCloudAPIErrorMessageException, InvalidTokenException, IllegalArgumentException
	{
		final T obj = super.find(reference);

		if (obj == null)
			return downloadByName(reference);

		return obj;


	}

	@Override
	public T getCachedObject(final T object)
	{

		final T cachedObject = super.getCachedObject(object);
		if (cachedObject != null)
			return cachedObject;

		if (object != null && object.getName() != null)
			return nameCache.get(object.getName());

		return null;
	}

	@Override
	public T post(final T obj) throws ApiNotReachableException, JSONException, ParseException,
		KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
// if (obj == null ||
// (obj.getName() == null && obj.getNumber() == null && obj.getId() == null))
// throw new PostWithNoReferenceSetException(null);
// else
		return upload(obj);
	}

	@Override
	public void updateCache(final List<? extends T> objs)
	{
		for (final T obj : objs)
		{
			if (obj.isDeleted() != null && obj.getName() != null)
			{
				if (obj.isDeleted())
				{
					nameCache.remove(obj.getName());
				}
				else
				{
					nameCache.put(obj.getName(), obj);
				}

			}
		}

		super.updateCache(objs);

	}

	@Override
	public void updateCache(final T obj)
	{
		if (obj.getName() != null)
		{
			if (obj.isDeleted() != null && obj.isDeleted())
			{
				nameCache.remove(obj.getName());
			}
			else
			{
				nameCache.put(obj.getName(), obj);
			}
		}

		super.updateCache(obj);
	}

}
