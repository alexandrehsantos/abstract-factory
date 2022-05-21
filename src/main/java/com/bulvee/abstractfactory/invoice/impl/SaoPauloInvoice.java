package com.bulvee.abstractfactory.invoice.impl;

import com.bulvee.abstractfactory.invoice.Invoice;

public class SaoPauloInvoice implements Invoice {

    @Override
    public void generate() {
        System.out.println("Calculating tax for São Paulo State...");
    }
}
