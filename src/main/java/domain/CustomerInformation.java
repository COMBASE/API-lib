package domain;

import java.util.Date;

public class CustomerInformation
{
	private String text;

	private String creatorName;

	private Date date;

	public CustomerInformation(final String text, final String creatorName, final Date date)
	{
		this.text = text;
		this.creatorName = creatorName;
		this.date = date;
	}

	public String getCreatorName()
	{
		return creatorName;
	}

	public Date getDate()
	{
		return date;
	}

	public String getText()
	{
		return text;
	}

	public void setCreatorName(final String creatorName)
	{
		this.creatorName = creatorName;
	}

	public void setDate(final Date date)
	{
		this.date = date;
	}

	public void setText(final String text)
	{
		this.text = text;
	}
}
