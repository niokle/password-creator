public class PasswordParameters {
    private String userName;
    private String masterPassword;
    private String appName;
    private String appAddress;
    private int numberOfSigns;
    private boolean smallLetters;
    private boolean largeLetters;
    private boolean numbers;
    private boolean specialSigns;

    public PasswordParameters(String userName,
                              String masterPassword,
                              String appName,
                              String appAddress,
                              int numberOfSigns,
                              boolean smallLetters,
                              boolean largeLetters,
                              boolean numbers,
                              boolean specialSigns) {
        this.userName = userName;
        this.masterPassword = masterPassword;
        this.appName = appName;
        this.appAddress = appAddress;
        this.numberOfSigns = numberOfSigns;
        this.smallLetters = smallLetters;
        this.largeLetters = largeLetters;
        this.numbers = numbers;
        this.specialSigns = specialSigns;
    }

    public String getUserName() {
        return userName;
    }

    public String getMasterPassword() {
        return masterPassword;
    }

    public String getAppName() {
        return appName;
    }

    public String getAppAddress() {
        return appAddress;
    }

    public int getNumberOfSigns() {
        return numberOfSigns;
    }

    public boolean isSmallLetters() {
        return smallLetters;
    }

    public boolean isLargeLetters() {
        return largeLetters;
    }

    public boolean isNumbers() {
        return numbers;
    }

    public boolean isSpecialSigns() {
        return specialSigns;
    }
}
