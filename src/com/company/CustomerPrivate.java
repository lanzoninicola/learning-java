package com.company;

public class CustomerPrivate extends Customer {

    String fiscalCode;

    public CustomerPrivate(int id, String name, String fiscalCode) {
        super(id, name);

        this.fiscalCode = fiscalCode;
    }


}
