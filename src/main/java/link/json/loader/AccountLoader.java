package link.json.loader;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Account;
import domain.DataType;

public class AccountLoader extends AbstractHasNameJsonLoader<Account>
{

	public AccountLoader(final CloudLink cloudLink)
	{
		super(DataType.account, cloudLink);
	}

	@Override
	public JSONObject toJSON(final Account value) throws JSONException
	{
		final JSONObject obj = value.toJSON();

		return obj;
	}

	@Override
	public Account fromJSON(final JSONObject obj) throws JSONException
	{
		final Account account = Account.fromJSON(obj);
		return account;
	}

}
