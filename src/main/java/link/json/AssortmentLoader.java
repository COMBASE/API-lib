package link.json;

import domain.Assortment;
import domain.DataType;

/**
 * 
 * @author mas
 * 
 */
public class AssortmentLoader extends HasNameJsonLoader<Assortment>
{
	public AssortmentLoader(final String cloudUrl, final String token)
	{
		super(DataType.assortment, cloudUrl, token);
	}

	@Override
	public Assortment.Builder getBuilder()
	{
		return new Assortment.Builder();
	}

}
