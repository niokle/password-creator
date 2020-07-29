public class PolishLettersConverter {
    public static char convert(char c) {
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
}
