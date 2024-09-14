package lecture2.homework.car;

public class Car implements Drivable {

    private String brand;
    private String type;
    private int yearReleased;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }


    @Override
    public void start() {
        System.out.println("Заводим двигатель.");
    }

    @Override
    public void stop() {
        System.out.println("Глушим двигатель.");
    }

    @Override
    public void drive(double distance) {
        System.out.printf("Только что автомобиль проехал %s метра(ов)\n", String.format("%.2f", distance));
    }
}