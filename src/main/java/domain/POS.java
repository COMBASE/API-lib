package domain;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class POS extends AbstractNameAndNumberApiObject<POS>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7976248646395275345L;
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
	// private WareHouse warehous;
	private String secret;
	private String systemHash;
	private String automaticEndOfDayIntervalStr;
	private boolean centInput;
	private boolean requirePaymentAmountInput;
	private boolean kioskMode;
	private String automaticPaymentFinalization;
	private String StringbloyalDeviceKey;

	protected static abstract class Init<T extends Init<T>> extends
		AbstractNameAndNumberApiObject.Init<T>
	{
		private final int autoLogoutDelay = 0;
		private final boolean autoReceiptPrint = false;
		private final String customerDisplayOfflineText = null;
		private final String customerDisplayOnlineText = null;
		private final String distributerCode = null;
		private final CustomerGroup defaultCustomerGroup = null;
		private final Payment defaultPaymentMethod = null;
		private final EconomicZone economicZone = null;
		private final boolean forceClosedDrawer = false;
		private final CustomerGroup friendsBonusCustomerGroup = null;
		private final String friendsbonusIdentification = null;
		private final String friendsbonusSecret = null;
		private final int maxBalanceAttempts = 0;
		private final String name = null;
		private final boolean orderNumberRequired = false;
		private OrganizationalUnit organizationalUnit = null;
		// private WareHouse warehous=null;
		private final String secret = null;
		private final String systemHash = null;
		private final String automaticEndOfDayIntervalStr = null;
		private final boolean centInput = false;
		private final boolean requirePaymentAmountInput = false;
		private final boolean kioskMode = false;
		private final String automaticPaymentFinalization = null;
		private final String StringbloyalDeviceKey = null;

		public T organizationalUnit(final OrganizationalUnit orgUnit)
		{
			organizationalUnit = orgUnit;
			return self();
		}

		@Override
		public POS build()
		{
			return new POS(this);
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

	private POS(final Init<?> init)
	{
		super(init);
		organizationalUnit = init.organizationalUnit;
	}

// public JSONObject toJSON()
// {
// final JSONObject obj = new JSONObject();
// try
// {
// obj.put("name", name);
// obj.put("deleted", deleted);
// obj.put("revision", revision);
// obj.put("uuid", uuid);
// if (number != null)
// obj.put("number", number);
//
//
// if (organizationalUnit != null)
// obj.put("organizationalUnit", organizationalUnit.getUuid());
// if (defaultCustomerGroup != null)
// obj.put("defaultCustomerGroup", defaultCustomerGroup.getUuid());
// if (defaultPaymentMethod != null)
// obj.put("defaultPaymentMethod", defaultPaymentMethod.getUuid());
// if (economicZone != null)
// obj.put("sector", economicZone.getUuid());
// if (friendsBonusCustomerGroup != null)
// obj.put("friendsBonusCustomerGroup", friendsBonusCustomerGroup.getUuid());
//
// return obj;
// }
// catch (final JSONException e)
// {
// e.printStackTrace();
// return null;
// }
// }
//
// public static POS fromJSON(JSONObject obj) throws JSONException
// {
// if (obj.has("result") && obj.getString("result") != null)
// obj = obj.getJSONObject("result");
// final OrganizationalUnit orgUnit = new OrganizationalUnit.Builder(null).build();
// orgUnit.setUuid(obj.getString("organizationalUnit"));
//
// final POS pos = new POS.Builder(null).number(obj.getString("number"))
// .organizationalUnit(orgUnit)
// .uuid(obj.getString("uuid"))
//
//
// .build();
// return pos;
// }
//
// public boolean post() throws IOException
// {
//
// if (organizationalUnit != null && organizationalUnit.getUuid() == null)
// organizationalUnit.post();
// return CloudLink.getConnector().postData(DataType.pos, this.toJSON());
// }

	public int getAutoLogoutDelay()
	{
		return autoLogoutDelay;
	}

	public void setAutoLogoutDelay(final int autoLogoutDelay)
	{
		this.autoLogoutDelay = autoLogoutDelay;
	}

	public boolean isAutoReceiptPrint()
	{
		return autoReceiptPrint;
	}

	public void setAutoReceiptPrint(final boolean autoReceiptPrint)
	{
		this.autoReceiptPrint = autoReceiptPrint;
	}

	public String getCustomerDisplayOfflineText()
	{
		return customerDisplayOfflineText;
	}

	public void setCustomerDisplayOfflineText(final String customerDisplayOfflineText)
	{
		this.customerDisplayOfflineText = customerDisplayOfflineText;
	}

	public String getCustomerDisplayOnlineText()
	{
		return customerDisplayOnlineText;
	}

	public void setCustomerDisplayOnlineText(final String customerDisplayOnlineText)
	{
		this.customerDisplayOnlineText = customerDisplayOnlineText;
	}

	public String getDistributerCode()
	{
		return distributerCode;
	}

	public void setDistributerCode(final String distributerCode)
	{
		this.distributerCode = distributerCode;
	}

	public CustomerGroup getDefaultCustomerGroup()
	{
		return defaultCustomerGroup;
	}

	public void setDefaultCustomerGroup(final CustomerGroup defaultCustomerGroup)
	{
		this.defaultCustomerGroup = defaultCustomerGroup;
	}

	public Payment getDefaultPaymentMethod()
	{
		return defaultPaymentMethod;
	}

	public void setDefaultPaymentMethod(final Payment defaultPaymentMethod)
	{
		this.defaultPaymentMethod = defaultPaymentMethod;
	}

	public EconomicZone getEconomicZone()
	{
		return economicZone;
	}

	public void setEconomicZone(final EconomicZone economicZone)
	{
		this.economicZone = economicZone;
	}

	public boolean isForceClosedDrawer()
	{
		return forceClosedDrawer;
	}

	public void setForceClosedDrawer(final boolean forceClosedDrawer)
	{
		this.forceClosedDrawer = forceClosedDrawer;
	}

	public CustomerGroup getFriendsBonusCustomerGroup()
	{
		return friendsBonusCustomerGroup;
	}

	public void setFriendsBonusCustomerGroup(final CustomerGroup friendsBonusCustomerGroup)
	{
		this.friendsBonusCustomerGroup = friendsBonusCustomerGroup;
	}

	public String getFriendsbonusIdentification()
	{
		return friendsbonusIdentification;
	}

	public void setFriendsbonusIdentification(final String friendsbonusIdentification)
	{
		this.friendsbonusIdentification = friendsbonusIdentification;
	}

	public String getFriendsbonusSecret()
	{
		return friendsbonusSecret;
	}

	public void setFriendsbonusSecret(final String friendsbonusSecret)
	{
		this.friendsbonusSecret = friendsbonusSecret;
	}

	public int getMaxBalanceAttempts()
	{
		return maxBalanceAttempts;
	}

	public void setMaxBalanceAttempts(final int maxBalanceAttempts)
	{
		this.maxBalanceAttempts = maxBalanceAttempts;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public void setName(final String name)
	{
		this.name = name;
	}

	public boolean isOrderNumberRequired()
	{
		return orderNumberRequired;
	}

	public void setOrderNumberRequired(final boolean orderNumberRequired)
	{
		this.orderNumberRequired = orderNumberRequired;
	}

	public OrganizationalUnit getOrganizationalUnit()
	{
		return organizationalUnit;
	}

	public void setOrganizationalUnit(final OrganizationalUnit organizationalUnit)
	{
		this.organizationalUnit = organizationalUnit;
	}

	public String getSecret()
	{
		return secret;
	}

	public void setSecret(final String secret)
	{
		this.secret = secret;
	}

	public String getSystemHash()
	{
		return systemHash;
	}

	public void setSystemHash(final String systemHash)
	{
		this.systemHash = systemHash;
	}

	public String getAutomaticEndOfDayIntervalStr()
	{
		return automaticEndOfDayIntervalStr;
	}

	public void setAutomaticEndOfDayIntervalStr(final String automaticEndOfDayIntervalStr)
	{
		this.automaticEndOfDayIntervalStr = automaticEndOfDayIntervalStr;
	}

	public boolean isCentInput()
	{
		return centInput;
	}

	public void setCentInput(final boolean centInput)
	{
		this.centInput = centInput;
	}

	public boolean isRequirePaymentAmountInput()
	{
		return requirePaymentAmountInput;
	}

	public void setRequirePaymentAmountInput(final boolean requirePaymentAmountInput)
	{
		this.requirePaymentAmountInput = requirePaymentAmountInput;
	}

	public boolean isKioskMode()
	{
		return kioskMode;
	}

	public void setKioskMode(final boolean kioskMode)
	{
		this.kioskMode = kioskMode;
	}

	public String getAutomaticPaymentFinalization()
	{
		return automaticPaymentFinalization;
	}

	public void setAutomaticPaymentFinalization(final String automaticPaymentFinalization)
	{
		this.automaticPaymentFinalization = automaticPaymentFinalization;
	}

	public String getStringbloyalDeviceKey()
	{
		return StringbloyalDeviceKey;
	}

	public void setStringbloyalDeviceKey(final String stringbloyalDeviceKey)
	{
		StringbloyalDeviceKey = stringbloyalDeviceKey;
	}

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = super.hashCode(result);
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime *
			result +
			((this.automaticEndOfDayIntervalStr == null) ? 0
				: this.automaticEndOfDayIntervalStr.hashCode());
		result = prime *
			result +
			((this.automaticPaymentFinalization == null) ? 0
				: this.automaticPaymentFinalization.hashCode());
		result = prime *
			result +
			((this.customerDisplayOfflineText == null) ? 0
				: this.customerDisplayOfflineText.hashCode());
		result = prime *
			result +
			((this.customerDisplayOnlineText == null) ? 0
				: this.customerDisplayOnlineText.hashCode());
		result = prime * result +
			((this.distributerCode == null) ? 0 : this.distributerCode.hashCode());
		result = prime *
			result +
			((this.friendsbonusIdentification == null) ? 0
				: this.friendsbonusIdentification.hashCode());
		result = prime * result +
			((this.friendsbonusSecret == null) ? 0 : this.friendsbonusSecret.hashCode());
		result = prime * result + ((this.secret == null) ? 0 : this.secret.hashCode());
		result = prime * result +
			((this.StringbloyalDeviceKey == null) ? 0 : this.StringbloyalDeviceKey.hashCode());
		result = prime * result + ((this.systemHash == null) ? 0 : this.systemHash.hashCode());
		result = prime * result +
			((this.defaultCustomerGroup == null) ? 0 : this.defaultCustomerGroup.hashCode());
		result = prime * result +
			((this.defaultPaymentMethod == null) ? 0 : this.defaultPaymentMethod.hashCode());
		result = prime * result +
			((this.organizationalUnit == null) ? 0 : this.organizationalUnit.hashCode());


		return result;
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

	@Override
	public POS fromJSON(final JSONObject obj) throws JSONException
	{
		readJSON(obj);
		return this;
	}

	@Override
	public void readJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		super.readJSON(obj);


	}
}
