public class Converter {
    double stepLength;
    double stepEnergy;

    public Converter() {
        this.stepLength = 75;
        this.stepEnergy = 50;
    }
    public double convertToKilometers(int step) {
        return step * stepLength / 1000;
    }

    public double convertToEnergy(int step) {
        return step * stepEnergy / 1000;
    }
}

