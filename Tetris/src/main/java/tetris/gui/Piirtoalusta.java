package tetris.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import tetris.domain.Ruutu;
import tetris.peli.Peli;

/**
 * Piirtoalusta piirtää taustan, liikkuvan palan ja pysähtyneet palat sekä
 * pisteet, räjäytetyt rivit ja seuraavan palan
 * @author heidvill
 */

public class Piirtoalusta extends JPanel implements Paivitettava {

    private Peli peli;
    private int palanSivunPituus;

    public Piirtoalusta(Peli peli, int palanSivunPituus) {
        super.setBackground(Color.GRAY);
        this.peli = peli;
        this.palanSivunPituus = palanSivunPituus;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.WHITE);
        g.fill3DRect(0, 0, 240, 400, true);

        g.setColor(peli.getPala().getVari());
        for (Ruutu r : peli.getPala().getRuudut()) {
            g.fill3DRect(r.getX() * palanSivunPituus, r.getY() * palanSivunPituus, palanSivunPituus, palanSivunPituus, true);
        }

        for (Ruutu ruutu : peli.getPalasailio().getRuudut()) {
            g.setColor(ruutu.getVari());
            g.fill3DRect(ruutu.getX() * palanSivunPituus, ruutu.getY() * palanSivunPituus, palanSivunPituus, palanSivunPituus, true);
        }

        g.setColor(Color.WHITE);
        g.drawString("Pisteet", 250, 15);
        g.drawString("Rivejä", 250, 72);
        g.drawString("Seuraava pala", 250, 130);
    }

    @Override
    public void paivita() {
        repaint();
    }
}
