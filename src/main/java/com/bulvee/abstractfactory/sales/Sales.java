package com.bulvee.abstractfactory.sales;

import com.bulvee.abstractfactory.invoice.Invoice;
import com.bulvee.abstractfactory.ticket.Ticket;

public class Sales {

    private final Invoice invoice;
    private final Ticket ticket;

    public Sales(SalesModuleFactory salesModuleFactory){
        invoice = salesModuleFactory.createInvoice();
        ticket = salesModuleFactory.createTicket();
    }

    public void make(){
        invoice.generate();
        ticket.generate();
    }
}
