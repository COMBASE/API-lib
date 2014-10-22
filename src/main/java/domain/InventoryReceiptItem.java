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

// public static InventoryReceiptItem fromJson(final JSONObject object) throws JSONException
// {
//
// final Product product = new Product.Builder(null).uuid(object.getString("article")).build();
//
// final InventoryReceipt receipt = new InventoryReceipt.Builder().uuid(
// object.getString("receipt")).build();
//
// final InventoryReceiptItem inventoryReceiptItem = new InventoryReceiptItem.Builder().uuid(
// object.getString("uuid"))
// .nominalGoods(new BigDecimal(object.getString("nominalGoods")))
// .actualGoods(new BigDecimal(object.getString("acturalGoods")))
// .article(product)
// .differenceReason(object.getString("differenceReason"))
// .receipt(receipt)
// .build();
//
//
// return inventoryReceiptItem;
// }

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
		writeJSON(obj);
		return obj;
	}

	@Override
	public void writeJSON(final JSONObject obj) throws JSONException
	{
		super.writeJSON(obj);

	}

	@Override
	public InventoryReceiptItem fromJSON(final JSONObject obj) throws JSONException
	{
		readJSON(obj);
		return this;
	}

	@Override
	public void readJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		super.readJSON(obj);


	}
}
