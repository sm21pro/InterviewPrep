package com.srikanth.interviews.FacebookExercises;

public class StringAddition {

    public static void main(String[] args) {
        System.out.println(new StringAddition().addStrings("23", "322"));
        System.out.println(new StringAddition().addStrings("0", "0"));
        System.out.println(new StringAddition().addStrings("1", "9"));
        System.out.println(new StringAddition().addStrings("9133", "0"));
    }

    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            num1 = normalize(num1, num2.length());
        } else {
            num2 = normalize(num2, num1.length());
        }

        int carry = 0;
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        String result = "";

        for (int i = 0; i < num1.length(); i++) {
            int sum = (int) (num1.charAt(i) - '0') + (int) (num2.charAt(i) - '0') + carry;
            result += (char) (sum % 10 + '0');
            carry = sum / 10;
        }

        if (carry > 0) {
            result += (char) (carry + '0');
        }
        return new StringBuilder(result).reverse().toString();


    }


    static String normalize(String num, int length) {
        int prefixes = length - num.length();
        for (int i = 0; i < prefixes; i++) {
            num = "0" + num;
        }

        return num;
    }

}
