package link.json.loader;

import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Assortment;
import domain.DataType;

/**
 * 
 * @author mas
 * 
 */
public class AssortmentLoader extends AbstractHasNameJsonLoader<Assortment>
{
	public AssortmentLoader(final String cloudUrl, final String token)
	{
		super(DataType.assortment, cloudUrl, token);
	}

	@Override
	public JSONObject toJSON(final Assortment value) throws JSONException
	{
		final JSONObject obj = super.appendToJson(value);
		// TODO append JSONObject
		return obj;
	}

	@Override
	public Assortment fromJSON(final JSONObject obj) throws JSONException
	{
		final Assortment assortment = Assortment.fromJSON(obj);

		return assortment;
	}
}
