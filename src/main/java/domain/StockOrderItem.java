package domain;

import java.math.BigDecimal;

public class StockOrderItem
{
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

	public StockOrderItem(final Builder builder)
	{
		bookedQuantity = builder.bookedQuantity;
		containerQuantity = builder.containerQuantity;
		quantity = builder.quantity;
		purchasePrice = builder.purchasePrice;
		salesPrice = builder.salesPrice;
		desiredOverallQuantity = builder.desiredOverallQuantity;
		actualOverallQuantity = builder.actualOverallQuantity;
		itemPrice = builder.itemPrice;

		name = builder.name;
		product = builder.product;
		color = builder.color;
		size = builder.size;
	}

	public static class Builder
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

		public Builder bookedQuantity(final BigDecimal value)
		{
			this.bookedQuantity = value;
			return this;
		}

		public Builder containerQuantity(final BigDecimal value)
		{
			this.containerQuantity = value;
			return this;
		}

		public Builder quantity(final BigDecimal value)
		{
			this.quantity = value;
			return this;
		}

		public Builder purchasePrice(final BigDecimal value)
		{
			this.purchasePrice = value;
			return this;
		}

		public Builder salesPrice(final BigDecimal value)
		{
			this.salesPrice = value;
			return this;
		}

		public Builder desiredOverallQuantity(final BigDecimal value)
		{
			this.desiredOverallQuantity = value;
			return this;
		}

		public Builder actualOverallQuantity(final BigDecimal value)
		{
			this.actualOverallQuantity = value;
			return this;
		}

		public Builder itemPrice(final BigDecimal value)
		{
			this.itemPrice = value;
			return this;
		}

		public Builder name(final String value)
		{
			this.name = value;
			return this;
		}

		public Builder product(final String value)
		{
			this.product = value;
			return this;
		}

		public Builder color(final String value)
		{
			this.color = value;
			return this;
		}

		public Builder size(final String value)
		{
			this.size = value;
			return this;
		}
	}

	public BigDecimal getBookedQuantity()
	{
		return bookedQuantity;
	}

	public void setBookedQuantity(final BigDecimal bookedQuantity)
	{
		this.bookedQuantity = bookedQuantity;
	}

	public BigDecimal getContainerQuantity()
	{
		return containerQuantity;
	}

	public void setContainerQuantity(final BigDecimal containerQuantity)
	{
		this.containerQuantity = containerQuantity;
	}

	public BigDecimal getQuantity()
	{
		return quantity;
	}

	public void setQuantity(final BigDecimal quantity)
	{
		this.quantity = quantity;
	}

	public BigDecimal getPurchasePrice()
	{
		return purchasePrice;
	}

	public void setPurchasePrice(final BigDecimal purchasePrice)
	{
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getSalesPrice()
	{
		return salesPrice;
	}

	public void setSalesPrice(final BigDecimal salesPrice)
	{
		this.salesPrice = salesPrice;
	}

	public BigDecimal getDesiredOverallQuantity()
	{
		return desiredOverallQuantity;
	}

	public void setDesiredOverallQuantity(final BigDecimal desiredOverallQuantity)
	{
		this.desiredOverallQuantity = desiredOverallQuantity;
	}

	public BigDecimal getActualOverallQuantity()
	{
		return actualOverallQuantity;
	}

	public void setActualOverallQuantity(final BigDecimal actualOverallQuantity)
	{
		this.actualOverallQuantity = actualOverallQuantity;
	}

	public BigDecimal getItemPrice()
	{
		return itemPrice;
	}

	public void setItemPrice(final BigDecimal itemPrice)
	{
		this.itemPrice = itemPrice;
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public String getProduct()
	{
		return product;
	}

	public void setProduct(final String product)
	{
		this.product = product;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(final String color)
	{
		this.color = color;
	}

	public String getSize()
	{
		return size;
	}

	public void setSize(final String size)
	{
		this.size = size;
	}
}
