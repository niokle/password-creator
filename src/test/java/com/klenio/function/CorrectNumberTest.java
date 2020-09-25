package com.klenio.function;

import org.junit.Assert;
import org.junit.Test;

import static com.klenio.function.CorrectNumber.getCorrectNumber;

public class CorrectNumberTest {

    @Test
    public void getCorrectNumberTest1() {
        //given
        int value = 0;
        int maxNumberOfElements = 10;

        //when
        int result = getCorrectNumber(value, maxNumberOfElements);

        //then
        Assert.assertEquals(0, result);
    }

    @Test
    public void getCorrectNumberTest2() {
        //given
        int value = 5;
        int maxNumberOfElements = 10;

        //when
        int result = getCorrectNumber(value, maxNumberOfElements);

        //then
        Assert.assertEquals(5, result);
    }

    @Test
    public void getCorrectNumberTest3() {
        //given
        int value = 10;
        int maxNumberOfElements = 10;

        //when
        int result = getCorrectNumber(value, maxNumberOfElements);

        //then
        Assert.assertEquals(0, result);
    }

    @Test
    public void getCorrectNumberTest4() {
        //given
        int value = 11;
        int maxNumberOfElements = 10;

        //when
        int result = getCorrectNumber(value, maxNumberOfElements);

        //then
        Assert.assertEquals(1, result);
    }

    @Test
    public void getCorrectNumberTest5() {
        //given
        int value = 15;
        int maxNumberOfElements = 10;

        //when
        int result = getCorrectNumber(value, maxNumberOfElements);

        //then
        Assert.assertEquals(5, result);
    }

    @Test
    public void getCorrectNumberTest6() {
        //given
        int value = 20;
        int maxNumberOfElements = 10;

        //when
        int result = getCorrectNumber(value, maxNumberOfElements);

        //then
        Assert.assertEquals(0, result);
    }
}