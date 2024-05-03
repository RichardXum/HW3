import stores.MyStack;

public class Calculator {

    public enum NotationMode {POSTFIX, PREFIX};

    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();

        char c;
        while ((c = (char) System.in.read()) != 0) {
            calc.getToken(c);
        }
    }

    private MyStack<Integer> stack;
    private NotationMode mode;
    
    public Calculator() {
        stack = new MyStack<>();
        mode = NotationMode.POSTFIX;
    }

    public int passString(String calculation) {
        for (int i = 0; i < calculation.length(); i++) {
            getToken(calculation.charAt(i));
        }

        return evaluate();
    }

    public void setMode(NotationMode mode) {
        this.mode = mode;
    }

    public NotationMode getMode() {
        return mode;
    }

    public int getToken(char c) {
        if ('0' <= c && c <= '9') {
            return newValueToken((int) (c - '0'));
        } else {
            switch (c) {
                case '+':
                    return newPlus();
                case '-':
                    return newMinus();
                case '*':
                    return newMultiply();
                case '/':
                    return newDivide();
                case '=':
                    return evaluate();
                case '\n':
                case '\t':
                case '\r':
                case ' ':
                    return 0;
                default:
                    System.out.println("Error bad input!!! Allowed inputs are: 0-9,+,-,*,/ and =");
                    return 0;
            }
        }
    }

    protected int newValueToken(int d) {
        System.out.println("Digit " + d);
        // INCOMPLETE
        stack.push(d);
        return d;
    }

    protected int newPlus() {
        System.out.println("Op +");
        // INCOMPLETE
        int a = stack.pop();
        int b = stack.pop();
        newValueToken(a+b);
        return a+b;
    }

    protected int newMinus() {
        System.out.println("Op -");
        // INCOMPLETE
        int a = stack.pop();
        int b = stack.pop();
        newValueToken(b-a);
        return b-a;
    }

    protected int newDivide() throws IllegalArgumentException {
        System.out.println("Op /");
        // INCOMPLETE
        int a = stack.pop();
        int b = stack.pop();
        if (a == 0) {
            throw new IllegalArgumentException("a cannot be 0");
        }
        newValueToken(b/a);
        return b/a;
    }

    protected int newMultiply() {
        System.out.println("Op *");
        // INCOMPLETE
        int a = stack.pop();
        int b = stack.pop();
        newValueToken(a*b);
        return a*b;
    }

    protected int evaluate() {
        System.out.println("Value =");
        // INCOMPLETE
        int a = stack.pop();
        return a;
    }

    public String toString() {
        return stack.toString();
    }

}
