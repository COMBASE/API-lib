package link.json.loader;

import java.text.ParseException;

import link.CloudLink;
import link.json.AbstractHasNumberJsonLoader;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import domain.User;
import domain.enums.DataType;

public class UserLoader extends AbstractHasNumberJsonLoader<User>
{
	public UserLoader(final CloudLink cloudLink)
	{
		super(DataType.user, cloudLink);
	}

	@Override
	public JSONObject toJSON(final User value) throws JSONException
	{
		final JSONObject obj = value.toJSON();
		return obj;
	}

	@Override
	public User fromJSON(final JSONObject obj) throws JSONException, ParseException
	{
		final User user = User.fromJSON(obj);
		return user;
	}


}
