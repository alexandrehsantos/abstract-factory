package com.bulvee.abstractfactory.sales.impl;

import com.bulvee.abstractfactory.invoice.Invoice;
import com.bulvee.abstractfactory.sales.SalesModuleFactory;
import com.bulvee.abstractfactory.ticket.Ticket;

import java.io.IOException;
import java.util.Properties;

public class StoreFactory implements SalesModuleFactory {
    private final Properties properties;

    public StoreFactory(String pathResources) {
        properties = this.loadProp(pathResources);
    }

    @Override
    public Invoice createInvoice() {
        String calassInvoice = this.properties.getProperty("invoice");
        Invoice invoice = null;
        try {
            invoice = (Invoice) Class.forName(calassInvoice).newInstance();
        } catch (Exception e) {
            System.out.println("Fail to load configuration properties for invoice.");
        }
        return invoice;
    }

    @Override
    public Ticket createTicket() {
        String classTicket = this.properties.getProperty("ticket");
        Ticket ticket = null;
        try {
            ticket = (Ticket) Class.forName(classTicket).newInstance();
        } catch (Exception e) {
            System.out.println("Fail to load configuration properties for ticket.");
        }
        return ticket;
    }


    private Properties loadProp(String pathResources) {
        Properties prop = null;
        try {
            prop = new Properties();
            prop.load(this.getClass().getResourceAsStream(pathResources));
        } catch (IOException e) {
            System.out.println("Fail to load configuration properties");
            e.printStackTrace();
        }
        return prop;
    }

}
