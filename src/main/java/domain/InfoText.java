package domain;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class InfoText
{
	private String text;
	private int number = 0;
	private InfoTextType type;

	public InfoText(String text, InfoTextType type)
	{
		this.text = text;
		this.type = type;
	}

	public InfoText(int number, String text, InfoTextType type)
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
			if (number != 0)
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
}
