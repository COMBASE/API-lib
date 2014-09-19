package domain;

import java.util.Date;
import java.util.List;

public class StockOrder
{
	private final Date requiredFrom;
	private final Date requiredTo;
	private final Date pickUpDate;
	private final Date autoFinalization;
	private final Boolean autoSend;
	private final Date posFinalizationTime;
	private final Date dispatchNotificationCreationTime;
	private final Date stockReceiptCreationTime;
	private final Date stockReceiptFinalizationTime;
	private final Date returnCreationTime;
	private final Date bookingTime;
	private final Date createTime;

	private final Boolean send;

	private final String currency;
	private final String specialOfferCode;
	private final String bookedBy;
	private final String createdBy;
	private final String target;
	private final String supplier;
	private final String source;
	private final String description;
	private final List<StockOrderItem> items;

	public StockOrder(final Builder builder)
	{
		requiredFrom = builder.requiredFrom;
		requiredTo = builder.requiredTo;
		pickUpDate = builder.pickUpDate;
		autoFinalization = builder.autoFinalization;
		autoSend = builder.autoSend;
		posFinalizationTime = builder.posFinalizationTime;
		dispatchNotificationCreationTime = builder.dispatchNotificationCreationTime;
		stockReceiptCreationTime = builder.stockReceiptCreationTime;
		stockReceiptFinalizationTime = builder.stockReceiptFinalizationTime;
		returnCreationTime = builder.returnCreationTime;
		bookingTime = builder.bookingTime;
		createTime = builder.createTime;

		send = builder.send;

		currency = builder.currency;
		specialOfferCode = builder.specialOfferCode;
		bookedBy = builder.bookedBy;
		createdBy = builder.createdBy;
		target = builder.target;
		supplier = builder.supplier;
		source = builder.source;
		description = builder.description;
		items = builder.items;
	}

	public static class Builder
	{
		private Date requiredFrom = null;
		private Date requiredTo = null;
		private Date pickUpDate = null;
		private Date autoFinalization = null;
		private Boolean autoSend = null;
		private Date posFinalizationTime = null;
		private Date dispatchNotificationCreationTime = null;
		private Date stockReceiptCreationTime = null;
		private Date stockReceiptFinalizationTime = null;
		private Date returnCreationTime = null;
		private Date bookingTime = null;
		private Date createTime = null;

		private Boolean send = null;

		private String currency = null;
		private String specialOfferCode = null;
		private String bookedBy = null;
		private String createdBy = null;
		private String target = null;
		private String supplier = null;
		private String source = null;
		private String description = null;
		private List<StockOrderItem> items = null;

		public Builder requiredFrom(final Date value)
		{
			this.requiredFrom = value;
			return this;
		}

		public Builder requiredTo(final Date value)
		{
			this.requiredTo = value;
			return this;
		}

		public Builder pickUpDate(final Date value)
		{
			this.pickUpDate = value;
			return this;
		}

		public Builder autoFinalization(final Date value)
		{
			this.autoFinalization = value;
			return this;
		}

		public Builder autoSend(final Boolean value)
		{
			this.autoSend = value;
			return this;
		}

		public Builder posFinalizationTime(final Date value)
		{
			this.posFinalizationTime = value;
			return this;
		}

		public Builder dispatchNotificationCreationTime(final Date value)
		{
			this.dispatchNotificationCreationTime = value;
			return this;
		}

		public Builder stockReceiptCreationTime(final Date value)
		{
			this.stockReceiptCreationTime = value;
			return this;
		}

		public Builder stockReceiptFinalizationTime(final Date value)
		{
			this.stockReceiptFinalizationTime = value;
			return this;
		}

		public Builder returnCreationTime(final Date value)
		{
			this.returnCreationTime = value;
			return this;
		}

		public Builder bookingTime(final Date value)
		{
			this.bookingTime = value;
			return this;
		}

		public Builder createTime(final Date value)
		{
			this.createTime = value;
			return this;
		}

		public Builder send(final Boolean value)
		{
			this.send = value;
			return this;
		}

		public Builder currency(final String value)
		{
			this.currency = value;
			return this;
		}

		public Builder specialOfferCode(final String value)
		{
			this.specialOfferCode = value;
			return this;
		}

		public Builder bookedBy(final String value)
		{
			this.bookedBy = value;
			return this;
		}

		public Builder createdBy(final String value)
		{
			this.createdBy = value;
			return this;
		}

		public Builder target(final String value)
		{
			this.target = value;
			return this;
		}

		public Builder supplier(final String value)
		{
			this.supplier = value;
			return this;
		}

		public Builder source(final String value)
		{
			this.source = value;
			return this;
		}

		public Builder description(final String value)
		{
			this.description = value;
			return this;
		}

		public Builder items(final List<StockOrderItem> value)
		{
			this.items = value;
			return this;
		}
	}


}
