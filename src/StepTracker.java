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

    public void saveStep(int month, int step, int day) {
        if (step < 0) {
            System.out.println("Введите положительное число");
        } else {
            MonthData monthData = monthToData.get(month);
            monthData.month.add(day, step);
            monthToData.replace(month, monthData);
            System.out.println("Шаги сохранены");
        }
    }

    public void maxStepMonth(int monthNumber) {
        MonthData monthData = monthToData.get(monthNumber);
        int maxStepMonth = 0;
        for (Integer step : monthData.month) {
            if(step > maxStepMonth) {
                maxStepMonth = step;
            }
        }
        System.out.println("Максимальное количество шагов за " + monthNumber + " - "+ maxStepMonth);
    }

    public void sumStepMonth (int monthNumber) {
        MonthData monthData = monthToData.get(monthNumber);
        int sumStep = 0;
        for (Integer step : monthData.month) {
            sumStep += step;
        }
        System.out.printf("Общее количество шагов за %s - %s", monthNumber,sumStep);
    }

    public void averageStepMonth(int monthNumber) {
        MonthData monthData = monthToData.get(monthNumber);
        int sumStepMonth = 0;
        for (Integer step : monthData.month) {
            sumStepMonth += step;
        }
        double averageStep = (double) sumStepMonth / 30;
        System.out.printf("Среднее количество шагов за %s - %s", monthNumber,averageStep);
    }

    public void stepsInKilometers(int monthNumber) {
        MonthData monthData = monthToData.get(monthNumber);
        int sumStepMonth = 0;
        for (Integer step : monthData.month) {
            sumStepMonth += step;
        }
        double distanceInKilometers = converter.convertToKilometers(sumStepMonth);
        System.out.printf("Шаги в километрах %s", distanceInKilometers );
    }

    public void bestSeries(int monthNumber){
        MonthData monthData = monthToData.get(monthNumber);
        int result = 0;
        for (Integer step : monthData.month) {
            if(step >= stepTarget) {
                result ++;
            }
        }
        System.out.printf("Лучшая серия %s дней", result);
    }

    public void stepsToEnergy(int monthNumber) {
        MonthData monthData = monthToData.get(monthNumber);
        int sumStepMonth = 0;
        for (Integer step : monthData.month) {
            sumStepMonth += step;
        }
        double kilocalories = converter.convertToEnergy(sumStepMonth);
        System.out.printf("Сожжено килокалорий %s за %s шагов", kilocalories, sumStepMonth );
    }

    public void getStepStatic(int monthNumber) {
        MonthData monthData = monthToData.get(monthNumber);
        int dayNumber = 1;
        for (Integer step : monthData.month) {
            System.out.printf("%s день : %s.", dayNumber, step);
            dayNumber ++;
        }
    }
    void setStep(int step){
        if(step < 0){
            System.out.println("Введите положительное число");
        } else {
            this.stepTarget = step;
        }
    }
} 