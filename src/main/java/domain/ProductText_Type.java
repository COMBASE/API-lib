package domain;


public enum ProductText_Type
{
	description("ARTICLETEXT_DESCRIPTION"), nutritionals("ARTICLETEXT_NUTRITIONAL_VALUE"), ingredients(
		"ARTICLETEXT_INGREDIENTS"), allergens("ARTICLETEXT_ALLERGENS"), receiptDescription("ARTICLETEXT_RECEIPT_TEXT"),
		manual("ARTICLETEXT_MANUAL"), orderText("ARTICLETEXT_ORDER_TEXT"), careInstructions("ARTICLETEXT_CARE_INSTRUCTIONS"),
		recipe("ARTICLETEXT_RECIPE"), certificate("ARTICLETEXT_CERTIFICATE"), warrantyText("ARTICLETEXT_WARRANTY_TEXT"),
		infoUrl("ARTICLETEXT_INFO_URL");
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
