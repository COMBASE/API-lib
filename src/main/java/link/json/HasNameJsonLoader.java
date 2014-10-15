package link.json;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.AbstractApiObject.ApiObjectBuilder;
import domain.DataType;
import domain.interfaces.HasId;
import domain.interfaces.HasName;
import domain.interfaces.HasNumber;
import error.ApiNotReachableException;

public abstract class HasNameJsonLoader<T extends HasId & HasNumber & HasName> extends
	HasNumberJsonLoader<T>
{

	private final Map<String, T> nameCache = new HashMap<String, T>();

	public HasNameJsonLoader(final DataType dataType, final String cloudUrl, final String token)
	{
		super(dataType, cloudUrl, token);
		// TODO Auto-generated constructor stub
	}

	public T downloadByName(final String name) throws ApiNotReachableException, JSONException
	{
		final T cachedObject = nameCache.get(name);
		if (cachedObject != null)
			return cachedObject;

		final String jStr = cloudLink.getJSONByName(getDataType(), name);
		final JSONObject jDownloaded = createJsonObject(jStr);
		if (jDownloaded == null)
			return null;
		final T downloaded = getBuilder().fromJSON(jDownloaded);
		nameCache.put(name, downloaded);
		return downloaded;
	}

	@Override
	public void updateCachedObject(final T obj)
	{
		if (obj.getName() != null)
			nameCache.put(obj.getName(), obj);

		super.updateCachedObject(obj);
	}

	@Override
	public abstract ApiObjectBuilder<T> getBuilder();

}
