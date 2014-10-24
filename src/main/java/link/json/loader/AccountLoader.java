package link.json.loader;

import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Account;
import domain.DataType;

public class AccountLoader extends AbstractHasNameJsonLoader<Account>
{

	public AccountLoader(final String cloudUrl, final String token)
	{
		super(DataType.account, cloudUrl, token);
	}

	@Override
	public JSONObject toJSON(final Account value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);

		// TODO append json

		return obj;
	}

	@Override
	public Account fromJSON(final JSONObject obj) throws JSONException
	{
		final Account account = Account.fromJSON(obj);
		return account;
	}

}
