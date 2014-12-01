package link.json.loader;

import link.CloudLink;
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
	public AssortmentLoader(final CloudLink cloudLink)
	{
		super(DataType.assortment, cloudLink);
	}

	@Override
	public JSONObject toJSON(final Assortment value) throws JSONException
	{
		final JSONObject obj = value.toJSON();

		return obj;
	}

	@Override
	public Assortment fromJSON(final JSONObject obj) throws JSONException
	{
		final Assortment assortment = Assortment.fromJSON(obj);

		return assortment;
	}
}
