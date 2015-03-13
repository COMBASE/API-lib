package domain;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Product extends AbstractNameAndNumberApiObject<Product>
{
	public static class Builder extends Init<Builder>
	{

		@Override
		protected Builder self()
		{
			return this;
		}

	}

	protected static abstract class Init<T extends Init<T>> extends
			AbstractNameAndNumberApiObject.Init<T>

	{
		private Boolean activeAssortment = null;
		private Date activeAssortmentFrom = null;
		private Integer costs = null;
		private Boolean discountable = null;
		private Boolean priceChangeable = null;
		private BigDecimal basePriceMax = new BigDecimal(String.valueOf("9999.99"));
		private BigDecimal basePriceMin = new BigDecimal(String.valueOf("-9999.99"));
		private Boolean requiresSerialNumber = null;
		private Boolean trackInventory = null;
		private CommodityGroup commodityGroup = null;
		private Sector sector = null;
		private Sector altsector = null;
		private final List<Price> prices = new ArrayList<Price>();
		private Assortment assortment = null;
		private final List<Product_Text> texts = new ArrayList<Product_Text>();
		private final List<Product_Code> codes = new ArrayList<Product_Code>();
		private List<SupplierItemPrice> supplierItemPrices = null;
		private Boolean packaging = null;

		private Boolean preparationArticle = null;

		private List<Tag> tags = new ArrayList<Tag>();

		public T activeAssortment(final Boolean value)
		{
			activeAssortment = value;
			return self();
		}

		public T activeAssortmentFrom(final Date value)
		{
			activeAssortmentFrom = value;
			return self();
		}

		public T altsector(final Sector sec)
		{
			altsector = sec;
			return self();
		}

		public T assortment(final Assortment value)
		{
			assortment = value;
			return self();
		}

		public T basePriceMax(final BigDecimal value)
		{
			basePriceMax = value;
			return self();
		}

		public T basePriceMin(final BigDecimal value)
		{
			basePriceMin = value;
			return self();
		}

		@Override
		public Product build()
		{
			return new Product(this);
		}

		public T codes(final Collection<Product_Code> coll)
		{
			for (final Product_Code code : coll)
			{
				codes.add(code);
			}
			return self();
		}

		public T codes(final Product_Code code)
		{
			codes.add(code);
			return self();
		}

		public T commodityGroup(final CommodityGroup grp)
		{
			commodityGroup = grp;
			return self();
		}

		public T costs(final int i)
		{
			costs = i;
			return self();
		}

		public T discountable(final Boolean value)
		{
			discountable = value;
			return self();
		}

		public T packaging(final Boolean value)
		{
			packaging = value;
			return self();
		}

		public T preparationArticle(final Boolean value)
		{
			preparationArticle = value;
			return self();
		}

		public T priceChangeable(final Boolean value)
		{
			priceChangeable = value;
			return self();
		}

		public T prices(final Collection<Price> coll)
		{
			for (final Price price : coll)
			{
				prices.add(price);
			}
			return self();
		}

		public T prices(final Price p)
		{
			prices.add(p);
			return self();
		}

		public T requiresSerialNumber(final Boolean value)
		{
			requiresSerialNumber = value;
			return self();
		}

		public T sector(final Sector sec)
		{
			sector = sec;
			return self();
		}

		public T supplierItemPrice(final List<SupplierItemPrice> value)
		{
			supplierItemPrices = value;
			return self();
		}

		public T supplierItemPrice(final SupplierItemPrice value)
		{
			if (supplierItemPrices == null)
				supplierItemPrices = new ArrayList<SupplierItemPrice>();
			supplierItemPrices.add(value);
			return self();
		}

		public T tags(final List<Tag> value)
		{
			tags = value;
			return self();
		}

		public T tags(final Tag tag)
		{
			if (tags == null)
				tags = new ArrayList<Tag>();
			tags.add(tag);
			return self();
		}

		public T texts(final Collection<Product_Text> coll)
		{
			for (final Product_Text text : coll)
			{
				texts.add(text);
			}
			return self();
		}

		public T texts(final Product_Text text)
		{
			texts.add(text);
			return self();
		}

		public T trackInventory(final Boolean value)
		{
			trackInventory = value;
			return self();
		}

	}

	// TODO implement BD fields basePriceMax basePriceMin in from/to JSON
	// TODO implement SupplierItemPrice
	public static Product fromJSON(JSONObject obj) throws JSONException, ParseException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		final Assortment assortment = new Assortment.Builder().build();
		if (!obj.isNull("assortment"))
			assortment.setId(obj.getString("assortment"));

		final Sector sector = new Sector.Builder().build();
		if (!obj.isNull("sector"))
			sector.setId(obj.getString("sector"));

		final Sector altSector = new Sector.Builder().build();
		if (!obj.isNull("alternativeSector"))
			altSector.setId(obj.getString("alternativeSector"));

		final CommodityGroup commodityGroup = new CommodityGroup.Builder().id(
				obj.getString("commodityGroup")).build();

		final Product prod = new Product.Builder().name(obj.getString("name"))
				.id(obj.getString("uuid")).sector(sector).deleted(obj.getBoolean("deleted"))
				.altsector(altSector).revision(obj.getLong("revision"))
				.commodityGroup(commodityGroup).assortment(assortment)
				.preparationArticle(obj.getBoolean("preparationArticle"))
				.packaging(obj.getBoolean("packaging")).build();

		if (obj.has("number"))
			prod.setNumber(obj.getString("number"));

		if (!obj.isNull("articleCodes") && !obj.getString("articleCodes").equalsIgnoreCase("null"))
		{
			JSONArray jACode = new JSONArray();
			jACode = obj.getJSONArray("articleCodes");
			JSONObject jCode = new JSONObject();
			final List<Product_Code> codeList = new ArrayList<Product_Code>();
			Product_Code productCode = null;
			for (int i = 0; i <= jACode.length() - 1; i++)
			{
				jCode = (JSONObject) jACode.get(i);
				final BigDecimal quantity = new BigDecimal(jCode.getDouble("quantity"));
				if (!jCode.isNull("code"))
				{
					productCode = new Product_Code(jCode.getString("code"), quantity);
					codeList.add(productCode);
				}

			}
			prod.setCodes(codeList);
		}

		if (!obj.isNull("articleTexts") && !obj.getString("articleTexts").equalsIgnoreCase("null"))
		{
			JSONArray jAText = new JSONArray();
			jAText = obj.getJSONArray("articleTexts");
			JSONObject jText = new JSONObject();
			final List<Product_Text> textList = new ArrayList<Product_Text>();
			Product_Text productText = null;
			ProductText_Type type = null;
			final ProductText_Type[] possibleTypes = ProductText_Type.values();
			for (int i = 0; i <= jAText.length() - 1; i++)
			{
				jText = jAText.getJSONObject(i);
				if (!jText.isNull("text") && !jText.isNull("type"))
				{
					for (int j = 0; j < possibleTypes.length; j++)
					{
						if (possibleTypes[j].getReference().equalsIgnoreCase(
								jText.getString("type")))
						{
							type = possibleTypes[j];
							break;
						}
					}
					productText = new Product_Text(jText.getString("text"), type);
					textList.add(productText);
				}

			}
			prod.setTexts(textList);
		}

		if (!obj.isNull("prices") && !obj.getString("prices").equalsIgnoreCase("null"))
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
					final OrganizationalUnit organizationalUnit = new OrganizationalUnit.Builder()
							.id(jPrice.getString("organizationalUnit")).build();

					prices.add(new Price(organizationalUnit, value));
				} else
					prices.add(new Price(pricelist, prepareDate(jPrice, "validFrom"), value));
			}
			prod.setPrices(prices);
		}
		return prod;
	}

	private static final long serialVersionUID = -4259851643720605829L;
	private Boolean activeAssortment;
	private Date activeAssortmentFrom;
	private Integer costs;
	private Boolean discountable;
	private Boolean priceChangeable;
	private BigDecimal basePriceMax;
	private BigDecimal basePriceMin;

	private Boolean requiresSerialNumber;

	private Boolean trackInventory;

	private List<SupplierItemPrice> supplierItemPrices = null;

	private CommodityGroup commodityGroup;

	private Sector sector;

	private Sector altsector;

	private List<Price> prices;

	private List<Product_Text> texts;

	private Assortment assortment;

	private List<Product_Code> codes;

	private Boolean packaging;

	private Boolean preparationArticle;

	private List<Tag> tags;

	private Product(final Init<?> init)
	{
		super(init);
		activeAssortment = init.activeAssortment;
		activeAssortmentFrom = init.activeAssortmentFrom;
		costs = init.costs;
		discountable = init.discountable;
		priceChangeable = init.priceChangeable;
		basePriceMax = init.basePriceMax;
		basePriceMin = init.basePriceMin;
		requiresSerialNumber = init.requiresSerialNumber;
		trackInventory = init.trackInventory;
		commodityGroup = init.commodityGroup;
		sector = init.sector;
		altsector = init.altsector;
		prices = init.prices;
		texts = init.texts;
		assortment = init.assortment;
		supplierItemPrices = init.supplierItemPrices;
		codes = init.codes;
		preparationArticle = init.preparationArticle;
		packaging = init.packaging;
		tags = init.tags;
	}

	public void addCodes(final Collection<Product_Code> coll)
	{
		for (final Product_Code code : coll)
		{
			this.codes.add(code);
		}
	}

	public void addTexts(final Collection<Product_Text> texts)
	{
		for (final Product_Text product_Text : texts)
		{
			this.texts.add(product_Text);
		}
	}

	@Override
	public boolean equals(final Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Product other = (Product) obj;
		if (activeAssortment == null)
		{
			if (other.activeAssortment != null)
				return false;
		} else if (!activeAssortment.equals(other.activeAssortment))
			return false;
		if (activeAssortmentFrom == null)
		{
			if (other.activeAssortmentFrom != null)
				return false;
		} else if (!activeAssortmentFrom.equals(other.activeAssortmentFrom))
			return false;
		if (altsector == null)
		{
			if (other.altsector != null)
				return false;
		} else if (!altsector.equals(other.altsector))
			return false;
		if (assortment == null)
		{
			if (other.assortment != null)
				return false;
		} else if (!assortment.equals(other.assortment))
			return false;
		if (basePriceMax == null)
		{
			if (other.basePriceMax != null)
				return false;
		} else if (!basePriceMax.equals(other.basePriceMax))
			return false;
		if (basePriceMin == null)
		{
			if (other.basePriceMin != null)
				return false;
		} else if (!basePriceMin.equals(other.basePriceMin))
			return false;
		if (codes == null)
		{
			if (other.codes != null)
				return false;
		} else if (!codes.equals(other.codes))
			return false;
		if (commodityGroup == null)
		{
			if (other.commodityGroup != null)
				return false;
		} else if (!commodityGroup.equals(other.commodityGroup))
			return false;
		if (costs == null)
		{
			if (other.costs != null)
				return false;
		} else if (!costs.equals(other.costs))
			return false;
		if (discountable == null)
		{
			if (other.discountable != null)
				return false;
		} else if (!discountable.equals(other.discountable))
			return false;
		if (packaging == null)
		{
			if (other.packaging != null)
				return false;
		} else if (!packaging.equals(other.packaging))
			return false;
		if (preparationArticle == null)
		{
			if (other.preparationArticle != null)
				return false;
		} else if (!preparationArticle.equals(other.preparationArticle))
			return false;
		if (priceChangeable == null)
		{
			if (other.priceChangeable != null)
				return false;
		} else if (!priceChangeable.equals(other.priceChangeable))
			return false;
		if (prices == null)
		{
			if (other.prices != null)
				return false;
		} else if (!prices.equals(other.prices))
			return false;
		if (requiresSerialNumber == null)
		{
			if (other.requiresSerialNumber != null)
				return false;
		} else if (!requiresSerialNumber.equals(other.requiresSerialNumber))
			return false;
		if (sector == null)
		{
			if (other.sector != null)
				return false;
		} else if (!sector.equals(other.sector))
			return false;
		if (supplierItemPrices == null)
		{
			if (other.supplierItemPrices != null)
				return false;
		} else if (!supplierItemPrices.equals(other.supplierItemPrices))
			return false;
		if (tags == null)
		{
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (texts == null)
		{
			if (other.texts != null)
				return false;
		} else if (!texts.equals(other.texts))
			return false;
		if (trackInventory == null)
		{
			if (other.trackInventory != null)
				return false;
		} else if (!trackInventory.equals(other.trackInventory))
			return false;
		return true;
	}

	public Date getActiveAssortmentFrom()
	{
		return activeAssortmentFrom;
	}

	public Sector getAltsector()
	{
		return altsector;
	}

	public Assortment getAssortment()
	{
		return assortment;
	}

	public BigDecimal getBasePriceMax()
	{
		return basePriceMax;
	}

	public BigDecimal getBasePriceMin()
	{
		return basePriceMin;
	}

	public List<Product_Code> getCodes()
	{
		if (codes == null)
			codes = new ArrayList<Product_Code>();
		return codes;
	}

	public CommodityGroup getCommodityGroup()
	{
		return commodityGroup;
	}

	public int getCosts()
	{
		return costs;
	}

	public Boolean getPackaging()
	{
		return packaging;
	}

	public Boolean getPreparationArticle()
	{
		return preparationArticle;
	}

	public List<Price> getPrices()
	{
		return prices;
	}

	public Sector getSector()
	{
		return sector;
	}

	public List<SupplierItemPrice> getSupplierItemPrices()
	{
		return supplierItemPrices;
	}

	public List<SupplierItemPrice> getSuppliers()
	{
		return supplierItemPrices;
	}

	public List<Tag> getTags()
	{
		return tags;
	}

	public List<Product_Text> getTexts()
	{
		return texts;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activeAssortment == null) ? 0 : activeAssortment.hashCode());
		result = prime * result
				+ ((activeAssortmentFrom == null) ? 0 : activeAssortmentFrom.hashCode());
		result = prime * result + ((altsector == null) ? 0 : altsector.hashCode());
		result = prime * result + ((assortment == null) ? 0 : assortment.hashCode());
		result = prime * result + ((basePriceMax == null) ? 0 : basePriceMax.hashCode());
		result = prime * result + ((basePriceMin == null) ? 0 : basePriceMin.hashCode());
		result = prime * result + ((codes == null) ? 0 : codes.hashCode());
		result = prime * result + ((commodityGroup == null) ? 0 : commodityGroup.hashCode());
		result = prime * result + ((costs == null) ? 0 : costs.hashCode());
		result = prime * result + ((discountable == null) ? 0 : discountable.hashCode());
		result = prime * result + ((packaging == null) ? 0 : packaging.hashCode());
		result = prime * result
				+ ((preparationArticle == null) ? 0 : preparationArticle.hashCode());
		result = prime * result + ((priceChangeable == null) ? 0 : priceChangeable.hashCode());
		result = prime * result + ((prices == null) ? 0 : prices.hashCode());
		result = prime * result
				+ ((requiresSerialNumber == null) ? 0 : requiresSerialNumber.hashCode());
		result = prime * result + ((sector == null) ? 0 : sector.hashCode());
		result = prime * result
				+ ((supplierItemPrices == null) ? 0 : supplierItemPrices.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((texts == null) ? 0 : texts.hashCode());
		result = prime * result + ((trackInventory == null) ? 0 : trackInventory.hashCode());
		return result;
	}

	public Boolean isActiveAssortment()
	{
		return activeAssortment;
	}

	public Boolean isDiscountable()
	{
		return discountable;
	}

	public Boolean isPriceChangeable()
	{
		return priceChangeable;
	}

	public Boolean isRequiresSerialNumber()
	{
		return requiresSerialNumber;
	}

	public Boolean isTrackInventory()
	{
		return trackInventory;
	}

	public void setActiveAssortment(final Boolean activeAssortment)
	{
		this.activeAssortment = activeAssortment;
	}

	public void setActiveAssortmentFrom(final Date activeAssortmentFrom)
	{
		this.activeAssortmentFrom = activeAssortmentFrom;
	}

	public void setAltsector(final Sector altsector)
	{
		this.altsector = altsector;
	}

	public void setAssortment(final Assortment assortment)
	{
		this.assortment = assortment;
	}

	public void setBasePriceMax(final BigDecimal basePriceMax)
	{
		this.basePriceMax = basePriceMax;
	}

	public void setBasePriceMin(final BigDecimal basePriceMin)
	{
		this.basePriceMin = basePriceMin;
	}

	public void setCodes(final List<Product_Code> codes)
	{
		this.codes = codes;
	}

	public void setCommodityGroup(final CommodityGroup commodityGroup)
	{
		this.commodityGroup = commodityGroup;
	}

	public void setCosts(final int costs)
	{
		this.costs = costs;
	}

	public void setDiscountable(final Boolean discountable)
	{
		this.discountable = discountable;
	}

	public void setPackaging(final Boolean packaging)
	{
		this.packaging = packaging;
	}

	public void setPreparationArticle(final Boolean preparationArticle)
	{
		this.preparationArticle = preparationArticle;
	}

	public void setPriceChangeable(final Boolean priceChangeable)
	{
		this.priceChangeable = priceChangeable;
	}

	public void setPrices(final List<Price> prices)
	{
		this.prices = prices;
	}

	public void setRequiresSerialNumber(final Boolean requiresSerialNumber)
	{
		this.requiresSerialNumber = requiresSerialNumber;
	}

	public void setSector(final Sector sector)
	{
		this.sector = sector;
	}

	public void setSupplierItemPrices(final List<SupplierItemPrice> supplierItemPrices)
	{
		this.supplierItemPrices = supplierItemPrices;
	}

	public void setSuppliers(final List<SupplierItemPrice> suppliers)
	{
		this.supplierItemPrices = suppliers;
	}

	public void setTags(final List<Tag> tags)
	{
		this.tags = tags;
	}

	public void setTexts(final List<Product_Text> texts)
	{
		this.texts = texts;
	}

	public void setTrackInventory(final Boolean trackInventory)
	{
		this.trackInventory = trackInventory;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();
		appendJSON(obj);

		obj.put("activeAssortment", activeAssortment);
		if (activeAssortmentFrom != null)
			obj.put("activeAssortmentFrom", inputDf.format(activeAssortmentFrom));
		obj.put("costs", costs);
		obj.put("discountable", discountable);
		obj.put("priceChangeable", priceChangeable);
		obj.put("requiresSerialNumber", requiresSerialNumber);
		obj.put("trackInventory", trackInventory);
		obj.put("packaging", packaging);
		// obj.put("packaging", packaging);
		obj.put("preparationArticle", preparationArticle);
		if (commodityGroup != null)
			obj.put("commodityGroup", commodityGroup.getId());
		if (assortment != null)
			obj.put("assortment", assortment.getId());
		if (sector != null)
			obj.put("sector", sector.getId());
		if (altsector != null)
			obj.put("alternativeSector", altsector.getId());

		if (supplierItemPrices != null && !supplierItemPrices.isEmpty())
		{
			final JSONArray array = new JSONArray();
			for (final SupplierItemPrice supplierItemPrice : supplierItemPrices)
			{
				if (supplierItemPrice != null)
					array.put(supplierItemPrice.toJSON());
			}
			obj.put("supplierItemPrices", array);
		}

		if (prices != null && !prices.isEmpty())
		{
			final JSONArray array = new JSONArray();
			for (final Price p : prices)
			{
				if (p != null)
					array.put(p.toJSON());
			}
			obj.put("prices", array);
		}
		if (codes != null && !codes.isEmpty())
		{
			final JSONArray array = new JSONArray();
			for (final Product_Code code : codes)
			{
				if (code != null && !code.getCode().equalsIgnoreCase(""))
					array.put(code.toJSON());
			}
			obj.put("articleCodes", array);
		}
		if (texts != null && !texts.isEmpty())
		{
			final JSONArray array = new JSONArray();
			for (final Product_Text text : texts)
			{
				if (text != null)
					array.put(text.toJSON());
			}
			obj.put("articleTexts", array);
		}
		if (tags != null && !tags.isEmpty())
		{
			final JSONArray array = new JSONArray();
			for (final Tag tag : tags)
			{
				if (tag != null)
					array.put(tag.toJSON());
			}
			obj.put("tags", array);
		}

		return obj;
	}

	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();
		super.toString(stringBuilder);
		return stringBuilder.toString();
	}
}
