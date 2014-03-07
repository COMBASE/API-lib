package domain;

import java.math.BigDecimal;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Product_Code
{
	private BigDecimal quantity;
	private String code;

	public Product_Code(String code, BigDecimal quantity)
	{
		super();
		this.code = code;
		this.quantity = quantity;
	}

	public JSONObject toJSON()
	{
		JSONObject obj = new JSONObject();
		try
		{
			obj.put("code", code);
			obj.put("quantity", quantity);
			return obj;
		}
		catch (JSONException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
