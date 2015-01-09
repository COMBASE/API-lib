package domain;

public enum ReferenceType
{
	revision("updates"), uuid("id"), name("name"), number("number"), customerName("byName"), offset(
		"updates"), code("code"), page("page"), auth("auth");
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
