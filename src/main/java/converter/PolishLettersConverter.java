package converter;

public class PolishLettersConverter {
    private static char charConvert(char c) {
        switch (c) {
            case 'Ą':
                return 'A';
            case 'Ć':
                return 'C';
            case 'Ę':
                return 'E';
            case 'Ł':
                return 'L';
            case 'Ń':
                return 'N';
            case 'Ó':
                return 'O';
            case 'Ś':
                return 'S';
            case 'Ż':
            case 'Ź':
                return 'Z';
            case 'ą':
                return 'a';
            case 'ć':
                return 'c';
            case 'ę':
                return 'e';
            case 'ł':
                return 'l';
            case 'ń':
                return 'n';
            case 'ó':
                return 'o';
            case 'ś':
                return 's';
            case 'ż':
            case 'ź':
                return 'z';
            default:
                return c;
        }
    }

    public static String convert(String string) {
        String result = "";
        for (char c : string.toCharArray()) {
            result += charConvert(c);
        }
        return result;
    }
}
