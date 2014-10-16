package domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import domain.interfaces.HasId;

public abstract class AbstractApiObject implements HasId, Serializable
{

	private static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

	private static final long serialVersionUID = 2033325648556071101L;

	private String id;

	private Long revision;

	private boolean deleted;


	protected static abstract class Init<T extends Init<T>>
	{
		private String id;

		private Long revision;

		private boolean deleted;

		protected abstract T self();

		public T revision(final Long value)
		{
			this.revision = value;
			return self();
		}

		public T id(final String value)
		{
			id = value;
			return self();
		}

		public T deleted(final boolean value)
		{
			deleted = value;
			return self();
		}

		public abstract AbstractApiObject build();
	}

// public void readJSON(final JSONObject obj) throws JSONException
// {
// id(obj.getString("uuid"));
// deleted(obj.getBoolean("deleted"));
// revision(obj.getLong("revision"));
// }
//
// public void writeJSON(final JSONObject obj, final T value) throws JSONException
// {
// obj.put("uuid", id);
// obj.put("deleted", deleted);
// obj.put("revision", revision);
// }
//
// public T fromJSON(final JSONObject obj) throws JSONException
// {
// readJSON(obj);
// return this.build();
// }
//
// public JSONObject toJSON(final T value) throws JSONException
// {
// final JSONObject obj = new JSONObject();
// writeJSON(obj, value);
// return obj;
// }

	public static abstract class Builder extends Init<Builder>
	{

		@Override
		protected Builder self()
		{
			return this;
		}

		@Override
		public abstract AbstractApiObject build();
	}


	public AbstractApiObject(final Init<?> init)
	{
		super();
		this.id = init.id;
		this.revision = init.revision;
		this.deleted = init.deleted;
	}

	protected int hashCode(int result)
	{
		final int prime = 31;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result + ((this.revision == null) ? 0 : this.revision.hashCode());
		result = prime * result + ((this.deleted) ? 1 : 0);

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
