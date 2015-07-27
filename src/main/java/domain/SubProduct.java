package domain;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class SubProduct
{
	private String article = null;
	private BigDecimal amount = null;
	private List<Price> prices = new ArrayList<Price>();
	private Integer position = null;

	public SubProduct()
	{
		super();
		this.article = null;
		this.amount = null;
		this.prices = null;
		this.position = null;
	}

	public SubProduct(final String articleId, final BigDecimal amount, final List<Price> prices,
		final Integer position)
	{
		super();
		this.article = articleId;
		this.amount = amount;
		this.prices = prices;
		this.position = position;
	}

	@Override
	public boolean equals(final Object obj)
	{
		return obj.hashCode() == this.hashCode();
	}

	public BigDecimal getAmount()
	{
		return amount;
	}

	public String getArticle()
	{
		return article;
	}

	public Integer getPosition()
	{
		return position;
	}

	public List<Price> getPrices()
	{
		return prices;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = prime * result + ((this.article == null) ? 0 : this.article.hashCode());
		result = prime * result + ((this.amount == null) ? 0 : this.amount.hashCode());
		result = prime * result + ((this.prices == null) ? 0 : this.prices.hashCode());
		result = prime * result + ((this.position == null) ? 0 : this.position.hashCode());

		return result;
	}

	public void setAmount(final BigDecimal amount)
	{
		this.amount = amount;
	}

	public void setArticle(final String article)
	{
		this.article = article;
	}

	public void setPosition(final Integer position)
	{
		this.position = position;
	}

	public void setPrices(final List<Price> prices)
	{
		this.prices = prices;
	}

	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();

		obj.put("article", article);
		if (amount != null)
		{
			obj.put("amount", amount.doubleValue());
		}
		obj.put("position", position);

		if (prices != null && !prices.isEmpty())
		{
			final JSONArray array = new JSONArray();
			for (final Price p : prices)
			{
				if (p != null)
				{
					array.put(p.toJSON());
				}
			}
			obj.put("prices", array);
		}
		return obj;
	}

	public static SubProduct fromJSON(JSONObject obj) throws JSONException, ParseException
	{
		if (obj.has("result") && nullStringToNull(obj, "result") != null)
		{
			obj = obj.getJSONObject("result");
		}
		final SubProduct sp = new SubProduct();

		if (obj.has("article"))
		{
			sp.setArticle(nullStringToNull(obj, "article"));
		}

		if (obj.has("amount"))
		{
			sp.setAmount(BigDecimal.valueOf(obj.getDouble("amount")));
		}

		if (!obj.isNull("prices") && !nullStringToNull(obj, "prices").equalsIgnoreCase("null"))
		{
			final JSONArray jPrices = obj.getJSONArray("prices");
			final List<Price> prices = new ArrayList<Price>();
			JSONObject jPrice;
			for (int i = 0; i <= jPrices.length() - 1; i++)
			{
				jPrice = jPrices.getJSONObject(i);

				final BigDecimal value = new BigDecimal(jPrice.getDouble("value"));
				final Pricelist pricelist = new Pricelist.Builder().id(
					jPrice.getString("priceList")).build();
				if (!jPrice.isNull("organizationalUnit"))
				{
					final OrganizationalUnit organizationalUnit = new OrganizationalUnit.Builder().id(
						jPrice.getString("organizationalUnit"))
						.build();

					prices.add(new Price(organizationalUnit, value));
				}
				else
				{
					prices.add(new Price(pricelist, AbstractApiObject.prepareDate(jPrice,
						"validFrom"), value));
				}
			}
			sp.setPrices(prices);
		}

		if (obj.has("position"))
		{
			sp.setPosition(obj.getInt("position"));
		}

		return sp;
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
