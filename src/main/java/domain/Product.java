package domain;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import link.CloudLink;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Product
{
	private static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
	private String name;
	private int number;
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

	private Product(Builder builder)
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
	}

	public static class Builder
	{
		private final String name;
		private int number = 0;

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
		private List<Price> prices = new ArrayList<Price>();
		private Assortment assortment = null;
		private List<Product_Text> texts = new ArrayList<Product_Text>();

		public Builder(String name)
		{
			this.name = name;
		}

		public Builder number(int value)
		{
			number = value;
			return this;
		}

		public Builder deleted(boolean value)
		{
			deleted = value;
			return this;
		}

		public Builder activeAssortment(boolean value)
		{
			activeAssortment = value;
			return this;
		}

		public Builder activeAssortmentFrom(Date value)
		{
			activeAssortmentFrom = value;
			return this;
		}

		public Builder costs(int i)
		{
			costs = i;
			return this;
		}

		public Builder discountable(boolean value)
		{
			discountable = value;
			return this;
		}

		public Builder priceChangeable(boolean value)
		{
			priceChangeable = value;
			return this;
		}

		public Builder requiresSerialNumber(boolean value)
		{
			requiresSerialNumber = value;
			return this;
		}

		public Builder trackInventory(boolean value)
		{
			trackInventory = value;
			return this;
		}

		public Builder commodityGroup(CommodityGroup grp)
		{
			commodityGroup = grp;
			return this;
		}

		public Builder sector(Sector sec)
		{
			sector = sec;
			return this;
		}

		public Builder altsector(Sector sec)
		{
			altsector = sec;
			return this;
		}

		public Builder prices(Price p)
		{
			prices.add(p);
			return this;
		}

		public Builder prices(Collection<Price> coll)
		{
			for (Price price : coll)
			{
				prices.add(price);
			}
			return this;
		}

		public Builder texts(Product_Text text)
		{
			texts.add(text);
			return this;
		}

		public Builder texts(Collection<Product_Text> coll)
		{
			for (Product_Text text : coll)
			{
				texts.add(text);
			}
			return this;
		}

		public Builder assortment(Assortment value)
		{
			assortment = value;
			return this;
		}

		public Product build()
		{
			return new Product(this);
		}
	}

	public JSONObject toJSON()
	{
		JSONObject obj = new JSONObject();
		try
		{
			obj.put("name", name);
			if (number != 0)
				obj.put("number", number);
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
				if (prices.toArray().length > 1)
				{
					JSONArray array = new JSONArray();
					for (Price p : prices)
					{
						array.put(p.toJSON());
					}
					obj.put("prices", array);
				}
				else
				{
					obj.put("prices", prices.get(0).toJSON());
				}
			}
			if (!texts.isEmpty())
			{
				if (texts.toArray().length > 1)
				{
					JSONArray array = new JSONArray();
					for (Product_Text text : texts)
					{
						array.put(text.toJSON());
					}
					obj.put("articleTexts", array);
				}
				else
				{
					obj.put("articleTexts", texts.get(0).toJSON());
				}
			}
			return obj;
		}
		catch (JSONException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public boolean post() throws IOException
	{
		if (!prices.isEmpty())
		{
			for (Price p : prices)
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public boolean isDeleted()
	{
		return deleted;
	}

	public void setDeleted(boolean deleted)
	{
		this.deleted = deleted;
	}

	public boolean isActiveAssortment()
	{
		return activeAssortment;
	}

	public void setActiveAssortment(boolean activeAssortment)
	{
		this.activeAssortment = activeAssortment;
	}

	public Date getActiveAssortmentFrom()
	{
		return activeAssortmentFrom;
	}

	public void setActiveAssortmentFrom(Date activeAssortmentFrom)
	{
		this.activeAssortmentFrom = activeAssortmentFrom;
	}

	public int getCosts()
	{
		return costs;
	}

	public void setCosts(int costs)
	{
		this.costs = costs;
	}

	public boolean isDiscountable()
	{
		return discountable;
	}

	public void setDiscountable(boolean discountable)
	{
		this.discountable = discountable;
	}

	public boolean isPriceChangeable()
	{
		return priceChangeable;
	}

	public void setPriceChangeable(boolean priceChangeable)
	{
		this.priceChangeable = priceChangeable;
	}

	public boolean isRequiresSerialNumber()
	{
		return requiresSerialNumber;
	}

	public void setRequiresSerialNumber(boolean requiresSerialNumber)
	{
		this.requiresSerialNumber = requiresSerialNumber;
	}

	public boolean isTrackInventory()
	{
		return trackInventory;
	}

	public void setTrackInventory(boolean trackInventory)
	{
		this.trackInventory = trackInventory;
	}

	public CommodityGroup getCommodityGroup()
	{
		return commodityGroup;
	}

	public void setCommodityGroup(CommodityGroup commodityGroup)
	{
		this.commodityGroup = commodityGroup;
	}

	public Sector getSector()
	{
		return sector;
	}

	public void setSector(Sector sector)
	{
		this.sector = sector;
	}

	public Sector getAltsector()
	{
		return altsector;
	}

	public void setAltsector(Sector altsector)
	{
		this.altsector = altsector;
	}

	public List<Price> getPrices()
	{
		return prices;
	}

	public void setPrices(List<Price> prices)
	{
		this.prices = prices;
	}

	public List<Product_Text> getTexts()
	{
		return texts;
	}

	public void setTexts(List<Product_Text> texts)
	{
		this.texts = texts;
	}

	public Assortment getAssortment()
	{
		return assortment;
	}

	public void setAssortment(Assortment assortment)
	{
		this.assortment = assortment;
	}

	@Override
	public String toString()
	{
		return name;
	}
}
