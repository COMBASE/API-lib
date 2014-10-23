package domain;

import java.text.ParseException;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Customer extends AbstractNumberApiObject<Customer>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2258389891494944765L;
	private CustomerGroup customerGroup;
	private String firstName;
	private String lastName;
	private String gender;
	private String addressLine1;
	private String city;
	private String zipCode;
	private String country;
	private String email;
	private String phone;
	private Date birthday;

	protected static abstract class Init<T extends Init<T>> extends AbstractNumberApiObject.Init<T>
	{
		private CustomerGroup customerGroup = null;
		private String firstName = null;
		private String lastName = null;
		private String gender = null;
		private String addressLine1 = null;
		private String city = null;
		private String zipCode = null;
		private String country = null;
		private String email = null;
		private String phone = null;
		private Date birthday = null;

		public T customerGroup(final CustomerGroup grp)
		{
			customerGroup = grp;
			return self();
		}

		public T firstName(final String value)
		{
			firstName = value;
			return self();
		}

		public T lastName(final String value)
		{
			lastName = value;
			return self();
		}

		public T gender(final String value)
		{
			gender = value;
			return self();
		}

		public T addressLine1(final String value)
		{
			addressLine1 = value;
			return self();
		}

		public T city(final String value)
		{
			city = value;
			return self();
		}

		public T zipCode(final String value)
		{
			zipCode = value;
			return self();
		}

		public T country(final String value)
		{
			country = value;
			return self();
		}

		public T email(final String value)
		{
			email = value;
			return self();
		}

		public T phone(final String value)
		{
			phone = value;
			return self();
		}

		public T birthday(final Date value)
		{
			birthday = value;
			return self();
		}

		@Override
		public Customer build()
		{
			return new Customer(this);
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

	public Customer(final Init<?> init)
	{

		super(init);
		customerGroup = init.customerGroup;
		firstName = init.firstName;
		lastName = init.lastName;
		gender = init.gender;
		addressLine1 = init.addressLine1;
		city = init.city;
		zipCode = init.zipCode;
		country = init.country;
		email = init.email;
		phone = init.phone;
		birthday = init.birthday;
	}

// public static Customer fromJSON(JSONObject obj) throws JSONException
// {
//
//
// }
//
// public JSONObject toJSON()
// {
// JSONObject obj = new JSONObject();
// try
// {
// obj.put("deleted", deleted);
// obj.put("uuid", uuid);
// obj.put("revision", revision);
// if (number != null)
// obj.put("number", number);
// if (customerGroup != null)
// obj.put("customerGroup", customerGroup.getUuid());
// obj.put("firstName", firstName);
// obj.put("lastName", lastName);
// obj.put("gender", gender);
// obj.put("addressLine1", addressLine1);
// obj.put("city", city);
// obj.put("zipCode", zipCode);
// obj.put("country", country);
// obj.put("email", email);
// obj.put("phone", phone);
// obj.put("birthday", birthday);
// if (birthday != null)
// obj.put("birthday", inputDf.format(birthday));
//
// return obj;
// }
// catch ( JSONException e)
// {
// e.printStackTrace();
// return null;
// }
// }
//
// public boolean post() throws IOException
// {
//
// if (customerGroup != null && customerGroup.getUuid() == null)
// customerGroup.post();
//
// return CloudLink.getConnector().postData(DataType.customer, this.toJSON());
// }

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(final String gender)
	{
		this.gender = gender;
	}

	public String getAddressLine1()
	{
		return addressLine1;
	}

	public void setAddressLine1(final String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(final String city)
	{
		this.city = city;
	}

	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(final String zipCode)
	{
		this.zipCode = zipCode;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(final String country)
	{
		this.country = country;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(final String phone)
	{
		this.phone = phone;
	}

	public CustomerGroup getCustomerGroup()
	{
		return customerGroup;
	}

	public void setCustomerGroup(final CustomerGroup customerGroup)
	{
		this.customerGroup = customerGroup;
	}

	public Date getBirthday()
	{
		return birthday;
	}

	public void setBirthday(final Date birthday)
	{
		this.birthday = birthday;
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
		result = prime * result + ((this.addressLine1 == null) ? 0 : this.addressLine1.hashCode());
		result = prime * result + ((this.city == null) ? 0 : this.city.hashCode());
		result = prime * result + ((this.country == null) ? 0 : this.country.hashCode());
		result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
		result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
		result = prime * result + ((this.gender == null) ? 0 : this.gender.hashCode());
		result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
		result = prime * result + ((this.phone == null) ? 0 : this.phone.hashCode());
		result = prime * result + ((this.zipCode == null) ? 0 : this.zipCode.hashCode());
		result = prime * result + ((this.birthday == null) ? 0 : this.birthday.hashCode());
		result = prime * result +
			((this.customerGroup == null) ? 0 : this.customerGroup.hashCode());


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


	public static Customer fromJSON(JSONObject obj) throws JSONException
	{
		if (obj.has("result") && obj.getString("result") != null)
		{
			obj = obj.getJSONObject("result");
		}

		final String sdate = obj.getString("birthday");
		Date bdate = null;
		try
		{
			if (sdate != "null")
				bdate = inputDf.parse(sdate);
		}
		catch (final ParseException e)
		{
			e.printStackTrace();
		}

		final Customer cust = new Customer.Builder().id(obj.getString("uuid"))
			.number(obj.getString("number"))
			.firstName(obj.getString("firstName"))
			.lastName(obj.getString("lastName"))
			.email(obj.getString("email"))
			.gender(obj.getString("gender"))
			.zipCode(obj.getString("zipCode"))
			.addressLine1(obj.getString("addressLine1"))
			.city(obj.getString("city"))
			.country(obj.getString("country"))
			.phone(obj.getString("phone"))
			.birthday(bdate)
			.build();

		return cust;
	}
}
