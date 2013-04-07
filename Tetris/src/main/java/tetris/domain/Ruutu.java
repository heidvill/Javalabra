package tetris.domain;

import java.awt.Color;
import java.util.ArrayList;

public class Ruutu {

    private int x;
    private int y;
    private Color vari;

    public Ruutu(int x, int y, Color vari) {
        this.x = x;
        this.y = y;
        this.vari = vari;
    }

    public int getX() {
        return x;
    }

    public Color getVari() {
        return vari;
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

    public boolean osuuAlas(ArrayList<Ruutu> ruudut) {
        for (Ruutu r : ruudut) {
            if (y + 1 == r.getY() && x == r.getX()) {
                return true;
            }
        }
        return false;
    }

    public boolean osuuVasemmalleRuutuun(ArrayList<Ruutu> ruudut) {
        for (Ruutu r : ruudut) {
            if (x - 1 == r.getX() && y == r.getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean osuuVasemmalleRuutuun(Ruutu r) {
        if (x - 1 == r.getX() && y == r.getY()) {
            return true;
        }
        return false;
    }

    public boolean osuuOikealleRuutuun(ArrayList<Ruutu> ruudut) {
        for (Ruutu r : ruudut) {
            if (x + 1 == r.getX() && y == r.getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean osuuOikealleRuutuun(Ruutu r) {
        if (x + 1 == r.getX() && y == r.getY()) {
            return true;
        }
        return false;
    }

    public boolean onPaallekkainRuudunKanssa(ArrayList<Ruutu> ruudut) {
        for (Ruutu r : ruudut) {
            if (x == r.getX() && y == r.getY()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
