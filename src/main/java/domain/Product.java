package domain;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import link.CloudLink;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import error.ApiNotReachableException;

public class Product
{
	public static class Builder
	{
		private final String name;
		private String number = null;
		private String uuid = null;
		private boolean deleted = false;
		private boolean activeAssortment = false;
		private Date activeAssortmentFrom = null;
		private int costs = 0;
		private boolean discountable = true;
		private boolean priceChangeable = true;
		private boolean requiresSerialNumber = false;
		private boolean trackInventory = false;
		private CommodityGroup commodityGroup = null;
		private Sector sector = null;
		private Sector altsector = null;
		private final List<Price> prices = new ArrayList<Price>();
		private Assortment assortment = null;
		private final List<Product_Text> texts = new ArrayList<Product_Text>();
		private final List<Product_Code> codes = new ArrayList<Product_Code>();

		public Builder(final String name)
		{
			this.name = name;
		}

		public Builder activeAssortment(final boolean value)
		{
			activeAssortment = value;
			return this;
		}

		public Builder activeAssortmentFrom(final Date value)
		{
			activeAssortmentFrom = value;
			return this;
		}

		public Builder altsector(final Sector sec)
		{
			altsector = sec;
			return this;
		}

		public Builder assortment(final Assortment value)
		{
			assortment = value;
			return this;
		}

		public Product build()
		{
			return new Product(this);
		}

		public Builder codes(final Collection<Product_Code> coll)
		{
			for (final Product_Code code : coll)
			{
				codes.add(code);
			}
			return this;
		}

		public Builder codes(final Product_Code code)
		{
			codes.add(code);
			return this;
		}

		public Builder commodityGroup(final CommodityGroup grp)
		{
			commodityGroup = grp;
			return this;
		}

		public Builder costs(final int i)
		{
			costs = i;
			return this;
		}

		public Builder deleted(final boolean value)
		{
			deleted = value;
			return this;
		}

		public Builder discountable(final boolean value)
		{
			discountable = value;
			return this;
		}

		public Builder number(final String value)
		{
			number = value;
			return this;
		}

		public Builder priceChangeable(final boolean value)
		{
			priceChangeable = value;
			return this;
		}

		public Builder prices(final Collection<Price> coll)
		{
			for (final Price price : coll)
			{
				prices.add(price);
			}
			return this;
		}

		public Builder prices(final Price p)
		{
			prices.add(p);
			return this;
		}

		public Builder requiresSerialNumber(final boolean value)
		{
			requiresSerialNumber = value;
			return this;
		}

		public Builder sector(final Sector sec)
		{
			sector = sec;
			return this;
		}

		public Builder texts(final Collection<Product_Text> coll)
		{
			for (final Product_Text text : coll)
			{
				texts.add(text);
			}
			return this;
		}

		public Builder texts(final Product_Text text)
		{
			texts.add(text);
			return this;
		}

		public Builder trackInventory(final boolean value)
		{
			trackInventory = value;
			return this;
		}

		public Builder uuid(final String value)
		{
			uuid = value;
			return this;
		}
	}

	private static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

	public static Product fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		final Product prod = new Product.Builder(obj.getString("name")).uuid(obj.getString("uuid"))
			.build();
		if (obj.has("number"))
			prod.setNumber(obj.getString("number"));
		if (obj.getString("articleCodes") != "null")
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
				productCode = new Product_Code(jCode.getString("code"), quantity);
				codeList.add(productCode);
			}
			prod.setCodes(codeList);
		}
		if (obj.get("prices") != "null")
		{
			final JSONArray jPrices = obj.getJSONArray("prices");
			final List<Price> prices = new ArrayList<Price>();
			JSONObject jPrice;
			for (int i = 0; i <= jPrices.length() - 1; i++)
			{
				jPrice = jPrices.getJSONObject(i);

				final BigDecimal value = new BigDecimal(jPrice.getDouble("value"));
				final Pricelist pricelist = new Pricelist.PreBuilder(jPrice.getString("priceList")).build();
				Date date = new Date();
				try
				{
					date = inputDf.parse(jPrice.getString("validFrom"));
				}
				catch (final ParseException e)
				{
					e.printStackTrace();
				}
				if (jPrice.has("organizationalUnit"))
				{
					final Object orgUnit = jPrice.get("organizationalUnit");
					OrganizationalUnit organizationalUnit = null;
					if (orgUnit != null)
						organizationalUnit = new OrganizationalUnit.PreBuilder(
							jPrice.getString("organizationalUnit")).build();


					prices.add(new Price(pricelist, date, value, organizationalUnit));
				}
				else
					prices.add(new Price(pricelist, date, value));
			}
			prod.setPrices(prices);
		}
		return prod;
	}

	/**
	 * More optimized post method for uploading several products of the same group, sector, etc.
	 * !-STABLE-! ~MAS
	 * **/

	public static boolean post(final List<Product> productList)
	{

		final Date date1 = new Date();


// final JSONArray jProdArray = new JSONArray();
// final JSONObject jProdObject = new JSONObject();
		final HashSet<CommodityGroup> grpList = new HashSet<CommodityGroup>();
		final HashSet<Assortment> assortmentList = new HashSet<Assortment>();
		final HashSet<Sector> sectorList = new HashSet<Sector>();
		final HashSet<Pricelist> priceListLists = new HashSet<Pricelist>();

		// filling up SubPojo lists for...
		for (int i = 0; i < productList.size(); i++)
		{
			final Product product = productList.get(i);

			// ...commodityGroup
			if (product.getCommodityGroup() != null)
				grpList.add(productList.get(i).getCommodityGroup());


			// ...assortment
			if (product.getAssortment() != null)
				assortmentList.add(productList.get(i).getAssortment());


			// ...Sector+AltSector
			if (product.getSector() != null)
				sectorList.add(productList.get(i).getSector());


			// ...pricelist
			for (int j = 0; j < product.getPrices().size(); j++)
			{
				if (product.getPrices().get(j).getPriceList() != null)
					priceListLists.add(productList.get(i).getPrices().get(j).getPriceList());
			}
		}


		try
		{
			// posting all new SubPojos
			final Iterator<CommodityGroup> grpListIter = grpList.iterator();
			while (grpListIter.hasNext())
			{
				final CommodityGroup grp = grpListIter.next();
				if (grp != null && grp.getUuid() == null)
					grp.post();
			}
			final Iterator<Assortment> assortmentListIter = assortmentList.iterator();
			while (assortmentListIter.hasNext())
			{
				final Assortment assort = assortmentListIter.next();
				if (assort != null && assort.getUuid() == null)
					assort.post();
			}

			final Iterator<Sector> sectorListIter = sectorList.iterator();
			while (sectorListIter.hasNext())
			{
				final Sector sec = sectorListIter.next();
				if (sec != null && sec.getUuid() == null)
					sec.post();
			}

			final Iterator<Pricelist> priceListListsIter = priceListLists.iterator();
			while (priceListListsIter.hasNext())
			{
				final Pricelist priceL = priceListListsIter.next();
				if (priceL != null && priceL.getUuid() == null)
					priceL.post();
			}

		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
		catch (final ApiNotReachableException e)
		{
			e.printStackTrace();
		}

		boolean bool = false;

		for (int i = 0; i <= productList.size() - 1; i++)
		{
			// putting UUID to subobject Pojo of every next product having the same grp/sector/etc
// like the first.
// for (final CommodityGroup grp : grpList)
// {
// if (productList.get(i).getCommodityGroup() != null)
// if (productList.get(i).getCommodityGroup().getUuid() == null)
// if (grp.getNumber().equals(
// productList.get(i).getCommodityGroup().getNumber()))
// productList.get(i).setCommodityGroup(grp);
// }
// if (!assortmentList.contains(null))
// for (final Assortment assort : assortmentList)
// {
// if (assort.getNumber().equalsIgnoreCase(
// productList.get(i).getAssortment().getNumber()))
// productList.get(i).setAssortment(assort);
// }
// if (!sectorList.contains(null))
// for (final Sector sector : sectorList)
// {
// if (sector.getNumber().equalsIgnoreCase(
// productList.get(i).getSector().getNumber()))
// productList.get(i).setSector(sector);
// }
// if (!priceListLists.contains(null))
// for (final Pricelist pricelist : priceListLists)
// {
// for (final Price price : productList.get(i).getPrices())
// {
// if (pricelist.getNumber() != null &&
// pricelist.getNumber()
// .equalsIgnoreCase(price.getPriceList().getNumber()))
// price.setPriceList(pricelist);
// }
// }
			bool = CloudLink.getConnector().postData(DataType.product, productList.get(i).toJSON());
			System.out.print("*");

		}// end for
		final Date date2 = new Date();
		System.out.println("start: " + date1);
		System.out.println("end: " + date2);
		return bool;
	}

	private String name;
	private String number;
	private boolean deleted;
	private boolean activeAssortment;
	private Date activeAssortmentFrom;
	private int costs;
	private boolean discountable;
	private boolean priceChangeable;
	private boolean requiresSerialNumber;
	private boolean trackInventory;
	private CommodityGroup commodityGroup;
	private Sector sector;

	private Sector altsector;

	private List<Price> prices;

	private List<Product_Text> texts;

	private Assortment assortment;

	private List<Product_Code> codes;

	private String uuid = null;

	private Product(final Builder builder)
	{
		name = builder.name;
		number = builder.number;
		deleted = builder.deleted;
		activeAssortment = builder.activeAssortment;
		activeAssortmentFrom = builder.activeAssortmentFrom;
		costs = builder.costs;
		discountable = builder.discountable;
		priceChangeable = builder.priceChangeable;
		requiresSerialNumber = builder.requiresSerialNumber;
		trackInventory = builder.trackInventory;
		commodityGroup = builder.commodityGroup;
		sector = builder.sector;
		altsector = builder.altsector;
		prices = builder.prices;
		texts = builder.texts;
		assortment = builder.assortment;
		codes = builder.codes;
		uuid = builder.uuid;
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

	public List<Product_Code> getCodes()
	{
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

	public String getName()
	{
		return name;
	}

	public String getNumber()
	{
		return number;
	}

	public List<Price> getPrices()
	{
		return prices;
	}

	public Sector getSector()
	{
		return sector;
	}

	public List<Product_Text> getTexts()
	{
		return texts;
	}

	public String getUuid()
	{
		return uuid;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = prime * result + ((this.number == null) ? 0 : this.number.hashCode());
		result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());
		result = prime * result +
			((this.activeAssortmentFrom == null) ? 0 : this.activeAssortmentFrom.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.altsector == null) ? 0 : this.altsector.hashCode());
		result = prime * result + ((this.assortment == null) ? 0 : this.assortment.hashCode());
		result = prime * result + ((this.codes == null) ? 0 : this.codes.hashCode());
		result = prime * result +
			((this.commodityGroup == null) ? 0 : this.commodityGroup.hashCode());
		// result = prime * result + ((this.prices == null) ? 0 : this.prices.hashCode());
		result = prime * result + ((this.sector == null) ? 0 : this.sector.hashCode());


		return result;
	}

	public boolean isActiveAssortment()
	{
		return activeAssortment;
	}

	public boolean isDeleted()
	{
		return deleted;
	}

	public boolean isDiscountable()
	{
		return discountable;
	}

	public boolean isPriceChangeable()
	{
		return priceChangeable;
	}

	public boolean isRequiresSerialNumber()
	{
		return requiresSerialNumber;
	}

	public boolean isTrackInventory()
	{
		return trackInventory;
	}

	public boolean post() throws IOException, ApiNotReachableException
	{
		if (!prices.isEmpty())
		{
			for (final Price p : prices)
			{
				if (p.getPriceList().getUuid() == null)
					p.getPriceList().post();
			}
		}
		if (commodityGroup != null && commodityGroup.getUuid() == null)
			commodityGroup.post();
		if (sector != null && sector.getUuid() == null)
			sector.post();
		if (altsector != null && altsector.getUuid() == null)
			altsector.post();
		if (assortment != null && assortment.getUuid() == null)
			assortment.post();

		return CloudLink.getConnector().postData(DataType.product, this.toJSON());
	}

	public void setActiveAssortment(final boolean activeAssortment)
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

	public void setDeleted(final boolean deleted)
	{
		this.deleted = deleted;
	}

	public void setDiscountable(final boolean discountable)
	{
		this.discountable = discountable;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public void setNumber(final String number)
	{
		this.number = number;
	}

	public void setPriceChangeable(final boolean priceChangeable)
	{
		this.priceChangeable = priceChangeable;
	}

	public void setPrices(final List<Price> prices)
	{
		this.prices = prices;
	}

	public void setRequiresSerialNumber(final boolean requiresSerialNumber)
	{
		this.requiresSerialNumber = requiresSerialNumber;
	}

	public void setSector(final Sector sector)
	{
		this.sector = sector;
	}

	public void setTexts(final List<Product_Text> texts)
	{
		this.texts = texts;
	}

	public void setTrackInventory(final boolean trackInventory)
	{
		this.trackInventory = trackInventory;
	}

	public void setUuid(final String uuid)
	{
		this.uuid = uuid;
	}

	public JSONObject toJSON()
	{
		final JSONObject obj = new JSONObject();
		try
		{

			obj.put("name", name);
			if (number != null)
				obj.put("number", number);
			if (uuid != null)
				obj.put("uuid", uuid);
			obj.put("deleted", deleted);
			obj.put("activeAssortment", activeAssortment);
			if (activeAssortmentFrom != null)
				obj.put("activeAssortmentFrom", inputDf.format(activeAssortmentFrom));
			obj.put("costs", costs);
			obj.put("discountable", discountable);
			obj.put("priceChangeable", priceChangeable);
			obj.put("requiresSerialNumber", requiresSerialNumber);
			obj.put("trackInventory", trackInventory);
			if (commodityGroup != null)
				obj.put("commodityGroup", commodityGroup.getUuid());
			if (assortment != null)
				obj.put("assortment", assortment.getUuid());
			if (sector != null)
				obj.put("sector", sector.getUuid());
			if (altsector != null)
				obj.put("alternativeSector", altsector.getUuid());
			if (!prices.isEmpty())
			{
				final JSONArray array = new JSONArray();
				for (final Price p : prices)
				{
					array.put(p.toJSON());
				}
				obj.put("prices", array);
			}
			if (!codes.isEmpty())
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
			return obj;
		}
		catch (final JSONException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	@Override
	public String toString()
	{
		final String productstr = name + number + commodityGroup.getName() + " " +
			commodityGroup.getUuid();
		return productstr;

	}
}
