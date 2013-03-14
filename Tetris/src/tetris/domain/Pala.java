package tetris.domain;

import java.awt.Graphics;

public abstract class Pala {

    private int x;
    private int y;

    public Pala(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void liiku(int x1, int y1){
        x +=x1;
        y +=y1;
    }

    public abstract void kierraOikealle();
    
    public abstract void piirra(Graphics graphics);
}
