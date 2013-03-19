package tetris.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tetris.Suunta;
import tetris.domain.Pala;

public class Nappaimistonkuuntelija implements KeyListener {

    private Pala pala;

    public Nappaimistonkuuntelija(Pala pala) {
        this.pala = pala;
    }

    @Override
    public void keyPressed(KeyEvent e) {
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

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
