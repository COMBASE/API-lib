package link.json.loader;

import link.json.AbstractHasNumberJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;

public class AccountTransactionLoader extends AbstractHasNumberJsonLoader<AccountTransactionLoader>
{

	public AccountTransactionLoader(final DataType dataType, final String cloudUrl,
		final String token)
	{
		super(dataType, cloudUrl, token);
	}

	@Override
	public JSONObject toJSON(final AccountTransactionLoader value) throws JSONException
	{
		final JSONObject obj = super.appendToJson(value);

		// TODO append json
		return obj;
	}

	@Override
	public AccountTransactionLoader fromJSON(final JSONObject obj) throws JSONException
	{
		// TODO Auto-generated method stub
		return null;
	}

}
