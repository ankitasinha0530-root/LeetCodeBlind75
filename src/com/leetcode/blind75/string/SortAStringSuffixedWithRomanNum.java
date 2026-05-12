package com.practice.leetcode.blind75.string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortAStringSuffixedWithRomanNum {

    public static void main(String[] args) {

        String[] romanNames = {"Steven XL", "Steven XVI", "David IX", "Mary XV", "Mary XIII", "Mary XX"};

        String[] romanNames1 = {"Ankita I", "Ankita IX", "Ankita V", "Aravind VI", "Aravind IV"};

        List<RomanName> romanNameList = new ArrayList<RomanName>();
//		for(String romanName: romanNames){
        for (String romanName : romanNames1) {

            String[] splitedRomanName = romanName.split(" ");
            String name = splitedRomanName[0];
            String romanNumber = splitedRomanName.length > 1 ? splitedRomanName[1] : "";
            int decimalNumber = splitedRomanName.length > 1 ? romanToDecimal(romanNumber) : 0;

            RomanName roman = new RomanName();
            roman.setName(name);
            roman.setRomanNumber(romanNumber);
            roman.setDecimalNumber(decimalNumber);
            romanNameList.add(roman);
        }
        romanNameList.sort(Comparator.comparing(RomanName::getName)
                .thenComparing(RomanName::getDecimalNumber));
        for (RomanName name : romanNameList) {
            System.out.println(name.getName() + " " + name.getRomanNumber());
        }

    }

    public static int romanToDecimal(String romanNumber) {
        int decimal = 0;
        int lastNumber = 0;
        String romanNumeral = romanNumber.toUpperCase();
	    /* operation to be performed on upper cases even if user 
	       enters roman values in lower case chars */
        for (int x = romanNumeral.length() - 1; x >= 0; x--) {
            char convertToDecimal = romanNumeral.charAt(x);

            switch (convertToDecimal) {
                case 'M':
                    decimal = processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;

                case 'D':
                    decimal = processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;

                case 'C':
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;

                case 'L':
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;

                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;

                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;

                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
            }
        }
        // System.out.println(decimal);
        return decimal;
    }

    public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }

}

class RomanName {
    String Name;
    String romanNumber;
    long decimalNumber;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRomanNumber() {
        return romanNumber;
    }

    public void setRomanNumber(String romanNumber) {
        this.romanNumber = romanNumber;
    }

    public long getDecimalNumber() {
        return decimalNumber;
    }

    public void setDecimalNumber(long decimalNumber) {
        this.decimalNumber = decimalNumber;
    }
}