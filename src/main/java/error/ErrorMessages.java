package error;

public enum ErrorMessages
{

	Invalid_Token("Invalid Token"), No_object_found_for_id("No object found for id"), Input_List_is_empty_or_invalid(
		"Input List is empty or invalid"), No_saving_permitted_for_this_type(
			"No saving permitted for this type"), Deleting_is_prohibited_for_Object(
		"Deleting is prohibited for Object"), Object_is_write_protected("Object is write-protected"), No_Object_found_for_name(
					"No Object found for name"), No_object_found_for_number("No object found for number"), articlecode_must_be_unique(
		"articlecode must be unique "), No_product_found_for_code("No product found for code");

	private final String errorString;

	ErrorMessages(final String s)
	{
		this.errorString = s;
	}

	public String getErrorString()
	{
		return errorString;
	}

}
