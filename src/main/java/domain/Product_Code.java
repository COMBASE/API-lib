package domain;

import java.math.BigDecimal;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Product_Code
{
	private final BigDecimal quantity;
	private final String code;

	public Product_Code(final String code, final BigDecimal quantity)
	{
		super();
		this.code = code;
		this.quantity = quantity;
	}

	public JSONObject toJSON()
	{
		final JSONObject obj = new JSONObject();
		try
		{
			obj.put("code", code);
			obj.put("quantity", quantity);
			return obj;
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public BigDecimal getQuantity()
	{
		return quantity;
	}

	public String getCode()
	{
		return code;
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

		result = prime * result + ((this.quantity == null) ? 0 : this.quantity.hashCode());
		result = prime * result + ((this.code == null) ? 0 : this.code.hashCode());


		return result;
	}
}
