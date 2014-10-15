package domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.interfaces.HasId;

public abstract class AbstractApiObject implements HasId, Serializable
{

	private static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

	public static abstract class ApiObjectBuilder<T extends HasId>
	{
		private String id = null;
		private boolean deleted = false;
		private Long revision = null;

		public ApiObjectBuilder<T> revision(final Long value)
		{
			this.revision = value;
			return this;
		}

		public ApiObjectBuilder<T> id(final String value)
		{
			id = value;
			return this;
		}

		public ApiObjectBuilder<T> deleted(final boolean value)
		{
			deleted = value;
			return this;
		}

		public void readJSON(final JSONObject obj) throws JSONException
		{
			id(obj.getString("uuid"));
			deleted(obj.getBoolean("deleted"));
			revision(obj.getLong("revision"));
		}

		public void writeJSON(final JSONObject obj, final T value) throws JSONException
		{
			obj.put("uuid", id);
			obj.put("deleted", deleted);
			obj.put("revision", revision);
		}

		public abstract T build();

		public T fromJSON(final JSONObject obj) throws JSONException
		{
			readJSON(obj);
			return this.build();
		}

		public JSONObject toJSON(final T value) throws JSONException
		{
			final JSONObject obj = new JSONObject();
			writeJSON(obj, value);
			return obj;
		}
	}

	private static final long serialVersionUID = 2033325648556071101L;

	private String id;

	private Long revision;

	private boolean deleted;

	public AbstractApiObject(final ApiObjectBuilder<? extends HasId> builder)
	{
		super();
		this.id = builder.id;
		this.revision = builder.revision;
		this.deleted = builder.deleted;
	}

	protected int hashCode(int result)
	{
		final int prime = 31;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result + ((this.revision == null) ? 0 : this.revision.hashCode());

		return result;
	}

	protected StringBuilder toString(final StringBuilder builder)
	{
		builder.append("_");
		builder.append(this.revision);
		return builder;
	}

	@Override
	public String getId()
	{
		return id;
	}

	@Override
	public void setId(final String id)
	{
		this.id = id;
	}

	@Override
	public Long getRevision()
	{
		return revision;
	}

	@Override
	public void setRevision(final Long revision)
	{
		this.revision = revision;
	}

	@Override
	public boolean isDeleted()
	{
		return deleted;
	}

	@Override
	public void setDeleted(final boolean deleted)
	{
		this.deleted = deleted;
	}

	public static SimpleDateFormat getInputdf()
	{
		return inputDf;
	}
}
