package domain;


public enum DataType
{
	assortment("assortments"), cashier("cashiers"), commodityGroup("commodityGroups"), currency(
		"currencies"), customer("customers"), customergroup("customergroups"), dispatchnotification(
		"dispatchnotifications"), economicZone("economicZones"), infotext("infotexts"), price(
		"prices"), product("products"), receipt("rceipts"), sale("sales"), sector("sectors"), stockorder(
		"stockorders"), supplier("suppliers"), tag("tags"), tax("taxes"), timeTrackingEntity(
		"timeTrackingEntities"), timeTracking("timeTrackings"), user("users");
	private final String reference;

	DataType(String s)
	{
		this.reference = s;
	}

	public String getReference()
	{
		return reference;
	}
}
