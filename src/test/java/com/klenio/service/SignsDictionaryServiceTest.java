package com.klenio.service;

import com.klenio.domain.InputParametersDictionary;
import com.klenio.exception.EmptyDictionaryException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SignsDictionaryServiceTest extends TestCase {

    @Test
    public void getTableOfSigns_TrueTrueTrueTrue() throws EmptyDictionaryException {
        //given
        InputParametersDictionary inputParametersDictionary = new InputParametersDictionary(true, true, true, true);
        SignsDictionaryService signsDictionaryService = new SignsDictionaryService(inputParametersDictionary);

        //when
        List<Character> result = signsDictionaryService.getTableOfSigns();

        //then
        Assert.assertArrayEquals(new char[]{'a', 'Z', '0', '!'}, new char[]{result.get(0), result.get(1), result.get(2), result.get(3)});
      }

    @Test
    public void getTableOfSigns_FalseTrueTrueTrue() throws EmptyDictionaryException {
        //given
        InputParametersDictionary inputParametersDictionary = new InputParametersDictionary(false, true, true, true);
        SignsDictionaryService signsDictionaryService = new SignsDictionaryService(inputParametersDictionary);

        //when
        List<Character> result = signsDictionaryService.getTableOfSigns();

        //then
        Assert.assertArrayEquals(new char[]{'Z', '0', '!', 'Y'}, new char[]{result.get(0), result.get(1), result.get(2), result.get(3)});
    }

    @Test
    public void getTableOfSigns_FalseFalseTrueTrue() throws EmptyDictionaryException {
        //given
        InputParametersDictionary inputParametersDictionary = new InputParametersDictionary(false, false, true, true);
        SignsDictionaryService signsDictionaryService = new SignsDictionaryService(inputParametersDictionary);

        //when
        List<Character> result = signsDictionaryService.getTableOfSigns();

        //then
        Assert.assertArrayEquals(new char[]{'0', '!', '1', '#'}, new char[]{result.get(0), result.get(1), result.get(2), result.get(3)});
    }

    @Test
    public void getTableOfSigns_FalseFalseFalseTrue() throws EmptyDictionaryException {
        //given
        InputParametersDictionary inputParametersDictionary = new InputParametersDictionary(false, false, false, true);
        SignsDictionaryService signsDictionaryService = new SignsDictionaryService(inputParametersDictionary);

        //when
        List<Character> result = signsDictionaryService.getTableOfSigns();

        //then
        Assert.assertArrayEquals(new char[]{'!', '#', '$', '%'}, new char[]{result.get(0), result.get(1), result.get(2), result.get(3)});
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getTableOfSigns_FalseFalseFalseFalse() throws EmptyDictionaryException {
        //given
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Dictionary is empty");
        InputParametersDictionary inputParametersDictionary = new InputParametersDictionary(false, false, false, false);


        //when
        SignsDictionaryService signsDictionaryService = new SignsDictionaryService(inputParametersDictionary);

        //then

    }
}