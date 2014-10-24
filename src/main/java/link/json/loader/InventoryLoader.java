package link.json.loader;

import java.text.ParseException;

import link.json.AbstractHasNumberJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.Inventory;

public class InventoryLoader extends AbstractHasNumberJsonLoader<Inventory>
{

	public InventoryLoader(final String cloudUrl, final String token)
	{
		super(DataType.inventory, cloudUrl, token);
	}

	@Override
	public JSONObject toJSON(final Inventory value) throws JSONException
	{
		final JSONObject obj = super.appendTheJson(value);
		return obj;
	}

	@Override
	public Inventory fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Inventory inventory = Inventory.fromJSON(obj);
		return inventory;
	}

}
