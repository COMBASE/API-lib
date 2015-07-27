package domain;

import java.math.BigDecimal;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class SupplierItemPrice
{
	public static class Builder
	{
		private String supplier = null;
		private String orderNumber = null;
		private BigDecimal boxSize = null;
		private BigDecimal price = null;
		private String boxDescription = null;

		public Builder boxDescription(final String value)
		{
			this.boxDescription = value;
			return this;
		}

		public Builder boxSize(final BigDecimal value)
		{
			this.boxSize = value;
			return this;
		}

		public SupplierItemPrice build()
		{
			return new SupplierItemPrice(this);
		}

		public Builder orderNumber(final String value)
		{
			this.orderNumber = value;
			return this;
		}

		public Builder price(final BigDecimal value)
		{
			this.price = value;
			return this;
		}

		public Builder supplier(final String value)
		{
			this.supplier = value;
			return this;
		}
	}

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

	public String getBox_description()
	{
		return boxDescription;
	}

	public BigDecimal getBoxSize()
	{
		return boxSize;
	}

	public String getOrder_number()
	{
		return orderNumber;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public String getSupplier()
	{
		return supplier;
	}

	public void setBox_description(final String box_description)
	{
		this.boxDescription = box_description;
	}

	public void setBoxSize(final BigDecimal boxSize)
	{
		this.boxSize = boxSize;
	}

	public void setOrder_number(final String order_number)
	{
		this.orderNumber = order_number;
	}

	public void setPrice(final BigDecimal price)
	{
		this.price = price;
	}

	public void setSupplier(final String supplier)
	{
		this.supplier = supplier;
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

	public static SupplierItemPrice fromJSON(final JSONObject obj) throws JSONException
	{
		final SupplierItemPrice supplierItemPrice = new SupplierItemPrice.Builder().supplier(
			nullStringToNull(obj, "supplier"))
			.boxDescription(nullStringToNull(obj, "boxDescription"))
			.boxSize(new BigDecimal(String.valueOf(obj.getDouble("boxSize"))))
			.orderNumber(nullStringToNull(obj, "orderNumber"))
			.price(new BigDecimal(String.valueOf(obj.getDouble("price"))))
			.build();
		return supplierItemPrice;
	}

	/**
	 *
	 * @param obj
	 * @param value
	 * @return
	 * @throws JSONException
	 */
	protected static String nullStringToNull(final JSONObject obj, final String value)
		throws JSONException
	{
		if (obj.getString(value).equalsIgnoreCase("null"))
			return null;
		return obj.getString(value);
	}
}
