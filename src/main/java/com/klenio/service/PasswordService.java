package com.klenio.service;

import com.klenio.domain.InputParametersPassword;
import com.klenio.dto.InputParametersDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PasswordService {
    private InputParametersPassword inputParametersPassword;
    private SignsDictionaryService signsDictionaryService;

    public PasswordService(InputParametersPassword inputParametersPassword, SignsDictionaryService signsDictionaryService) {
        this.inputParametersPassword = inputParametersPassword;
        this.signsDictionaryService = signsDictionaryService;
    }

    public String getPassword() {
        String userName = inputParametersPassword.getUserName();
        String masterPassword = inputParametersPassword.getMasterPassword();
        String appName = inputParametersPassword.getAppName();
        String appAddress = inputParametersPassword.getAppAddress();
        int numberOfSigns = inputParametersPassword.getNumberOfSigns();

        List<Character> tableOfSigns = signsDictionaryService.getTableOfSigns();

        String password = "";

        for (int i = 0; i < numberOfSigns; i++) {
            password += " ";
        }

        password = stringsCont(password, masterPassword);
        password = stringsCont(password,userName);
        password = stringsCont(password, appName);
        password = stringsCont(password, appAddress);

        String passwordFinal = "";
        for (char c : password.toCharArray()) {
            passwordFinal += tableOfSigns.get(correctNumber(c, tableOfSigns.size() - 1));
        }

        return passwordFinal;
    }

    private int correctNumber(int number, int maxNumber) {
        return number%maxNumber == 0 ? maxNumber : number%maxNumber;
    }

    //todo
    public String stringsCont(String baseString, String secondSring) {
        String result = "";
        int maxValue = Math.max(baseString.length(), secondSring.length());
        for (int i = 0; i < maxValue; i++) {
            result += (char) (baseString.toCharArray()[i%baseString.length()] + (secondSring.length() == 0 ? 0 : secondSring.toCharArray()[i%secondSring.length()]));
        }
        boolean pasteToEnd = false;
        while (result.length() != baseString.length()) {
            pasteToEnd = !pasteToEnd;
            if (pasteToEnd) {
                result = result.substring(1, result.length() - 1) + (char) (result.charAt(0) + result.charAt(result.length() - 1));
            } else {
                result = (char) (result.charAt(0) + result.charAt(result.length() - 1)) + result.substring(1, result.length() - 1);
            }
        }
        return result;
    }
}
