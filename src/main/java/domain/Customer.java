package domain;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
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
		private List<CustomerInformation> informations = null;

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

		public T information(final CustomerInformation value)
		{
			if (informations == null)
			{
				informations = new ArrayList<>();
			}


			informations.add(value);
			return self();
		}

		public T information(final List<CustomerInformation> values)
		{
			informations = values;
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

	public static Customer fromJSON(JSONObject obj) throws JSONException, ParseException
	{
		if (obj.has("result") && nullStringToNull(obj, "result") != null)
		{
			obj = obj.getJSONObject("result");
		}

		if (nullStringToNull(obj, "information") != null)
		{
			final JSONArray jInformations = obj.getJSONArray("information");

			for (int i = 0; i < jInformations.length(); i++)
			{
				final JSONObject jInfo = jInformations.getJSONObject(i);
				final CustomerInformation information = new CustomerInformation(
					nullStringToNull(jInfo, "text"), nullStringToNull(jInfo, "creatora"),
					prepareDate(jInfo, "date"));
			}
		}

		final Customer cust = new Customer.Builder().id(nullStringToNull(obj, "uuid"))
			.deleted(obj.getBoolean("deleted"))
			.revision(obj.getLong("revision"))
			.number(nullStringToNull(obj, "number"))
			.firstName(nullStringToNull(obj, "firstName"))
			.lastName(nullStringToNull(obj, "lastName"))
			.email(nullStringToNull(obj, "email"))
			.gender(nullStringToNull(obj, "gender"))
			.zipCode(nullStringToNull(obj, "zipCode"))
			.addressLine1(nullStringToNull(obj, "addressLine1"))
			.city(nullStringToNull(obj, "city"))
			.state(nullStringToNull(obj, "state"))
			.country(nullStringToNull(obj, "country"))
			.phone(nullStringToNull(obj, "phone"))
			.birthday(prepareDate(obj, "birthday"))
			.company(nullStringToNull(obj, "company"))
			.birthday(prepareDate(obj, "birthday"))
			.build();

		return cust;
	}

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

	private List<CustomerInformation> informations;

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
		state = init.state;
	}

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

	public List<CustomerInformation> getInformations()
	{
		return informations;
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

	public void setInformations(final List<CustomerInformation> informations)
	{
		this.informations = informations;
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
}
