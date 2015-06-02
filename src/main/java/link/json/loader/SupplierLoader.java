package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Supplier;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

public class SupplierLoader extends AbstractHasNameJsonLoader<Supplier>
{

	CurrencyLoader currencyLoader;

	public SupplierLoader(final CloudLink cloudLink)
	{
		super(DataType.supplier, cloudLink);
	}

	@Override
	public Supplier fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Supplier supplier = Supplier.fromJSON(obj);

		return supplier;
	}

	@Override
	public Supplier postAndResolve(final Supplier obj) throws JSONException, ParseException,
		KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		if (obj.getPaymentCurrency() != null)
		{
			if (currencyLoader == null)
			{
				currencyLoader = new CurrencyLoader(cloudLink);
			}
			currencyLoader.postAndResolve(obj.getPaymentCurrency());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No Currency to resolve and to pre-post");
		}

		return post(obj);
	}

	@Override
	public JSONObject toJSON(final Supplier value) throws JSONException
	{
		final JSONObject obj = value.toJSON();

		return obj;
	}

}
