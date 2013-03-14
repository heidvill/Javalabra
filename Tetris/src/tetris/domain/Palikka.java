
package tetris.domain;

import java.awt.Graphics;
import java.util.ArrayList;

public class Palikka extends Pala{
    
    private ArrayList<Pala> palat;

    public Palikka() {
        super(0, 0);
        palat = new ArrayList();
    }

    
    
    @Override
    public void kierraOikealle() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void piirra(Graphics graphics) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
