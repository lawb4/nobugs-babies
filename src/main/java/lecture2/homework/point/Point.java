package lecture2.homework.point;

public class Point implements Movable {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void moveUp() {
        setY(getY() + 1);
    }

    @Override
    public void moveDown() {
        setY(getY() - 1);
    }

    @Override
    public void moveLeft() {
        setX(getX() - 1);
    }

    @Override
    public void moveRight() {
        setX(getX() + 1);
    }
}
