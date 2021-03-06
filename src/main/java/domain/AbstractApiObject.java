package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.interfaces.HasId;
import domain.interfaces.HasJSON;



public abstract class AbstractApiObject<T extends HasId> implements HasId, Serializable, HasJSON<T>
{

	public static abstract class Builder extends Init<Builder>
	{

		@Override
		public abstract AbstractApiObject<?> build();


		@Override
		protected Builder self()
		{
			return this;
		}
	}


	protected static abstract class Init<T extends Init<T>>
	{
		private String id;

		private Long revision;

		private Boolean deleted;


		public abstract AbstractApiObject<?> build();


		public T deleted(final Boolean value)
		{
			deleted = value;
			return self();
		}


		public T id(final String value)
		{
			id = value;
			return self();
		}


		public T revision(final Long value)
		{
			this.revision = value;
			return self();
		}


		protected abstract T self();
	}


	protected static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

	private static final long serialVersionUID = 2033325648556071101L;

	private String id;

	private Long revision;

	private Boolean deleted;


	public AbstractApiObject(final Init<?> init)
	{
		super();
		this.id = init.id;
		this.revision = init.revision;
		this.deleted = init.deleted;
	}


	@Override
	public JSONObject appendJSON(final JSONObject obj) throws JSONException
	{
		obj.put("uuid", getId());
		obj.put("deleted", isDeleted());
		obj.put("revision", getRevision());

		return obj;
	}


	@Override
	public String getId()
	{
		return id;
	}


	@Override
	public Long getRevision()
	{
		return revision;
	}


	@Override
	public Boolean isDeleted()
	{
		return deleted;
	}


	@Override
	public void setDeleted(final Boolean deleted)
	{
		this.deleted = deleted;
	}


	@Override
	public void setId(final String id)
	{
		this.id = id;
	}


	@Override
	public void setRevision(final Long revision)
	{
		this.revision = revision;
	}


	public abstract JSONObject toJSON() throws JSONException;


	protected int hashCode(int result)
	{
		final int prime = 31;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result + ((this.revision == null) ? 0 : this.revision.hashCode());
		result = prime * result + ((this.deleted == null) ? 0 : this.deleted.hashCode());

		return result;
	}


	protected StringBuilder toString(final StringBuilder builder)
	{
		if (id != null)
		{
			builder.append("id=");
			builder.append(this.id);
		}
		if (deleted != null)
		{
			builder.append("_deleted=");
			builder.append(this.deleted);
		}
		if (revision != null)
		{
			builder.append("_rev=");
			builder.append(this.revision);
		}
		return builder;
	}


	/**
	 * @param obj
	 * @param value
	 * @return
	 * @throws JSONException
	 */
	protected static String nullStringToNull(final JSONObject obj, final String value) throws JSONException
	{
		if (obj == null)
		{
			return null;
		}
		if (!obj.has(value))
		{
			return null;
		}
		if (obj.getString(value) == null)
		{
			return null;
		}
		if (obj.getString(value).equalsIgnoreCase("null"))
		{
			return null;
		}
		return obj.getString(value);
	}


	protected static BigDecimal prepareBigDecimal(final JSONObject obj, final String bigDecimalString) throws JSONException
	{
		if (!obj.isNull(bigDecimalString) && !obj.getString(bigDecimalString).equalsIgnoreCase("null"))
			return new BigDecimal(obj.getString(bigDecimalString));
		return null;
	}


	/**
	 * @param obj
	 * @param dateString
	 * @return
	 * @throws ParseException
	 * @throws JSONException
	 */
	protected static Date prepareDate(final JSONObject obj, final String dateString) throws ParseException, JSONException
	{
		if (!obj.isNull(dateString) || !obj.getString(dateString).equalsIgnoreCase("null"))
			return inputDf.parse(obj.getString(dateString));
		return null;
	}
}
