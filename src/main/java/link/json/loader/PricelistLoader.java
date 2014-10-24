package link.json.loader;

import java.text.ParseException;

import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.Pricelist;

public class PricelistLoader extends AbstractHasNameJsonLoader<Pricelist>
{

	public PricelistLoader(final String cloudUrl, final String token)
	{
		super(DataType.priceList, cloudUrl, token);
	}

	@Override
	public JSONObject toJSON(final Pricelist value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);
		return obj;
	}

	@Override
	public Pricelist fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Pricelist pricelist = Pricelist.fromJSON(obj);
		return pricelist;
	}

}
