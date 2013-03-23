
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
    
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public boolean osuuko(Ruutu r){
        if(x+1== r.getX()){
            return true;
        }
        if(y-1 == r.getY() || y+1 == r.getY()){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }    
    
}
