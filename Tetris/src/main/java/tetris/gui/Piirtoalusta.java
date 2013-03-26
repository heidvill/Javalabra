package tetris.gui;

import java.awt.Graphics;
import javax.swing.JPanel;
import tetris.domain.Ruutu;
import tetris.peli.Peli;

public class Piirtoalusta extends JPanel implements Paivitettava {

    private Peli peli;
    private int palanSivunPituus;

    public Piirtoalusta(Peli peli, int palanSivunPituus) {
        this.peli = peli;
        this.palanSivunPituus = palanSivunPituus;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(peli.getPala().getVari());
        for (Ruutu r : peli.getPala().getRuudut()) {
            g.fill3DRect(r.getX() * palanSivunPituus, r.getY() * palanSivunPituus, palanSivunPituus, palanSivunPituus, true);
        }

        if (!peli.getPaikoillaanOlevat().isEmpty()) {
            for (Ruutu ruutu : peli.getPaikoillaanOlevat()) {
                g.setColor(ruutu.getVari());
                g.fill3DRect(ruutu.getX() * palanSivunPituus, ruutu.getY() * palanSivunPituus, palanSivunPituus, palanSivunPituus, true);
            }
        }
    }

    @Override
    public void paivita() {
        repaint();
    }
}
