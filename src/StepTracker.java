import java.util.ArrayList;
import java.util.HashMap;

public class StepTracker {
    Converter converter = new Converter();

    HashMap<Integer, MonthData> monthToData = new HashMap<>();

    int stepTarget = 10000;

    public StepTracker() {
        for (int i = 1; i <= 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    public void saveStep(int month, int day, int step) {
        if (step < 0) {
            System.out.println("Введите положительное число");
        } else {
            MonthData monthData = monthToData.get(month);
            Integer steps = monthData.month.get(day - 1);
            int resultSteps = steps + step;
            monthData.month.remove(day - 1);
            monthData.month.add((day - 1), resultSteps);
            monthToData.replace(month, monthData);
            System.out.println("Шаги сохранены");
        }
    }

    public void allStatic(int month) {
        System.out.println("Выбирите какую информацию вы хотите узнать за месяц");
        maxStepMonth(month);
        sumStepMonth(month);
        averageStepMonth(month);
        stepsInKilometers(month);
        stepsToEnergy(month);
        bestSeries(month);
        getStepStatic(month);
    }

    public void maxStepMonth(int monthNumber) {
        MonthData monthData = monthToData.get(monthNumber);
        int maxStepMonth = 0;
        for (Integer step : monthData.month) {
            if (step > maxStepMonth) {
                maxStepMonth = step;
            }
        }
        System.out.println("Максимальное количество шагов за " + monthNumber + " - " + maxStepMonth);
    }

    public void sumStepMonth(int monthNumber) {
        MonthData monthData = monthToData.get(monthNumber);
        int sumStep = 0;
        for (Integer step : monthData.month) {
            sumStep += step;
        }
        System.out.println("Общее количество шагов за " + monthNumber + ": " + sumStep);
    }

    public void averageStepMonth(int monthNumber) {
        MonthData monthData = monthToData.get(monthNumber);
        int sumStepMonth = 0;
        for (Integer step : monthData.month) {
            sumStepMonth += step;
        }
        int averageStep = sumStepMonth / 30;
        System.out.println("Среднее количество шагов за " + monthNumber + ": " + averageStep);
    }

    public void stepsInKilometers(int monthNumber) {
        MonthData monthData = monthToData.get(monthNumber);
        int sumStepMonth = 0;
        for (Integer step : monthData.month) {
            sumStepMonth += step;
        }
        double distanceInKilometers = converter.convertToKilometers(sumStepMonth);
        System.out.println("Шаги в километрах " + distanceInKilometers);
    } // Не считает Километры

    public void bestSeries(int monthNumber) {
        MonthData monthData = monthToData.get(monthNumber);
        int result = 0;
        for (Integer step : monthData.month) {
            if (step >= stepTarget) {
                result++;
            }
        }
        System.out.println("Лучшая серия " + result + " дней");
    }

    public void stepsToEnergy(int monthNumber) {
        MonthData monthData = monthToData.get(monthNumber);
        int sumStepMonth = 0;
        for (Integer step : monthData.month) {
            sumStepMonth += step;
        }
        double kilocalories = converter.convertToEnergy(sumStepMonth);
        System.out.println("Сожжено килокалорий " + kilocalories + " за " + sumStepMonth + " шагов");
    } // Не считает килаколории

    public void getStepStatic(int monthNumber) {
        MonthData monthData = monthToData.get(monthNumber);
        int dayNumber = 1;
        for (Integer step : monthData.month) {
            System.out.println(dayNumber + " день : " + step);
            dayNumber++;
        }
    } // Неправильно выводит день

    void setStep(int step) {
        if (step < 0) {
            System.out.println("Введите положительное число");
        } else {
            this.stepTarget = step;
        }
    }
} 