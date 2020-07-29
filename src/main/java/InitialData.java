import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class InitialData {
    public List<Character> smallLetters = new ArrayList<>();
    public List<Character> largeLetters = new ArrayList<>();
    public List<Character> numbers = new ArrayList<>();
    public List<Character> specialSigns = new ArrayList<>();

    public InitialData() {
        fillSmallLetters();
        fillLargeLetters();
        fillNumbers();
        fillSpecialSigns();
    }

    private void fillSmallLetters() {
        for (char c = 'a'; c <= 'z'; c++) {
            smallLetters.add(c);
        }
    }

    private void fillLargeLetters() {
        for (char c = 'A'; c <= 'Z'; c++) {
            largeLetters.add(c);
        }
    }

    private void fillNumbers() {
        for (char c = '0'; c <= '9'; c++) {
            numbers.add(c);
        }
    }

    private void fillSpecialSigns() {
        for (char c = '!'; c <= '*'; c++) {
            if (c != '"' && c != '\'' && c != '(' && c != ')') {
                specialSigns.add(c);
            }
        }
    }
}


