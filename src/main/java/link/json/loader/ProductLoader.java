package link.json.loader;

import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.Product;

/**
 * 
 * @author mas
 * 
 */
public class ProductLoader extends AbstractHasNameJsonLoader<Product>
{

	public ProductLoader(final String cloudUrl, final String token)
	{
		super(DataType.product, cloudUrl, token);
	}

	@Override
	public JSONObject toJSON(final Product value) throws JSONException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product fromJSON(final JSONObject obj) throws JSONException
	{
		// TODO Auto-generated method stub
		return null;
	}
}
