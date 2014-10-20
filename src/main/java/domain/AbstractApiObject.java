package domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.interfaces.HasId;

public abstract class AbstractApiObject<T extends AbstractApiObject<?>> implements HasId,
	Serializable
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

	protected static final SimpleDateFormat inputDf = new SimpleDateFormat(
		"yyyy-MM-dd'T'HH:mm:ssXXX");

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

	public abstract T fromJSON(final JSONObject obj) throws JSONException;

// public AbstractApiObject fromJSON(final JSONObject obj) throws JSONException
// {
// readJSON(obj);
// return this;
// }

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

	protected int hashCode(int result)
	{
		final int prime = 31;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result + ((this.revision == null) ? 0 : this.revision.hashCode());
		result = prime * result + ((this.deleted == null) ? 0 : this.deleted.hashCode());

		return result;
	}

	@Override
	public Boolean isDeleted()
	{
		return deleted;
	}

	public void readJSON(final JSONObject obj) throws JSONException
	{
		if (obj.has("uuid") && !obj.get("uuid").equals(null))
			setId(obj.getString("uuid"));
		if (obj.has("deleted") && !obj.get("deleted").equals(null))
			setDeleted(Boolean.valueOf(obj.getBoolean("deleted")));
		if (obj.has("revision") && !obj.get("revision").equals(null))
			setRevision(Long.valueOf(obj.getLong("revision")));
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

	public abstract JSONObject toJSON(final T value) throws JSONException;

// public JSONObject toJSON(final AbstractApiObject value) throws JSONException
// {
// final JSONObject obj = new JSONObject();
// writeJSON(obj, value);
// return obj;
// }

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

	public void writeJSON(final JSONObject obj, final T value) throws JSONException
	{
		obj.put("uuid", id);
		obj.put("deleted", deleted);
		obj.put("revision", revision);
	}
}
