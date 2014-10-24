package link.json.loader;

import java.text.ParseException;

import link.json.AbstractHasIdJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.PosBalance;

public class PosBalanceLoader extends AbstractHasIdJsonLoader<PosBalance>
{

	public PosBalanceLoader(final DataType dataType, final String cloudUrl, final String token)
	{
		super(dataType, cloudUrl, token);
	}

	@Override
	public JSONObject toJSON(final PosBalance value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);
		return obj;
	}

	@Override
	public PosBalance fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final PosBalance posBalance = PosBalance.fromJSON(obj);
		return posBalance;
	}

}
