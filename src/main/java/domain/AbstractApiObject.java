package domain;

import java.io.Serializable;
import java.util.List;

import domain.interfaces.HasJSON;
import domain.interfaces.IsPostable;

public abstract class AbstractApiObject implements Serializable, HasJSON<AbstractApiObject>,
	IsPostable
{
	private static final long serialVersionUID = 2033325648556071101L;

	private String id;

	private Long revision;

	private boolean deleted;

	public AbstractApiObject(final ApiObjectBuilder builder)
	{
		super();
		this.id = builder.id;
		this.revision = builder.revision;
		this.deleted = builder.deleted;
	}

	public static abstract class ApiObjectBuilder
	{
		private String id = null;
		private boolean deleted;
		private Long revision;

		public ApiObjectBuilder revision(final Long value)
		{
			this.revision = value;
			return this;
		}

		public ApiObjectBuilder id(final String value)
		{
			id = value;
			return this;
		}

		public ApiObjectBuilder deleted(final boolean value)
		{
			deleted = value;
			return this;
		}

		public abstract AbstractApiObject build();
	}

	@Override
	public abstract int hashCode();

	@Override
	public abstract String toString();

	public abstract void postList(final List<AbstractApiObject> list, final int limit);

	public abstract DataType getType();

	public String getId()
	{
		return id;
	}

	public void setId(final String id)
	{
		this.id = id;
	}

	public Long getRevision()
	{
		return revision;
	}

	public void setRevision(final Long revision)
	{
		this.revision = revision;
	}

	public boolean isDeleted()
	{
		return deleted;
	}

	public void setDeleted(final boolean deleted)
	{
		this.deleted = deleted;
	}
}
