package com.klenio.service;

import com.klenio.domain.InputParametersDictionary;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SignsDictionaryServiceTest extends TestCase {

    @Test
    public void getTableOfSigns_TrueTrueTrueTrue() {
        //given
        InputParametersDictionary inputParametersDictionary = new InputParametersDictionary(true, true, true, true);
        SignsDictionaryService signsDictionaryService = new SignsDictionaryService(inputParametersDictionary);

        //when
        List<Character> result = signsDictionaryService.getTableOfSigns();

        //then
        Assert.assertArrayEquals(new char[]{'a', 'Z', '0', '!'}, new char[]{result.get(0), result.get(1), result.get(2), result.get(3)});
      }

    @Test
    public void getTableOfSigns_FalseTrueTrueTrue() {
        //given
        InputParametersDictionary inputParametersDictionary = new InputParametersDictionary(false, true, true, true);
        SignsDictionaryService signsDictionaryService = new SignsDictionaryService(inputParametersDictionary);

        //when
        List<Character> result = signsDictionaryService.getTableOfSigns();

        //then
        Assert.assertArrayEquals(new char[]{'Z', '0', '!', 'Y'}, new char[]{result.get(0), result.get(1), result.get(2), result.get(3)});
    }

    @Test
    public void getTableOfSigns_FalseFalseTrueTrue() {
        //given
        InputParametersDictionary inputParametersDictionary = new InputParametersDictionary(false, false, true, true);
        SignsDictionaryService signsDictionaryService = new SignsDictionaryService(inputParametersDictionary);

        //when
        List<Character> result = signsDictionaryService.getTableOfSigns();

        //then
        Assert.assertArrayEquals(new char[]{'0', '!', '1', '#'}, new char[]{result.get(0), result.get(1), result.get(2), result.get(3)});
    }

    @Test
    public void getTableOfSigns_FalseFalseFalseTrue() {
        //given
        InputParametersDictionary inputParametersDictionary = new InputParametersDictionary(false, false, false, true);
        SignsDictionaryService signsDictionaryService = new SignsDictionaryService(inputParametersDictionary);

        //when
        List<Character> result = signsDictionaryService.getTableOfSigns();

        //then
        Assert.assertArrayEquals(new char[]{'!', '#', '$', '%'}, new char[]{result.get(0), result.get(1), result.get(2), result.get(3)});
    }

    @Test
    public void getTableOfSigns_FalseFalseFalseFalse() {
        //given
        InputParametersDictionary inputParametersDictionary = new InputParametersDictionary(false, false, false, false);
        SignsDictionaryService signsDictionaryService = new SignsDictionaryService(inputParametersDictionary);

        //when
        List<Character> result = signsDictionaryService.getTableOfSigns();

        //then
        Assert.assertArrayEquals(new int[]{0}, new int[]{result.size()});
    }
}