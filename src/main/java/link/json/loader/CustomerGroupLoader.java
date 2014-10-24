package link.json.loader;

import java.text.ParseException;

import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.CustomerGroup;
import domain.DataType;

public class CustomerGroupLoader extends AbstractHasNameJsonLoader<CustomerGroup>
{

	public CustomerGroupLoader(final String cloudUrl, final String token)
	{
		super(DataType.customergroup, cloudUrl, token);
	}

	@Override
	public JSONObject toJSON(final CustomerGroup value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);
		return obj;
	}

	@Override
	public CustomerGroup fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final CustomerGroup customerGroup = CustomerGroup.fromJSON(obj);
		return customerGroup;
	}

}
