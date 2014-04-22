package domain;

import java.io.IOException;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Payment {
	private boolean deleted;
	private String revision;
	private String uuid;
	private Cashier cashier;
	private int itemNumber;
	private String itemSequence;
	private double manualPrice;
	private Receipt receipt;
	private double itemPrice;
	private double netItemPrice;
	private double baseItemPrice;
	private String receiptNumber;
	private String serialNumber;
	private double amount;
	private long transactionTime;
	private POS pos;
	private PaymentMethods paymentMethod;
	private Currency currency;
	
	private Payment(Builder builder) {
		deleted = builder.deleted;
		revision = builder.revision;
		uuid = builder.uuid;
		cashier = builder.cashier;
		receipt=builder.receipt;
		receiptNumber = builder.receiptNumber;
		manualPrice=builder.manualPrice;
		itemPrice=builder.itemPrice;
		itemNumber=builder.itemNumber;
		netItemPrice=builder.netItemPrice;
		baseItemPrice=builder.baseItemPrice;
		serialNumber=builder.serialNumber;
		itemSequence=builder.itemSequence;
		pos=builder.pos;
		currency=builder.currency;
		paymentMethod=builder.paymentMethod;
	}
	
	public static class Builder {
		private boolean deleted = false;
		private String revision=null;
		private String uuid=null;
		private String itemSequence=null;
		private Cashier cashier=null;
		private String receiptNumber=null;
		private double manualPrice=0;
		private Receipt receipt=null;
		private double itemPrice=0;
		private int itemNumber=0;
		private double netItemPrice=0;
		private double baseItemPrice=0;
		private String serialNumber=null;
		private POS pos=null;
		private Currency currency=null;
		private PaymentMethods paymentMethod=null;
		
		public Builder pos(POS posy){
			pos=posy;
			return this;
		}
		
		public Builder itemNumber(int value){
			itemNumber=value;
			return this;
		}

		public Builder deleted(boolean value) {
			deleted = value;
			return this;
		}
		
		public Builder revision(String value){
			revision=value;
			return this;
		}
		
		public Builder uuid(String value){
			uuid=value;
			return this;
		}
		
		public Builder cashier(Cashier cash){
			cashier=cash;
			return this;
		}
		
		public Builder paymentMethod(PaymentMethods payMeth){
			paymentMethod=payMeth;
			return this;
		}
		
		public Builder receipt(Receipt rec){
			receipt=rec;
			return this;
		}
		
		public Builder receiptNumber(String value){
			receiptNumber=value;
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
		
		public Builder currency(Currency cur){
			currency=cur;
			return this;
		}
		
		public Payment build(){
			return new Payment(this);
		}
	}
	
	public JSONObject toJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("deleted", deleted);
			obj.put("revision", revision);
			obj.put("uuid", uuid);
			obj.put("receiptNumber", receiptNumber);
			obj.put("currency", currency.getUuid());
			
			if (cashier != null)
				obj.put("cashier", cashier.getUuid());
			if (pos != null)
				obj.put("pos", pos.getUuid());
			
			
			return obj;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Payment fromJSON(JSONObject obj) throws JSONException {
		if(obj.has("result") && obj.getString("result")!=null)
			obj=obj.getJSONObject("result"); 
		Cashier cash=new Cashier.Builder(null).build();
		cash.setUuid(obj.getString("cashier"));
		Receipt rec=new Receipt.Builder().build();
		rec.setUuid(obj.getString("receipt"));
		POS pos=new POS.Builder(null).build();
		pos.setUuid(obj.getString("pos"));
		Currency cur=new Currency.Builder(null).build();
		cur.setUuid(obj.getString("currency"));
		PaymentMethods payMeth=new PaymentMethods.Builder(null).build();
		payMeth.setUuid(obj.getString("paymentMethod"));
		Payment pay = new Payment.Builder().
					deleted(obj.getBoolean("deleted")).
					revision(obj.getString("revision")).
					uuid(obj.getString("uuid")).
					cashier(cash).
					receipt(rec).
					pos(pos).
					currency(cur).
					paymentMethod(payMeth)
				.build();
		return pay;
	}
	
	public boolean post() throws IOException {
		
		if (cashier != null && cashier.getUuid() == null)
			cashier.post();
		return CloudLink.getConnector().postData(DataType.sale,
				this.toJSON());
	}
	
	
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public String getRevision() {
		return revision;
	}
	public void setRevision(String revision) {
		this.revision = revision;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Cashier getCashier() {
		return cashier;
	}
	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}
	public int getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getItemSequence() {
		return itemSequence;
	}
	public void setItemSequence(String itemSequence) {
		this.itemSequence = itemSequence;
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
	public String getReceiptNumber() {
		return receiptNumber;
	}
	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public POS getPos() {
		return pos;
	}

	public void setPos(POS pos) {
		this.pos = pos;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(long transactionTime) {
		this.transactionTime = transactionTime;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public PaymentMethods getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethods paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	
}