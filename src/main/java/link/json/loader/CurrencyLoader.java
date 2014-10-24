package link.json.loader;

import java.text.ParseException;

import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Currency;
import domain.DataType;

public class CurrencyLoader extends AbstractHasNameJsonLoader<Currency>
{

	public CurrencyLoader(final String cloudUrl, final String token)
	{
		super(DataType.currency, cloudUrl, token);
	}

	@Override
	public JSONObject toJSON(final Currency value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);
		return obj;
	}

	@Override
	public Currency fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Currency currency = Currency.fromJSON(obj);
		return currency;
	}

}