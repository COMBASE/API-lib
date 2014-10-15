package link.json;

import domain.DataType;
import domain.Product;

public class ProductLoader
{

	public ProductLoader(final String cloudUrl, final String token)
	{
		super(DataType.assortment, cloudUrl, token);
	}

	@Override
	public Product.Builder getBuilder()
	{
		return new Product.Builder();
	}


}
