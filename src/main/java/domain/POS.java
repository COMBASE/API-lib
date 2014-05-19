package domain;

import java.io.IOException;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class POS {
	private boolean deleted;
	private String revision;
	private String uuid;
	private String number;
	private int autoLogoutDelay;
	private boolean autoReceiptPrint;
	private String customerDisplayOfflineText;
	private String customerDisplayOnlineText;
	private String distributerCode;
	private CustomerGroup defaultCustomerGroup;
	private Payment defaultPaymentMethod;
	private EconomicZone economicZone;
	private boolean forceClosedDrawer;
	private CustomerGroup friendsBonusCustomerGroup;
	private String friendsbonusIdentification;
	private String friendsbonusSecret;
	private int maxBalanceAttempts;
	private String name;
	private boolean orderNumberRequired;
	private OrganizationalUnit organizationalUnit;
	//private WareHouse warehous;
	private String secret;
	private String systemHash;
	private String automaticEndOfDayIntervalStr;
	private boolean centInput;
	private boolean requirePaymentAmountInput;
	private boolean kioskMode;
	private String automaticPaymentFinalization;
	private String StringbloyalDeviceKey;
	
	private POS(Builder builder) {
		deleted=builder.deleted;
		revision=builder.revision;
		number=builder.number;
		name=builder.name;
		organizationalUnit=builder.organizationalUnit;
	}
	
	public static class Builder {
		private boolean deleted=false;
		private String revision=null;
		private String uuid=null;
		private String number=null;
		private int autoLogoutDelay=0;
		private boolean autoReceiptPrint=false;
		private String customerDisplayOfflineText=null;
		private String customerDisplayOnlineText=null;
		private String distributerCode=null;
		private CustomerGroup defaultCustomerGroup=null;
		private Payment defaultPaymentMethod=null;
		private EconomicZone economicZone=null;
		private boolean forceClosedDrawer=false;
		private CustomerGroup friendsBonusCustomerGroup=null;
		private String friendsbonusIdentification=null;
		private String friendsbonusSecret=null;
		private int maxBalanceAttempts=0;
		private String name=null;
		private boolean orderNumberRequired=false;
		private OrganizationalUnit organizationalUnit=null;
		//private WareHouse warehous=null;
		private String secret=null;
		private String systemHash=null;
		private String automaticEndOfDayIntervalStr=null;
		private boolean centInput=false;
		private boolean requirePaymentAmountInput=false;
		private boolean kioskMode=false;
		private String automaticPaymentFinalization=null;
		private String StringbloyalDeviceKey=null;
		
		public Builder(String name) {
			this.name=name;
		}		
		
		public Builder number(String value){
			number=value;
			return this;
		}
		
		public Builder organizationalUnit(OrganizationalUnit orgUnit){
			organizationalUnit=orgUnit;
			return this;
		}
		
		public POS build(){
			return new POS(this);
		}
	}
	
	public JSONObject toJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("name", name);
			obj.put("deleted", deleted);
			obj.put("revision", revision);
			obj.put("uuid", uuid);
			obj.put("number", number);
			
			
			if (organizationalUnit != null)
				obj.put("organizationalUnit", organizationalUnit.getUuid());
			if (defaultCustomerGroup != null)
				obj.put("defaultCustomerGroup", defaultCustomerGroup.getUuid());
			if (defaultPaymentMethod != null)
				obj.put("defaultPaymentMethod", defaultPaymentMethod.getUuid());
			if (economicZone != null)
				obj.put("sector", economicZone.getUuid());
			if (friendsBonusCustomerGroup != null)
				obj.put("friendsBonusCustomerGroup", friendsBonusCustomerGroup.getUuid());
			
			return obj;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static POS fromJSON(JSONObject obj) throws JSONException {
		if(obj.has("result") && obj.getString("result")!=null)
			obj=obj.getJSONObject("result"); 
		OrganizationalUnit orgUnit=new OrganizationalUnit.Builder(null).build();
		orgUnit.setUuid(obj.getString("organizationalUnit"));
		
		POS pos = new POS.Builder(null).
				number(obj.getString("number")).
				organizationalUnit(orgUnit)
					
					
					
				.build();
		return pos;
	}
	
	public boolean post() throws IOException {
		
		if (organizationalUnit != null && organizationalUnit.getUuid() == null)
			organizationalUnit.post();
		return CloudLink.getConnector().postData(DataType.pos,this.toJSON());
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getAutoLogoutDelay() {
		return autoLogoutDelay;
	}
	public void setAutoLogoutDelay(int autoLogoutDelay) {
		this.autoLogoutDelay = autoLogoutDelay;
	}
	public boolean isAutoReceiptPrint() {
		return autoReceiptPrint;
	}
	public void setAutoReceiptPrint(boolean autoReceiptPrint) {
		this.autoReceiptPrint = autoReceiptPrint;
	}
	public String getCustomerDisplayOfflineText() {
		return customerDisplayOfflineText;
	}
	public void setCustomerDisplayOfflineText(String customerDisplayOfflineText) {
		this.customerDisplayOfflineText = customerDisplayOfflineText;
	}
	public String getCustomerDisplayOnlineText() {
		return customerDisplayOnlineText;
	}
	public void setCustomerDisplayOnlineText(String customerDisplayOnlineText) {
		this.customerDisplayOnlineText = customerDisplayOnlineText;
	}
	public String getDistributerCode() {
		return distributerCode;
	}
	public void setDistributerCode(String distributerCode) {
		this.distributerCode = distributerCode;
	}
	public CustomerGroup getDefaultCustomerGroup() {
		return defaultCustomerGroup;
	}
	public void setDefaultCustomerGroup(CustomerGroup defaultCustomerGroup) {
		this.defaultCustomerGroup = defaultCustomerGroup;
	}
	public Payment getDefaultPaymentMethod() {
		return defaultPaymentMethod;
	}
	public void setDefaultPaymentMethod(Payment defaultPaymentMethod) {
		this.defaultPaymentMethod = defaultPaymentMethod;
	}
	public EconomicZone getEconomicZone() {
		return economicZone;
	}
	public void setEconomicZone(EconomicZone economicZone) {
		this.economicZone = economicZone;
	}
	public boolean isForceClosedDrawer() {
		return forceClosedDrawer;
	}
	public void setForceClosedDrawer(boolean forceClosedDrawer) {
		this.forceClosedDrawer = forceClosedDrawer;
	}
	public CustomerGroup getFriendsBonusCustomerGroup() {
		return friendsBonusCustomerGroup;
	}
	public void setFriendsBonusCustomerGroup(CustomerGroup friendsBonusCustomerGroup) {
		this.friendsBonusCustomerGroup = friendsBonusCustomerGroup;
	}
	public String getFriendsbonusIdentification() {
		return friendsbonusIdentification;
	}
	public void setFriendsbonusIdentification(String friendsbonusIdentification) {
		this.friendsbonusIdentification = friendsbonusIdentification;
	}
	public String getFriendsbonusSecret() {
		return friendsbonusSecret;
	}
	public void setFriendsbonusSecret(String friendsbonusSecret) {
		this.friendsbonusSecret = friendsbonusSecret;
	}
	public int getMaxBalanceAttempts() {
		return maxBalanceAttempts;
	}
	public void setMaxBalanceAttempts(int maxBalanceAttempts) {
		this.maxBalanceAttempts = maxBalanceAttempts;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isOrderNumberRequired() {
		return orderNumberRequired;
	}
	public void setOrderNumberRequired(boolean orderNumberRequired) {
		this.orderNumberRequired = orderNumberRequired;
	}
	public OrganizationalUnit getOrganizationalUnit() {
		return organizationalUnit;
	}
	public void setOrganizationalUnit(OrganizationalUnit organizationalUnit) {
		this.organizationalUnit = organizationalUnit;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getSystemHash() {
		return systemHash;
	}
	public void setSystemHash(String systemHash) {
		this.systemHash = systemHash;
	}
	public String getAutomaticEndOfDayIntervalStr() {
		return automaticEndOfDayIntervalStr;
	}
	public void setAutomaticEndOfDayIntervalStr(String automaticEndOfDayIntervalStr) {
		this.automaticEndOfDayIntervalStr = automaticEndOfDayIntervalStr;
	}
	public boolean isCentInput() {
		return centInput;
	}
	public void setCentInput(boolean centInput) {
		this.centInput = centInput;
	}
	public boolean isRequirePaymentAmountInput() {
		return requirePaymentAmountInput;
	}
	public void setRequirePaymentAmountInput(boolean requirePaymentAmountInput) {
		this.requirePaymentAmountInput = requirePaymentAmountInput;
	}
	public boolean isKioskMode() {
		return kioskMode;
	}
	public void setKioskMode(boolean kioskMode) {
		this.kioskMode = kioskMode;
	}
	public String getAutomaticPaymentFinalization() {
		return automaticPaymentFinalization;
	}
	public void setAutomaticPaymentFinalization(String automaticPaymentFinalization) {
		this.automaticPaymentFinalization = automaticPaymentFinalization;
	}
	public String getStringbloyalDeviceKey() {
		return StringbloyalDeviceKey;
	}
	public void setStringbloyalDeviceKey(String stringbloyalDeviceKey) {
		StringbloyalDeviceKey = stringbloyalDeviceKey;
	}
	
	
	
}
