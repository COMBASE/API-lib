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

	private final Map<String, Product> codeCache = new HashMap<String, Product>();

	public ProductLoader(final CloudLink cloudLink)
	{
		super(DataType.product, cloudLink);
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
	public Product fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Product product = Product.fromJSON(obj);

		return product;
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
	public Product post(final Product obj) throws ApiNotReachableException, JSONException,
	ParseException, InvalidTokenException, KoronaCloudAPIErrorMessageException
	{

		try
		{

			return upload(obj);

		}
		catch (final KoronaCloudAPIErrorMessageException e)
		{

			final Map<String, String> errorMap = e.getErrorMap();

			if (errorMap.containsKey(ErrorMessages.articlecode_must_be_unique.getErrorString()))
			{
				LOGGER.info("Some articles were not posted! Article Code already in use.");
			}

			if (errorMap.containsKey(ErrorMessages.Code_not_found_for_Price.getErrorString()))
			{
				LOGGER.info("Some articles were not posted! Article Code on Prices not in use.");
			}

			throw new KoronaCloudAPIErrorMessageException(e, e.getErrorMap());

		}

	}

	@Override
	public Product postAndResolve(final Product obj) throws JSONException, ParseException,
	KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		if (obj.getCommodityGroup() != null &&
			(obj.getCommodityGroup().getName() != null ||
				obj.getCommodityGroup().getNumber() != null || obj.getCommodityGroup().getId() != null))
		{
			final CommodityGroupLoader loader = new CommodityGroupLoader(cloudLink);

			loader.post(obj.getCommodityGroup());
		}

		if (obj.getSector() != null &&
			(obj.getSector().getName() != null || obj.getSector().getNumber() != null || obj.getSector()
			.getId() != null))
		{
			final SectorLoader loader = new SectorLoader(cloudLink);
			loader.post(obj.getSector());
		}

		if (obj.getAltsector() != null &&
			(obj.getAltsector().getName() != null || obj.getAltsector().getNumber() != null || obj.getAltsector()
			.getId() != null))
		{
			final SectorLoader loader = new SectorLoader(cloudLink);
			loader.post(obj.getAltsector());
		}

		if (obj.getAssortment() != null &&
			(obj.getAssortment().getName() != null || obj.getAssortment().getNumber() != null || obj.getAssortment()
			.getId() != null))
		{
			final AssortmentLoader loader = new AssortmentLoader(cloudLink);
			loader.post(obj.getAssortment());
		}

		return post(obj);
	}

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
			{
				LOGGER.info("Some articles were not posted! Article Code already in use.");
			}

			if (errorMap.containsKey(ErrorMessages.Code_not_found_for_Price.getErrorString()))
			{
				LOGGER.info("Some articles were not posted! Article Code on Prices not in use.");
			}

			throw new KoronaCloudAPIErrorMessageException(e, e.getErrorMap());

		}
	}

	@Override
	public JSONObject toJSON(final Product value) throws JSONException
	{
		final JSONObject obj = value.toJSON();

		return obj;
	}

	@Override
	public void updateCache(final Product obj)
	{
		if (obj.getCodes() != null && !obj.getCodes().isEmpty())
		{
			for (final Product_Code code : obj.getCodes())
			{
				codeCache.put(code.getCode(), obj);
			}
		}

		super.updateCache(obj);
	}
}
