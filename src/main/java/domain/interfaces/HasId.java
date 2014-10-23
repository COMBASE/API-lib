package domain.interfaces;

/**
 * 
 * @author Unknown.
 * 
 *         According to latest archaeological excavation this interface may have already been
 *         implemented by the Maya.
 * 
 *         see also: http://de.wikipedia.org/wiki/Maya-Schrift
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
