package com.klenio.service;

import com.klenio.domain.InputParametersDictionary;
import com.klenio.dto.InputParametersDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@Component
public class SignsDictionaryService {
    private List<Character> smallLetters = new ArrayList<>();
    private List<Character> largeLetters = new ArrayList<>();
    private List<Character> numbers = new ArrayList<>();
    private List<Character> specialSigns = new ArrayList<>();
    private List<Character> tableOfSigns = new ArrayList<>();


    public SignsDictionaryService(InputParametersDictionary inputParametersDictionary) {
        fillSmallLetters(inputParametersDictionary.isSmallLetters());
        fillLargeLetters(inputParametersDictionary.isLargeLetters());
        fillNumbers(inputParametersDictionary.isNumbers());
        fillSpecialSigns(inputParametersDictionary.isSpecialSigns());
        fillTableOfSigns();
    }

    public List<Character> getTableOfSigns() {
        return tableOfSigns;
    }

    private void fillSmallLetters(boolean isSmallLetters) {
        if (isSmallLetters) {
            for (char c = 'a'; c <= 'z'; c++) {
                smallLetters.add(c);
            }
        }
    }

    private void fillLargeLetters(boolean isLargeLetters) {
        if (isLargeLetters) {
            for (char c = 'Z'; c >= 'A'; c--) {
                largeLetters.add(c);
            }
        }
    }

    private void fillNumbers(boolean isNumbers) {
        if (isNumbers) {
            for (char c = '0'; c <= '9'; c++) {
                numbers.add(c);
            }
        }
    }

    private void fillSpecialSigns(boolean isSpecialSigns) {
        if (isSpecialSigns) {
            for (char c = '!'; c <= '*'; c++) {
                if (c != '"' && c != '\'' && c != '(' && c != ')') {
                    specialSigns.add(c);
                }
            }
        }
    }

    private void fillTableOfSigns() {
        List<Integer> sizes = new ArrayList<>();
        sizes.add(smallLetters.size());
        sizes.add(largeLetters.size());
        sizes.add(numbers.size());
        sizes.add(specialSigns.size());

        for (int i = 0; i < Collections.max(sizes); i++) {
            if (i < smallLetters.size() - 1) {
                tableOfSigns.add(smallLetters.get(i));
            }
            if (i < largeLetters.size() - 1) {
                tableOfSigns.add(largeLetters.get(i));
            }
            if (i < numbers.size() - 1) {
                tableOfSigns.add(numbers.get(i));
            }
            if (i < specialSigns.size() - 1) {
                tableOfSigns.add(specialSigns.get(i));
            }
        }
    }
}



