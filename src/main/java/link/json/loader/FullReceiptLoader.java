package link.json.loader;

import java.text.ParseException;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.AccountTransaction;
import domain.FullReceipt;
import domain.Payment;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.ErrorMessages;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;
import link.CloudLink;
import link.json.AbstractHasNumberJsonLoader;



public class FullReceiptLoader extends AbstractHasNumberJsonLoader<FullReceipt>
{
	private AccountTransactionLoader accountTransactionLoader;

	private PaymentLoader paymentLoader;


	public FullReceiptLoader(final CloudLink cloudLink)
	{
		super(DataType.fullReceipt, cloudLink);
	}


	/**
	 * Downloads all receipt of the particular paymentMethod with customer set
	 * only
	 *
	 * @param paymentMethodId
	 * @param revision
	 * @param limit
	 * @return
	 * @throws ApiNotReachableException
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 */
	public JSONArray downloadAllByLimitedRevisionWith(final String paymentMethodId, final long revision, final int limit) throws ApiNotReachableException, InvalidTokenException, KoronaCloudAPIErrorMessageException
	{
		try
		{
			final String jStr = cloudLink.getPersonalizedJSONPageByOffsetWith(getDataType(), revision, paymentMethodId, limit, 0);
			final JSONArray jArray = createJsonArray(jStr);
			return jArray;
		}
		catch (final KoronaCloudAPIErrorMessageException e)
		{
			if (e.getErrorMap().containsKey(ErrorMessages.No_object_found_for_revision.getErrorString()))
			{
				totalElements = "0";
				return null;
			}
			else
			{
				throw new KoronaCloudAPIErrorMessageException(e, e.getErrorMap());
			}
		}
	}


	/**
	 * Downloads the next amountPerPage objects from the cloud starting by the
	 * next lowest revision provided to this method. The Offset is the page
	 * controller iterating over pages by offset+amountPerPage.
	 *
	 * @param revision
	 * @param amountPerPage
	 * @param offset
	 * @return JSONArray
	 * @throws ApiNotReachableException
	 * @throws InvalidTokenException
	 * @throws KoronaCloudAPIErrorMessageException
	 */
	public JSONArray downloadPersonalizedReceiptWith(final long revision, final String paymentMethodUid, final int amountPerPage, int offset) throws ApiNotReachableException, KoronaCloudAPIErrorMessageException, InvalidTokenException
	{
		try
		{
			final String jStr = cloudLink.getPersonalizedJSONPageByOffsetWith(getDataType(), revision, paymentMethodUid, amountPerPage, offset);
			final JSONArray jArray = createJsonArray(jStr);
			if (jArray == null)
			{
				return null;
			}
			offset += amountPerPage;

			return jArray;
		}
		catch (final KoronaCloudAPIErrorMessageException e)
		{
			if (e.getErrorMap().containsKey(ErrorMessages.No_object_found_for_revision.getErrorString()))
			{
				totalElements = "0";
				return null;
			}
			else
			{
				throw new KoronaCloudAPIErrorMessageException(e, e.getErrorMap());
			}
		}
	}


	@Override
	public FullReceipt fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final FullReceipt fullReceipt = FullReceipt.fromJSON(obj);
		return fullReceipt;
	}


	@Override
	public FullReceipt postAndResolve(final FullReceipt obj) throws JSONException, ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
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
			LOGGER.debug(super.getDataType() + ": No Account Transaction to resolve and to pre-post");
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
