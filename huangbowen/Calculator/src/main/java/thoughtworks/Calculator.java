package thoughtworks;

public class Calculator {

    private Scanner scanner;

    public Calculator(String expression) {
        this.scanner = new Scanner(expression);
    }

    private char head;

    public int calculate() {

        int result = 0;
        if (Scanner.END != (head = scanner.getNext())) {
            result = expression();
        }
        if (head != Scanner.END) {
            throw new RuntimeException(String.format("syntax error at %s", head));
        }

        return result;
    }

    private int expression() {
        int result = term();
        int tempResult;
        char operate;
        while ((operate = head) == '+' || operate == '-') {
            head = scanner.getNext();
            tempResult = term();
            switch (operate) {
                case '+':
                    result += tempResult;
                    break;
                case '-':
                    result -= tempResult;
            }
        }
        return result;
    }

    private int term() {
        int result = factor();
        int tempResult;
        char operate;
        while ((operate = head) == '*' || operate == '/') {
            head = scanner.getNext();
            tempResult = factor();
            switch (operate) {
                case '*':
                    result *= tempResult;
                    break;
                case '/':
                    result /= tempResult;
            }
        }
        return result;
    }

    private int factor() {
        int factor = 0;
        String digit = "";

        while (Character.isDigit(head)) {
            digit += String.valueOf(head);
            head = scanner.getNext();
        }

        if (!digit.equals("")) {
            return Integer.parseInt(digit);
        }
        if (!Character.isDigit(head)) {
            match('(');
            factor = expression();
            match(')');
        }

        return factor;
    }

    private void match(char symbol) {
        if (symbol == head) {
            head = scanner.getNext();
        }
    }


}
