public class Converter {
    double stepLength;
    double stepEnergy;

    public Converter() {
        this.stepLength = stepLength;
        this.stepEnergy = stepEnergy;
    }

    public double convertToKilometers(int step) {
        return step * stepLength / 10000;
    }

    public double convertToEnergy(int step) {
        return step * stepEnergy / 1000;
    }
}

