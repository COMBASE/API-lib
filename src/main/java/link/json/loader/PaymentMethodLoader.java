package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.PaymentMethod;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

public class PaymentMethodLoader extends AbstractHasNameJsonLoader<PaymentMethod>
{
	CurrencyLoader currencyLoader;

	public PaymentMethodLoader(final CloudLink cloudLink)
	{
		super(DataType.paymentMethod, cloudLink);
	}

	@Override
	public PaymentMethod fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final PaymentMethod paymentMethod = PaymentMethod.fromJSON(obj);
		return paymentMethod;
	}

	@Override
	public PaymentMethod postAndResolve(final PaymentMethod obj) throws JSONException,
		ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException,
		ApiNotReachableException
	{
		if (obj.getCurrency() != null)
		{
			if (currencyLoader == null)
			{
				currencyLoader = new CurrencyLoader(cloudLink);
			}
			currencyLoader.postAndResolve(obj.getCurrency());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No Currency to resolve and to pre-post");
		}

		return post(obj);
	}

	@Override
	public JSONObject toJSON(final PaymentMethod value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}

}
