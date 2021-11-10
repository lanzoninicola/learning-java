package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Main m = new Main();

        Customer mario = new CustomerCompany(1, "Mario Rossi", "303030303030");
        Customer mara = new CustomerPrivate(2, "Dioni Mara Malacarne", "d0303030303");

        List<Customer> customerList = new ArrayList<Customer>();

        customerList.add(mario);
        customerList.add(mara);

        List<Customer> customerMara = new ArrayList<Customer>();

        // customerList.forEach(() -> {
        //     System.out.println(customer.getName());
        // });


//        SumValues OrderTotals = ((a1, b1) -> a1 + b1);
//
//        int a = 8;
//        int b = 10;
//
//        OrderTotals.sum(8, 10);
//
//        Callable callMe = () -> {
//            System.out.println("Call me, please");
//            return "";
//        };


        // File f = new File("C:\\Users\\lanzo\\Documents\\Coding\\learning-java\\test.txt");
        // m.WriteToFile(f, "Mara malacarne");
    }

    private Runnable foo() {

        return new Runnable() {
            @Override
            public void run() {
                System.out.println("I am a runnable");
            }
        };
    }

    public void WriteToFile(File f, String text) {

        FileWriter fw = null;
        BufferedWriter bw =
                null;
        try {
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);

            if (f.exists()) {
                System.out.println("The file already exists, do you want overwrite the file (y/Y)");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                Integer c = bufferedReader.read();

                // Y or y
                if (c.equals(89) || c.equals(121)) {
                    bw.write(text);
                }

                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void makeOrder() {

        Product tv = new Product(1, "Television", 150);
        Product smartphone = new Product(2, "Samsung A51", 210.99);
        Product pc = new Product(3, "Super computer", 457.75);

        Customer mario = new CustomerCompany(1, "Mario Rossi", "303030303030");
        Customer mara = new CustomerPrivate(2, "Dioni Mara Malacarne", "d0303030303");


        Order marioOrder = new Order(1, mario);
        marioOrder.addProduct(tv, 1);
        marioOrder.addProduct(pc, 2);

        marioOrder.printOrderSummary();

        Order maraOrder = new Order(2, mara);
        maraOrder.addProduct(smartphone, 1);

        maraOrder.printOrderSummary();
    }
}
