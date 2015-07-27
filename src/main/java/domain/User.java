package domain;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.enums.UserPermissions;

public class User extends AbstractNumberApiObject<User>
{

	public static class Builder extends Init<Builder>
	{

		@Override
		protected Builder self()
		{
			return this;
		}


	}

	public static abstract class Init<T extends Init<T>> extends AbstractNumberApiObject.Init<T>
	{

		private Date created = null;

		private String email = null;

		private String requestedEmail = null;

		private Integer emailChangeCount = null;

		private String firstname = null;

		private List<OrganizationalUnit> orgs = null;

		private String passwordHash = null;

		private String passwordSalt = null;

		private List<UserPermissions> permissions = null;

		// private final Set<LoginTicketReadable> loginTickets = new TreeSet<LoginTicketReadable>();

		private String surname = null;

		// private UserRoleReadable role;

		private String locale = null;

		private OrganizationalUnit selectedOrg = null;


		@Override
		public User build()
		{
			return new User(this);
		}

		public T created(final Date value)
		{
			this.created = value;
			return self();
		}

		public T email(final String value)
		{
			email = value;
			return self();
		}

		public T emailChangeCount(final Integer value)
		{
			emailChangeCount = value;
			return self();
		}

		public T firstname(final String value)
		{
			firstname = value;
			return self();
		}

		public T locale(final String value)
		{
			locale = value;
			return self();
		}

		public T orgs(final Collection<OrganizationalUnit> values)
		{
			if (orgs == null)
			{
				orgs = new ArrayList<OrganizationalUnit>();
			}
			orgs.addAll(values);
			return self();
		}

		public T passwordHash(final String value)
		{
			passwordHash = value;
			return self();
		}

		public T passwordSalt(final String value)
		{
			passwordSalt = value;
			return self();
		}

		public T permissions(final Collection<UserPermissions> value)
		{
			if (permissions == null)
			{
				permissions = new ArrayList<UserPermissions>();
			}
			permissions.addAll(value);
			return self();
		}

		public T requestedEmail(final String value)
		{
			requestedEmail = value;
			return self();
		}

		public T selectedOrg(final OrganizationalUnit value)
		{
			selectedOrg = value;
			return self();
		}

		public T surname(final String value)
		{
			surname = value;
			return self();
		}

	}

	private static final long serialVersionUID = 6155723487145223684L;

	private Date created;

	private String email;

	private String requestedEmail;

	private int emailChangeCount;

	private String firstname;

	private List<OrganizationalUnit> orgs = new ArrayList<OrganizationalUnit>();

	private String passwordHash;

	// private final Set<LoginTicketReadable> loginTickets = new TreeSet<LoginTicketReadable>();

	private String passwordSalt;

	// private UserRoleReadable role;

	private List<UserPermissions> permissions = new ArrayList<UserPermissions>();

	private String surname;

	private String locale;

	private OrganizationalUnit selectedOrg;

	private User(final Init<?> init)
	{
		super(init);

		this.created = init.created;

		this.email = init.email;

		this.requestedEmail = init.requestedEmail;

		this.firstname = init.firstname;

		this.orgs = init.orgs;

		this.permissions = init.permissions;

		// private final Set<LoginTicketReadable> loginTickets = new TreeSet<LoginTicketReadable>();

		this.surname = init.surname;

		// private UserRoleReadable role;

		this.emailChangeCount = init.emailChangeCount;

		this.passwordHash = init.passwordHash;

		this.passwordSalt = init.passwordSalt;

		this.locale = init.locale;

		this.selectedOrg = init.selectedOrg;

	}


	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	public Date getCreated()
	{
		return created;
	}

	public String getEmail()
	{
		return email;
	}

	public int getEmailChangeCount()
	{
		return emailChangeCount;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public String getLocale()
	{
		return locale;
	}

	public List<OrganizationalUnit> getOrgs()
	{
		return orgs;
	}

	public String getPasswordHash()
	{
		return passwordHash;
	}

	public String getPasswordSalt()
	{
		return passwordSalt;
	}

	public List<UserPermissions> getPermissions()
	{
		return permissions;
	}

	public String getRequestedEmail()
	{
		return requestedEmail;
	}

	public OrganizationalUnit getSelectedOrg()
	{
		return selectedOrg;
	}

	public String getSurname()
	{
		return surname;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = super.hashCode(result);

		result = prime * result + ((created == null) ? 0 : this.created.hashCode());

		result = prime * result + ((this.email == null) ? 0 : this.created.hashCode());

		result = prime * result + ((this.requestedEmail == null) ? 0 : this.created.hashCode());

		result = prime * result + ((this.emailChangeCount == 0) ? 0 : this.created.hashCode());

		result = prime * result + ((this.firstname == null) ? 0 : this.created.hashCode());

		result = prime * result + ((this.orgs == null) ? 0 : this.created.hashCode());

		result = prime * result + ((this.passwordHash == null) ? 0 : this.created.hashCode());

		result = prime * result + ((this.passwordSalt == null) ? 0 : this.created.hashCode());

		result = prime * result + ((permissions == null) ? 0 : this.created.hashCode());

		// private final Set<LoginTicketReadable> loginTickets = new TreeSet<LoginTicketReadable>();

		result = prime * result + ((this.surname == null) ? 0 : this.created.hashCode());

		// private UserRoleReadable role;

		result = prime * result + ((this.locale == null) ? 0 : this.created.hashCode());

		result = prime * result + ((selectedOrg == null) ? 0 : this.created.hashCode());

		return result;
	}

	public void setCreated(final Date created)
	{
		this.created = created;
	}

	public void setEmail(final String email)
	{
		this.email = email;
	}

	public void setEmailChangeCount(final int emailChangeCount)
	{
		this.emailChangeCount = emailChangeCount;
	}

	public void setFirstname(final String firstname)
	{
		this.firstname = firstname;
	}

	public void setLocale(final String locale)
	{
		this.locale = locale;
	}

	public void setPasswordHash(final String passwordHash)
	{
		this.passwordHash = passwordHash;
	}

	public void setPasswordSalt(final String passwordSalt)
	{
		this.passwordSalt = passwordSalt;
	}

	public void setRequestedEmail(final String requestedEmail)
	{
		this.requestedEmail = requestedEmail;
	}

	public void setSelectedOrg(final OrganizationalUnit selectedOrg)
	{
		this.selectedOrg = selectedOrg;
	}

	public void setSurname(final String surname)
	{
		this.surname = surname;
	}

	@Override
	public JSONObject toJSON() throws JSONException
	{
		final JSONObject obj = new JSONObject();
		appendJSON(obj);

		if (created != null)
		{
			obj.put("created", inputDf.format(created));
		}

		obj.put("email", email);

		obj.put("requestedEmail", requestedEmail);

		obj.put("emailChangeCount", emailChangeCount);

		obj.put("firstname", firstname);

		if (orgs != null)
		{
			final Collection<String> OrganizationalUnitIDs = new ArrayList<String>();
			for (final OrganizationalUnit organizationalUnit : orgs)
			{
				if (organizationalUnit != null && organizationalUnit.getId() != null)
				{
					OrganizationalUnitIDs.add(organizationalUnit.getId());
				}
			}
			obj.put("orgs", orgs);
		}

		obj.put("passwordHash", passwordHash);

		obj.put("passwordSalt", passwordSalt);

		if (permissions != null)
		{
			obj.put("permissions", permissions);
		}

		// private final Set<LoginTicketReadable> loginTickets = new
// TreeSet<LoginTicketReadable>());

		obj.put("surname", surname);

		// private UserRoleReadable role);

		obj.put("locale", locale);

		if (selectedOrg != null)
		{
			obj.put("selectedOrg", selectedOrg.getId());
		}

		return obj;
	}

	public static User fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Collection<OrganizationalUnit> organizationalUnits = new ArrayList<OrganizationalUnit>();
		if (!obj.isNull("orgs"))
		{
			final JSONArray jArray = obj.getJSONArray("orgs");
			for (int i = 0; i < jArray.length(); i++)
			{
				final String orgId = jArray.getString(i);
				final OrganizationalUnit organizationalUnit = new OrganizationalUnit.Builder().id(
					orgId).build();
				organizationalUnits.add(organizationalUnit);
			}
		}

		final Collection<UserPermissions> permissions = new ArrayList<UserPermissions>();
		if (obj.isNull("permissions"))
		{
			final JSONArray jsonArray = obj.getJSONArray("permissions");
			for (int i = 0; i < jsonArray.length(); i++)
			{
				final String permissionString = jsonArray.getString(i);
				final UserPermissions permission = UserPermissions.valueOf(permissionString);
				permissions.add(permission);
			}
		}

// final OrganizationalUnit selectedOrg = new OrganizationalUnit.Builder().id(
// nullStringToNull(obj,"selectedOrg")).build();

		final User user = new User.Builder().created(
			inputDf.parse(nullStringToNull(obj, "created")))
			.deleted(obj.getBoolean("deleted"))
			.email(nullStringToNull(obj, "email"))
			.firstname(nullStringToNull(obj, "firstname"))
			.id(nullStringToNull(obj, "uuid"))
			.number(nullStringToNull(obj, "number"))
			.orgs(organizationalUnits)
			.permissions(permissions)
			.revision(obj.getLong("revision"))
			.surname(nullStringToNull(obj, "surname"))
			.build();

		return user;
	}

}
