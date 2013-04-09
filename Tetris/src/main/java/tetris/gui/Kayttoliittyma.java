package tetris.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import tetris.peli.Peli;

/**
 * Tetriksen käyttöliittymä
 *
 * @author heidvill
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Peli peli;
    private Piirtoalusta alusta;

    public Kayttoliittyma(Peli peli, int sivunPituus) {
        this.peli = peli;
        this.alusta = new Piirtoalusta(peli, sivunPituus);
    }

    @Override
    public void run() {
        frame = new JFrame("Tetris");
        frame.setPreferredSize(new Dimension(410, 435));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.add(alusta);
        frame.addKeyListener(new Nappaimistonkuuntelija(peli));
    }

    public JFrame getFrame() {
        return frame;
    }

    public Paivitettava getPiirtoalusta() {
        return alusta;
    }
}
