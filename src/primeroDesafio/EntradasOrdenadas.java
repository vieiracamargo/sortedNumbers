package primeroDesafio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EntradasOrdenadas {
    public static void main(String[] args) {
        System.out.print("Quantas entradas você deseja realizar? ");
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();

        if (!validInput(inputNumber)) {
            firstValeuMessage();
            inputNumber = scanner.nextInt();

            while (!validInput(inputNumber)) {
                firstValeuMessage();
                inputNumber = scanner.nextInt();
            }
        }

        for (int i = 0; i < inputNumber; i++) {
            System.out.println("Digite um número: ");
            int value = scanner.nextInt();

            if (!validNumber(value)) {
                secondValueMessage();
                value = scanner.nextInt();

                while (!validNumber(value)) {
                    secondValueMessage();
                    value = scanner.nextInt();
                }
            }

            numbers.add(value);
        }

        printSortedValues(numbers);
        scanner.close();
    }

    public static void printSortedValues(List<Integer> numbers) {
        List<Integer> even = new ArrayList<>(numbers.stream()
                .filter(value -> value % 2 == 0)
                .sorted()
                .toList());

        List<Integer> odd = numbers.stream()
                .filter(value -> value % 2 != 0)
                .sorted(Comparator.reverseOrder())
                .toList();

        even.addAll(odd);
        even.forEach(System.out::println);
    }

    public static boolean validInput(int value) {
        final boolean VALID_INTERVAL = value > 1 && value <= (int) Math.pow(10, 5);

        if (!VALID_INTERVAL) {
            return false;
        }

        return VALID_INTERVAL;

    }

    public static boolean validNumber(int value) {
        final boolean VALID_INTERVAL = value > 0;

        if (!VALID_INTERVAL) {
            return false;
        }

        return VALID_INTERVAL;

    }

    public static void firstValeuMessage(){
        System.out.println("O valor deve ser um inteiro, maior que 1 e menor que 100001.");
        System.out.println("Digite outro valor: ");
    }


    public static void secondValueMessage(){
        System.out.println("O valor deve ser um inteiro  positivo");
        System.out.println("Digite outro valor: ");
    }




}
