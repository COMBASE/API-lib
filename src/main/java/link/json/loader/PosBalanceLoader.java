package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasIdJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.PosBalance;
import domain.enums.DataType;

public class PosBalanceLoader extends AbstractHasIdJsonLoader<PosBalance>
{

	public PosBalanceLoader(final CloudLink cloudLink)
	{
		super(DataType.posBalance, cloudLink);
	}

	@Override
	public JSONObject toJSON(final PosBalance value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}

	@Override
	public PosBalance fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final PosBalance posBalance = PosBalance.fromJSON(obj);
		return posBalance;
	}

}
