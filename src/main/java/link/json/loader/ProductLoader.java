package link.json.loader;

import link.CloudLink;
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

	public ProductLoader(final CloudLink cloudLink)
	{
		super(DataType.product, cloudLink);
	}

	@Override
	public JSONObject toJSON(final Product value) throws JSONException
	{
		final JSONObject obj = value.toJSON();

		// TODO append json

		return obj;
	}

	@Override
	public Product fromJSON(final JSONObject obj) throws JSONException
	{
		final Product product = Product.fromJSON(obj);

		return product;
	}
}
