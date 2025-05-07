package com.ramy.costmanagement1.Entity;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Notification {
    /*
    * Invoice Due Reminder SDK
 Functionality: Notify clients of upcoming or overdue invoices.
 Inputs: Invoice ID, due date, client contact details.
 Outputs: Notification object (email, SMS, in-app)
 * */
 
 
 private Long invoiceId;
 private String clientEmail;
 private LocalDateTime dueDate;
 
 
}
