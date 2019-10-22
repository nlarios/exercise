package org.cochrane.exercise.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimeFactorization {

    public static Map<Integer, Integer> factorizeLoop(int number, List<Integer> primes) {
        Map<Integer, Integer> result = new HashMap<>();
        int i = 0;
        while ( number >= primes.get(i)) {
            if ( number % primes.get(i) == 0) {
                if(result.containsKey(primes.get(i))){
                    result.put(primes.get(i),result.get(primes.get(i))+1);
                }
                else {
                    result.put(primes.get(i),1);
                }
                number = number / primes.get(i);
            }
            else {
                i++;
            }
        }
        return result;
    }

    public static List<Integer> factorizeRecursion(int number, List<Integer> primes){
        return null;
    }
}
