package domain;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import link.CloudLink;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Customer {

	private static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

	private boolean deleted;
	private String uuid;
	private String revision;
	private String number;

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

	public Customer(Builder builder) {

		deleted = builder.deleted;
		uuid = builder.uuid;
		revision = builder.revision;
		number = builder.number;

		customerGroup = builder.customerGroup;
		firstName = builder.firstName;
		lastName = builder.lastName;
		gender = builder.gender;
		addressLine1 = builder.addressLine1;
		city = builder.city;
		zipCode = builder.zipCode;
		country = builder.country;
		email = builder.email;
		phone = builder.phone;
		birthday = builder.birthday;
	}

	public static class Builder {

		private boolean deleted = false;
		private String uuid = null;
		private String revision = null;
		private String number = null;

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

		public Builder deleted(boolean value) {
			deleted = value;
			return this;
		}

		public Builder uuid(String uuid) {
			this.uuid = uuid;
			return this;
		}

		public Builder revision(String revision) {
			this.revision = revision;
			return this;
		}

		public Builder number(String number) {
			this.number = number;
			return this;
		}

		public Builder customerGroup(CustomerGroup grp) {
			customerGroup = grp;
			return this;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder gender(String gender) {
			this.gender = gender;
			return this;
		}

		public Builder addressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
			return this;
		}

		public Builder city(String city) {
			this.city = city;
			return this;
		}

		public Builder zipCode(String zipCode) {
			this.zipCode = zipCode;
			return this;
		}

		public Builder country(String country) {
			this.country = country;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder birthday(Date value) {
			this.birthday = value;
			return this;
		}

		public Customer build() {
			return new Customer(this);
		}
	}

	public static Customer fromJSON(JSONObject obj) throws JSONException {

		if (obj.has("result") && obj.getString("result") != null) {
			obj = obj.getJSONObject("result");
		}

		String sdate = obj.getString("birthday");
		Date bdate = null;
		try {
			if (sdate != "null")
				bdate = inputDf.parse(sdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Customer cust = new Customer.Builder().uuid(obj.getString("uuid")).number(obj.getString("number")).firstName(obj.getString("firstName"))
				.lastName(obj.getString("lastName")).email(obj.getString("email")).gender(obj.getString("gender")).zipCode(obj.getString("zipCode"))
				.addressLine1(obj.getString("addressLine1")).city(obj.getString("city")).country(obj.getString("country"))
				.phone(obj.getString("phone")).birthday(bdate).build();

		return cust;
	}

	public JSONObject toJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("deleted", deleted);
			obj.put("uuid", uuid);
			obj.put("revision", revision);
			if (number!=null)
				obj.put("number", number);
			if (customerGroup != null)
				obj.put("customerGroup", customerGroup.getUuid());
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
			if (birthday != null)
				obj.put("birthday", inputDf.format(birthday));

			return obj;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean post() throws IOException {

		if (customerGroup != null && customerGroup.getUuid() == null)
			customerGroup.post();

		return CloudLink.getConnector().postData(DataType.customer, this.toJSON());
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public CustomerGroup getCustomerGroup() {
		return customerGroup;
	}

	public void setCustomerGroup(CustomerGroup customerGroup) {
		this.customerGroup = customerGroup;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((this.number == null) ? 0 : this.number.hashCode());
		result = prime * result + ((this.uuid == null) ? 0 : this.uuid.hashCode());
		result = prime * result + ((this.addressLine1 == null) ? 0 : this.addressLine1.hashCode());
		result = prime * result + ((this.city == null) ? 0 : this.city.hashCode());
		result = prime * result + ((this.country == null) ? 0 : this.country.hashCode());
		result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
		result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
		result = prime * result + ((this.gender == null) ? 0 : this.gender.hashCode());
		result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
		result = prime * result + ((this.phone == null) ? 0 : this.phone.hashCode());
		result = prime * result + ((this.revision == null) ? 0 : this.revision.hashCode());
		result = prime * result + ((this.zipCode == null) ? 0 : this.zipCode.hashCode());
		result = prime * result + ((this.birthday == null) ? 0 : this.birthday.hashCode());
		result = prime * result + ((this.customerGroup == null) ? 0 : this.customerGroup.hashCode());
		

		return result;
	}

}
