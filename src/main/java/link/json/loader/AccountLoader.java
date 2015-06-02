package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Account;
import domain.enums.DataType;
import error.ApiNotReachableException;
import error.InvalidTokenException;
import error.KoronaCloudAPIErrorMessageException;

public class AccountLoader extends AbstractHasNameJsonLoader<Account>
{

	public AccountLoader(final CloudLink cloudLink)
	{
		super(DataType.account, cloudLink);
	}

	@Override
	public Account fromJSON(final JSONObject obj) throws JSONException
	{
		final Account account = Account.fromJSON(obj);
		return account;
	}

	@Override
	public Account postAndResolve(final Account obj) throws JSONException, ParseException,
		KoronaCloudAPIErrorMessageException, InvalidTokenException, ApiNotReachableException
	{
		LOGGER.debug(super.getDataType() + ": Nothing to resolve and to pre-post");

		return post(obj);
	}

	@Override
	public JSONObject toJSON(final Account value) throws JSONException
	{
		final JSONObject obj = value.toJSON();

		return obj;
	}

}
