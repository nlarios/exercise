package org.cochrane.exercise.main;


import org.cochrane.exercise.problems.PrimeFactorization;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ExerciseMain {



    public static String readFileAsString(String fileName)throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void main(String[] args) {

        List<Integer> primes = new ArrayList<>();
        String primeFile = null;
        try {
            primeFile = readFileAsString("primes.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        primeFile = primeFile.replaceAll("\\r\\n|\\r|\\n", " ");
        String[] primeStrings = primeFile.split(" ");
        for (String s : primeStrings) {
            primes.add(Integer.parseInt(s));
            System.out.println(s);
        }

        String input = "";
        while (!input.equals("exit")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your nationality: ");
            input = scanner.nextLine();
            Integer number = Integer.parseInt(input);
            Map<Integer,Integer> result = PrimeFactorization.factorizeLoop(number, primes);

            //Reverse map order and print
            ArrayList<Integer> keys = new ArrayList<Integer>(result.keySet());
            for(int i=keys.size()-1; i>=0;i--){
                System.out.print(keys.get(i) + "^" + result.get(keys.get(i))  + " ");
            }
//            result.entrySet().stream()
//                    .forEach( (entry)-> System.out.print(entry.getKey() + "^" + entry.getValue() + " "));
//            System.out.println();
        }


    }
}
