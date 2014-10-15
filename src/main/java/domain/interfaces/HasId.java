package domain.interfaces;


public interface HasId
{
	public String getId();

	public void setId(final String id);

	public Long getRevision();

	public void setRevision(final Long revision);

	public boolean isDeleted();

	public void setDeleted(final boolean deleted);

}
