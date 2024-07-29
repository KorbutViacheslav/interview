
public class UncheckedAndCustomExceptionExample {
    public static void divideAndCheck(int a, int b) throws NegativeNumberException {
        if (a < 0 || b < 0) {
            throw new NegativeNumberException("Числа повинні бути позитивними");
        }
        try {
            int result = a / b;
            System.out.println("Результат ділення: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Помилка ділення: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            divideAndCheck(10, 0);
        } catch (NegativeNumberException e) {
            System.out.println("Виникло власне виключення: " + e.getMessage());
        }

        try {
            divideAndCheck(-5, 2);
        } catch (NegativeNumberException e) {
            System.out.println("Виникло власне виключення: " + e.getMessage());
        }
    }
}

class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}
