package error;

public enum ErrorMessages
{

	Invalid_Token("Invalid Token"), No_object_found_for_id("No object found for id"), Input_List_is_empty_or_invalid(
		"Input List is empty or invalid"), No_saving_permitted_for_this_type(
		"No saving permitted for this type"), Deleting_is_prohibited_for_Object(
		"Deleting is prohibited for Object"), Object_is_write_protected("Object is write-protected"), No_Object_found_for_name(
		"No Object found for name"), No_object_found_for_number("No object found for number"), articlecode_must_be_unique(
		"articlecode must be unique"), No_object_found_for_revision("No object found for revision"), No_object_found_for_day(
		"No object found for day"), No_Financial_Accounting_Package(
		"No Financial Accounting Package active"), Code_not_found_for_Price(
									"Code not found for Price"), Invalid_UUID_string("Invalid UUID string"), Object_either_deleted_or_not_found(
										"Object either deleted or not found"), No_Valid_UUID_for_PaymentMethod(
		"No Valid UUID for PaymentMethod");

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
