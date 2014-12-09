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
import domain.interfaces.HasName;
import domain.interfaces.HasNumber;
import error.ApiNotReachableException;
import error.SubObjectInitializationException;

public abstract class AbstractHasNameJsonLoader<T extends HasId & HasNumber & HasName> extends
	AbstractHasNumberJsonLoader<T>
{

	private final Map<String, T> nameCache = new HashMap<String, T>();

	public AbstractHasNameJsonLoader(final DataType dataType, final CloudLink cloudLink)
	{
		super(dataType, cloudLink);
	}

	public T downloadByName(final String name) throws ApiNotReachableException, JSONException,
		ParseException, SubObjectInitializationException
	{
		final T cachedObject = nameCache.get(name);
		if (cachedObject != null)
			return cachedObject;

		final String jStr = cloudLink.getJSONByName(getDataType(), name);
		final JSONObject jDownloaded = createJsonObject(jStr);
		if (jDownloaded == null)
			throw new SubObjectInitializationException(name, getDataType(), null);
		final T downloaded = fromJSON(jDownloaded);
		nameCache.put(name, downloaded);
		return downloaded;
	}

	@Override
	public T post(final T obj) throws ApiNotReachableException, JSONException, ParseException
	{
// if (obj == null ||
// (obj.getName() == null && obj.getNumber() == null && obj.getId() == null))
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

		if (object != null && object.getName() != null)
			return nameCache.get(object.getName());

		return null;
	}

	@Override
	public void updateCache(final T obj)
	{
		if (obj.getName() != null)
			nameCache.put(obj.getName(), obj);

		super.updateCache(obj);
	}

	@Override
	public void updateCache(final List<T> objs)
	{
		for (final T obj : objs)
		{
			if (obj.getName() != null)
				nameCache.put(obj.getName(), obj);
		}

		super.updateCache(objs);

	}

}