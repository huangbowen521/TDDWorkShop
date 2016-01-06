package thoughtworks;

public class Scanner {
    public Scanner(String source) {
        this.source = source.toCharArray();
    }

    private char[] source;
    private int index = 0;
    public static char END = '\n';

    public char getNext() {
        char result;

        do {
            if (index >= source.length) {
                return END;
            }
            result = source[index];
            index += 1;
        } while (Character.isWhitespace(result));

        return result;
    }
}
