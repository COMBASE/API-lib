package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Tax;
import domain.enums.DataType;

public class TaxLoader extends AbstractHasNameJsonLoader<Tax>
{

	public TaxLoader(final CloudLink cloudLink)
	{
		super(DataType.tax, cloudLink);
	}

	@Override
	public JSONObject toJSON(final Tax value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}

	@Override
	public Tax fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Tax tax = Tax.fromJSON(obj);
		return tax;
	}

}
