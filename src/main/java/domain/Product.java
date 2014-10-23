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
	/**
	 * 
	 */
	private static final long serialVersionUID = -4259851643720605829L;
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

	protected static abstract class Init<T extends Init<T>> extends
		AbstractNameAndNumberApiObject.Init<T>
	{
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

		public T activeAssortment(final boolean value)
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

		public T discountable(final boolean value)
		{
			discountable = value;
			return self();
		}

		public T priceChangeable(final boolean value)
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

		public T requiresSerialNumber(final boolean value)
		{
			requiresSerialNumber = value;
			return self();
		}

		public T sector(final Sector sec)
		{
			sector = sec;
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

		public T trackInventory(final boolean value)
		{
			trackInventory = value;
			return self();
		}

		@Override
		public Product build()
		{
			return new Product(this);
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

// public static Product fromJSON(JSONObject obj) throws JSONException
// {

// }

	/**
	 * More optimized post method for uploading several products of the same group, sector, etc.
	 * !-STABLE-! ~MAS
	 * **/

// public static void postList(final List<Product> productList, final int limit)
// {
//
// final Date date1 = new Date();
// System.out.println("start: " + date1);
//
//
// JSONArray jProdArray = new JSONArray();
// // final JSONObject jProdObject = new JSONObject();
// final HashSet<CommodityGroup> grpList = new HashSet<CommodityGroup>();
// final HashSet<Assortment> assortmentList = new HashSet<Assortment>();
// final HashSet<Sector> sectorList = new HashSet<Sector>();
// final HashSet<Pricelist> priceListLists = new HashSet<Pricelist>();
//
// // filling up SubPojo lists for...
// for (int i = 0; i < productList.size(); i++)
// {
// final Product product = productList.get(i);
//
// // ...commodityGroup
// if (product.getCommodityGroup() != null)
// grpList.add(productList.get(i).getCommodityGroup());
//
//
// // ...assortment
// if (product.getAssortment() != null)
// assortmentList.add(productList.get(i).getAssortment());
//
//
// // ...Sector+AltSector
// if (product.getSector() != null)
// sectorList.add(productList.get(i).getSector());
//
//
// // ...pricelist
// for (int j = 0; j < product.getPrices().size(); j++)
// {
// if (product.getPrices().get(j).getPriceList() != null)
// priceListLists.add(productList.get(i).getPrices().get(j).getPriceList());
// }
//
// }
//
//
// try
// {
// // posting all new SubPojos
// final Iterator<CommodityGroup> grpListIter = grpList.iterator();
// while (grpListIter.hasNext())
// {
// final CommodityGroup grp = grpListIter.next();
// if (grp != null && grp.getUuid() == null)
// grp.post();
// }
// final Iterator<Assortment> assortmentListIter = assortmentList.iterator();
// while (assortmentListIter.hasNext())
// {
// final Assortment assort = assortmentListIter.next();
// if (assort != null && assort.getUuid() == null)
// assort.post();
// }
//
// final Iterator<Sector> sectorListIter = sectorList.iterator();
// while (sectorListIter.hasNext())
// {
// final Sector sec = sectorListIter.next();
// if (sec != null && sec.getUuid() == null)
// sec.post();
// }
//
// final Iterator<Pricelist> priceListListsIter = priceListLists.iterator();
// while (priceListListsIter.hasNext())
// {
// final Pricelist priceL = priceListListsIter.next();
// if (priceL != null && priceL.getUuid() == null)
// priceL.post();
// }
//
// }
// catch (final IOException e)
// {
// e.printStackTrace();
// }
// catch (final ApiNotReachableException e)
// {
// e.printStackTrace();
// }
// // Thread Executor init
// final ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime()
// .availableProcessors());
//
// int offset = 0;
// int i = 0;
// while (i < productList.size())
// {
// jProdArray = new JSONArray();
// offset = offset + limit;
// while (i < offset && i < productList.size())
// {
// final Product product = productList.get(i);
//
// // Commoditygroup UUID check
// if (product.getCommodityGroup().getUuid() == null)
// for (final CommodityGroup group : grpList)
// {
// if (group.getNumber().equalsIgnoreCase(
// product.getCommodityGroup().getNumber()))
// product.setCommodityGroup(group);
// }
//
// // Assortment UUID check
// if (product.getAssortment().getUuid() == null)
// for (final Assortment assortment : assortmentList)
// {
// if (assortment.getNumber().equalsIgnoreCase(
// product.getAssortment().getNumber()))
// product.setAssortment(assortment);
// }
//
// // Sector UUID check
// if (product.getSector().getUuid() == null)
// for (final Sector sector : sectorList)
// {
// if (sector.getNumber().equalsIgnoreCase(product.getSector().getNumber()))
// product.setSector(sector);
// }
//
// // pricelist
// for (final Price price : product.getPrices())
// {
// if (price.getPriceList().getUuid() == null)
// for (final Pricelist pricelist : priceListLists)
// {
// if (pricelist.getNumber().equalsIgnoreCase(
// price.getPriceList().getNumber()))
// price.setPriceList(pricelist);
// }
// }
//
// jProdArray.put(productList.get(i).toJSON());
// i++;
// }
//
// exec.execute(new PostListThread(jProdArray));
// // bool = CloudLink.getConnector().postData(DataType.product, jProdArray);
// }
// exec.shutdown();
// while (!exec.isTerminated())
// {
// }
//
// final Date date2 = new Date();
// System.out.println("end: " + date2);
// }


	private Product(final Init<?> init)
	{
		super(init);
		activeAssortment = init.activeAssortment;
		activeAssortmentFrom = init.activeAssortmentFrom;
		costs = init.costs;
		discountable = init.discountable;
		priceChangeable = init.priceChangeable;
		requiresSerialNumber = init.requiresSerialNumber;
		trackInventory = init.trackInventory;
		commodityGroup = init.commodityGroup;
		sector = init.sector;
		altsector = init.altsector;
		prices = init.prices;
		texts = init.texts;
		assortment = init.assortment;
		codes = init.codes;
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


		return result;
	}

	public boolean isActiveAssortment()
	{
		return activeAssortment;
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

// public boolean post() throws IOException, ApiNotReachableException
// {
// if (!prices.isEmpty())
// {
// for (final Price p : prices)
// {
// if (p.getPriceList().getUuid() == null)
// p.getPriceList().post();
// }
// }
// if (commodityGroup != null && commodityGroup.getUuid() == null)
// commodityGroup.post();
// if (sector != null && sector.getUuid() == null)
// sector.post();
// if (altsector != null && altsector.getUuid() == null)
// altsector.post();
// if (assortment != null && assortment.getUuid() == null)
// assortment.post();
//
// return CloudLink.getConnector().postData(DataType.product, this.toJSON());
// }

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

	public void setDiscountable(final boolean discountable)
	{
		this.discountable = discountable;
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


// public JSONObject toJSON()
// {
// final JSONObject obj = new JSONObject();
// try
// {
//
// obj.put("name", name);
// if (number != null)
// obj.put("number", number);
// if (uuid != null)
// obj.put("uuid", uuid);
// obj.put("deleted", deleted);
// obj.put("activeAssortment", activeAssortment);
// if (activeAssortmentFrom != null)
// obj.put("activeAssortmentFrom", inputDf.format(activeAssortmentFrom));
// obj.put("costs", costs);
// obj.put("discountable", discountable);
// obj.put("priceChangeable", priceChangeable);
// obj.put("requiresSerialNumber", requiresSerialNumber);
// obj.put("trackInventory", trackInventory);
// if (commodityGroup != null)
// obj.put("commodityGroup", commodityGroup.getUuid());
// if (assortment != null)
// obj.put("assortment", assortment.getUuid());
// if (sector != null)
// obj.put("sector", sector.getUuid());
// if (altsector != null)
// obj.put("alternativeSector", altsector.getUuid());
// if (!prices.isEmpty())
// {
// final JSONArray array = new JSONArray();
// for (final Price p : prices)
// {
// array.put(p.toJSON());
// }
// obj.put("prices", array);
// }
// if (!codes.isEmpty())
// {
// final JSONArray array = new JSONArray();
// for (final Product_Code code : codes)
// {
// if (!code.getCode().equalsIgnoreCase(""))
// array.put(code.toJSON());
// }
// obj.put("articleCodes", array);
// }
// if (!texts.isEmpty())
// {
// final JSONArray array = new JSONArray();
// for (final Product_Text text : texts)
// {
// array.put(text.toJSON());
// }
// obj.put("articleTexts", array);
// }
// return obj;
// }
// catch (final JSONException e)
// {
// e.printStackTrace();
// return null;
// }
// }

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	@Override
	public String toString()
	{
		final StringBuilder stringBuilder = new StringBuilder();
		super.toString(stringBuilder);
		return stringBuilder.toString();
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


	public static Product fromJSON(JSONObject obj) throws JSONException
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
				final Pricelist pricelist = new Pricelist.Builder().id(
					jPrice.getString("priceList")).build();
				Date date = new Date();
				try
				{
					date = inputDf.parse(jPrice.getString("validFrom"));
				}
				catch (final ParseException e)
				{
					e.printStackTrace();
				}
				if (!jPrice.isNull("organizationalUnit"))
				{
					final String orgUnitUuid = jPrice.getString("organizationalUnit");
					final OrganizationalUnit organizationalUnit = new OrganizationalUnit.Builder().id(
						jPrice.getString("organizationalUnit"))
						.build();

					prices.add(new Price(pricelist, date, value, organizationalUnit));
				}
				else
					prices.add(new Price(pricelist, date, value, null));
			}
			prod.setPrices(prices);
		}
		return prod;
	}
}
