package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNameJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.Tag;
import domain.enums.DataType;

public class TagLoader extends AbstractHasNameJsonLoader<Tag>
{

	public TagLoader(final CloudLink cloudLink)
	{
		super(DataType.tag, cloudLink);
	}

	@Override
	public JSONObject toJSON(final Tag value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}

	@Override
	public Tag fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final Tag tag = Tag.fromJSON(obj);
		return tag;
	}

}
