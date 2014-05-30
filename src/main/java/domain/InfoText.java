package domain;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class InfoText
{
	private String text;
	private String number = null;
	private InfoTextType type;

	public InfoText(String text, InfoTextType type)
	{
		this.text = text;
		this.type = type;
	}

	public InfoText(String number, String text, InfoTextType type)
	{
		this.number = number;
		this.text = text;
		this.type = type;
	}

	public JSONObject toJSON()
	{
		try
		{
			JSONObject obj = new JSONObject();
			obj.put("text", text);
			if (number!=null)
				obj.put("number", number);
			obj.put("type", type.name());
			return obj;
		}
		catch (JSONException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public boolean post()
	{
		return CloudLink.getConnector().postData(DataType.infotext, this.toJSON());
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((this.number == null) ? 0 : this.number.hashCode());
		result = prime * result + ((this.text == null) ? 0 : this.text.hashCode());
		result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
		
		
		

		return result;
	}
}
