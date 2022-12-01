package System;

public class Vector2 {
    int x, y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

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

    public boolean isEquals(Vector2 opposit) {
        return opposit.y == y && opposit.x == x;
    }

    public double getDist(Vector2 opposit) {
        return Math.sqrt(Math.pow(opposit.x - this.x, 2) + Math.pow(opposit.y - this.y, 2));
    }
}
