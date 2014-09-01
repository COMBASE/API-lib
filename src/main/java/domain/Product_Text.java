package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Product_Text
{
	private String text;
	private ProductText_Type type;

	public Product_Text(final String text, final ProductText_Type type)
	{
		super();
		this.text = text;
		this.type = type;
	}

	public JSONObject toJSON()
	{
		final JSONObject obj = new JSONObject();
		try
		{
			obj.put("text", text);
			obj.put("type", type.getReference());
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
		}
		return obj;
	}

	public String getText()
	{
		return text;
	}

	public void setText(final String text)
	{
		this.text = text;
	}

	public ProductText_Type getType()
	{
		return type;
	}

	public void setType(final ProductText_Type type)
	{
		this.type = type;
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

		result = prime * result + ((this.text == null) ? 0 : this.text.hashCode());
		result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());


		return result;
	}
}
