package domain;

import java.io.IOException;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class EconomicZone
{
	private String name;
	private int number = 0;
	private String uuid = null;

	public EconomicZone(String name)
	{
		this.name = name;
	}

	public EconomicZone(int number, String name)
	{
		this.number = number;
		this.name = name;
	}

	public JSONObject toJSON()
	{
		JSONObject obj = new JSONObject();
		try
		{
			obj.put("name", name);
			if (number != 0)
				obj.put("number", number);
			return obj;
		}
		catch (JSONException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public boolean post() throws IOException
	{
		boolean result = CloudLink.getConnector().postData(DataType.economicZone, this.toJSON());
		if (number != 0)
			uuid = CloudLink.getUUID(DataType.economicZone, String.valueOf(number));
		else
			uuid = CloudLink.getUUID(DataType.economicZone, name);
		return result;
	}

	public String getUuid()
	{
		return uuid;
	}
}
