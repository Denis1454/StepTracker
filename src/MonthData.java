import java.util.ArrayList;
public class MonthData {
    ArrayList<Integer> month = new ArrayList<>(30);

    public MonthData() {
        for (int i = 0; i < 30; i++) {
            month.add(1);
        }
    }
    void addInList(int step,int day) {
        month.set(day - 1,step);
    }
    
}



