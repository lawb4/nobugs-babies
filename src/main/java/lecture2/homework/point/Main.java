package lecture2.homework.point;

public class Main {
    public static void main(String[] args) {

        Point point = new Point();
        point.setX(0);
        point.setY(0);

        point.moveUp();
        point.moveDown();
        point.moveDown();
        point.moveLeft();
        point.moveLeft();
        point.moveLeft();
        point.moveRight();
        point.moveRight();
        point.moveRight();
        point.moveRight();

        System.out.printf("Координата точки: (%d,%d)", point.getX(), point.getY());
    }
}
