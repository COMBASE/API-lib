package link.json.loader;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Product;
import domain.Product_Code;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.ErrorMessages;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

/**
 *
 * @author mas
 *
 */
public class ProductLoader extends AbstractHasNameJsonLoader<Product>
{

	@Override
	public List<Product> postList(final List<? extends Product> objs, final int limit,
		final int threads) throws JSONException, ParseException,
		KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{

		try
		{

			return super.postList(objs, limit, threads);

		}
		catch (final KoronaCloudAPIErrorMessageException e)
		{

			final Map<String, String> errorMap = e.getErrorMap();

			if (errorMap.containsKey(ErrorMessages.articlecode_must_be_unique.getErrorString()))
				LOGGER.error("Some articles were not posted! Article Code already in use.");

			throw new KoronaCloudAPIErrorMessageException(e, e.getErrorMap());

		}
	}

	@Override
	public Product post(final Product obj) throws ApiNotReachableException, JSONException,
	ParseException, InvalidTokenException, KoronaCloudAPIErrorMessageException
	{

		try
		{

			return upload(obj);

		}
		catch (final KoronaCloudAPIErrorMessageException e)
		{
			throw new KoronaCloudAPIErrorMessageException(e.getCause(), null);
		}

	}

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
		JSONException, ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException
	{

		final Product cachedObject = codeCache.get(code);

		if (cachedObject != null)
			return cachedObject;

		final String jStr;

		try
		{

			jStr = cloudLink.getJSONByCode(code);

		}
		catch (final KoronaCloudAPIErrorMessageException e)
		{

			final Map<String, String> errrorMap = e.getErrorMap();

			if (errrorMap.containsKey("No object found for code"))
				return null;
			else
				throw new KoronaCloudAPIErrorMessageException(e, errrorMap);

		}

		final JSONObject jDownloaded = createJsonObject(jStr);


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
