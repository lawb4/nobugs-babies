package lecture2.homework1.car;

public class Main {
    public static void main(String[] args) {

        Car car = new Car();
        car.setBrand("Opel");
        car.setType("Sedan");
        car.setYearReleased(2003);

        car.start();
        car.drive(927.34d);
        car.stop();
    }
}
