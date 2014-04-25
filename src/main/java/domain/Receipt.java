package domain;

import java.io.IOException;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Receipt {
	private boolean deleted;
	private int revision;
	private String uuid;
	private int number;
	private Cashier cashier;
	private long creatTime;
	private String currency;
	private CustomerGroup customerGroup;
	private long finishTime;
	private long modifiedTime;
	private int orderNumber;
	//private Pos pos;
	private Pricelist priceGroup;
	private double grossTotalAmount;
	private double netTotalAmount;
	private double taxAmount;
	private double grossRevenueAmount;
	private double netRevenueAmount;
	private double receiptDiscountAmount;
	private double receiptDiscountGrossAmount;
	private double receiptDiscountNetAmount;
	private double zCount;
	private double voided;
	//private Customer customer;
	
	private Receipt(Builder builder){
		deleted=builder.deleted;
		revision=builder.revision;
		number=builder.number;
		cashier=builder.cashier;
		creatTime=builder.creatTime;
		currency=builder.currency;
		customerGroup=builder.customerGroup;
		finishTime=builder.finishTime;
		modifiedTime=builder.modifiedTime;
		orderNumber=builder.orderNumber;
		//pos=builder.pos;
		priceGroup=builder.priceGroup;
		grossTotalAmount=builder.grossTotalAmount;
		netTotalAmount=builder.netTotalAmount;
		taxAmount=builder.taxAmount;
		grossRevenueAmount=builder.grossRevenueAmount;
		netRevenueAmount=builder.netRevenueAmount;
		receiptDiscountAmount=builder.receiptDiscountAmount;
		receiptDiscountGrossAmount=builder.receiptDiscountGrossAmount;
		receiptDiscountNetAmount=builder.receiptDiscountNetAmount;
		zCount=builder.zCount;
		voided=builder.voided;
		//customer=builder.customer;
	}
	
	public static class Builder{
		private boolean deleted=false;
		private int revision=0;
		private int number=0;
		private Cashier cashier=null;
		private long creatTime=0;
		private String currency=null;
		private CustomerGroup customerGroup=null;
		private long finishTime=0;
		private long modifiedTime=0;
		private int orderNumber=0;
		//private Pos pos;
		private Pricelist priceGroup=null;
		private double grossTotalAmount=0;
		private double netTotalAmount=0;
		private double taxAmount=0;
		private double grossRevenueAmount=0;
		private double netRevenueAmount=0;
		private double receiptDiscountAmount=0;
		private double receiptDiscountGrossAmount=0;
		private double receiptDiscountNetAmount=0;
		private double zCount=0;
		private double voided=0;
		//private Customer customer;
		
		public Builder(){
			
		}
		public Builder deleted(boolean value){
			this.deleted=value;
			return this;
		}
		public Builder revision(int value){
			this.revision=value;
			return this;
		}
		public Builder number(int value){
			this.number=value;
			return this;
		}
		public Builder cashier(Cashier cash){
			this.cashier=cash;
			return this;
		}
		public Builder creatTime(long value){
			this.creatTime=value;
			return this;
		}
		public Builder currency(String value){
			this.currency=value;
			return this;
		}
		public Builder finishTime(long value){
			this.finishTime=value;
			return this;
		}
		public Builder modifiedTime(long value){
			this.modifiedTime=value;
			return this;
		}
		public Builder orderNumber(int value){
			this.orderNumber=value;
			return this;
		}
		public Builder grossTotalAmount(double value){
			this.grossTotalAmount=value;
			return this;
		}
		public Builder netTotalAmount(double value){
			this.netTotalAmount=value;
			return this;
		}
		public Builder taxAmount(double value){
			this.taxAmount=value;
			return this;
		}
		public Builder grossRevnueAmount(double value){
			this.grossRevenueAmount=value;
			return this;
		}
		public Builder netRevenueAmount(double value){
			this.netRevenueAmount=value;
			return this;
		}
		public Builder receiptDiscountAmount(double value){
			this.receiptDiscountAmount=value;
			return this;
		}
		public Builder receiptDiscountGrossAmount(double value){
			this.receiptDiscountGrossAmount=value;
			return this;
		}
		public Builder receiptDiscountNetAmount(double value){
			this.receiptDiscountNetAmount=value;
			return this;
		}
		public Builder zCount(double value){
			this.zCount=value;
			return this;
		}
		public Builder voided(double value){
			this.voided=value;
			return this;
		}
		public Builder customerGroup(CustomerGroup cGrp){
			this.customerGroup=cGrp;
			return this;
		}
		public Receipt build(){
			return new Receipt(this);
		}
	}
	
	public JSONObject toJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("deleted", deleted);
			obj.put("revision", revision);
			obj.put("uuid", uuid);
						
			return obj;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static Receipt fromJSON(JSONObject obj) throws JSONException {
		if(obj.has("result") && obj.getString("result")!=null)
			obj=obj.getJSONObject("result"); 
		Cashier cash=new Cashier.Builder(null).build();
		cash.setUuid(obj.getString("cashier"));
		CustomerGroup cGrp=new CustomerGroup.Builder(null).build();
		cGrp.setUuid(obj.getString("customerGroup"));
		Receipt rec = new Receipt.Builder().
					number(obj.getInt("number")).
					revision(obj.getInt("revision")).
					cashier(cash).customerGroup(cGrp).
					receiptDiscountGrossAmount(obj.getDouble("receiptDiscountGrossAmount"))
				.build();
		return rec;
	}
	
	public boolean post() throws IOException {
		
		if (cashier != null && cashier.getUuid() == null)
			cashier.post();
		
		return CloudLink.getConnector().postData(DataType.receipt,
				this.toJSON());
	}
	
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public int getRevision() {
		return revision;
	}
	public void setRevision(int revision) {
		this.revision = revision;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Cashier getCashier() {
		return cashier;
	}
	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}
	public long getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(long creatTime) {
		this.creatTime = creatTime;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public long getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(long finishTime) {
		this.finishTime = finishTime;
	}
	public long getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(long modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public double getGrossTotalAmount() {
		return grossTotalAmount;
	}
	public void setGrossTotalAmount(double grossTotalAmount) {
		this.grossTotalAmount = grossTotalAmount;
	}
	public double getNetTotalAmount() {
		return netTotalAmount;
	}
	public void setNetTotalAmount(double netTotalAmount) {
		this.netTotalAmount = netTotalAmount;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public double getGrossRevenueAmount() {
		return grossRevenueAmount;
	}
	public void setGrossRevenueAmount(double grossRevenueAmount) {
		this.grossRevenueAmount = grossRevenueAmount;
	}
	public double getNetRevenueAmount() {
		return netRevenueAmount;
	}
	public void setNetRevenueAmount(double netRevenueAmount) {
		this.netRevenueAmount = netRevenueAmount;
	}
	public double getReceiptDiscountAmount() {
		return receiptDiscountAmount;
	}
	public void setReceiptDiscountAmount(double receiptDiscountAmount) {
		this.receiptDiscountAmount = receiptDiscountAmount;
	}
	public double getReceiptDiscountGrossAmount() {
		return receiptDiscountGrossAmount;
	}
	public void setReceiptDiscountGrossAmount(double receiptDiscountGrossAmount) {
		this.receiptDiscountGrossAmount = receiptDiscountGrossAmount;
	}
	public double getReceiptDiscountNetAmount() {
		return receiptDiscountNetAmount;
	}
	public void setReceiptDiscountNetAmount(double receiptDiscountNetAmount) {
		this.receiptDiscountNetAmount = receiptDiscountNetAmount;
	}
	public double getzCount() {
		return zCount;
	}
	public void setzCount(double zCount) {
		this.zCount = zCount;
	}
	public double getVoided() {
		return voided;
	}
	public void setVoided(double voided) {
		this.voided = voided;
	}
	public CustomerGroup getCustomerGroup() {
		return customerGroup;
	}
	public void setCustomerGroup(CustomerGroup customerGroup) {
		this.customerGroup = customerGroup;
	}
	public Pricelist getPriceGroup() {
		return priceGroup;
	}
	public void setPriceGroup(Pricelist priceGroup) {
		this.priceGroup = priceGroup;
	}
	
	
	
}
