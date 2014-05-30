package domain;

import java.io.IOException;
import java.math.BigDecimal;
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

public class Product
{
	private static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
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
		codes = builder.codes;
		uuid = builder.uuid;
	}

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
		private List<Price> prices = new ArrayList<Price>();
		private Assortment assortment = null;
		private List<Product_Text> texts = new ArrayList<Product_Text>();
		private List<Product_Code> codes = new ArrayList<Product_Code>();

		public Builder(String name)
		{
			this.name = name;
		}

		public Builder uuid(String value)
		{
			uuid = value;
			return this;
		}

		public Builder number(String value)
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

		public Builder codes(Product_Code code)
		{
			codes.add(code);
			return this;
		}

		public Builder codes(Collection<Product_Code> coll)
		{
			for (Product_Code code : coll)
			{
				codes.add(code);
			}
			return this;
		}

		public Product build()
		{
			return new Product(this);
		}
	}

	public static Product fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		Product prod = new Product.Builder(obj.getString("name")).uuid(obj.getString("uuid")).build();
		if (obj.has("number"))
			prod.setNumber(obj.getString("number"));
		if(obj.getString("articleCodes")!="null"){
			JSONArray jACode=new JSONArray();
			jACode=obj.getJSONArray("articleCodes");
			JSONObject jCode=new JSONObject();
			List <Product_Code> codeList=new ArrayList<Product_Code>();
			Product_Code productCode=null;
			for(int i=0;i<=jACode.length()-1;i++){
				jCode= (JSONObject) jACode.get(i);
				BigDecimal quantity = new BigDecimal(jCode.getDouble("quantity"));
				productCode=new Product_Code(jCode.getString("code"), quantity);
				codeList.add(productCode);
			}
			prod.setCodes(codeList);
			
			
		}
		return prod;
	}

	public JSONObject toJSON()
	{
		JSONObject obj = new JSONObject();
		try
		{
			obj.put("name", name);
			if (number!=null)
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
				JSONArray array = new JSONArray();
				for (Price p : prices)
				{
					array.put(p.toJSON());
				}
				obj.put("prices", array);
			}
			if (!codes.isEmpty())
			{
				JSONArray array = new JSONArray();
				for (Product_Code code : codes)
				{
					array.put(code.toJSON());
				}
				obj.put("articleCodes", array);
			}
			if (!texts.isEmpty())
			{
				JSONArray array = new JSONArray();
				for (Product_Text text : texts)
				{
					array.put(text.toJSON());
				}
				obj.put("articleTexts", array);
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
				
		return CloudLink.getConnector().postData(DataType.product,
				this.toJSON());
	}
	
	/** 
	 * More optimized post method for uploading several products of the same group, sector, etc. 
	 * ~MAS
	 * **/
	
	public static boolean post(List<Product> productList){
		
		Date date1=new Date();
		
		
		JSONArray jProdArray=new JSONArray();
		JSONObject jProdObject=new JSONObject();
		HashSet<CommodityGroup> grpList=new HashSet<CommodityGroup>();
		HashSet<Assortment> assortmentList=new HashSet<Assortment>();
		HashSet<Sector> sectorList=new HashSet<Sector>();
		HashSet<Pricelist> priceListLists=new HashSet<Pricelist>();
		
		//filling up SubPojo lists for...
		for(int i=0;i<=productList.size()-1;i++){
			//...commodityGroup
			if(grpList.isEmpty())
				grpList.add(productList.get(i).getCommodityGroup());
			else{
			boolean dublicate=false;
				Iterator<CommodityGroup> it=grpList.iterator();
				while(it.hasNext()){
					if(it.next().hashCode()==productList.get(i).getCommodityGroup().hashCode())
						dublicate=true;
					
				}
				if(dublicate==false)
					grpList.add(productList.get(i).getCommodityGroup());
			}
			
			//...assortment
			if(assortmentList.isEmpty())
				assortmentList.add(productList.get(i).getAssortment());
			else{
			boolean dublicate=false;
				Iterator<Assortment> it=assortmentList.iterator();
				while(it.hasNext()){
					if(it.next().hashCode()==productList.get(i).getAssortment().hashCode())
						dublicate=true;
					
				}
				if(dublicate==false)
					assortmentList.add(productList.get(i).getAssortment());
			}
			
			//...Sector+AltSector
			if(sectorList.isEmpty())
				sectorList.add(productList.get(i).getSector());
			else{
			boolean dublicate=false;
				Iterator<Sector> it=sectorList.iterator();
				while(it.hasNext()){
					if(it.next().hashCode()==productList.get(i).getSector().hashCode())
						dublicate=true;
					
				}
				if(dublicate==false)
					sectorList.add(productList.get(i).getSector());
			}
			
						
			//...pricelist
			for(int j=0;j<=productList.get(i).getPrices().size()-1;j++){
				if(priceListLists.isEmpty())
					priceListLists.add(productList.get(i).getPrices().get(j).getPriceList());
				else{
				boolean dublicate=false;
					Iterator<Pricelist> it=priceListLists.iterator();
					while(it.hasNext()){
						if(it.next().hashCode()==productList.get(i).getPrices().get(j).getPriceList().hashCode())
							dublicate=true;
						
					}
					if(dublicate==false)
						priceListLists.add(productList.get(i).getPrices().get(j).getPriceList());
				}
				
			}
		}
		
	    
		
		try {
			//posting all new SubPojos
			Iterator<CommodityGroup> grpListIter=grpList.iterator();
			while(grpListIter.hasNext()){
				CommodityGroup grp=grpListIter.next();
				if ( grp != null && grp.getUuid() == null)
					grp.post();	
			}
			Iterator<Assortment> assortmentListIter=assortmentList.iterator();
			while(assortmentListIter.hasNext()){
				Assortment assort=assortmentListIter.next();
				if ( assort != null && assort.getUuid() == null)
					assort.post();
			}
			Iterator<Sector> sectorListIter=sectorList.iterator();
			while(sectorListIter.hasNext()){
				Sector sec=sectorListIter.next();
				if ( sec != null && sec.getUuid() == null)
					sec.post();
			}
			Iterator<Pricelist> priceListListsIter=priceListLists.iterator();
			while(priceListListsIter.hasNext()){
				Pricelist priceL=priceListListsIter.next();
				if ( priceL != null && priceL.getUuid() == null)
					priceL.post();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		boolean bool=false;
		
		for(int i=0;i<=productList.size()-1;i++){
			//Getting Pojo data for every next product having the same grp/sector/etc like the first.
			for(CommodityGroup grp:grpList){
				if(grp.getNumber()==productList.get(i).getCommodityGroup().getNumber())
					productList.get(i).setCommodityGroup(grp);
			}
			for(Assortment assort:assortmentList){
				if(assort.getNumber()==productList.get(i).getAssortment().getNumber())
					productList.get(i).setAssortment(assort);
			}
			for(Sector sector:sectorList){
				if(sector.getNumber()==productList.get(i).getSector().getNumber())
					productList.get(i).setSector(sector);
			}
			for(Pricelist pricelist:priceListLists){
				for(Price price:productList.get(i).getPrices()){
					if(pricelist.getNumber()==price.getPriceList().getNumber())
						price.setPriceList(pricelist);
				}
			}
			//fill up JSONArray
			jProdObject=productList.get(i).toJSON();
			jProdArray.put(jProdObject);
			System.out.print("*");
			
		}//end for
		//post all products
		bool=CloudLink.getConnector().postData(DataType.product,jProdArray);
		Date date2=new Date();
		System.out.println("start: "+date1);
		System.out.println("end: "+date2);
		return bool;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getNumber()
	{
		return number;
	}

	public void setNumber(String number)
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

	public List<Product_Code> getCodes()
	{
		return codes;
	}

	public void setCodes(List<Product_Code> codes)
	{
		this.codes = codes;
	}

	public String getUuid()
	{
		return uuid;
	}

	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}

	@Override
	public String toString()
	{	
		String productstr=name+number+commodityGroup.getName()+" "+commodityGroup.getUuid();
		return productstr;
		
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((this.number == null) ? 0 : this.number.hashCode());
		result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());
		result = prime * result + ((this.activeAssortmentFrom == null) ? 0 : this.activeAssortmentFrom.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.altsector == null) ? 0 : this.altsector.hashCode());
		result = prime * result + ((this.assortment == null) ? 0 : this.assortment.hashCode());
		result = prime * result + ((this.codes == null) ? 0 : this.codes.hashCode());
		result = prime * result + ((this.commodityGroup == null) ? 0 : this.commodityGroup.hashCode());
		//result = prime * result + ((this.prices == null) ? 0 : this.prices.hashCode());
		result = prime * result + ((this.sector == null) ? 0 : this.sector.hashCode());
		
		
		

		return result;
	}
}
