package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Supplier;
import domain.enums.DataType;

public class SupplierLoader extends AbstractHasNameJsonLoader<Supplier>
{

	public SupplierLoader(CloudLink cloudLink)
	{
		super(DataType.supplier, cloudLink);
	}

	@Override
	public Supplier fromJSON(JSONObject obj) throws JSONException, ParseException
	{
		final Supplier supplier = Supplier.fromJSON(obj);

		return supplier;
	}

	@Override
	public JSONObject toJSON(Supplier value) throws JSONException
	{
		final JSONObject obj = value.toJSON();

		return obj;
	}

}
