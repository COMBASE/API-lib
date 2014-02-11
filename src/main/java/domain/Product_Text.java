package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Product_Text
{
	private String text;
	private ProductText_Type type;

	public Product_Text(String text, ProductText_Type type)
	{
		super();
		this.text = text;
		this.type = type;
	}

	public JSONObject toJSON()
	{
		JSONObject obj = new JSONObject();
		try
		{
			obj.put("text", text);
			obj.put("type", type.getReference());
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return obj;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public ProductText_Type getType()
	{
		return type;
	}

	public void setType(ProductText_Type type)
	{
		this.type = type;
	}
}
