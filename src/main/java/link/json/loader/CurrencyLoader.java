package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Currency;
import domain.enums.DataType;

public class CurrencyLoader extends AbstractHasNameJsonLoader<Currency>
{

	public CurrencyLoader(final CloudLink cloudLink)
	{
		super(DataType.currency, cloudLink);
	}

	@Override
	public JSONObject toJSON(final Currency value) throws JSONException
	{
		final JSONObject obj = value.toJSON();

		return obj;
	}

	@Override
	public Currency fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Currency currency = Currency.fromJSON(obj);
		return currency;
	}

}