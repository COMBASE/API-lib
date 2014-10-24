package link.json.loader;

import java.text.ParseException;

import link.json.AbstractHasIdJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.Sale;

public class SaleLoader extends AbstractHasIdJsonLoader<Sale>
{

	public SaleLoader(final DataType dataType, final String cloudUrl, final String token)
	{
		super(dataType, cloudUrl, token);
	}

	@Override
	public JSONObject toJSON(final Sale value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);
		return obj;
	}

	@Override
	public Sale fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Sale sale = Sale.fromJSON(obj);
		return sale;
	}

}
