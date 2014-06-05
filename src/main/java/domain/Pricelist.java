package domain;

import java.io.IOException;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Pricelist
{
	private String number;
	private String name;
	private boolean netPrices;
	private boolean deleted;
	private String uuidOfCurrency;
	private String uuid;

	private Pricelist(Builder builder)
	{
		name = builder.name;
		number = builder.number;
		uuid=builder.uuid;
		uuidOfCurrency = builder.uuidOfCurrency;
		deleted = builder.deleted;
		netPrices = builder.netPrices;
	}

	public static class Builder
	{
		private final String name;
		private String number = null;
		private String uuid=null;
		private final String uuidOfCurrency;
		private boolean deleted = false;
		private boolean netPrices = false;

		public Builder(String name, String uuidOfCurrency)
		{
			this.name = name;
			this.uuidOfCurrency = uuidOfCurrency;
		}

		public Builder number(String value)
		{
			number = value;
			return this;
		}
		
		public Builder uuid(String value){
			this.uuid=value;
			return this;
		}

		public Builder deleted(boolean value)
		{
			deleted = value;
			return this;
		}

		public Builder netPrices(boolean value)
		{
			netPrices = value;
			return this;
		}

		public Pricelist build()
		{
			return new Pricelist(this);
		}
	}
	
	public static Pricelist fromJSON(JSONObject obj) throws JSONException {
		if(obj.has("result") && obj.getString("result")!=null)
			obj = obj.getJSONObject("result");
			
		Pricelist priceList = new Pricelist.Builder(obj.getString("name"),obj.getString("currency")).
							uuid(obj.getString("uuid"))
							.build();
		if (obj.has("number"))
			priceList.setNumber(obj.getString("number"));

		return priceList;
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
			obj.put("netPrices", netPrices);
			obj.put("currency", uuidOfCurrency);
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
		boolean result = CloudLink.getConnector().postData(DataType.priceList, this.toJSON());
		if (number!=null)
			uuid = CloudLink.getUUIDByNumber(DataType.priceList, String.valueOf(number));
		else
			uuid = CloudLink.getUUIDByName(DataType.priceList, name);
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

	public boolean isNetPrices() {
		return netPrices;
	}

	public void setNetPrices(boolean netPrices) {
		this.netPrices = netPrices;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getUuidOfCurrency() {
		return uuidOfCurrency;
	}

	public void setUuidOfCurrency(String uuidOfCurrency) {
		this.uuidOfCurrency = uuidOfCurrency;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.number == null) ? 0 : this.number.hashCode());
		result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());
		result = prime * result + ((this.uuidOfCurrency == null) ? 0 : this.uuidOfCurrency.hashCode());

		return result;
	}
}
