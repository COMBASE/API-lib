package domain;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Supplier extends AbstractNameAndNumberApiObject<Supplier>
{
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

		public T accountNumber(final String value)
		{
			accountNumber = value;
			return self();
		}

		public T additionalInformation(final String value)
		{
			additionalInformation = value;
			return self();
		}

		public T bank(final String value)
		{
			bank = value;
			return self();
		}

		public T bic(final String value)
		{
			bic = value;
			return self();
		}

		@Override
		public Supplier build()
		{
			return new Supplier(this);
		}

		public T contactEmail(final String value)
		{
			contactEmail = value;
			return self();
		}

		public T contactPersonEmail(final String value)
		{
			contactPersonEmail = value;
			return self();
		}

		public T contactPersonFirstname(final String value)
		{
			contactPersonFirstname = value;
			return self();
		}

		public T contactPersonMobile(final String value)
		{
			contactPersonMobile = value;
			return self();
		}

		public T contactPersonPhone(final String value)
		{
			contactPersonPhone = value;
			return self();
		}

		public T contactPersonSalutation(final String value)
		{
			contactPersonSalutation = value;
			return self();
		}

		public T contactPersonSurname(final String value)
		{
			contactPersonSurname = value;
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

		public T contactWebsite(final String value)
		{
			contactWebsite = value;
			return self();
		}

		public T creditorIdentifier(final String value)
		{
			creditorIdentifier = value;
			return self();
		}

		public T customerNumber(final String value)
		{
			customerNumber = value;
			return self();
		}

		public T delayedDeliveryStarting(final BigDecimal value)
		{
			delayedDeliveryStarting = value;
			return self();
		}

		public T deliveryTime(final BigDecimal value)
		{
			deliveryTime = value;
			return self();
		}

		public T deliveryWeekdays(final BigDecimal value)
		{
			deliveryWeekdays = value;
			return self();
		}

		public T iban(final String value)
		{
			iban = value;
			return self();
		}

		public T orderEmail(final String value)
		{
			orderEmail = value;
			return self();
		}

		public T orderPhone(final String value)
		{
			orderPhone = value;
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

		public T orderWeekdays(final BigDecimal value)
		{
			orderWeekdays = value;
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

		public T rountingCode(final String value)
		{
			rountingCode = value;
			return self();
		}

		public T shipper(final String value)
		{
			shipper = value;
			return self();
		}
	}

	private static final long serialVersionUID = 5411304390291780800L;

	private static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

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

	public String getAccountNumber()
	{
		return accountNumber;
	}

	public String getAdditionalInformation()
	{
		return additionalInformation;
	}

	public String getBank()
	{
		return bank;
	}

	public String getBic()
	{
		return bic;
	}

	public String getContactEmail()
	{
		return contactEmail;
	}

	public String getContactPersonEmail()
	{
		return contactPersonEmail;
	}

	public String getContactPersonFirstname()
	{
		return contactPersonFirstname;
	}

	public String getContactPersonMobile()
	{
		return contactPersonMobile;
	}

	public String getContactPersonPhone()
	{
		return contactPersonPhone;
	}

	public String getContactPersonSalutation()
	{
		return contactPersonSalutation;
	}

	public String getContactPersonSurname()
	{
		return contactPersonSurname;
	}

	public String getContactPersonTelefax()
	{
		return contactPersonTelefax;
	}

	public String getContactPhone()
	{
		return contactPhone;
	}

	public String getContactTelefax()
	{
		return contactTelefax;
	}

	public String getContactWebsite()
	{
		return contactWebsite;
	}

	public String getCreditorIdentifier()
	{
		return creditorIdentifier;
	}

	public String getCustomerNumber()
	{
		return customerNumber;
	}

	public BigDecimal getDelayedDeliveryStarting()
	{
		return delayedDeliveryStarting;
	}

	public BigDecimal getDeliveryTime()
	{
		return deliveryTime;
	}

	public BigDecimal getDeliveryWeekdays()
	{
		return deliveryWeekdays;
	}

	public String getIban()
	{
		return iban;
	}

	public String getOrderEmail()
	{
		return orderEmail;
	}

	public String getOrderPhone()
	{
		return orderPhone;
	}

	public Date getOrderTimeFrom()
	{
		return orderTimeFrom;
	}

	public Date getOrderTimeTo()
	{
		return orderTimeTo;
	}

	public BigDecimal getOrderWeekdays()
	{
		return orderWeekdays;
	}

	public Currency getPaymentCurrency()
	{
		return paymentCurrency;
	}

	public String getPaymentMethod()
	{
		return paymentMethod;
	}

	public String getRountingCode()
	{
		return rountingCode;
	}

	public String getShipper()
	{
		return shipper;
	}

	public void setAccountNumber(final String accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public void setAdditionalInformation(final String additionalInformation)
	{
		this.additionalInformation = additionalInformation;
	}

	public void setBank(final String bank)
	{
		this.bank = bank;
	}

	public void setBic(final String bic)
	{
		this.bic = bic;
	}

	public void setContactEmail(final String contactEmail)
	{
		this.contactEmail = contactEmail;
	}

	public void setContactPersonEmail(final String contactPersonEmail)
	{
		this.contactPersonEmail = contactPersonEmail;
	}

	public void setContactPersonFirstname(final String contactPersonFirstname)
	{
		this.contactPersonFirstname = contactPersonFirstname;
	}

	public void setContactPersonMobile(final String contactPersonMobile)
	{
		this.contactPersonMobile = contactPersonMobile;
	}

	public void setContactPersonPhone(final String contactPersonPhone)
	{
		this.contactPersonPhone = contactPersonPhone;
	}

	public void setContactPersonSalutation(final String contactPersonSalutation)
	{
		this.contactPersonSalutation = contactPersonSalutation;
	}

	public void setContactPersonSurname(final String contactPersonSurname)
	{
		this.contactPersonSurname = contactPersonSurname;
	}

	public void setContactPersonTelefax(final String contactPersonTelefax)
	{
		this.contactPersonTelefax = contactPersonTelefax;
	}

	public void setContactPhone(final String contactPhone)
	{
		this.contactPhone = contactPhone;
	}

	public void setContactTelefax(final String contactTelefax)
	{
		this.contactTelefax = contactTelefax;
	}

	public void setContactWebsite(final String contactWebsite)
	{
		this.contactWebsite = contactWebsite;
	}

	public void setCreditorIdentifier(final String creditorIdentifier)
	{
		this.creditorIdentifier = creditorIdentifier;
	}

	public void setCustomerNumber(final String customerNumber)
	{
		this.customerNumber = customerNumber;
	}

	public void setDelayedDeliveryStarting(final BigDecimal delayedDeliveryStarting)
	{
		this.delayedDeliveryStarting = delayedDeliveryStarting;
	}

	public void setDeliveryTime(final BigDecimal deliveryTime)
	{
		this.deliveryTime = deliveryTime;
	}

	public void setDeliveryWeekdays(final BigDecimal deliveryWeekdays)
	{
		this.deliveryWeekdays = deliveryWeekdays;
	}

	public void setIban(final String iban)
	{
		this.iban = iban;
	}

	public void setOrderEmail(final String orderEmail)
	{
		this.orderEmail = orderEmail;
	}

	public void setOrderPhone(final String orderPhone)
	{
		this.orderPhone = orderPhone;
	}

	public void setOrderTimeFrom(final Date orderTimeFrom)
	{
		this.orderTimeFrom = orderTimeFrom;
	}

	public void setOrderTimeTo(final Date orderTimeTo)
	{
		this.orderTimeTo = orderTimeTo;
	}

	public void setOrderWeekdays(final BigDecimal orderWeekdays)
	{
		this.orderWeekdays = orderWeekdays;
	}

	public void setPaymentCurrency(final Currency paymentCurrency)
	{
		this.paymentCurrency = paymentCurrency;
	}

	public void setPaymentMethod(final String paymentMethod)
	{
		this.paymentMethod = paymentMethod;
	}

	public void setRountingCode(final String rountingCode)
	{
		this.rountingCode = rountingCode;
	}

	public void setShipper(final String shipper)
	{
		this.shipper = shipper;
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
		if (paymentCurrency != null)
		{
			obj.put("orderTimeFrom", inputDf.format(orderTimeFrom));
		}
		if (paymentCurrency != null)
		{
			obj.put("orderTimeTo", inputDf.format(orderTimeTo));
		}
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

		return obj;
	}

	public static Supplier fromJSON(JSONObject obj) throws JSONException, ParseException
	{
		if (obj.has("result") && nullStringToNull(obj, "result") != null)
		{
			obj = obj.getJSONObject("result");
		}

		final Supplier sup = new Supplier.Builder().build();

		if (obj.has("number"))
		{
			sup.setNumber(nullStringToNull(obj, "number"));
		}

		if (!obj.isNull("uuid"))
		{
			sup.setId(nullStringToNull(obj, "uuid"));
		}

		if (!obj.isNull("customerNumber"))
		{
			sup.setCustomerNumber(nullStringToNull(obj, "customerNumber"));
		}

		if (!obj.isNull("additionalInformation"))
		{
			sup.setAdditionalInformation(nullStringToNull(obj, "additionalInformation"));
		}

		if (!obj.isNull("contactPersonSalutation"))
		{
			sup.setContactPersonSalutation(nullStringToNull(obj, "contactPersonSalutation"));
		}

		if (!obj.isNull("contactPersonFirstname"))
		{
			sup.setContactPersonFirstname(nullStringToNull(obj, "contactPersonFirstname"));
		}

		if (!obj.isNull("contactPersonSurname"))
		{
			sup.setContactPersonSurname(nullStringToNull(obj, "contactPersonSurname"));
		}

		if (!obj.isNull("contactPersonEmail"))
		{
			sup.setContactPersonEmail(nullStringToNull(obj, "contactPersonEmail"));
		}

		if (!obj.isNull("contactPersonPhone"))
		{
			sup.setContactPersonPhone(nullStringToNull(obj, "contactPersonPhone"));
		}

		if (!obj.isNull("contactPersonMobile"))
		{
			sup.setContactPersonMobile(nullStringToNull(obj, "contactPersonMobile"));
		}

		if (!obj.isNull("contactPersonTelefax"))
		{
			sup.setContactPersonTelefax(nullStringToNull(obj, "contactPersonTelefax"));
		}

		if (!obj.isNull("contactPhone"))
		{
			sup.setContactPhone(nullStringToNull(obj, "contactPhone"));
		}

		if (!obj.isNull("contactTelefax"))
		{
			sup.setContactTelefax(nullStringToNull(obj, "contactTelefax"));
		}

		if (!obj.isNull("contactEmail"))
		{
			sup.setContactEmail(nullStringToNull(obj, "contactEmail"));
		}

		if (!obj.isNull("contactWebsite"))
		{
			sup.setContactWebsite(nullStringToNull(obj, "contactWebsite"));
		}

		if (!obj.isNull("orderPhone"))
		{
			sup.setOrderPhone(nullStringToNull(obj, "orderPhone"));
		}

		if (!obj.isNull("orderEmail"))
		{
			sup.setOrderEmail(nullStringToNull(obj, "orderEmail"));
		}

		if (!obj.isNull("orderWeekdays"))
		{
			sup.setOrderWeekdays(prepareBigDecimal(obj, "orderWeekdays"));
		}

		if (!obj.isNull("orderTimeFrom"))
		{
			sup.setOrderTimeFrom(prepareDate(obj, "orderTimeFrom"));
		}

		if (!obj.isNull("orderTimeTo"))
		{
			sup.setOrderTimeTo(prepareDate(obj, "orderTimeTo"));
		}

		if (!obj.isNull("deliveryWeekdays"))
		{
			sup.setDeliveryWeekdays(prepareBigDecimal(obj, "deliveryWeekdays"));
		}

		if (!obj.isNull("deliveryTime"))
		{
			sup.setDeliveryTime(prepareBigDecimal(obj, "deliveryTime"));
		}

		if (!obj.isNull("delayedDeliveryStarting"))
		{
			sup.setDelayedDeliveryStarting(prepareBigDecimal(obj, "delayedDeliveryStarting"));
		}

		if (!obj.isNull("shipper"))
		{
			sup.setShipper(nullStringToNull(obj, "shipper"));
		}

		if (!obj.isNull("paymentCurrency"))
		{
			sup.setPaymentCurrency(new Currency.Builder().id(
				nullStringToNull(obj, "paymentCurrency")).build());
		}

		if (!obj.isNull("paymentMethod"))
		{
			sup.setPaymentMethod(nullStringToNull(obj, "paymentMethod"));
		}

		if (!obj.isNull("bank"))
		{
			sup.setBank(nullStringToNull(obj, "bank"));
		}

		if (!obj.isNull("rountingCode"))
		{
			sup.setRountingCode(nullStringToNull(obj, "rountingCode"));
		}

		if (!obj.isNull("bic"))
		{
			sup.setBic(nullStringToNull(obj, "bic"));
		}

		if (!obj.isNull("accountNumber"))
		{
			sup.setAccountNumber(nullStringToNull(obj, "accountNumber"));
		}

		if (!obj.isNull("iban"))
		{
			sup.setIban(nullStringToNull(obj, "iban"));
		}

		if (!obj.isNull("creditorIdentifier"))
		{
			sup.setCreditorIdentifier(nullStringToNull(obj, "creditorIdentifier"));
		}

		return sup;
	}
}
