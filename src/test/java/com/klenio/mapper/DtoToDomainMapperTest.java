package com.klenio.mapper;

import com.klenio.domain.InputParametersDictionary;
import com.klenio.domain.InputParametersPassword;
import com.klenio.dto.InputParametersDto;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DtoToDomainMapperTest extends TestCase {

    @Test
    public void inputParametersDtoToInputParametersDictionary() {
        //given
        InputParametersDto inputParametersDto = new InputParametersDto("user name",
                "master password",
                "app name",
                "app address",
                16,
                true,
                false,
                true,
                false);
        DtoToDomainMapper dtoToDomainMapper = new DtoToDomainMapper();

        //when
        InputParametersDictionary inputParametersDictionary = dtoToDomainMapper.inputParametersDtoToInputParametersDictionary(inputParametersDto);

        //then
        Assert.assertTrue(inputParametersDictionary.isSmallLetters());
        Assert.assertFalse(inputParametersDictionary.isLargeLetters());
        Assert.assertTrue(inputParametersDictionary.isNumbers());
        Assert.assertFalse(inputParametersDictionary.isSpecialSigns());
    }

    @Test
    public void inputParametersDtoToInputParametersPassword() {
        InputParametersDto inputParametersDto = new InputParametersDto("user name",
                "master password",
                "app name",
                "app address",
                16,
                true,
                false,
                true,
                false);
        DtoToDomainMapper dtoToDomainMapper = new DtoToDomainMapper();

        //when
        InputParametersPassword inputParametersPassword = dtoToDomainMapper.inputParametersDtoToInputParametersPassword(inputParametersDto);

        //then
        Assert.assertArrayEquals(new String[]{"user name"}, new String[]{inputParametersPassword.getUserName()});
        Assert.assertArrayEquals(new String[]{"master password"}, new String[]{inputParametersPassword.getMasterPassword()});
        Assert.assertArrayEquals(new String[]{"app name"}, new String[]{inputParametersPassword.getAppName()});
        Assert.assertArrayEquals(new String[]{"app address"}, new String[]{inputParametersPassword.getAppAddress()});
        Assert.assertArrayEquals(new int[]{16}, new int[]{inputParametersPassword.getNumberOfSigns()});
    }
}