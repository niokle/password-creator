package com.klenio.service;

import com.klenio.domain.InputParametersPassword;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PasswordService {
    private InputParametersPassword inputParametersPassword;
    private SignsDictionaryService signsDictionaryService;

    public PasswordService(InputParametersPassword inputParametersPassword, SignsDictionaryService signsDictionaryService) {
        this.inputParametersPassword = inputParametersPassword;
        this.signsDictionaryService = signsDictionaryService;
    }

    public String getPassword() {
        String masterPassword = inputParametersPassword.getMasterPassword();
        String userName = inputParametersPassword.getUserName();
        String appName = inputParametersPassword.getAppName();
        String appAddress = inputParametersPassword.getAppAddress();
        int numberOfSigns = inputParametersPassword.getNumberOfSigns();

        List<Character> tableOfSigns = signsDictionaryService.getTableOfSigns();

        List<Integer> passwordMatrix = getPasswordSizeMatrix(numberOfSigns);
        passwordMatrix = codingPasswordMatrix(passwordMatrix, masterPassword);
        passwordMatrix = codingPasswordMatrix(passwordMatrix, userName);
        passwordMatrix = codingPasswordMatrix(passwordMatrix, appName);
        passwordMatrix = codingPasswordMatrix(passwordMatrix, appAddress);

        String password = "";
        for (Integer i : passwordMatrix) {
            password += tableOfSigns.get(correctNumber(i, tableOfSigns.size() - 1));
        }
        return password;
    }

    private List<Integer> getPasswordSizeMatrix(int numberOfSigns) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numberOfSigns; i++) {
            result.add(getIntCalc1(numberOfSigns, i));
        }
        //todo
        System.out.println(result);
        return result;
    }

    private int getIntCalc1(int numberOfSigns, int i) {
        return (int) (i * Math.PI - numberOfSigns < 0 ? i * Math.PI + numberOfSigns : i * Math.PI - numberOfSigns);
    }

    private List<Integer> codingPasswordMatrix(List<Integer> passwordMatrix, String code) {
        List<Integer> result = passwordMatrix;
        for (char c : code.toCharArray()) {
            result = result.stream().map(val -> getIntCalc2(code, c, val)).collect(Collectors.toList());
        }
        //todo
        System.out.println(result);
        return result;
    }

    private int getIntCalc2(String code, char c, Integer val) {
        return val % 2 == 0 || val - c + code.chars().sum() < 0 ? val + c + code.chars().sum() : val - c + code.chars().sum();
    }

    private int correctNumber(int number, int maxNumber) {
        return number%maxNumber == 0 ? maxNumber : number%maxNumber;
    }
}
