package link.json.loader;

import java.text.ParseException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Payment;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;
import link.CloudLink;
import link.json.AbstractHasIdJsonLoader;



public class PaymentLoader extends AbstractHasIdJsonLoader<Payment>
{
	private CurrencyLoader currencyLoader;

	private CashierLoader cashierLoader;

	private PaymentMethodLoader paymentMethodLoader;

	private POSLoader posLoader;

	private ReceiptLoader receiptLoader;


	public PaymentLoader(final CloudLink cloudLink)
	{
		super(DataType.payment, cloudLink);
	}


	@Override
	public Payment fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Payment payment = Payment.fromJSON(obj);
		return payment;
	}


	@Override
	public Payment postAndResolve(final Payment obj) throws JSONException, ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
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

		if (obj.getPaymentMethod() != null)
		{
			if (paymentMethodLoader == null)
			{
				paymentMethodLoader = new PaymentMethodLoader(cloudLink);
			}
			paymentMethodLoader.postAndResolve(obj.getPaymentMethod());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No PaymentMethod to resolve and to pre-post");
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
	public JSONObject toJSON(final Payment value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}
}
