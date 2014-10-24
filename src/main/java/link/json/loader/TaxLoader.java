package link.json.loader;

import java.text.ParseException;

import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.Tax;

public class TaxLoader extends AbstractHasNameJsonLoader<Tax>
{

	public TaxLoader(final String cloudUrl, final String token)
	{
		super(DataType.tax, cloudUrl, token);
	}

	@Override
	public JSONObject toJSON(final Tax value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);
		return obj;
	}

	@Override
	public Tax fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Tax tax = Tax.fromJSON(obj);
		return tax;
	}

}
