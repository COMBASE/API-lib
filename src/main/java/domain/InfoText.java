package domain;



public class InfoText
{
	private final String text;
	private String number = null;
	private final InfoTextType type;

	public InfoText(final String text, final InfoTextType type)
	{
		this.text = text;
		this.type = type;
	}

	public InfoText(final String number, final String text, final InfoTextType type)
	{
		this.number = number;
		this.text = text;
		this.type = type;
	}

// public JSONObject toJSON()
// {
// try
// {
// final JSONObject obj = new JSONObject();
// obj.put("text", text);
// if (number != null)
// obj.put("number", number);
// obj.put("type", type.name());
// return obj;
// }
// catch (final JSONException e)
// {
// e.printStackTrace();
// return null;
// }
// }
//
// public boolean post()
// {
// return CloudLink.getConnector().postData(DataType.infotext, this.toJSON());
// }

	@Override
	public boolean equals(final Object obj)
	{

		return obj.hashCode() == this.hashCode();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = prime * result + ((this.number == null) ? 0 : this.number.hashCode());
		result = prime * result + ((this.text == null) ? 0 : this.text.hashCode());
		result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());


		return result;
	}
}
