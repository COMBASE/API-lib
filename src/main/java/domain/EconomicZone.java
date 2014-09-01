package domain;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import error.ApiNotReachableException;


public class EconomicZone
{
	private final String name;
	private String number = null;
	private String uuid = null;

	public EconomicZone(final String name)
	{
		this.name = name;
	}

	public EconomicZone(final String number, final String name)
	{
		this.number = number;
		this.name = name;
	}

	public JSONObject toJSON()
	{
		final JSONObject obj = new JSONObject();
		try
		{
			obj.put("name", name);
			if (number != null)
				obj.put("number", number);
			return obj;
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public boolean post() throws ApiNotReachableException
	{
		final boolean result = CloudLink.getConnector().postData(DataType.economicZone,
			this.toJSON());
		if (number != null)
			uuid = CloudLink.getUUIDByNumber(DataType.economicZone, number);
		else
			uuid = CloudLink.getUUIDByName(DataType.economicZone, name);
		return result;
	}

	public String getUuid()
	{
		return uuid;
	}

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = prime * result + ((this.number == null) ? 0 : this.number.hashCode());
		result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());


		return result;
	}

}
