package domain;

import java.math.BigDecimal;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class InventoryReceiptItem extends AbstractApiObject<InventoryReceiptItem>
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
		private BigDecimal nominalGoods = null;

		private BigDecimal actualGoods = null;

		private String differenceReason = null;

		private Product article = null;

		private InventoryReceipt receipt = null;

		public T actualGoods(final BigDecimal value)
		{
			actualGoods = value;
			return self();
		}

		public T article(final Product value)
		{
			article = value;
			return self();
		}

		@Override
		public InventoryReceiptItem build()
		{
			return new InventoryReceiptItem(this);
		}

		public T differenceReason(final String value)
		{
			differenceReason = value;
			return self();
		}

		public T nominalGoods(final BigDecimal value)
		{
			nominalGoods = value;
			return self();
		}

		public T receipt(final InventoryReceipt value)
		{
			receipt = value;
			return self();
		}
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 7867322273575161809L;

	private BigDecimal nominalGoods;

	private BigDecimal actualGoods;

	private String differenceReason;

	private Product article;

	private InventoryReceipt receipt;


	public InventoryReceiptItem(final Init<?> init)
	{
		super(init);

		this.nominalGoods = init.nominalGoods;

		this.actualGoods = init.actualGoods;

		this.differenceReason = init.differenceReason;

		this.article = init.article;

		this.receipt = init.receipt;
	}

	public BigDecimal getActualGoods()
	{
		return actualGoods;
	}

	public Product getArticle()
	{
		return article;
	}

	public String getDifferenceReason()
	{
		return differenceReason;
	}

	public BigDecimal getNominalGoods()
	{
		return nominalGoods;
	}

	public InventoryReceipt getReceipt()
	{
		return receipt;
	}

	public void setActualGoods(final BigDecimal actualGoods)
	{
		this.actualGoods = actualGoods;
	}

	public void setArticle(final Product article)
	{
		this.article = article;
	}

	public void setDifferenceReason(final String differenceReason)
	{
		this.differenceReason = differenceReason;
	}

	public void setNominalGoods(final BigDecimal nominalGoods)
	{
		this.nominalGoods = nominalGoods;
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

		obj.put("nominalGoods", nominalGoods);

		obj.put("actualGoods", actualGoods);

		obj.put("differenceReason", differenceReason);

		if (article != null)
		{
			obj.put("article", article.getId());
		}

		if (receipt != null)
		{
			obj.put("receipt", receipt.getId());
		}

		return obj;
	}

	public static InventoryReceiptItem fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && nullStringToNull(obj, "result") != null)
		{
			obj = obj.getJSONObject("result");
		}

		final Product product = new Product.Builder().id(nullStringToNull(obj, "article")).build();

		final InventoryReceipt receipt = new InventoryReceipt.Builder().id(
			nullStringToNull(obj, "receipt")).build();

		final InventoryReceiptItem inventoryReceiptItem = new InventoryReceiptItem.Builder().id(
			nullStringToNull(obj, "uuid"))
			.nominalGoods(prepareBigDecimal(obj, "nominalGoods"))
			.actualGoods(prepareBigDecimal(obj, "actualGoods"))
			.article(product)
			.differenceReason(nullStringToNull(obj, "differenceReason"))
			.receipt(receipt)
			.build();


		return inventoryReceiptItem;
	}


}
