package domain;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Supplier extends AbstractNameAndNumberApiObject<Supplier>
{
	private static final long serialVersionUID = 5411304390291780800L;

	private static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

	public static class Builder extends Init<Builder>
	{
		@Override
		protected Builder self()
		{
			return this;
		}
	}

	protected static abstract class Init<T extends Init<T>> extends
		AbstractNameAndNumberApiObject.Init<T>
	{
		private String customerNumber;
		private String additionalInformation;
		private String contactPersonSalutation;
		private String contactPersonFirstname;
		private String contactPersonSurname;
		private String contactPersonEmail;
		private String contactPersonPhone;
		private String contactPersonMobile;
		private String contactPersonTelefax;
		private String contactPhone;
		private String contactTelefax;
		private String contactEmail;
		private String contactWebsite;
		private String orderPhone;
		private String orderEmail;
		private BigDecimal orderWeekdays;
		private Date orderTimeFrom;
		private Date orderTimeTo;
		private BigDecimal deliveryWeekdays;
		private BigDecimal deliveryTime;
		private BigDecimal delayedDeliveryStarting;
		private String shipper;
		private Currency paymentCurrency;
		private String paymentMethod;
		private String bank;
		private String rountingCode;
		private String bic;
		private String accountNumber;
		private String iban;
		private String creditorIdentifier;

		public T customerNumber(final String value)
		{
			customerNumber = value;
			return self();
		}

		public T additionalInformation(final String value)
		{
			additionalInformation = value;
			return self();
		}

		public T contactPersonSalutation(final String value)
		{
			contactPersonSalutation = value;
			return self();
		}

		public T contactPersonFirstname(final String value)
		{
			contactPersonFirstname = value;
			return self();
		}

		public T contactPersonSurname(final String value)
		{
			contactPersonSurname = value;
			return self();
		}

		public T contactPersonEmail(final String value)
		{
			contactPersonEmail = value;
			return self();
		}

		public T contactPersonPhone(final String value)
		{
			contactPersonPhone = value;
			return self();
		}

		public T contactPersonMobile(final String value)
		{
			contactPersonMobile = value;
			return self();
		}

		public T contactPersonTelefax(final String value)
		{
			contactPersonTelefax = value;
			return self();
		}

		public T contactPhone(final String value)
		{
			contactPhone = value;
			return self();
		}

		public T contactTelefax(final String value)
		{
			contactTelefax = value;
			return self();
		}

		public T contactEmail(final String value)
		{
			contactEmail = value;
			return self();
		}

		public T contactWebsite(final String value)
		{
			contactWebsite = value;
			return self();
		}

		public T orderPhone(final String value)
		{
			orderPhone = value;
			return self();
		}

		public T orderEmail(final String value)
		{
			orderEmail = value;
			return self();
		}

		public T orderWeekdays(final BigDecimal value)
		{
			orderWeekdays = value;
			return self();
		}

		public T orderTimeFrom(final Date value)
		{
			orderTimeFrom = value;
			return self();
		}

		public T orderTimeTo(final Date value)
		{
			orderTimeTo = value;
			return self();
		}

		public T deliveryWeekdays(final BigDecimal value)
		{
			deliveryWeekdays = value;
			return self();
		}

		public T deliveryTime(final BigDecimal value)
		{
			deliveryTime = value;
			return self();
		}

		public T delayedDeliveryStarting(final BigDecimal value)
		{
			delayedDeliveryStarting = value;
			return self();
		}

		public T shipper(final String value)
		{
			shipper = value;
			return self();
		}

		public T paymentCurrency(final Currency value)
		{
			paymentCurrency = value;
			return self();
		}

		public T paymentMethod(final String value)
		{
			paymentMethod = value;
			return self();
		}

		public T bank(final String value)
		{
			bank = value;
			return self();
		}

		public T rountingCode(final String value)
		{
			rountingCode = value;
			return self();
		}

		public T bic(final String value)
		{
			bic = value;
			return self();
		}

		public T accountNumber(final String value)
		{
			accountNumber = value;
			return self();
		}

		public T iban(final String value)
		{
			iban = value;
			return self();
		}

		public T creditorIdentifier(final String value)
		{
			creditorIdentifier = value;
			return self();
		}

		@Override
		public Supplier build()
		{
			return new Supplier(this);
		}
	}

	private String customerNumber;
	private String additionalInformation;
	private String contactPersonSalutation;
	private String contactPersonFirstname;
	private String contactPersonSurname;
	private String contactPersonEmail;
	private String contactPersonPhone;
	private String contactPersonMobile;
	private String contactPersonTelefax;
	private String contactPhone;
	private String contactTelefax;
	private String contactEmail;
	private String contactWebsite;
	private String orderPhone;
	private String orderEmail;
	private BigDecimal orderWeekdays;
	private Date orderTimeFrom;
	private Date orderTimeTo;
	private BigDecimal deliveryWeekdays;
	private BigDecimal deliveryTime;
	private BigDecimal delayedDeliveryStarting;
	private String shipper;
	private Currency paymentCurrency;
	private String paymentMethod;
	private String bank;
	private String rountingCode;
	private String bic;
	private String accountNumber;
	private String iban;
	private String creditorIdentifier;

	private Supplier(final Init<?> init)
	{
		super(init);

		customerNumber = init.customerNumber;
		additionalInformation = init.additionalInformation;
		contactPersonSalutation = init.contactPersonSalutation;
		contactPersonFirstname = init.contactPersonFirstname;
		contactPersonSurname = init.contactPersonSurname;
		contactPersonEmail = init.contactPersonEmail;
		contactPersonPhone = init.contactPersonPhone;
		contactPersonMobile = init.contactPersonMobile;
		contactPersonTelefax = init.contactPersonTelefax;
		contactPhone = init.contactPhone;
		contactTelefax = init.contactTelefax;
		contactEmail = init.contactEmail;
		contactWebsite = init.contactWebsite;
		orderPhone = init.orderPhone;
		orderEmail = init.orderEmail;
		orderWeekdays = init.orderWeekdays;
		orderTimeFrom = init.orderTimeFrom;
		orderTimeTo = init.orderTimeTo;
		deliveryWeekdays = init.deliveryWeekdays;
		deliveryTime = init.deliveryTime;
		delayedDeliveryStarting = init.delayedDeliveryStarting;
		shipper = init.shipper;
		paymentCurrency = init.paymentCurrency;
		paymentMethod = init.paymentMethod;
		bank = init.bank;
		rountingCode = init.rountingCode;
		bic = init.bic;
		accountNumber = init.accountNumber;
		iban = init.iban;
		creditorIdentifier = init.creditorIdentifier;
	}

	public String getCustomerNumber()
	{
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber)
	{
		this.customerNumber = customerNumber;
	}

	public String getAdditionalInformation()
	{
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation)
	{
		this.additionalInformation = additionalInformation;
	}

	public String getContactPersonSalutation()
	{
		return contactPersonSalutation;
	}

	public void setContactPersonSalutation(String contactPersonSalutation)
	{
		this.contactPersonSalutation = contactPersonSalutation;
	}

	public String getContactPersonFirstname()
	{
		return contactPersonFirstname;
	}

	public void setContactPersonFirstname(String contactPersonFirstname)
	{
		this.contactPersonFirstname = contactPersonFirstname;
	}

	public String getContactPersonSurname()
	{
		return contactPersonSurname;
	}

	public void setContactPersonSurname(String contactPersonSurname)
	{
		this.contactPersonSurname = contactPersonSurname;
	}

	public String getContactPersonEmail()
	{
		return contactPersonEmail;
	}

	public void setContactPersonEmail(String contactPersonEmail)
	{
		this.contactPersonEmail = contactPersonEmail;
	}

	public String getContactPersonPhone()
	{
		return contactPersonPhone;
	}

	public void setContactPersonPhone(String contactPersonPhone)
	{
		this.contactPersonPhone = contactPersonPhone;
	}

	public String getContactPersonMobile()
	{
		return contactPersonMobile;
	}

	public void setContactPersonMobile(String contactPersonMobile)
	{
		this.contactPersonMobile = contactPersonMobile;
	}

	public String getContactPersonTelefax()
	{
		return contactPersonTelefax;
	}

	public void setContactPersonTelefax(String contactPersonTelefax)
	{
		this.contactPersonTelefax = contactPersonTelefax;
	}

	public String getContactPhone()
	{
		return contactPhone;
	}

	public void setContactPhone(String contactPhone)
	{
		this.contactPhone = contactPhone;
	}

	public String getContactTelefax()
	{
		return contactTelefax;
	}

	public void setContactTelefax(String contactTelefax)
	{
		this.contactTelefax = contactTelefax;
	}

	public String getContactEmail()
	{
		return contactEmail;
	}

	public void setContactEmail(String contactEmail)
	{
		this.contactEmail = contactEmail;
	}

	public String getContactWebsite()
	{
		return contactWebsite;
	}

	public void setContactWebsite(String contactWebsite)
	{
		this.contactWebsite = contactWebsite;
	}

	public String getOrderPhone()
	{
		return orderPhone;
	}

	public void setOrderPhone(String orderPhone)
	{
		this.orderPhone = orderPhone;
	}

	public String getOrderEmail()
	{
		return orderEmail;
	}

	public void setOrderEmail(String orderEmail)
	{
		this.orderEmail = orderEmail;
	}

	public BigDecimal getOrderWeekdays()
	{
		return orderWeekdays;
	}

	public void setOrderWeekdays(BigDecimal orderWeekdays)
	{
		this.orderWeekdays = orderWeekdays;
	}

	public Date getOrderTimeFrom()
	{
		return orderTimeFrom;
	}

	public void setOrderTimeFrom(Date orderTimeFrom)
	{
		this.orderTimeFrom = orderTimeFrom;
	}

	public Date getOrderTimeTo()
	{
		return orderTimeTo;
	}

	public void setOrderTimeTo(Date orderTimeTo)
	{
		this.orderTimeTo = orderTimeTo;
	}

	public BigDecimal getDeliveryWeekdays()
	{
		return deliveryWeekdays;
	}

	public void setDeliveryWeekdays(BigDecimal deliveryWeekdays)
	{
		this.deliveryWeekdays = deliveryWeekdays;
	}

	public BigDecimal getDeliveryTime()
	{
		return deliveryTime;
	}

	public void setDeliveryTime(BigDecimal deliveryTime)
	{
		this.deliveryTime = deliveryTime;
	}

	public BigDecimal getDelayedDeliveryStarting()
	{
		return delayedDeliveryStarting;
	}

	public void setDelayedDeliveryStarting(BigDecimal delayedDeliveryStarting)
	{
		this.delayedDeliveryStarting = delayedDeliveryStarting;
	}

	public String getShipper()
	{
		return shipper;
	}

	public void setShipper(String shipper)
	{
		this.shipper = shipper;
	}

	public Currency getPaymentCurrency()
	{
		return paymentCurrency;
	}

	public void setPaymentCurrency(Currency paymentCurrency)
	{
		this.paymentCurrency = paymentCurrency;
	}

	public String getPaymentMethod()
	{
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod)
	{
		this.paymentMethod = paymentMethod;
	}

	public String getBank()
	{
		return bank;
	}

	public void setBank(String bank)
	{
		this.bank = bank;
	}

	public String getRountingCode()
	{
		return rountingCode;
	}

	public void setRountingCode(String rountingCode)
	{
		this.rountingCode = rountingCode;
	}

	public String getBic()
	{
		return bic;
	}

	public void setBic(String bic)
	{
		this.bic = bic;
	}

	public String getAccountNumber()
	{
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public String getIban()
	{
		return iban;
	}

	public void setIban(String iban)
	{
		this.iban = iban;
	}

	public String getCreditorIdentifier()
	{
		return creditorIdentifier;
	}

	public void setCreditorIdentifier(String creditorIdentifier)
	{
		this.creditorIdentifier = creditorIdentifier;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();
		appendJSON(obj);

		obj.put("customerNumber", customerNumber);
		obj.put("additionalInformation", additionalInformation);
		obj.put("contactPersonSalutation", contactPersonSalutation);
		obj.put("contactPersonFirstname", contactPersonFirstname);
		obj.put("contactPersonSurname", contactPersonSurname);
		obj.put("contactPersonEmail", contactPersonEmail);
		obj.put("contactPersonPhone", contactPersonPhone);
		obj.put("contactPersonMobile", contactPersonMobile);
		obj.put("contactPersonTelefax", contactPersonTelefax);
		obj.put("contactPhone", contactPhone);
		obj.put("contactTelefax", contactTelefax);
		obj.put("contactEmail", contactEmail);
		obj.put("contactWebsite", contactWebsite);
		obj.put("orderPhone", orderPhone);
		obj.put("orderEmail", orderEmail);
		obj.put("orderWeekdays", orderWeekdays);
		obj.put("orderTimeFrom", inputDf.format(orderTimeFrom));
		obj.put("orderTimeTo", inputDf.format(orderTimeTo));
		obj.put("deliveryWeekdays", deliveryWeekdays);
		obj.put("deliveryTime", deliveryTime);
		obj.put("delayedDeliveryStarting", delayedDeliveryStarting);
		obj.put("shipper", shipper);
		if (paymentCurrency != null)
		{
			obj.put("paymentCurrency", paymentCurrency.getId());
		}
		obj.put("paymentMethod", paymentMethod);
		obj.put("bank", bank);
		obj.put("rountingCode", rountingCode);
		obj.put("bic", bic);
		obj.put("accountNumber", accountNumber);
		obj.put("iban", iban);
		obj.put("creditorIdentifier", creditorIdentifier);

		return null;
	}

	public static Supplier fromJSON(JSONObject obj) throws JSONException, ParseException
	{
		if (obj.has("result") && obj.getString("result") != null)
			obj = obj.getJSONObject("result");

		Supplier sup = new Supplier.Builder().build();

		if (obj.has("number"))
			sup.setNumber(obj.getString("number"));

		if (!obj.isNull("uuid"))
			sup.setId(obj.getString("uuid"));

		if (!obj.isNull("customerNumber"))
			sup.setCustomerNumber(obj.getString("customerNumber"));

		if (!obj.isNull("additionalInformation"))
			sup.setAdditionalInformation(obj.getString("additionalInformation"));

		if (!obj.isNull("contactPersonSalutation"))
			sup.setContactPersonSalutation(obj.getString("contactPersonSalutation"));

		if (!obj.isNull("contactPersonFirstname"))
			sup.setContactPersonFirstname(obj.getString("contactPersonFirstname"));

		if (!obj.isNull("contactPersonSurname"))
			sup.setContactPersonSurname(obj.getString("contactPersonSurname"));

		if (!obj.isNull("contactPersonEmail"))
			sup.setContactPersonEmail(obj.getString("contactPersonEmail"));

		if (!obj.isNull("contactPersonPhone"))
			sup.setContactPersonPhone(obj.getString("contactPersonPhone"));

		if (!obj.isNull("contactPersonMobile"))
			sup.setContactPersonMobile(obj.getString("contactPersonMobile"));

		if (!obj.isNull("contactPersonTelefax"))
			sup.setContactPersonTelefax(obj.getString("contactPersonTelefax"));

		if (!obj.isNull("contactPhone"))
			sup.setContactPhone(obj.getString("contactPhone"));

		if (!obj.isNull("contactTelefax"))
			sup.setContactTelefax(obj.getString("contactTelefax"));

		if (!obj.isNull("contactEmail"))
			sup.setContactEmail(obj.getString("contactEmail"));

		if (!obj.isNull("contactWebsite"))
			sup.setContactWebsite(obj.getString("contactWebsite"));

		if (!obj.isNull("orderPhone"))
			sup.setOrderPhone(obj.getString("orderPhone"));

		if (!obj.isNull("orderEmail"))
			sup.setOrderEmail(obj.getString("orderEmail"));

		if (!obj.isNull("orderWeekdays"))
			sup.setOrderWeekdays(new BigDecimal(obj.getDouble("orderWeekdays")));

		if (!obj.isNull("orderTimeFrom"))
			sup.setOrderTimeFrom(inputDf.parse(obj.getString("orderTimeFrom")));

		if (!obj.isNull("orderTimeTo"))
			sup.setOrderTimeTo(inputDf.parse(obj.getString("orderTimeTo")));

		if (!obj.isNull("deliveryWeekdays"))
			sup.setDeliveryWeekdays(new BigDecimal(obj.getDouble("deliveryWeekdays")));

		if (!obj.isNull("deliveryTime"))
			sup.setDeliveryTime(new BigDecimal(obj.getDouble("deliveryTime")));

		if (!obj.isNull("delayedDeliveryStarting"))
			sup.setDelayedDeliveryStarting(new BigDecimal(obj.getDouble("delayedDeliveryStarting")));

		if (!obj.isNull("shipper"))
			sup.setShipper(obj.getString("shipper"));

		if (!obj.isNull("paymentCurrency"))
			sup.setPaymentCurrency(new Currency.Builder().id(obj.getString("paymentCurrency"))
				.build());

		if (!obj.isNull("paymentMethod"))
			sup.setPaymentMethod(obj.getString("paymentMethod"));

		if (!obj.isNull("bank"))
			sup.setBank(obj.getString("bank"));

		if (!obj.isNull("rountingCode"))
			sup.setRountingCode(obj.getString("rountingCode"));

		if (!obj.isNull("bic"))
			sup.setBic(obj.getString("bic"));

		if (!obj.isNull("accountNumber"))
			sup.setAccountNumber(obj.getString("accountNumber"));

		if (!obj.isNull("iban"))
			sup.setIban(obj.getString("iban"));

		if (!obj.isNull("creditorIdentifier"))
			sup.setCreditorIdentifier(obj.getString("creditorIdentifier"));

		return sup;
	}
}
