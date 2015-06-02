package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasIdJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.AccountTransaction;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

public class AccountTransactionLoader extends AbstractHasIdJsonLoader<AccountTransaction>
{
	AccountLoader accountLoader;
	CashierLoader cashierLoader;
	POSLoader posLoader;
	ReceiptLoader receiptLoader;

	public AccountTransactionLoader(final CloudLink cloudLink)
	{
		super(DataType.accountTransaction, cloudLink);
	}

	@Override
	public AccountTransaction fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final AccountTransaction accountTransaction = AccountTransaction.fromJSON(obj);
		return accountTransaction;
	}

	@Override
	public AccountTransaction postAndResolve(final AccountTransaction obj) throws JSONException,
	ParseException, KoronaCloudAPIErrorMessageException, InvalidTokenException,
	ApiNotReachableException
	{
		if (obj.getAccount() != null)
		{
			if (accountLoader == null)
			{
				accountLoader = new AccountLoader(cloudLink);
			}
			accountLoader.postAndResolve(obj.getAccount());
		}
		else
		{
			LOGGER.debug(super.getDataType() + ": No Account to resolve and to pre-post");
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
	public JSONObject toJSON(final AccountTransaction value) throws JSONException
	{
		final JSONObject obj = value.toJSON();


		return obj;
	}
}
