package link.json.loader;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.Product;
import domain.Product_Code;
import error.ApiNotReachableException;
import error.SubObjectInitializationException;

/**
 *
 * @author mas
 *
 */
public class ProductLoader extends AbstractHasNameJsonLoader<Product>
{

	private final Map<String, Product> codeCache = new HashMap<String, Product>();

	public ProductLoader(final CloudLink cloudLink)
	{
		super(DataType.product, cloudLink);
	}

	@Override
	public JSONObject toJSON(final Product value) throws JSONException
	{
		final JSONObject obj = value.toJSON();

		return obj;
	}

	@Override
	public Product fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Product product = Product.fromJSON(obj);

		return product;
	}

	public Product downloadByCode(final String code) throws ApiNotReachableException,
	JSONException, ParseException, SubObjectInitializationException
	{
		final Product cachedObject = codeCache.get(code);
		if (cachedObject != null)
			return cachedObject;

		final String jStr = cloudLink.getJSONByCode(code);
		final JSONObject jDownloaded = createJsonObject(jStr);
		if (jDownloaded == null)
			throw new SubObjectInitializationException(code, getDataType(), null);
		final Product downloaded = fromJSON(jDownloaded);
		updateCache(downloaded);
		return downloaded;
	}

	@Override
	public Product getCachedObject(final Product object)
	{

		final Product cachedObject = super.getCachedObject(object);
		if (cachedObject != null)
			return cachedObject;

		if (object != null && object.getName() != null)
			return codeCache.get(object.getName());

		return null;
	}

	@Override
	public void updateCache(final Product obj)
	{
		if (obj.getCodes() != null && !obj.getCodes().isEmpty())
			for (final Product_Code code : obj.getCodes())
			{
				codeCache.put(code.getCode(), obj);
			}

		super.updateCache(obj);
	}
}
