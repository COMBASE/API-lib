package domain;

import java.io.IOException;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Assortment
{
	private boolean deleted;
	private String uuid;
	private String revision;
	private String number;
	private String name;
	
	private String description;
	
	

	private Assortment(Builder builder)
	{
		number = builder.number;
		name = builder.name;
		description = builder.description;
		deleted = builder.deleted;
	}

	public static class Builder
	{
		private final String name;
		private String number = null;
		private String description;
		private boolean deleted;

		public Builder(String name)
		{
			this.name = name;
		}

		public Builder number(String value)
		{
			number = value;
			return this;
		}

		public Builder deleted(boolean value)
		{
			deleted = value;
			return this;
		}

		public Builder description(String desc)
		{
			description = desc;
			return this;
		}

		public Assortment build()
		{
			return new Assortment(this);
		}
	}

	public JSONObject toJSON()
	{
		JSONObject obj = new JSONObject();
		try
		{
			obj.put("name", name);
			if (number!=null)
				obj.put("number", number);
			obj.put("deleted", deleted);
			obj.put("description", description);
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
		boolean result = CloudLink.getConnector().postData(DataType.assortment, this.toJSON());
		if (number!=null)
			uuid = CloudLink.getUUIDByNumber(DataType.assortment, String.valueOf(number));
		else			
			uuid = CloudLink.getUUIDByName(DataType.assortment, name);
		return result;
	}

	public String getUuid()
	{
		return uuid;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
