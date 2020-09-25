package com.klenio.function;

public class CorrectNumber {
    public static int getCorrectNumber(int number, int maxNumber) {
        return number%maxNumber == 0 ? maxNumber : number%maxNumber;
    }
}
