package tetris.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import tetris.domain.Pala;
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

        g.setColor(Color.WHITE);
        for (Ruutu r : peli.getPala().getRuudut()) {
            g.fill3DRect(r.getX()*palanSivunPituus, r.getY()*palanSivunPituus, palanSivunPituus, palanSivunPituus, true);
        }
//        g.setColor(Color.RED);
//        g.fillOval(peli.getOmena().getX()*palanSivunPituus, peli.getOmena().getY()*palanSivunPituus,
//                palanSivunPituus, palanSivunPituus);
    }

    @Override
    public void paivita() {
        repaint();
    }
}
