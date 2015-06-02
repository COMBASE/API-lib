package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNumberJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.AccountTransaction;
import domain.FullReceipt;
import domain.Payment;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

public class FullReceiptLoader extends AbstractHasNumberJsonLoader<FullReceipt>
{
	AccountTransactionLoader accountTransactionLoader;

	PaymentLoader paymentLoader;

	public FullReceiptLoader(final CloudLink cloudLink)
	{
		super(DataType.fullReceipt, cloudLink);
	}

	@Override
	public FullReceipt fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final FullReceipt fullReceipt = FullReceipt.fromJSON(obj);
		return fullReceipt;
	}

	@Override
	public FullReceipt postAndResolve(final FullReceipt obj) throws JSONException, ParseException,
		KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		if (obj.getAccountTransaction() != null && !obj.getAccountTransaction().isEmpty())
		{
			for (final AccountTransaction accountTransaction : obj.getAccountTransaction())
			{
				if (accountTransaction != null)
				{
					if (accountTransactionLoader == null)
					{
						accountTransactionLoader = new AccountTransactionLoader(cloudLink);
					}
					accountTransactionLoader.postAndResolve(accountTransaction);
				}

			}
		}
		else
		{
			LOGGER.debug(super.getDataType() +
				": No Account Transaction to resolve and to pre-post");
		}

		if (obj.getPayment() != null && !obj.getPayment().isEmpty())
		{
			for (final Payment payment : obj.getPayment())
			{
				if (payment != null)
				{
					if (paymentLoader == null)
					{
						paymentLoader = new PaymentLoader(cloudLink);
					}
					paymentLoader.postAndResolve(payment);
				}

			}
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No Payment to resolve and to pre-post");
		}

		return post(obj);
	}

	@Override
	public JSONObject toJSON(final FullReceipt value) throws JSONException
	{
		final JSONObject obj = value.toJSON();

		return obj;
	}
}
