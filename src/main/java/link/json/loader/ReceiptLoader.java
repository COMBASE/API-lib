package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNumberJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Receipt;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

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

	@Override
	public Receipt fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Receipt receipt = Receipt.fromJSON(obj);
		return receipt;
	}

	@Override
	public Receipt postAndResolve(final Receipt obj) throws JSONException, ParseException,
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
