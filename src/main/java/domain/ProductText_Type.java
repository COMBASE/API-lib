package domain;


public enum ProductText_Type
{
	description("ARTICLETEXT_DESCRIPTION"), nutritionals("ARTICLETEXT_NUTRITIONAL_VALUE"), ingredients(
		"ARTICLETEXT_INGREDIENTS"), allergens("ARTICLETEXT_ALLERGENS");
	private final String reference;

	ProductText_Type(String s)
	{
		this.reference = s;
	}

	public String getReference()
	{
		return reference;
	}
	
	
}
