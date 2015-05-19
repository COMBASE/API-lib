package domain;

import java.text.ParseException;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Customer extends AbstractNumberApiObject<Customer>
{

	public static class Builder extends Init<Builder>
	{

		@Override
		protected Builder self()
		{
			return this;
		}

	}
	protected static abstract class Init<T extends Init<T>> extends AbstractNumberApiObject.Init<T>
	{
		private CustomerGroup customerGroup = null;
		private String firstName = null;
		private String lastName = null;
		private String gender = null;
		private String company = null;
		private String addressLine1 = null;
		private String city = null;
		private String zipCode = null;
		private String state = null;
		private String country = null;
		private String email = null;
		private String phone = null;
		private Date birthday = null;

		public T addressLine1(final String value)
		{
			addressLine1 = value;
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

		public T city(final String value)
		{
			city = value;
			return self();
		}

		public T company(final String value)
		{
			company = value;
			return self();
		}

		public T country(final String value)
		{
			country = value;
			return self();
		}

		public T customerGroup(final CustomerGroup grp)
		{
			customerGroup = grp;
			return self();
		}

		public T email(final String value)
		{
			email = value;
			return self();
		}

		public T firstName(final String value)
		{
			firstName = value;
			return self();
		}

		public T gender(final String value)
		{
			gender = value;
			return self();
		}

		public T lastName(final String value)
		{
			lastName = value;
			return self();
		}

		public T phone(final String value)
		{
			phone = value;
			return self();
		}

		public T state(final String value)
		{
			state = value;
			return self();
		}

		public T zipCode(final String value)
		{
			zipCode = value;
			return self();
		}
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 2258389891494944765L;
	private CustomerGroup customerGroup;
	private String company;
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
	private String state;

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
		company = init.company;
		setState(init.state);
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

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	public String getAddressLine1()
	{
		return addressLine1;
	}

	public Date getBirthday()
	{
		return birthday;
	}

	public String getCity()
	{
		return city;
	}

	public String getCompany()
	{
		return company;
	}

	public String getCountry()
	{
		return country;
	}

	public CustomerGroup getCustomerGroup()
	{
		return customerGroup;
	}

	public String getEmail()
	{
		return email;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getGender()
	{
		return gender;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getPhone()
	{
		return phone;
	}

	public String getState()
	{
		return state;
	}

	public String getZipCode()
	{
		return zipCode;
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

	public void setAddressLine1(final String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}

	public void setBirthday(final Date birthday)
	{
		this.birthday = birthday;
	}

	public void setCity(final String city)
	{
		this.city = city;
	}

	public void setCompany(final String company)
	{
		this.company = company;
	}

	public void setCountry(final String country)
	{
		this.country = country;
	}

	public void setCustomerGroup(final CustomerGroup customerGroup)
	{
		this.customerGroup = customerGroup;
	}

	public void setEmail(final String email)
	{
		this.email = email;
	}

	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	public void setGender(final String gender)
	{
		this.gender = gender;
	}

	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

	public void setPhone(final String phone)
	{
		this.phone = phone;
	}

	public void setState(final String state)
	{
		this.state = state;
	}

	public void setZipCode(final String zipCode)
	{
		this.zipCode = zipCode;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();
		appendJSON(obj);

		obj.put("customerGroup", customerGroup.getId());
		obj.put("firstName", firstName);
		obj.put("lastName", lastName);
		obj.put("gender", gender);
		obj.put("addressLine1", addressLine1);
		obj.put("city", city);
		obj.put("zipCode", zipCode);
		obj.put("country", country);
		obj.put("email", email);
		obj.put("phone", phone);
		obj.put("birthday", birthday);
		obj.put("company", company);
		obj.put("state", state);

		return obj;
	}

	public static Customer fromJSON(JSONObject obj) throws JSONException, ParseException
	{
		if (obj.has("result") && obj.getString("result") != null)
		{
			obj = obj.getJSONObject("result");
		}

		final Customer cust = new Customer.Builder().id(obj.getString("uuid"))
			.deleted(obj.getBoolean("deleted"))
			.revision(obj.getLong("revision"))
			.number(obj.getString("number"))
			.firstName(obj.getString("firstName"))
			.lastName(obj.getString("lastName"))
			.email(obj.getString("email"))
			.gender(obj.getString("gender"))
			.zipCode(obj.getString("zipCode"))
			.addressLine1(obj.getString("addressLine1"))
			.city(obj.getString("city"))
			.state(obj.getString("state"))
			.country(obj.getString("country"))
			.phone(obj.getString("phone"))
			.birthday(prepareDate(obj, "birthday"))
			.company(obj.getString("company"))
			.birthday(prepareDate(obj, "birthday"))
			.build();

		return cust;
	}
}
