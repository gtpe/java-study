package w8.interface_method;

public class Main implements CustomCalculator {

    public static void main(String[] args) {
        CustomCalculator calculator = new Main();

        // 짝수의 합.
        int sumOfevenNumbers = calculator.addEvenNumbers(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("# sum of even numbers: " + sumOfevenNumbers); // 20

        // 홀수의 합.
        int sumOfoddNumbers = calculator.addOddNumbers(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("# sum of odd numbers: " + sumOfoddNumbers); // 25
    }

}
