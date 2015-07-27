package domain;

import java.math.BigDecimal;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class StockOrderItem extends AbstractApiObject<StockOrderItem>
{

	public static class Builder extends Init<Builder>
	{

		@Override
		protected Builder self()
		{
			return this;
		}

	}

	protected static abstract class Init<T extends Init<T>> extends AbstractApiObject.Init<T>
	{
		private BigDecimal bookedQuantity = null;
		private BigDecimal containerQuantity = null;
		private BigDecimal quantity = null;
		private BigDecimal purchasePrice = null;
		private BigDecimal salesPrice = null;
		private BigDecimal desiredOverallQuantity = null;
		private BigDecimal actualOverallQuantity = null;
		private BigDecimal itemPrice = null;

		private String name = null;
		private String product = null;
		private String color = null;
		private String size = null;

		public T actualOverallQuantity(final BigDecimal value)
		{
			this.actualOverallQuantity = value;
			return self();
		}

		public T bookedQuantity(final BigDecimal value)
		{
			this.bookedQuantity = value;
			return self();
		}

		@Override
		public StockOrderItem build()
		{
			return new StockOrderItem(this);
		}

		public T color(final String value)
		{
			this.color = value;
			return self();
		}

		public T containerQuantity(final BigDecimal value)
		{
			this.containerQuantity = value;
			return self();
		}

		public T desiredOverallQuantity(final BigDecimal value)
		{
			this.desiredOverallQuantity = value;
			return self();
		}

		public T itemPrice(final BigDecimal value)
		{
			this.itemPrice = value;
			return self();
		}

		public T name(final String value)
		{
			this.name = value;
			return self();
		}

		public T product(final String value)
		{
			this.product = value;
			return self();
		}

		public T purchasePrice(final BigDecimal value)
		{
			this.purchasePrice = value;
			return self();
		}

		public T quantity(final BigDecimal value)
		{
			this.quantity = value;
			return self();
		}

		public T salesPrice(final BigDecimal value)
		{
			this.salesPrice = value;
			return self();
		}

		public T size(final String value)
		{
			this.size = value;
			return self();
		}
	}

	private static final long serialVersionUID = -3894410230357779821L;
	private BigDecimal bookedQuantity;
	private BigDecimal containerQuantity;
	private BigDecimal quantity;
	private BigDecimal purchasePrice;
	private BigDecimal salesPrice;
	private BigDecimal desiredOverallQuantity;

	private BigDecimal actualOverallQuantity;
	private BigDecimal itemPrice;
	private String name;
	private String product;

	private String color;

	private String size;

	public StockOrderItem(final Init<?> init)
	{
		super(init);
		bookedQuantity = init.bookedQuantity;
		containerQuantity = init.containerQuantity;
		quantity = init.quantity;
		purchasePrice = init.purchasePrice;
		salesPrice = init.salesPrice;
		desiredOverallQuantity = init.desiredOverallQuantity;
		actualOverallQuantity = init.actualOverallQuantity;
		itemPrice = init.itemPrice;

		name = init.name;
		product = init.product;
		color = init.color;
		size = init.size;
	}

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	public BigDecimal getActualOverallQuantity()
	{
		return actualOverallQuantity;
	}

	public BigDecimal getBookedQuantity()
	{
		return bookedQuantity;
	}

	public String getColor()
	{
		return color;
	}

	public BigDecimal getContainerQuantity()
	{
		return containerQuantity;
	}

	public BigDecimal getDesiredOverallQuantity()
	{
		return desiredOverallQuantity;
	}

	public BigDecimal getItemPrice()
	{
		return itemPrice;
	}

	public String getName()
	{
		return name;
	}

	public String getProduct()
	{
		return product;
	}

	public BigDecimal getPurchasePrice()
	{
		return purchasePrice;
	}

	public BigDecimal getQuantity()
	{
		return quantity;
	}

	public BigDecimal getSalesPrice()
	{
		return salesPrice;
	}

	public String getSize()
	{
		return size;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = super.hashCode(result);
		result = prime * result +
			((this.bookedQuantity == null) ? 0 : this.bookedQuantity.hashCode());
		result = prime * result +
			((this.containerQuantity == null) ? 0 : this.containerQuantity.hashCode());
		result = prime * result +
			((this.desiredOverallQuantity == null) ? 0 : this.desiredOverallQuantity.hashCode());
		result = prime * result + ((this.itemPrice == null) ? 0 : this.itemPrice.hashCode());
		result = prime * result +
			((this.purchasePrice == null) ? 0 : this.purchasePrice.hashCode());
		result = prime * result + ((this.quantity == null) ? 0 : this.quantity.hashCode());
		result = prime * result + ((this.salesPrice == null) ? 0 : this.salesPrice.hashCode());
		result = prime * result + ((this.size == null) ? 0 : this.size.hashCode());

		return result;
	}

	public void setActualOverallQuantity(final BigDecimal actualOverallQuantity)
	{
		this.actualOverallQuantity = actualOverallQuantity;
	}

	public void setBookedQuantity(final BigDecimal bookedQuantity)
	{
		this.bookedQuantity = bookedQuantity;
	}

	public void setColor(final String color)
	{
		this.color = color;
	}

	public void setContainerQuantity(final BigDecimal containerQuantity)
	{
		this.containerQuantity = containerQuantity;
	}

	public void setDesiredOverallQuantity(final BigDecimal desiredOverallQuantity)
	{
		this.desiredOverallQuantity = desiredOverallQuantity;
	}

	public void setItemPrice(final BigDecimal itemPrice)
	{
		this.itemPrice = itemPrice;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public void setProduct(final String product)
	{
		this.product = product;
	}

	public void setPurchasePrice(final BigDecimal purchasePrice)
	{
		this.purchasePrice = purchasePrice;
	}

	public void setQuantity(final BigDecimal quantity)
	{
		this.quantity = quantity;
	}

	public void setSalesPrice(final BigDecimal salesPrice)
	{
		this.salesPrice = salesPrice;
	}

	public void setSize(final String size)
	{
		this.size = size;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		JSONObject obj = new JSONObject();
		obj = appendJSON(obj);

		obj.put("bookedQuantity", bookedQuantity);
		obj.put("containerQuantity", containerQuantity);
		obj.put("quantity", quantity);
		obj.put("purchasePrice", purchasePrice);
		obj.put("salesPrice", salesPrice);
		obj.put("desiredOverallQuantity", desiredOverallQuantity);
		obj.put("actualOverallQuantity", actualOverallQuantity);
		obj.put("itemPrice", itemPrice);

		obj.put("name", name);
		obj.put("product", product);
		obj.put("color", color);
		obj.put("size", size);

		return obj;
	}

	public static StockOrderItem fromJSON(final JSONObject obj) throws JSONException
	{

		final StockOrderItem item = new StockOrderItem.Builder().actualOverallQuantity(
			prepareBigDecimal(obj, "actualOverallQuantity"))
			.bookedQuantity(prepareBigDecimal(obj, "bookedQuantity"))
			.color(nullStringToNull(obj, "color"))
			.containerQuantity(prepareBigDecimal(obj, "containerQuantity"))
			.deleted(obj.getBoolean("deleted"))
			.desiredOverallQuantity(prepareBigDecimal(obj, "desiredOverallQuantity"))
			.id(nullStringToNull(obj, "uuid"))
			.itemPrice(prepareBigDecimal(obj, "itemPrice"))
			.name(nullStringToNull(obj, "name"))
			.product(nullStringToNull(obj, "product"))
			.purchasePrice(prepareBigDecimal(obj, "purchasePrice"))
			.quantity(prepareBigDecimal(obj, "quantity"))
			.revision(obj.getLong("revision"))
			.salesPrice(prepareBigDecimal(obj, "salesPrice"))
			.build();

		return item;
	}
}
