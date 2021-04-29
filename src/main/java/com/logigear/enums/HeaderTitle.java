package com.logigear.enums;

public enum HeaderTitle {

    ID("No."),
    DEPART_STATION("Depart Station"),
    ARRIVE_STATION("Arrive Station"),
    SEAT_TYPE("Seat Type"),
    DEPART_DATE("Depart Date"),
    BOOK_DATE("Book Date"),
    EXPIRED_DATE("Expired Date"),
    STATUS("Status"),
    TICKET_AMOUNT("Amount"),
    TOTAL_PRICE("Total Price"),
    OPERATION("Operation");

    public final String value;

    HeaderTitle(String value) {
        this.value = value;
    }

}
