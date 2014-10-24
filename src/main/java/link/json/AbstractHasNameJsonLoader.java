package link.json;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.interfaces.HasId;
import domain.interfaces.HasName;
import domain.interfaces.HasNumber;
import error.ApiNotReachableException;

public abstract class AbstractHasNameJsonLoader<T extends HasId & HasNumber & HasName> extends
	AbstractHasNumberJsonLoader<T>
{

	private final Map<String, T> nameCache = new HashMap<String, T>();

	public AbstractHasNameJsonLoader(final DataType dataType, final String cloudUrl,
		final String token)
	{
		super(dataType, cloudUrl, token);
	}

	@Override
	public JSONObject appendTheJson(final T value) throws JSONException
	{
		JSONObject obj = new JSONObject();

		obj = super.appendTheJson(value);

		obj.put("name", value.getName());

		return new JSONObject();
	}

	public T downloadByName(final String name) throws ApiNotReachableException, JSONException,
		ParseException
	{
		final T cachedObject = nameCache.get(name);
		if (cachedObject != null)
			return cachedObject;

		final String jStr = cloudLink.getJSONByName(getDataType(), name);
		final JSONObject jDownloaded = createJsonObject(jStr);
		if (jDownloaded == null)
			return null;
		final T downloaded = fromJSON(jDownloaded);
		nameCache.put(name, downloaded);
		return downloaded;
	}

	@Override
	public T post(final T obj) throws ApiNotReachableException, JSONException, ParseException
	{
		final String result = CloudLink.getConnector().postData(getDataType(), toJSON(obj));
		final JSONObject jObj = new JSONObject(result);
		final T ret = fromJSON(jObj);
		updateCache(ret);
		return ret;
	}

	@Override
	public void updateCache(final T obj)
	{
		if (obj.getName() != null)
			nameCache.put(obj.getName(), obj);

		super.updateCache(obj);
	}
}