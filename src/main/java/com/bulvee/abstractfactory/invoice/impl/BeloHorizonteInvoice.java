package com.bulvee.abstractfactory.invoice.impl;

import com.bulvee.abstractfactory.invoice.Invoice;

public class BeloHorizonteInvoice implements Invoice {
    @Override
    public void generate() {
        System.out.println("Calculating tax for Belo Horizonte state...");
    }
}
