package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasIdJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.AccountTransaction;
import domain.enums.DataType;

public class AccountTransactionLoader extends AbstractHasIdJsonLoader<AccountTransaction>
{

	public AccountTransactionLoader(final CloudLink cloudLink)
	{
		super(DataType.accountTransaction, cloudLink);
	}

	@Override
	public JSONObject toJSON(final AccountTransaction value) throws JSONException
	{
		final JSONObject obj = value.toJSON();


		return obj;
	}

	@Override
	public AccountTransaction fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final AccountTransaction accountTransaction = AccountTransaction.fromJSON(obj);
		return accountTransaction;
	}
}
