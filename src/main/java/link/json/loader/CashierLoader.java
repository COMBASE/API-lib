package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Cashier;
import domain.DataType;

public class CashierLoader extends AbstractHasNameJsonLoader<Cashier>
{

	public CashierLoader(final CloudLink cloudLink)
	{
		super(DataType.cashier, cloudLink);
	}

	@Override
	public JSONObject toJSON(final Cashier value) throws JSONException
	{
		final JSONObject obj = value.toJSON();


		return obj;
	}

	@Override
	public Cashier fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Cashier cashier = Cashier.fromJSON(obj);
		return cashier;
	}

}
