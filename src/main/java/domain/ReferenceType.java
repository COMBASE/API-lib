package domain;

public enum ReferenceType
{
	revision("updates"), uuid("id"), name("name"), number("number"), customerName("byName"), offset(
		"updates");
	private final String reference;

	ReferenceType(final String s)
	{
		this.reference = s;
	}

	public String getType()
	{
		return reference;
	}
}
