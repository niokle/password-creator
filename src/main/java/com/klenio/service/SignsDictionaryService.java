package com.klenio.service;

import com.klenio.domain.InputParametersDictionary;
import com.klenio.exception.EmptyDictionaryException;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
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


    public SignsDictionaryService(InputParametersDictionary inputParametersDictionary) throws EmptyDictionaryException {
        if (isNotDictionaryEmpty(inputParametersDictionary)) {
            fillSmallLetters(inputParametersDictionary.isSmallLetters());
            fillLargeLetters(inputParametersDictionary.isLargeLetters());
            fillNumbers(inputParametersDictionary.isNumbers());
            fillSpecialSigns(inputParametersDictionary.isSpecialSigns());
            fillTableOfSigns();
        } else {
            throw new EmptyDictionaryException("Dictionary is empty");
        }
    }

    public List<Character> getTableOfSigns() {
        return tableOfSigns;
    }

    private boolean isNotDictionaryEmpty(InputParametersDictionary inputParametersDictionary) {
        return inputParametersDictionary.isLargeLetters() || inputParametersDictionary.isSmallLetters()
                || inputParametersDictionary.isNumbers() || inputParametersDictionary.isSpecialSigns();
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
            if (smallLetters.size() > 0) {
                tableOfSigns.add(smallLetters.get(getCorrectNumber(i, smallLetters.size())));
            }
            if (largeLetters.size() > 0) {
                tableOfSigns.add(largeLetters.get(getCorrectNumber(i, largeLetters.size())));
            }
            if (numbers.size() > 0) {
                tableOfSigns.add(numbers.get(getCorrectNumber(i, numbers.size())));
            }
            if (specialSigns.size() > 0) {
                tableOfSigns.add(specialSigns.get(getCorrectNumber(i, specialSigns.size())));
            }
        }
    }
}



