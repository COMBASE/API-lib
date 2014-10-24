package link.json.loader;

import java.text.ParseException;

import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Cashier;
import domain.DataType;

public class CashierLoader extends AbstractHasNameJsonLoader<Cashier>
{

	public CashierLoader(final String cloudUrl, final String token)
	{
		super(DataType.cashier, cloudUrl, token);
	}

	@Override
	public JSONObject toJSON(final Cashier value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);
		return obj;
	}

	@Override
	public Cashier fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Cashier cashier = Cashier.fromJSON(obj);
		return cashier;
	}

}
