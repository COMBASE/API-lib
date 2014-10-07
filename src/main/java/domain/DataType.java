package domain;

public enum DataType
{
	account("accounts"), accountTransaction("accountTransactions"), assortment("assortments"), cashier(
		"cashiers"), commodityGroup("commodityGroups"), currency("currencies"), customer(
		"customers"), customergroup("customerGroups"), dispatchnotification("dispatchnotifications"), economicZone(
		"economicZones"), infotext("infotexts"), organizationalUnit("organizationalUnits"), payment(
		"payments"), paymentMethod("paymentMethods"), priceList("priceLists"), product("products"), receipt(
		"receipts"), sale("sales"), sector("sectors"), stockorder("stockorders"), supplier(
		"suppliers"), tag("tags"), tax("taxes"), timeTrackingEntity("timeTrackingEntities"), timeTracking(
		"timeTrackings"), user("users"), pos("pos"), fullReceipt("fullReceipts"), posBalance(
		"posBalances"), inventory("inventories"), inventoryReceipt("inventoryReceipts"), inventoryReceiptItem(
		"inventoryReceiptItems");
	private final String reference;

	DataType(final String s)
	{
		this.reference = s;
	}

	public String getReference()
	{
		return reference;
	}
}
