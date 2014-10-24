package link.json.loader;

import java.text.ParseException;

import link.json.AbstractHasIdJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.AccountTransaction;
import domain.DataType;

public class AccountTransactionLoader extends AbstractHasIdJsonLoader<AccountTransaction>
{

	public AccountTransactionLoader(final String cloudUrl, final String token)
	{
		super(DataType.accountTransaction, cloudUrl, token);
	}

	@Override
	public JSONObject toJSON(final AccountTransaction value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);

		// TODO append JSONstring
		return obj;
	}

	@Override
	public AccountTransaction fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final AccountTransaction accountTransaction = AccountTransaction.fromJSON(obj);
		return accountTransaction;
	}
}
