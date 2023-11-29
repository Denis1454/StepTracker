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
                System.out.println("Выбирите месяц от 1 до 12,где 1 это Январь.");
                int month = scanner.nextInt();
                System.out.println("Выбирите день.");
                int day = scanner.nextInt();
                System.out.println("Введите количество шагов пройденных за день.");
                int step = scanner.nextInt();
                StepTracker.saveStep(month,day,step);
            } else if (userInput == 2) {
                System.out.println("Выбирите за какой месяц вы хотите узнать статистики.");
                int month = scanner.nextInt();
                StepTracker.allStatic(month);
            } else if (userInput == 3) {
                System.out.println("Введите новое целевое значение шагов в день.");
                int step = scanner.nextInt();
                StepTracker.setStep(step);
                System.out.println("Новое целевое значение шагов сохраненой.");
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
