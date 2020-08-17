package service;

import initial.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PasswordService {
    private PasswordParameters passwordParameters;
    private InitialData initialData;

    public PasswordService(PasswordParameters passwordParameters, InitialData initialData) {
        this.passwordParameters = passwordParameters;
        this.initialData = initialData;
    }

    public String getPassword() {
        String userName = passwordParameters.getUserName();
        String masterPassword = passwordParameters.getMasterPassword();
        String appName = passwordParameters.getAppName();
        String appAddress = passwordParameters.getAppAddress();
        int numberOfSigns = passwordParameters.getNumberOfSigns();

        List<Character> tableOfSigns = initialData.getTableOfSigns();

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
