package domain.interfaces;

/**
 * 
 * @author gob
 * 
 */
public interface HasId
{
	public String getId();

	public Long getRevision();

	public Boolean isDeleted();

	public void setDeleted(final Boolean deleted);

	public void setId(final String id);

	public void setRevision(final Long revision);

}
