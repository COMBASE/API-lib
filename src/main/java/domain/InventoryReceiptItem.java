package domain;

import java.math.BigDecimal;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class InventoryReceiptItem extends AbstractApiObject<InventoryReceiptItem>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7867322273575161809L;

	private BigDecimal nominalGoods;

	private BigDecimal actualGoods;

	private String differenceReason;

	private Product article;

	private InventoryReceipt receipt;

	protected static abstract class Init<T extends Init<T>> extends AbstractApiObject.Init<T>
	{
		private BigDecimal nominalGoods = null;

		private BigDecimal actualGoods = null;

		private String differenceReason = null;

		private Product article = null;

		private InventoryReceipt receipt = null;

		public T nominalGoods(final BigDecimal value)
		{
			nominalGoods = value;
			return self();
		}

		public T actualGoods(final BigDecimal value)
		{
			actualGoods = value;
			return self();
		}

		public T differenceReason(final String value)
		{
			differenceReason = value;
			return self();
		}

		public T article(final Product value)
		{
			article = value;
			return self();
		}

		public T receipt(final InventoryReceipt value)
		{
			receipt = value;
			return self();
		}

		@Override
		public InventoryReceiptItem build()
		{
			return new InventoryReceiptItem(this);
		}
	}

	public static class Builder extends Init<Builder>
	{

		@Override
		protected Builder self()
		{
			return this;
		}

	}


	public InventoryReceiptItem(final Init<?> init)
	{
		super(init);

		this.nominalGoods = init.nominalGoods;

		this.actualGoods = init.actualGoods;

		this.differenceReason = init.differenceReason;

		this.article = init.article;

		this.receipt = init.receipt;
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

	@Override
	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();
		appendJSON(obj);
		return obj;
	}

	public static InventoryReceiptItem fromJSON(final JSONObject obj) throws JSONException
	{
		final Product product = new Product.Builder().id(obj.getString("article")).build();

		final InventoryReceipt receipt = new InventoryReceipt.Builder().id(obj.getString("receipt"))
			.build();

		final InventoryReceiptItem inventoryReceiptItem = new InventoryReceiptItem.Builder().id(
			obj.getString("uuid"))
			.nominalGoods(new BigDecimal(obj.getString("nominalGoods")))
			.actualGoods(new BigDecimal(obj.getString("acturalGoods")))
			.article(product)
			.differenceReason(obj.getString("differenceReason"))
			.receipt(receipt)
			.build();


		return inventoryReceiptItem;
	}
}
