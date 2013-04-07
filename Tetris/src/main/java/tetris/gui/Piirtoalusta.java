package tetris.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import tetris.domain.Ruutu;
import tetris.peli.Peli;

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
        g.drawString("Rivejä", 250, 100);
        g.drawString("Seuraava pala", 250, 150);
    }

    @Override
    public void paivita() {
        repaint();
    }
}
