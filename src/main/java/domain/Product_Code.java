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

	public BigDecimal getQuantity() {
		return quantity;
	}

	public String getCode() {
		return code;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((this.quantity == null) ? 0 : this.quantity.hashCode());
		result = prime * result + ((this.code == null) ? 0 : this.code.hashCode());
		
		
		

		return result;
	}
}
