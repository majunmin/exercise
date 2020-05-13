
package com.mjm.java8.future.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
public class Shop {

    private String name;


    public String getPrice(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[
                new Random().nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    private double calculatePrice(String product) {
        delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

        private static void delay() {
                try {
                        TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
        }


}