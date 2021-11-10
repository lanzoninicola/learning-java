package com.company;

public class CustomerCompany extends Customer {

    String vat;

    public CustomerCompany(int id, String name, String vat) {
        super(id, name);

        this.vat = vat;
    }
}
