package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasIdJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Sale;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

public class SaleLoader extends AbstractHasIdJsonLoader<Sale>
{
	CashierLoader cashierLoader;

	ProductLoader productLoader;

	CommodityGroupLoader commodityGroupLoader;

	ReceiptLoader receiptLoader;

	POSLoader posLoader;

	public SaleLoader(final CloudLink cloudLink)
	{
		super(DataType.sale, cloudLink);
	}

	@Override
	public Sale fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Sale sale = Sale.fromJSON(obj);
		return sale;
	}

	@Override
	public Sale postAndResolve(final Sale obj) throws JSONException, ParseException,
	KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		if (obj.getCashier() != null)
		{
			if (cashierLoader == null)
			{
				cashierLoader = new CashierLoader(cloudLink);
			}
			cashierLoader.postAndResolve(obj.getCashier());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No Cashier to resolve and to pre-post");
		}

		if (obj.getArticle() != null)
		{
			if (productLoader == null)
			{
				productLoader = new ProductLoader(cloudLink);
			}
			productLoader.postAndResolve(obj.getArticle());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No Product to resolve and to pre-post");
		}

		if (obj.getCommodityGroup() != null)
		{
			if (commodityGroupLoader == null)
			{
				commodityGroupLoader = new CommodityGroupLoader(cloudLink);
			}
			commodityGroupLoader.postAndResolve(obj.getCommodityGroup());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No CommodityGroup to resolve and to pre-post");
		}

		if (obj.getPos() != null)
		{
			if (posLoader == null)
			{
				posLoader = new POSLoader(cloudLink);
			}
			posLoader.postAndResolve(obj.getPos());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No POS to resolve and to pre-post");
		}

		if (obj.getReceipt() != null)
		{
			if (receiptLoader == null)
			{
				receiptLoader = new ReceiptLoader(cloudLink);
			}
			receiptLoader.postAndResolve(obj.getReceipt());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No Receipt to resolve and to pre-post");
		}

		return post(obj);
	}

	@Override
	public JSONObject toJSON(final Sale value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}

}
