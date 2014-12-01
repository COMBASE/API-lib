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
		private int autoLogoutDelay = 0;
		private boolean autoReceiptPrint = false;
		private String customerDisplayOfflineText = null;
		private String customerDisplayOnlineText = null;
		private String distributerCode = null;
		private CustomerGroup defaultCustomerGroup = null;
		private Payment defaultPaymentMethod = null;
		private EconomicZone economicZone = null;
		private boolean forceClosedDrawer = false;
		private CustomerGroup friendsBonusCustomerGroup = null;
		private String friendsbonusIdentification = null;
		private String friendsbonusSecret = null;
		private int maxBalanceAttempts = 0;
		private String name = null;
		private boolean orderNumberRequired = false;
		private OrganizationalUnit organizationalUnit = null;
		// private WareHouse warehous=null;
		private String secret = null;
		private String systemHash = null;
		private String automaticEndOfDayIntervalStr = null;
		private boolean centInput = false;
		private boolean requirePaymentAmountInput = false;
		private boolean kioskMode = false;
		private final String automaticPaymentization = null;
		private String StringbloyalDeviceKey = null;

		public T organizationalUnit(final OrganizationalUnit orgUnit)
		{
			organizationalUnit = orgUnit;
			return self();
		}

		public T autoLogoutDelay(final int value)
		{
			this.autoLogoutDelay = value;
			return self();
		}

		public T autoReceiptPrint(final boolean value)
		{
			this.autoReceiptPrint = value;
			return self();
		}

		public T customerDisplayOfflineText(final String value)
		{
			this.customerDisplayOfflineText = value;
			return self();
		}

		public T customerDisplayOnlineText(final String value)
		{
			this.customerDisplayOnlineText = value;
			return self();
		}

		public T distributerCode(final String value)
		{
			this.distributerCode = value;
			return self();
		}

		public T defaultCustomerGroup(final CustomerGroup value)
		{
			this.defaultCustomerGroup = value;
			return self();
		}

		public T defaultPaymentMethod(final Payment value)
		{
			this.defaultPaymentMethod = value;
			return self();
		}

		public T economicZone(final EconomicZone value)
		{
			this.economicZone = value;
			return self();
		}

		public T forceClosedDrawer(final boolean value)
		{
			this.forceClosedDrawer = value;
			return self();
		}

		public T friendsBonusCustomerGroup(final CustomerGroup value)
		{
			this.friendsBonusCustomerGroup = value;
			return self();
		}

		public T friendsbonusIdentification(final String value)
		{
			this.friendsbonusIdentification = value;
			return self();
		}

		public T friendsbonusSecret(final String value)
		{
			this.friendsbonusSecret = value;
			return self();
		}

		public T maxBalanceAttempts(final int value)
		{
			this.maxBalanceAttempts = value;
			return self();
		}

		@Override
		public T name(final String value)
		{
			this.name = value;
			return self();
		}

		public T orderNumberRequired(final boolean value)
		{
			this.orderNumberRequired = value;
			return self();
		}

		// private WareHouse warehous=null;
		public T secret(final String value)
		{
			this.secret = value;
			return self();
		}

		public T systemHash(final String value)
		{
			this.systemHash = value;
			return self();
		}

		public T automaticEndOfDayIntervalStr(final String value)
		{
			this.automaticEndOfDayIntervalStr = value;
			return self();
		}

		public T centInput(final boolean value)
		{
			this.centInput = value;
			return self();
		}

		public T requirePaymentAmountInput(final boolean value)
		{
			this.requirePaymentAmountInput = value;
			return self();
		}

		public T kioskMode(final boolean value)
		{
			this.kioskMode = value;
			return self();
		}

		public T StringbloyalDeviceKey(final String value)
		{
			this.StringbloyalDeviceKey = value;
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
//
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
		appendJSON(obj);

		if (organizationalUnit != null)
			obj.put("organizationalUnit", organizationalUnit.getId());
		if (defaultCustomerGroup != null)
			obj.put("defaultCustomerGroup", defaultCustomerGroup.getId());
		if (defaultPaymentMethod != null)
			obj.put("defaultPaymentMethod", defaultPaymentMethod.getId());
		if (economicZone != null)
			obj.put("sector", economicZone.getId());
		if (friendsBonusCustomerGroup != null)
			obj.put("friendsBonusCustomerGroup", friendsBonusCustomerGroup.getId());

		return obj;
	}

	public static POS fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");
		final OrganizationalUnit orgUnit = new OrganizationalUnit.Builder().build();
		orgUnit.setId(obj.getString("organizationalUnit"));

		final POS pos = new POS.Builder().number(obj.getString("number"))
			.organizationalUnit(orgUnit)
			.id(obj.getString("uuid"))


			.build();
		return pos;
	}
}
