package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Pricelist;
import domain.enums.DataType;

public class PricelistLoader extends AbstractHasNameJsonLoader<Pricelist>
{

	public PricelistLoader(final CloudLink cloudLink)
	{
		super(DataType.priceList, cloudLink);
	}

	@Override
	public JSONObject toJSON(final Pricelist value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}

	@Override
	public Pricelist fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Pricelist pricelist = Pricelist.fromJSON(obj);
		return pricelist;
	}

}
