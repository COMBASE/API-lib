package domain;

import java.math.BigDecimal;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class SupplierItemPrice
{
	private String supplier;
	private String orderNumber;
	private BigDecimal boxSize;
	private BigDecimal price;
	private String boxDescription;

	public SupplierItemPrice(final Builder builder)
	{
		supplier = builder.supplier;
		orderNumber = builder.orderNumber;
		boxSize = builder.boxSize;
		price = builder.price;
		boxDescription = builder.boxDescription;
	}

	public static class Builder
	{
		private String supplier = null;
		private String orderNumber = null;
		private BigDecimal boxSize = null;
		private BigDecimal price = null;
		private String boxDescription = null;

		public Builder supplier(final String value)
		{
			this.supplier = value;
			return this;
		}

		public Builder orderNumber(final String value)
		{
			this.orderNumber = value;
			return this;
		}

		public Builder boxSize(final BigDecimal value)
		{
			this.boxSize = value;
			return this;
		}

		public Builder price(final BigDecimal value)
		{
			this.price = value;
			return this;
		}

		public Builder boxDescription(final String value)
		{
			this.boxDescription = value;
			return this;
		}

		public SupplierItemPrice build()
		{
			return new SupplierItemPrice(this);
		}
	}

	public static SupplierItemPrice fromJSON(final JSONObject obj) throws JSONException
	{
		final SupplierItemPrice supplierItemPrice = new SupplierItemPrice.Builder().supplier(
			obj.getString("supplier"))
			.boxDescription(obj.getString("boxDescription"))
			.boxSize(new BigDecimal(String.valueOf(obj.getDouble("boxSize"))))
			.orderNumber(obj.getString("orderNumber"))
			.price(new BigDecimal(String.valueOf(obj.getDouble("price"))))
			.build();
		return supplierItemPrice;
	}

	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();

		obj.put("supplier", supplier);
		obj.put("boxDescription", boxDescription);
		obj.put("boxSize", boxSize);
		obj.put("orderNumber", orderNumber);
		obj.put("price", price);

		return obj;
	}

	public String getSupplier()
	{
		return supplier;
	}

	public void setSupplier(final String supplier)
	{
		this.supplier = supplier;
	}

	public String getOrder_number()
	{
		return orderNumber;
	}

	public void setOrder_number(final String order_number)
	{
		this.orderNumber = order_number;
	}

	public BigDecimal getBoxSize()
	{
		return boxSize;
	}

	public void setBoxSize(final BigDecimal boxSize)
	{
		this.boxSize = boxSize;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public void setPrice(final BigDecimal price)
	{
		this.price = price;
	}

	public String getBox_description()
	{
		return boxDescription;
	}

	public void setBox_description(final String box_description)
	{
		this.boxDescription = box_description;
	}
}
