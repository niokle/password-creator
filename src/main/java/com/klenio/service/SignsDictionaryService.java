package com.klenio.service;

import com.klenio.domain.InputParametersDictionary;
import com.klenio.dto.InputParametersDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.klenio.function.CorrectNumber.getCorrectNumber;

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
        for (int i = 0; i < 120; i++) {
            tableOfSigns.add(smallLetters.get(getCorrectNumber(i, smallLetters.size())));
            tableOfSigns.add(largeLetters.get(getCorrectNumber(i, largeLetters.size())));
            tableOfSigns.add(numbers.get(getCorrectNumber(i, numbers.size())));
            tableOfSigns.add(specialSigns.get(getCorrectNumber(i, specialSigns.size())));
        }
    }
}



