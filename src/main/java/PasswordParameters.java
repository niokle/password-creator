import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
