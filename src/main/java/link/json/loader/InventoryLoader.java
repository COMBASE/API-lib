package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.DataType;
import domain.Inventory;

public class InventoryLoader extends AbstractHasNameJsonLoader<Inventory>
{

	public InventoryLoader(final CloudLink cloudLink)
	{
		super(DataType.inventory, cloudLink);
	}

	@Override
	public JSONObject toJSON(final Inventory value) throws JSONException
	{
		final JSONObject obj = value.toJSON();

		return obj;
	}

	@Override
	public Inventory fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Inventory inventory = Inventory.fromJSON(obj);
		return inventory;
	}

}
