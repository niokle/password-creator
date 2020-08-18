package com.klenio.converter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PolishLettersConverterTest {

    @Test
    public void convert() {
        //given
        String input = "Śruba, żyrafa, ręka. Życie, świcie, ćwierć.";
        String result = "Sruba, zyrafa, reka. Zycie, swicie, cwierc.";

        //when
        String converted = PolishLettersConverter.convert(input);

        //then
        Assert.assertArrayEquals(new String[]{result}, new String[]{converted});
    }
}