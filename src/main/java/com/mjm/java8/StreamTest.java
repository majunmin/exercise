package com.mjm.java8;

import java.math.BigInteger;
import java.util.stream.Stream;

public class StreamTest {

    private static BigInteger ONE = new BigInteger("1", 10);

    private static BigInteger TWO = new BigInteger("2", 10);

    public static void main(String[] args) {

        primes().map(p -> TWO.pow(p.intValue()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);
    }


    static Stream<BigInteger> primes(){
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
}
