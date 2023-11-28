import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker StepTracker = new StepTracker();
        Converter converter = new Converter();
        MonthData monthData = new MonthData();
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if(userInput == 1) {
                int addInList = scanner.nextInt();
            } else if (userInput == 2) {
                int step = scanner.nextInt();
                StepTracker.getStepStatic(step);
            } else if (userInput == 3) {

            } else if (userInput == 4) {
                break;
            } // обаботка разных случаев

            printMenu(); // печатем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt();
            // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("1 - Ввести количество шагов за определённый день;");
        System.out.println("2 - Напечатать статистику за определённый месяц;");
        System.out.println("3 - Изменить цель по количеству шагов в день;");
        System.out.println("4 - Выйти из приложения.");
    }
}
