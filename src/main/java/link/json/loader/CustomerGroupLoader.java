package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.CustomerGroup;
import domain.DataType;

public class CustomerGroupLoader extends AbstractHasNameJsonLoader<CustomerGroup>
{

	public CustomerGroupLoader(final CloudLink cloudLink)
	{
		super(DataType.customergroup, cloudLink);
	}

	@Override
	public JSONObject toJSON(final CustomerGroup value) throws JSONException
	{
		final JSONObject obj = value.toJSON();

		obj.put("deleted", value.isDeleted());
		obj.put("revision", value.getRevision());
		obj.put("uuid", value.getId());
		obj.put("name", value.getName());
		obj.put("number", value.getNumber());

		return obj;
	}

	@Override
	public CustomerGroup fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final CustomerGroup customerGroup = CustomerGroup.fromJSON(obj);
		return customerGroup;
	}

}
