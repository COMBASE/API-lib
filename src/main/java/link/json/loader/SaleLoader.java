package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasIdJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.Sale;

public class SaleLoader extends AbstractHasIdJsonLoader<Sale>
{

	public SaleLoader(final CloudLink cloudLink)
	{
		super(DataType.sale, cloudLink);
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
