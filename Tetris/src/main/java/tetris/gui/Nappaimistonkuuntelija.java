package tetris.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tetris.Suunta;
import tetris.domain.Pala;
import tetris.peli.Peli;

public class Nappaimistonkuuntelija implements KeyListener {

   // private Pala pala;
    private Peli peli;

    public Nappaimistonkuuntelija(Peli peli) {
        this.peli = peli;
       // this.pala = peli.getPala();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Pala pala = peli.getPala();
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            pala.kierraOikealle();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pala.setSuunta(Suunta.ALAS);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pala.setSuunta(Suunta.VASEN);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pala.setSuunta(Suunta.OIKEA);
        }
    }

//    public void setPala(Pala pala) {
//        this.pala = pala;
//    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
