package link.json;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.interfaces.HasId;
import domain.interfaces.HasNumber;
import error.ApiNotReachableException;
import error.SubObjectInitializationException;

public abstract class AbstractHasNumberJsonLoader<T extends HasId & HasNumber> extends
	AbstractHasIdJsonLoader<T>
{

	private final Map<String, T> numberCache = new HashMap<String, T>();

	public AbstractHasNumberJsonLoader(final DataType dataType, final CloudLink cloudLink)
	{
		super(dataType, cloudLink);
	}

	/**
	 * 
	 * @param number
	 * @return
	 * @throws ApiNotReachableException
	 * @throws JSONException
	 * @throws ParseException
	 * @throws SubObjectInitializationException
	 */
	public T downloadByNumber(final String number) throws ApiNotReachableException, JSONException,
		ParseException, SubObjectInitializationException
	{
		final T cachedObject = numberCache.get(number);
		if (cachedObject != null)
			return cachedObject;

		final String jStr = cloudLink.getJSONByNumber(getDataType(), number);
		final JSONObject jDownloaded = createJsonObject(jStr);
		if (jDownloaded == null)
			throw new SubObjectInitializationException(number, getDataType(), null);
		final T downloaded = fromJSON(jDownloaded);
		numberCache.put(number, downloaded);
		return downloaded;
	}

	@Override
	public T post(final T obj) throws ApiNotReachableException, JSONException, ParseException
	{
// if (obj == null || (obj.getNumber() == null && obj.getId() == null))
// throw new PostWithNoReferenceSetException(null);
// else
		return upload(obj);
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
	public void updateCache(final T obj)
	{
		if (obj.getNumber() != null)
			numberCache.put(obj.getNumber(), obj);

		super.updateCache(obj);
	}

	@Override
	public void updateCache(final List<T> objs)
	{
		for (final T obj : objs)
		{
			if (obj.getNumber() != null)
				numberCache.put(obj.getNumber(), obj);
		}

		super.updateCache(objs);

	}
}