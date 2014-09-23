package link.json;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Assortment;
import domain.DataType;
import error.ApiNotReachableException;

/**
 * 
 * @author mas
 * 
 */
public class AssortmentDownloader extends JsonDownloader
{
	private final Map<String, JSONObject> numberCache = new HashMap<String, JSONObject>();
	private final Map<String, Assortment> numberObjectCache = new HashMap<String, Assortment>();
	protected final Map<String, JSONObject> uuidCache = new HashMap<String, JSONObject>();

	public AssortmentDownloader(final String cloudUrl, final String token)
	{
		super(DataType.assortment, cloudUrl, token);
	}

	@Override
	public JSONObject downloadByNumber(final String number) throws ApiNotReachableException
	{
		final JSONObject cachedObject = numberCache.get(number);
		if (cachedObject != null)
			return cachedObject;

		final JSONObject downloaded = super.downloadByNumber(number);
		numberCache.put(number, downloaded);
		return downloaded;
	}

	public Assortment downloadObjectByNumber(final String number) throws ApiNotReachableException,
		JSONException
	{
		final Assortment cachedObject = numberObjectCache.get(number);
		if (cachedObject != null)
			return cachedObject;

		final JSONObject jDownloaded = downloadByNumber(number);
		if (jDownloaded == null)
			return null;
		final Assortment downloaded = Assortment.fromJSON(jDownloaded);
		numberObjectCache.put(number, downloaded);
		return downloaded;
	}

	@Override
	public JSONObject downloadByUUID(final String uuid) throws ApiNotReachableException
	{
		final JSONObject cachedObject = uuidCache.get(uuid);
		if (cachedObject != null)
		{
			return cachedObject;
		}

		final JSONObject downloaded = super.downloadByUUID(uuid);
		uuidCache.put(uuid, downloaded);
		return downloaded;
	}

	/**
	 * updates the cached object altered during runtime.
	 * 
	 * @param product
	 */
	public void saveAssortment(final Assortment assortment)
	{
		final JSONObject jObj = assortment.toJSON();

		numberCache.put(assortment.getNumber(), jObj);
		numberObjectCache.put(assortment.getNumber(), assortment);
	}

}
