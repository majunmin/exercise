package com.mjm.java8.future.example;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * 商店返回的字符串解析操作
 * @author majunmin
 * @description
 * @datetime 2020/5/12 5:10 下午
 * @since
 */
@Getter
public class Quote {

    private final String shopName;
    private final double price;
    private final Discount.Code discountCode;

    public Quote(String shopName, double price, Discount.Code discountCode) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = discountCode;
    }

    public static Quote parse(String s){
        String[] splits = StringUtils.split(s, ":");
        String shopName = splits[0];
        Double price = Double.parseDouble(splits[1]);
        Discount.Code discountCode = Discount.Code.valueOf(splits[2]);
        return new Quote(shopName, price, discountCode);
    }
}
