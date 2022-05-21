package com.bulvee.abstractfactory.sales;


import com.bulvee.abstractfactory.invoice.Invoice;
import com.bulvee.abstractfactory.ticket.Ticket;

public interface SalesModuleFactory {

    Invoice createInvoice();

    Ticket createTicket();
}
