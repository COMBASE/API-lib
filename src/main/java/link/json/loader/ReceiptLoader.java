package link.json.loader;

import java.text.ParseException;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Receipt;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.ErrorMessages;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;
import link.CloudLink;
import link.json.AbstractHasNumberJsonLoader;



public class ReceiptLoader extends AbstractHasNumberJsonLoader<Receipt>
{
	CashierLoader cashierLoader;

	CustomerLoader customerLoader;

	CustomerGroupLoader customerGroupLoader;

	OrganizationalUnitLoader organizationalUnitLoader;

	POSLoader posLoader;


	public ReceiptLoader(final CloudLink cloudLink)
	{
		super(DataType.receipt, cloudLink);
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
				throw new KoronaCloudAPIErrorMessageException(e, e.getErrorMap());
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
				return null;
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
				throw new KoronaCloudAPIErrorMessageException(e, e.getErrorMap());
		}
	}


	@Override
	public Receipt fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Receipt receipt = Receipt.fromJSON(obj);
		return receipt;
	}


	@Override
	public Receipt postAndResolve(final Receipt obj) throws JSONException, ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
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

		if (obj.getCustomer() != null)
		{
			if (customerLoader == null)
			{
				customerLoader = new CustomerLoader(cloudLink);
			}
			customerLoader.postAndResolve(obj.getCustomer());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No Customer to resolve and to pre-post");
		}

		if (obj.getCustomerGroup() != null)
		{
			if (customerGroupLoader == null)
			{
				customerGroupLoader = new CustomerGroupLoader(cloudLink);
			}
			customerGroupLoader.postAndResolve(obj.getCustomerGroup());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No CustomerGroup to resolve and to pre-post");
		}

		if (obj.getOrganizationalUnit() != null)
		{
			if (organizationalUnitLoader == null)
			{
				organizationalUnitLoader = new OrganizationalUnitLoader(cloudLink);
			}
			organizationalUnitLoader.postAndResolve(obj.getOrganizationalUnit());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No OrganizationalUnit to resolve and to pre-post");
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

		return post(obj);
	}


	@Override
	public JSONObject toJSON(final Receipt value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}

}
