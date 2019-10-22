package org.cochrane.exercise.problems;

public class CochraneParser {
    public static boolean parser(String sentence) {
        String first = sentence.substring(0, 1);
        String sub = sentence.substring(1);
        if (first.equals("N")) {
           return parser(sub);
        }
        else if (first.equals("C") || first.equals("D")
                || first.equals("E") || first.equals("I") ) {

            for (int i = 1; i <=sub.length(); i++){
                String firstHalf = sub.substring(0,i);
                String secondHalf = sub.substring(i);
                if(parser(firstHalf) && parser(secondHalf)){
                    return true;
                }
            }
            return false;
        }
        else if(sentence.matches("N[p-z]")){
            return true;
        }
        else if(sentence.matches("[p-z]"))   {
            return true;
        }
        else {
            return false;
        }
    }
}
