package domain;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import link.CloudLink;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Sale {
	private String name;
	private boolean deleted;
	private Long revision;
	private String uuid;
	private Product article;
	private Cashier cashier;
	private CommodityGroup commodityGroup;
	private long bookingTime;
	private String description;
	private String infoTexts;
	private Sector sector;
	private String receiptNumber;
	private int receiptIndex;
	private double quantity;
	private POS pos;  
	private Receipt receipt;
	private double manualPrice;
	private double itemPrice;
	private double grossItemPrice;
	private double netItemPrice;
	private double baseItemPrice;
	private String serialNumber;
	private List<TaxPayments> taxPayments;
	
	
	
	private Sale(Builder builder) {
		name=builder.name;
		deleted = builder.deleted;
		revision = builder.revision;
		uuid = builder.uuid;
		article = builder.article;
		cashier = builder.cashier;
		commodityGroup = builder.commodityGroup;
		bookingTime = builder.bookingTime;
		description = builder.description;
		infoTexts = builder.infoTexts;
		sector = builder.sector;
		receiptNumber = builder.receiptNumber;
		receiptIndex = builder.receiptIndex;
		quantity = builder.quantity;
		receipt= builder.receipt;
		manualPrice=builder.manualPrice;
		itemPrice=builder.itemPrice;
		grossItemPrice=builder.grossItemPrice;
		netItemPrice=builder.netItemPrice;
		baseItemPrice=builder.baseItemPrice;
		serialNumber=builder.serialNumber;
		pos=builder.pos;
		taxPayments=builder.taxPayments;
	}
	
	public static class Builder {
		private String name=null;
		private boolean deleted = false;
		private Long revision=null;
		private String uuid=null;
		private Product article=null;
		private Cashier cashier=null;
		private CommodityGroup commodityGroup = null;
		private long bookingTime=0;
		private String description=null;
		private String infoTexts=null;
		private Sector sector = null;
		private String receiptNumber=null;
		private int receiptIndex=0;
		private double quantity=0;
		private Receipt receipt=null;
		private double manualPrice=0;
		private double itemPrice=0;
		private double grossItemPrice=0;
		private double netItemPrice=0;
		private double baseItemPrice=0;
		private String serialNumber=null;
		private POS pos;
		private List<TaxPayments> taxPayments=new ArrayList<TaxPayments>();
		
		

		public Builder(String name) {
			this.name = name;
		}
		
		public Builder pos(POS posy){
			pos=posy;
			return this;
		}
		
		public Builder taxPayments(TaxPayments taxPayment){
			taxPayments.add(taxPayment);
			return this;
		}
		
		public Builder taxPayments(Collection<TaxPayments> coll){
			for (TaxPayments taxPay : coll) {
				taxPayments.add(taxPay);
			}
			return this;
		}
		
		public Builder deleted(boolean value) {
			deleted = value;
			return this;
		}
		
		public Builder revision(Long value){
			revision=value;
			return this;
		}
		
		public Builder uuid(String value){
			uuid=value;
			return this;
		}
		
		public Builder article(Product prod){
			article=prod;
			return this;
		}
		
		public Builder cashier(Cashier cash){
			cashier=cash;
			return this;
		}
		
		public Builder commodityGroup(CommodityGroup grp){
			commodityGroup=grp;
			return this;
		}
		
		public Builder bookingTime(long time){
			bookingTime=time;
			return this;
		}
		
		public Builder description(String txt){
			description=txt;
			return this;
		}
		
		public Builder infoTexts(String txt){
			infoTexts=txt;
			return this;
		}
		
		public Builder sector(Sector sec){
			sector=sec;
			return this;
		}
		
		public Builder receiptNumber(String value){
			receiptNumber=value;
			return this;
		}
		
		public Builder receiptIndex(int value){
			receiptIndex=value;
			return this;
		}
		
		public Builder quantity(double value){
			quantity=value;
			return this;
		}
		
		public Builder receipt(Receipt rec){
			this.receipt=rec;
			return this;
		}
		
		public Builder manualPrice(double value){
			manualPrice=value;
			return this;
		}
		
		public Builder itemPrice(double value){
			itemPrice=value;
			return this;
		}
		
		public Builder grossItemPrice(double value){
			grossItemPrice=value;
			return this;
		}
		
		public Builder netItemPrice(double value){
			netItemPrice=value;
			return this;
		}
		
		public Builder baseItemPrice(double value){
			baseItemPrice=value;
			return this;
		}
		
		public Builder serialNumber(String value){
			serialNumber=value;
			return this;
		}
		
		public Sale build(){
			return new Sale(this);
		}
	}
	
	public JSONObject toJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("name", name);
			obj.put("deleted", deleted);
			obj.put("revision", revision);
			obj.put("uuid", uuid);
			obj.put("bookingTime", bookingTime);
			obj.put("description",description);
			obj.put("infoTexts",infoTexts);
			obj.put("sector", sector);
			obj.put("receiptNumber", receiptNumber);
			obj.put("receiptIndex", receiptIndex);
			obj.put("quantity", quantity);
			
			if (cashier != null)
				obj.put("cashier", cashier.getUuid());
			if (article != null)
				obj.put("article", article.getUuid());
			if (commodityGroup != null)
				obj.put("commodityGroup", commodityGroup.getUuid());
			if (sector != null)
				obj.put("sector", sector.getUuid());
			
			return obj;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Sale fromJSON(JSONObject obj) throws JSONException {
		if(obj.has("result") && obj.getString("result")!=null)
			obj=obj.getJSONObject("result");
		
		
		Product prod=new Product.Builder(null).build();
		prod.setUuid(obj.getString("article"));
		
		Cashier cash=new Cashier.Builder(null).build();
		cash.setUuid(obj.getString("cashier"));
		
		CommodityGroup grp=new CommodityGroup.Builder(null).build();
		grp.setUuid(obj.getString("commodityGroup"));
		
		Sector sec=new Sector.Builder(null).build();
		sec.setUuid(obj.getString("sector"));
		
		Receipt rec=new Receipt.Builder().build();
		rec.setUuid(obj.getString("receipt"));
		
		POS pos=new POS.Builder(null).build();
		pos.setUuid(obj.getString("pos"));
				
		Sale sale = new Sale.Builder(null).
					deleted(obj.getBoolean("deleted")).
					revision(obj.getLong("revision")).
					uuid(obj.getString("uuid")).
					article(prod).
					cashier(cash).
					commodityGroup(grp).
					bookingTime(obj.getLong("bookingTime")).
					description(obj.getString("description")).
					infoTexts(obj.getString("infoTexts")).
					sector(sec).
					receiptNumber(obj.getString("receiptNumber")).
					receiptIndex(obj.getInt("receiptIndex")).
					quantity(obj.getInt("quantity")).
					receipt(rec).grossItemPrice(obj.getDouble("grossItemPrice")).
					pos(pos)
				.build();
		
		JSONArray jTax=new JSONArray();
		jTax=obj.getJSONArray("taxPayments");
		if(!jTax.isNull(0)){
			for(int i=0;i<=jTax.length()-1;i++){
				JSONObject tax=new JSONObject();
				tax=jTax.getJSONObject(i);
				TaxPayments taxO=new TaxPayments(tax.getString("salesTax"),tax.getDouble("currentTaxRate"),tax.getDouble("amount"));
				List<TaxPayments> taxL=new ArrayList<TaxPayments>();
				taxL.add(taxO);
				sale.setTaxPayments(taxL);
			}
		}
		
		return sale;
	}
	
	public boolean post() throws IOException {
		
		if (commodityGroup != null && commodityGroup.getUuid() == null)
			commodityGroup.post();
		if (sector != null && sector.getUuid() == null)
			sector.post();
		if (cashier != null && cashier.getUuid() == null)
			cashier.post();
		if (article != null && article.getUuid() == null)
			article.post();
		return CloudLink.getConnector().postData(DataType.sale,
				this.toJSON());
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public boolean getDeleted(){
		return this.deleted;
	}
	public void setDeleted(boolean deleted){
		this.deleted=deleted;
	}
	
	public Long getRevision(){
		return this.revision;
	}
	public void setRevision(Long revision){
		this.revision=revision;
	}
	
	public String getUuid(){
		return this.uuid;
	}
	public void setUuid(String uuid){
		this.uuid=uuid;
	}
	
	public Product getArticle(){
		return this.article;
	}
	public void setArticle(Product article){
		this.article=article;
	}
	
	public Cashier getCashier(){
		return this.cashier;
	}
	public void setCashier(Cashier cashier){
		this.cashier=cashier;
	}
	
	public CommodityGroup getCommodityGroup(){
		return this.commodityGroup;
	}
	public void setCommodityGroup(CommodityGroup grp){
		this.commodityGroup=grp;
	}
	
	public long getBookingTime(){
		return this.bookingTime;
	}
	public void setBookingTime(long bookingTime){
		this.bookingTime=bookingTime;
	}
	
	public String getDescription(){
		return this.description;
	}
	public void setDescription(String txt){
		this.description=txt;
	}
	
	public String getInfoTexts(){
		return this.infoTexts;
	}
	public void setInfoTexts(String infoTexts){
		this.infoTexts=infoTexts;
	}
	
	public Sector getSector(){
		return this.sector;
	}
	public void setSector(Sector sec){
		this.sector=sec;
	}
	
	public String getReceiptNumber(){
		return this.receiptNumber;
	}
	public void setReceiptNumber(String number){
		this.receiptNumber=number;
	}
	
	public int getReceiptIndex(){
		return this.receiptIndex;
	}
	public void setReceiptIndex(int index){
		this.receiptIndex=index;
	}
	
	public double getQuantity(){
		return this.quantity;
	}
	public void setQuantity(int quant){
		this.quantity=quant;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public double getManualPrice() {
		return manualPrice;
	}

	public void setManualPrice(double manualPrice) {
		this.manualPrice = manualPrice;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public double getGrossItemPrice() {
		return grossItemPrice;
	}

	public void setGrossItemPrice(double grossItemPrice) {
		this.grossItemPrice = grossItemPrice;
	}

	public double getNetItemPrice() {
		return netItemPrice;
	}

	public void setNetItemPrice(double netItemPrice) {
		this.netItemPrice = netItemPrice;
	}

	public double getBaseItemPrice() {
		return baseItemPrice;
	}

	public void setBaseItemPrice(double baseItemPrice) {
		this.baseItemPrice = baseItemPrice;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public POS getPos() {
		return pos;
	}

	public void setPos(POS pos) {
		this.pos = pos;
	}

	public List<TaxPayments> getTaxPayments() {
		return taxPayments;
	}

	public void setTaxPayments(List<TaxPayments> taxPayments) {
		this.taxPayments = taxPayments;
	}
	
	
}
