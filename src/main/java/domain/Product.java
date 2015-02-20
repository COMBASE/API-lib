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
		private BigDecimal basePriceMax = null;
		private BigDecimal basePriceMin = null;
		private Boolean requiresSerialNumber = null;
		private Boolean trackInventory = null;
		private CommodityGroup commodityGroup = null;
		private Sector sector = null;
		private Sector altsector = null;
		private final List<Price> prices = null;
		private Assortment assortment = null;
		private List<Product_Text> texts = null;
		private List<Product_Code> codes = null;
		private List<SupplierItemPrice> supplierItemPrices = null;
		private Boolean packaging = null;

		private Boolean preparationArticle = null;

		private List<Tag> tags = null;

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

			if (codes == null)
				codes = new ArrayList<Product_Code>();

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
			if (texts == null)
				texts = new ArrayList<Product_Text>();
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

	private static final long serialVersionUID = -4259851643720605829L;

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
			.id(obj.getString("uuid"))
			.sector(sector)
			.deleted(obj.getBoolean("deleted"))
			.altsector(altSector)
			.revision(obj.getLong("revision"))
			.commodityGroup(commodityGroup)
			.assortment(assortment)
			.preparationArticle(obj.getBoolean("preparationArticle"))
			.packaging(obj.getBoolean("packaging"))
			.basePriceMax(prepareBigDecimal(obj, "basePriceMax"))
			.basePriceMin(prepareBigDecimal(obj, "basePriceMin"))
			.build();

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
				jCode = (JSONObject)jACode.get(i);
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
					final OrganizationalUnit organizationalUnit = new OrganizationalUnit.Builder().id(
						jPrice.getString("organizationalUnit"))
						.build();

					prices.add(new Price(pricelist, prepareDate(jPrice, "validFrom"), value,
						organizationalUnit));
				}
				else
					prices.add(new Price(pricelist, prepareDate(jPrice, "validFrom"), value, null));
			}
			prod.setPrices(prices);
		}
		return prod;
	}

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

		return obj.hashCode() == this.hashCode();
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

		result = super.hashCode(result);
		result = prime * result + ((this.altsector == null) ? 0 : this.altsector.hashCode());
		result = prime * result + ((this.assortment == null) ? 0 : this.assortment.hashCode());
		result = prime * result + ((this.codes == null) ? 0 : this.codes.hashCode());
		result = prime * result +
			((this.commodityGroup == null) ? 0 : this.commodityGroup.hashCode());
		// result = prime * result + ((this.prices == null) ? 0 : this.prices.hashCode());
		result = prime * result + ((this.sector == null) ? 0 : this.sector.hashCode());
		result = prime * result + ((this.tags == null) ? 0 : this.tags.hashCode());

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

		if (basePriceMax == null)
			basePriceMax = new BigDecimal(String.valueOf("9999.99"));

		if (basePriceMin == null)
			basePriceMin = new BigDecimal(String.valueOf("-9999.99"));

		obj.put("basePriceMax", basePriceMax);

		obj.put("basePriceMin", basePriceMin);


		if (supplierItemPrices != null && !supplierItemPrices.isEmpty())
		{
			final JSONArray array = new JSONArray();
			for (final SupplierItemPrice supplierItemPrice : supplierItemPrices)
			{
				array.put(supplierItemPrice.toJSON());
			}
			obj.put("supplierItemPrices", array);
		}

		if (prices != null && !prices.isEmpty())
		{

			final JSONArray array = new JSONArray();
			for (final Price p : prices)
			{
				array.put(p.toJSON());
			}
			obj.put("prices", array);
		}
		if (codes != null && !codes.isEmpty())
		{
			final JSONArray array = new JSONArray();
			for (final Product_Code code : codes)
			{
				if (!code.getCode().equalsIgnoreCase(""))
					array.put(code.toJSON());
			}
			obj.put("articleCodes", array);
		}
		if (!texts.isEmpty())
		{
			final JSONArray array = new JSONArray();
			for (final Product_Text text : texts)
			{
				array.put(text.toJSON());
			}
			obj.put("articleTexts", array);
		}
		if (tags != null && !tags.isEmpty())
		{
			final JSONArray array = new JSONArray();
			for (final Tag tag : tags)
			{
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
