package domain;

import java.math.BigDecimal;

public class InventoryReceiptItem
{
	private BigDecimal nominalGoods;

	private BigDecimal actualGoods;

	private String differenceReason;

	private Product article;

	private Receipt receipt;

	public InventoryReceiptItem(final Builder builder)
	{
		this.nominalGoods = builder.nominalGoods;

		this.actualGoods = builder.actualGoods;

		this.differenceReason = builder.differenceReason;

		this.article = builder.article;

		this.receipt = builder.receipt;
	}

	public static class Builder
	{

		private BigDecimal nominalGoods = null;

		private BigDecimal actualGoods = null;

		private String differenceReason = null;

		private Product article = null;

		private Receipt receipt = null;

		public Builder nominalGoods(final BigDecimal value)
		{
			nominalGoods = value;
			return this;
		}

		public Builder actualGoods(final BigDecimal value)
		{
			actualGoods = value;
			return this;
		}

		public Builder differenceReason(final String value)
		{
			differenceReason = value;
			return this;
		}

		public Builder article(final Product value)
		{
			article = value;
			return this;
		}

		public Builder receipt(final Receipt value)
		{
			receipt = value;
			return this;
		}
	}

	public BigDecimal getNominalGoods()
	{
		return nominalGoods;
	}

	public void setNominalGoods(final BigDecimal nominalGoods)
	{
		this.nominalGoods = nominalGoods;
	}

	public BigDecimal getActualGoods()
	{
		return actualGoods;
	}

	public void setActualGoods(final BigDecimal actualGoods)
	{
		this.actualGoods = actualGoods;
	}

	public String getDifferenceReason()
	{
		return differenceReason;
	}

	public void setDifferenceReason(final String differenceReason)
	{
		this.differenceReason = differenceReason;
	}

	public Product getArticle()
	{
		return article;
	}

	public void setArticle(final Product article)
	{
		this.article = article;
	}

	public Receipt getReceipt()
	{
		return receipt;
	}

	public void setReceipt(final Receipt receipt)
	{
		this.receipt = receipt;
	}
}
