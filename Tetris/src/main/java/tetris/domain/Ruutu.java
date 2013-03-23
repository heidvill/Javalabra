package tetris.domain;

public class Ruutu {

    private int x;
    private int y;

    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public boolean osuu(Ruutu r){
        if(osuuAlas(r) || osuuOikealle(r) || osuuVasemmalle(r)){
            return true;
        }
        return false;
    }

    public boolean osuuAlas(Ruutu r) {
        if (y + 1 == r.getY() && x == r.getX()) {
            return true;
        }
        return false;
    }

    public boolean osuuVasemmalle(Ruutu r) {
        if (x - 1 == r.getX() && y == r.getY()) {
            return true;
        }
        return false;
    }

    public boolean osuuOikealle(Ruutu r) {
        if (x + 1 == r.getX() && y == r.getY()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
