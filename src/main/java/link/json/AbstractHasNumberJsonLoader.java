package link.json;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.interfaces.HasId;
import domain.interfaces.HasNumber;
import error.ApiNotReachableException;

public abstract class AbstractHasNumberJsonLoader<T extends HasId & HasNumber> extends AbstractHasIdJsonLoader<T>
{

	private final Map<String, T> numberCache = new HashMap<String, T>();

	public AbstractHasNumberJsonLoader(final DataType dataType, final String cloudUrl, final String token)
	{
		super(dataType, cloudUrl, token);
	}

	@Override
	public JSONObject appendToJson(final T value) throws JSONException
	{
		JSONObject obj = new JSONObject();

		obj = super.appendToJson(value);

		obj.put("number", value.getNumber());

		return new JSONObject();
	}


	/**
	 * 
	 * @param number
	 * @return
	 * @throws ApiNotReachableException
	 * @throws JSONException
	 */
	public T downloadByNumber(final String number) throws ApiNotReachableException, JSONException
	{
		final T cachedObject = numberCache.get(number);
		if (cachedObject != null)
			return cachedObject;

		final String jStr = cloudLink.getJSONByNumber(getDataType(), number);
		final JSONObject jDownloaded = createJsonObject(jStr);
		if (jDownloaded == null)
			return null;
		final T downloaded = fromJSON(jDownloaded);
		numberCache.put(number, downloaded);
		return downloaded;
	}

	@Override
	public void updateCachedObject(final T obj)
	{
		if (obj.getNumber() != null)
			numberCache.put(obj.getNumber(), obj);

		super.updateCachedObject(obj);
	}
}
