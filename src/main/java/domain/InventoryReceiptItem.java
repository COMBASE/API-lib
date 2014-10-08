package domain;

import java.math.BigDecimal;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class InventoryReceiptItem
{
	private String uuid;

	private boolean deleted;

	private BigDecimal nominalGoods;

	private BigDecimal actualGoods;

	private String differenceReason;

	private Product article;

	private InventoryReceipt receipt;

	public InventoryReceiptItem(final Builder builder)
	{
		this.uuid = builder.uuid;

		this.setDeleted(builder.deleted);

		this.nominalGoods = builder.nominalGoods;

		this.actualGoods = builder.actualGoods;

		this.differenceReason = builder.differenceReason;

		this.article = builder.article;

		this.receipt = builder.receipt;
	}

	public static class Builder
	{

		private String uuid = null;

		private boolean deleted = false;

		private BigDecimal nominalGoods = null;

		private BigDecimal actualGoods = null;

		private String differenceReason = null;

		private Product article = null;

		private InventoryReceipt receipt = null;

		public Builder nominalGoods(final BigDecimal value)
		{
			nominalGoods = value;
			return this;
		}

		public Builder uuid(final String value)
		{
			uuid = value;
			return this;
		}

		public Builder deleted(final boolean value)
		{
			deleted = value;
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

		public Builder receipt(final InventoryReceipt value)
		{
			receipt = value;
			return this;
		}

		public InventoryReceiptItem build()
		{
			return new InventoryReceiptItem(this);
		}
	}

	public static InventoryReceiptItem fromJson(final JSONObject object) throws JSONException
	{

		final Product product = new Product.Builder(null).uuid(object.getString("article")).build();

		final InventoryReceipt receipt = new InventoryReceipt.Builder().uuid(
			object.getString("receipt")).build();

		final InventoryReceiptItem inventoryReceiptItem = new InventoryReceiptItem.Builder().uuid(
			object.getString("uuid"))
			.nominalGoods(new BigDecimal(object.getString("nominalGoods")))
			.actualGoods(new BigDecimal(object.getString("acturalGoods")))
			.article(product)
			.differenceReason(object.getString("differenceReason"))
			.receipt(receipt)
			.build();


		return inventoryReceiptItem;
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

	public InventoryReceipt getReceipt()
	{
		return receipt;
	}

	public void setReceipt(final InventoryReceipt receipt)
	{
		this.receipt = receipt;
	}

	public String getUuid()
	{
		return uuid;
	}

	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

	public boolean isDeleted()
	{
		return deleted;
	}

	public void setDeleted(final boolean deleted)
	{
		this.deleted = deleted;
	}
}
