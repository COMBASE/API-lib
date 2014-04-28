package domain;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class AccountTransaction {
	private static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
	private boolean deleted;
	private String revision;
	private String uuid;
	private Account account; 
	private Receipt receipt;
	private Cashier cashier;
	private POS pos;
	private double amount;
	private Date bookingTime;
	private int receiptIndex;
	private String description;
	
	
	private AccountTransaction(Builder builder){
		revision=builder.revision;
		deleted=builder.deleted;
		account=builder.account;
		receipt=builder.receipt;
		cashier=builder.cashier;
		pos=builder.pos;
		amount=builder.amount;
		bookingTime=builder.bookingTime;
		receiptIndex=builder.receiptIndex;
		description=builder.description;
	}
 
 public static class Builder {
	 private boolean deleted=false;
	 private String uuid=null;
	 private String revision=null;
	 private Account account;
	 private Receipt receipt=null;
	 private Cashier cashier=null;
	 private POS pos=null;
	 private double amount=0;
	 private Date bookingTime=null;
	 private int receiptIndex=0;
	 private String description=null;
	 
	 public Builder revision(String value){
		 revision=value;
		 return this;
	 }
	 public Builder deleted(boolean value){
		 deleted=value;
		 return this;
	 }
	 public Builder account(Account acc){
		  account=acc;
		  return this;
	 }
	 public Builder receipt(Receipt rec){
		  receipt=rec;
		  return this;
	 }
	 public Builder cashier(Cashier cash){
		  cashier=cash;
		  return this;
	 }
	 public Builder pos(POS posy){
		  pos=posy;
		  return this;
	 }
	 public Builder amount(double value){
		  amount=value;
		  return this;
	 }
	 public Builder bookingTime(Date value){
		  bookingTime=value;
		  return this;
	 }
	 public Builder receiptIndex(int value){
		  receiptIndex=value;
		  return this;
	 }
	 public Builder description(String value){
		  description=value;
		  return this;
	 }
	 public AccountTransaction build(){
		 return new AccountTransaction(this);
	 }
 }

 public JSONObject toJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("deleted", deleted);
			obj.put("revision", revision);
			obj.put("uuid", uuid);
			obj.put("account", account.getUuid());
			obj.put("receipt", receipt.getUuid());
			obj.put("cashier", cashier.getUuid());
			obj.put("pos", pos.getUuid());
			obj.put("amount", amount);
			obj.put("bookingTime", bookingTime);
			obj.put("receiptIndex", receiptIndex);
			obj.put("description", description);
			return obj;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static AccountTransaction fromJSON(JSONObject obj) throws JSONException {
		if(obj.has("result") && obj.getString("result")!=null)
			obj=obj.getJSONObject("result");
		
		//date
		String date=obj.getString("bookingTime");
		Date bTime=null;
		try {
			bTime = inputDf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Account acc=new Account.Builder().build();
		acc.setUuid(obj.getString("account"));
		Receipt rec = new Receipt.Builder().build();
		rec.setUuid(obj.getString("receipt"));
		Cashier cash =new Cashier.Builder(null).build();
		cash.setUuid(obj.getString("cashier"));
		POS pos=new POS.Builder(null).build();
		pos.setUuid(obj.getString("pos"));
		AccountTransaction accT = new AccountTransaction.Builder().
					deleted(obj.getBoolean("deleted")).
					revision(obj.getString("revision")).
					receipt(rec).
					cashier(cash).
					pos(pos).
					account(acc).
					amount(obj.getDouble("amount")).
					bookingTime(bTime).
					receiptIndex(obj.getInt("receiptIndex")).
					description(obj.getString("description"))
				.build();
		return accT;
	}
	
	public boolean post() throws IOException {
		/*if (account != null && account.getUuid() == null)
			account.post();*/
		if (receipt != null && receipt.getUuid() == null)
			receipt.post();
		if (cashier != null && cashier.getUuid() == null)
			cashier.post();
		if (pos != null && pos.getUuid() == null)
			pos.post();
		return CloudLink.getConnector().postData(DataType.accountTransaction,
				this.toJSON());
		
	}
 
public String getUuid() {
	return uuid;
}

public void setUuid(String uuid) {
	this.uuid = uuid;
}

public String getRevision() {
	return revision;
}

public void setRevision(String revision) {
	this.revision = revision;
}

public boolean isDeleted() {
	return deleted;
}

public void setDeleted(boolean deleted) {
	this.deleted = deleted;
}

public Receipt getReceipt() {
	return receipt;
}

public void setReceipt(Receipt receipt) {
	this.receipt = receipt;
}

public Cashier getCashier() {
	return cashier;
}

public void setCashier(Cashier cashier) {
	this.cashier = cashier;
}

public POS getPos() {
	return pos;
}

public void setPos(POS pos) {
	this.pos = pos;
}

public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}

public Date getBookingTime() {
	return bookingTime;
}

public void setBookingTime(Date bookingTime) {
	this.bookingTime = bookingTime;
}

public int getReceiptIndex() {
	return receiptIndex;
}

public void setReceiptIndex(int receiptIndex) {
	this.receiptIndex = receiptIndex;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Account getAccount() {
	return account;
}

public void setAccount(Account account) {
	this.account = account;
}
 
}
